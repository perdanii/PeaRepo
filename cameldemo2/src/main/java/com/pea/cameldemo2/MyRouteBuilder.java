package com.pea.cameldemo2;

import static com.pea.cameldemo2.Utils.headerEnricherStrategy;
import static com.pea.cameldemo2.Utils.javascript;
import static org.apache.camel.Exchange.HTTP_METHOD;
import static org.apache.camel.Exchange.HTTP_PATH;
import static org.apache.camel.Exchange.HTTP_QUERY;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {
    	getContext().setTracing(true);
    	getContext().addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));

    	// @formatter:off
    	
    	/** route 1: data source which will be converted and ennriched with geo-data */
//        from("file:src/data?noop=true")			//## 2 ##:file-consumer
    	from("jetty:http://0.0.0.0:8081/orders/") 	//## 3 ##:jetty-consumer
    	
	        .process(javascript("convert.js"))
	        .enrich("direct:geocoder",headerEnricherStrategy("ziel"))
	        //.log("Converted-json-object: ${body}")
	        .log("Ziel:${header.ziel}")
	        .filter(header("ziel").isEqualTo(","))
	        	.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
	        	.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
	        	.setBody(constant("{\"error\":\"Ziel nicht gefunden.\"}"))
	        	.stop()
	        .end()
	        
//	        .to("file:dest")				//## 1 ##:write to file
//	        .to("activemq:bestellung")		//## 2 ##:relevant with file-consumer	        
	        .inOnly("activemq:bestellung")	//## 3 ##:relevant with jetty-consumer
	        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(204))
	        ;
        
        /*
         * INPUT:
         * body: Bestellung als JSON-Object (als String)
         * 
         * OUTPUT:
         * body: Geokoordinate als String "9.0535531,48.5236164" oder "", wenn geocoder die Adresse nicht aufloesen konnte
         */
    	/** route 2: get geocoding information */
        from("direct:geocoder")
        	.setProperty("plz").jsonpath("$.adresse.plz")
        	.setProperty("city").jsonpath("$.adresse.city")
        	.log("PLZ: ${property.plz} Stadt: ${property.city}")

            .setHeader(HTTP_PATH, simple("/geocoding/"))
            .setHeader(HTTP_QUERY, simple("address='${property.plz} ${property.city} DE'"))
            .setHeader(HTTP_METHOD, simple("GET"))
            .to("jetty:http://services.gisgraphy.com?bridgeEndpoint=true")
            
            .setProperty("latitude").xpath("/results/result[geocodingLevel='CITY']/lat/text()")
            .setProperty("longitude").xpath("/results/result[geocodingLevel='CITY']/lng/text()")
            //.setProperty("latitude", xpath("/results/result[geocodingLevel='CITY']/lat/text()"))
            .log("Latitude: ${property.latitude} Longitude: ${property.longitude}")
            .setBody().simple("${property.latitude} ${property.longitude}")
            .setBody(body().regexReplaceAll(" ",","))//replace empty space with comma
            .log("Geo-response: ${body}")
    		;
        
        /** route 3: */
        from("activemq:bestellung?concurrentConsumers=2")
        	.log("Verarbeitung beginn: ${header.ziel}")
        	.delay(2000)
        	.log("Verarbeitung ende: ${header.ziel}")
        	;
        
        // @formatter:on
    }
}
