package com.digital.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.digital.constants.DigitalDiningConstants;
import com.digital.data.DatabaseServices;

@Path("/rest")
public class TestService {
	@GET
	@Path("/ping")
	public String ping() {
		return "working fine...";
	}

	@POST
	@Path("/insertNewItem")
	public String insertNewItem(String payload) {
		try {
			JSONObject jsonObject = new JSONObject(payload);
			HashMap<String, String> newItem = new HashMap<String, String>();
			newItem.put(DigitalDiningConstants.ITEM_NUMBER,
					jsonObject.optString(DigitalDiningConstants.ITEM_NUMBER));
			newItem.put(DigitalDiningConstants.ITEM_NAME,
					jsonObject.optString(DigitalDiningConstants.ITEM_NAME));
			newItem.put(DigitalDiningConstants.ITEM_PRICE,
					jsonObject.optString(DigitalDiningConstants.ITEM_PRICE));
			newItem.put(DigitalDiningConstants.ITEM_CATEGORY,
					jsonObject.optString(DigitalDiningConstants.ITEM_CATEGORY));
			return DatabaseServices.insertToDB(newItem);
		} catch (JSONException e) {
			System.out.println("JSONException : " + e);
			return "JSONException : " + e;
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			System.out.println("DriverClass Not Found! " + e);
			return "DriverClass Not Found! " + e;
		} catch (URISyntaxException e) {
			System.out.println("URISyntax Exception : " + e);
			return "URISyntax Exception : " + e;
		} catch (SQLException e) {
			System.out.println("SQL Exception : " + e);
			return "SQL Exception : " + e;
		}
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllItems(){
		String result = null;
		try {
			result = DatabaseServices.getAllItems().toString();
		} catch (ClassNotFoundException | URISyntaxException | SQLException
				| JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
