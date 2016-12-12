package com.digital.data;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.digital.constants.DigitalDiningConstants;

public class DatabaseServices {
	private static String createQuery = "CREATE TABLE ITEMS("
			+ "ITEM_NUMBER TEXT PRIMARY KEY NOT NULL,"
			+ "ITEM_NAME TEXT NOT NULL,"
			+ "ITEM_PRICE TEXT NOT NULL,"
			+ "ITEM_CATEGORY TEXT NOT NULL);";
	
	public static String insertToDB(HashMap<String, String> newItem)
			throws ClassNotFoundException, URISyntaxException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DatabaseConnectivity.getConnected();
		if (connection != null) {
			Statement st = connection.createStatement();
			String insertQuery = "INSERT INTO ITEMS VALUES("
					+ newItem.get(DigitalDiningConstants.ITEM_NUMBER)+","
					+ newItem.get(DigitalDiningConstants.ITEM_NAME)+","
					+ newItem.get(DigitalDiningConstants.ITEM_PRICE)+","
					+ newItem.get(DigitalDiningConstants.ITEM_CATEGORY)+")";
			st.executeQuery(insertQuery);
			System.out.println("Query executed!");
			return "Query executed!";
		}
		else
			return "Query failed!";

	}

}
