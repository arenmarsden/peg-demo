package ac.uk.stfc.msc.peg.projectembeddedguacamoledemo;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Application {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080); // Set the port

        // Set the base directory for the Tomcat instance
        String baseDir = System.getProperty("java.io.tmpdir");
        tomcat.setBaseDir(baseDir);

        // Add the web application
        Context ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());

        // Start the Tomcat server
        tomcat.start();
        tomcat.getServer().await();
    }

}