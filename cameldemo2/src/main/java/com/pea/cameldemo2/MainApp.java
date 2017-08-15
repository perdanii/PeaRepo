package com.pea.cameldemo2;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 * (Apache Camel Tutorial #01: Hello World: https://www.youtube.com/watch?v=gu1KHvcNMiE&t=120s)
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run(args);
    }

}

