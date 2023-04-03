package acceptance.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

        public  static String env() {
            String path;
            String env = "prod";
            // String env = System.getProperty("env") ;
            path = "src/test/java/resources/config/env_";

            try (InputStream input = new FileInputStream(  path + env+ ".properties")) {
                Properties prop = new Properties();
                prop.load(input);
                System.out.println(prop.getProperty("BaseUri"));
                return (prop.getProperty("BaseUri"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
