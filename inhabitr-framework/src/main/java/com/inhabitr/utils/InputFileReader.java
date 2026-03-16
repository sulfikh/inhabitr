package com.inhabitr.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InputFileReader {
	private Properties prop;

	public InputFileReader() {
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("src/test/resources/configurations/inputFile.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getValidEmail() {
		return prop.getProperty("VALID_EMAIL");
	}
	public String getValidPassword() {
		return prop.getProperty("VALID_PASSWORD");
	}

	public String getInvalidEmailFormat() {
		return prop.getProperty("INVALID_EMAIL_FORMAT");
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

	public String getInValidEmail() {
		return prop.getProperty("INVALID_EMAIL");
	}

	public String getInValidPassword() {
		return prop.getProperty("INVALID_PASSWORD");
	}
	
	public String getPropertyNameField() {
		return prop.getProperty("PROPERTY_NAME_FIELD");
	}
	public String getExpectedAddress() {
		return prop.getProperty("EXPECTED_ADDRESS");
	}
	public String getSelectMonth() {
		return prop.getProperty("SELECT_MONTH");
	}
	public String getSelectYear() {
		return prop.getProperty("SELECT_YEAR");
	}
	public String getSelectAddress() {
		return prop.getProperty("SELECT_ADDRESS");
	}
	public String getBillingEntity() {
		return prop.getProperty("BILLING_ENTITY");
	}
	public String getHotelFranchiseCode() {
		return prop.getProperty("HOTEL_FRANCHISE_CODE");
	}
	
	public String getFloorPlan() {
		return prop.getProperty("FLOOR_PLAN");
	}
	public String getRoomType() {
		return prop.getProperty("ROOM_TYPE");
	}
	public String getRoomCount() {
		return prop.getProperty("ROOM_COUNT");
	}
	public String getTotalRoomCount() {
		return prop.getProperty("TOTAL_ROOM_COUNT");
	}
	public String getFilterSelected() {
		return prop.getProperty("FILTER_SELECTED");
	}
	public String getSortSelected() {
		return prop.getProperty("SORT_SELECTED");
	}


	public String getSearchText() {
		return prop.getProperty("SEARCH_TEXT");
	}
	public String getSearchProject() {
		return prop.getProperty("PROJECT_SEARCHTEXT");
	}
	
}
