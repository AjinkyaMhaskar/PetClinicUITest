package test.java.dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private final String propertyFilePath = "configs/Configuration.properties";
	FileInputStream reader = null;
	static Properties properties = null;

	public ConfigFileReader() {
		try {
			reader = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static String getBROWSER() {
		String BROWSER = properties.getProperty("BROWSER");
		if (BROWSER != null)
			return BROWSER;
		else
			throw new RuntimeException("BROWSER not specified in the Configuration.properties file.");
	}
	
	public static String getBaseURL() {
		String baseURL = properties.getProperty("baseURL");
		if (baseURL != null)
			return baseURL;
		else
			throw new RuntimeException("BaseURL not specified in the Configuration.properties file.");
	}
	
	public static String getImgresourceURL() {
		String imgresourceURL = properties.getProperty("imgresourceURL");
		if (imgresourceURL != null)
			return imgresourceURL;
		else
			throw new RuntimeException("ImgresourceURL not specified in the Configuration.properties file.");
	}
	
	public static String getfindOwnerURL() {
		String findOwnerURL = properties.getProperty("findOwnerURL");
		if (findOwnerURL != null)
			return findOwnerURL;
		else
			throw new RuntimeException("findOwnerURL not specified in the Configuration.properties file.");
	}
	
	public static String getOwnerName() {
		String OwnerName = properties.getProperty("OwnerName");
		if (OwnerName != null)
			return OwnerName;
		else
			throw new RuntimeException("OwnerName not specified in the Configuration.properties file.");
	}
	
	public static String getOwnerLastName() {
		String OwnerLastName = properties.getProperty("OwnerLastName");
		if (OwnerLastName != null)
			return OwnerLastName;
		else
			throw new RuntimeException("OwnerLastName not specified in the Configuration.properties file.");
	}
	
	public static String getOwnerAddress() {
		String OwnerAddress = properties.getProperty("OwnerAddress");
		if (OwnerAddress != null)
			return OwnerAddress;
		else
			throw new RuntimeException("OwnerAddress not specified in the Configuration.properties file.");
	}
	
	public static String getOwnerCity() {
		String OwnerCity = properties.getProperty("OwnerCity");
		if (OwnerCity != null)
			return OwnerCity;
		else
			throw new RuntimeException("OwnerCity not specified in the Configuration.properties file.");
	}
	
	public static String getOwnerTelephone() {
		String OwnerTelephone = properties.getProperty("OwnerTelephone");
		if (OwnerTelephone != null)
			return OwnerTelephone;
		else
			throw new RuntimeException("OwnerTelephone not specified in the Configuration.properties file.");
	}
	
	public static String getPetName() {
		String PetName = properties.getProperty("PetName");
		if (PetName != null)
			return PetName;
		else
			throw new RuntimeException("PetName not specified in the Configuration.properties file.");
	}
	
	public static String getPetDOB() {
		String PetDOB = properties.getProperty("PetDOB");
		if (PetDOB != null)
			return PetDOB;
		else
			throw new RuntimeException("PetDOB not specified in the Configuration.properties file.");
	}
	
	public static String getPetType() {
		String PetType = properties.getProperty("PetType");
		if (PetType != null)
			return PetType;
		else
			throw new RuntimeException("PetType not specified in the Configuration.properties file.");
	}
}
