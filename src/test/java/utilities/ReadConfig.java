package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
		
		public ReadConfig()
		{
			File src = new File ("./src//test//resources//config.properties");
			
			try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			}   catch (Exception e) {
				System.out.println("Exception is" + e.getMessage());
			}
			
			}
		
		public String getApplicationURL()
		{
			String url = pro.getProperty("appURL");
			return url;
		}
		
		public String getUsername()
		{
			String username = pro.getProperty("username");
			return username;
		}
		
		
	

}
