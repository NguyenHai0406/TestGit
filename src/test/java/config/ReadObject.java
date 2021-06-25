package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {
	Properties p = new Properties(); 
	public Properties getObjectRepository() {
        //Read object repository file
		try {
			InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\object.properties"));
	        //load all objects
	        p.load(stream);
	        return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
}
