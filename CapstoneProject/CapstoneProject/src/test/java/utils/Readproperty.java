package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readproperty {
	
	public static Properties readProperites()
	{
		Properties prop=null;
		String fileName="C:\\Users\\KIIT\\eclipse-workspace\\CapstoneProject\\src\\test\\resources\\config\\config.properties";
		try {
			FileInputStream fs=new FileInputStream(fileName);
			prop=new Properties();
			prop.load(fs);
		} catch (FileNotFoundException e) {
			System.out.println("File path not match");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

}
