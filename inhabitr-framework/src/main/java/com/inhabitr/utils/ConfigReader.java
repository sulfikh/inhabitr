package com.inhabitr.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;

	public ConfigReader() {
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("src/test/resources/configurations/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getQAURL() {
		return prop.getProperty("QAURL");
	}

	public String getBrowser() {
		return prop.getProperty("BROWSER");
	}

	public Long getGlobalWaitValue() {
		return Long.parseLong(prop.getProperty("GLOBALWAIT"));
	}

	public String getValidEmail() {
		return prop.getProperty("VALIDEMAIL");
	}
	public String getValidPassword() {
		return prop.getProperty("VALIDPASSWORD");
	}

	public String getRegistrationExcel() {
		return prop.getProperty("Registration_EXCEL");
	}
	public String getHomePageTitle() {
		return prop.getProperty("HOMEPAGE_TITLE");
	}
	public String getLoginPageTitle() {
		return prop.getProperty("LOGINPAGE_TITLE");
	}
	public String getRegisterPageTitle() {
		return prop.getProperty("REGISTERPAGE_TITLE");
	}

	public String getLoginPageUrl() {
		return prop.getProperty("LOGINPAGE_URL");
	}
	public String getRegistrationPageUrl() {
		return prop.getProperty("REGISTRATIONPAGE_URL");
	}

	public String getInValidEmail() {
		return prop.getProperty("INVALIDEMAIL");
	}

	public String getInValidPassword() {
		return prop.getProperty("INVALIDPASSWORD");
	}

	
}
