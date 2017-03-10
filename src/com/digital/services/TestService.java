package com.digital.services;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.digital.pojo.Transaction;
import com.digital.constants.expenseManagerConstants;
import com.digital.data.DatabaseServices;

@Path("/rest")
public class TestService {
	@GET
	@Path("/ping")
	public String ping() {
		return "working fine...";
	}

	@GET
	@Path("/create")
	public String createTables(){
		try {
			return DatabaseServices.createTable();
		}catch(Exception e){
			System.out.println("Exception : "+e);
			return "Failed : "+e;
		}
	}
	
	@POST
	@Path("/insertToDB")
	public String test(String payload){
		try{
			JSONObject jsonObject = new JSONObject(payload);
			/*Transaction transaction = new Transaction();
			transaction.setDate(new Date(jsonObject.getJSONObject(expenseManagerConstants.T_Date).toString()));
			transaction.setParticulars(jsonObject.getJSONObject(expenseManagerConstants.T_Particulars).toString());
			transaction.setAmount(jsonObject.getJSONObject(expenseManagerConstants.T_Amount).toString());
			transaction.setCategory(jsonObject.getJSONObject(expenseManagerConstants.T_Category).toString()); 
			transaction.setBorrowed(jsonObject.getJSONObject(expenseManagerConstants.T_isDebit).toString());
			transaction.setDebitedFrom(jsonObject.getJSONObject(expenseManagerConstants.T_DebitedFrom).toString());
			transaction.setDebitSettled(jsonObject.getJSONObject(expenseManagerConstants.T_DebitSettled).toString());
			transaction.setCredited(jsonObject.getJSONObject(expenseManagerConstants.T_isCredit).toString());
			transaction.setCreditedTo(jsonObject.getJSONObject(expenseManagerConstants.T_CreditTo).toString());
			transaction.setCreditSettled(jsonObject.getJSONObject(expenseManagerConstants.T_CreditSettled).toString());
			transaction.setTimestamp(jsonObject.getJSONObject(expenseManagerConstants.T_Timestamp).toString());*/
			Transaction transaction = new Transaction(jsonObject.getJSONObject(expenseManagerConstants.T_Date),jsonObject.getJSONObject(expenseManagerConstants.T_Particulars),jsonObject.getJSONObject(expenseManagerConstants.T_Amount),jsonObject.getJSONObject(expenseManagerConstants.T_Category),jsonObject.getJSONObject(expenseManagerConstants.T_isDebit),jsonObject.getJSONObject(expenseManagerConstants.T_DebitedFrom),jsonObject.getJSONObject(expenseManagerConstants.T_DebitSettled),jsonObject.getJSONObject(expenseManagerConstants.T_isCredit),jsonObject.getJSONObject(expenseManagerConstants.T_CreditTo),jsonObject.getJSONObject(expenseManagerConstants.T_CreditSettled),jsonObject.getJSONObject(expenseManagerConstants.T_Timestamp));
			return transaction.toString();
			//return DatabaseServices.insertToDB(transaction);
		 }catch(Exception e){
			return "Exception occured : "+e;
		}
	}
	/*@POST
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
	
	@GET
	@Path("/delete/{itemNumber}")
	public String deleteItem(@PathParam("itemNumber") String itemNumber) throws ClassNotFoundException, URISyntaxException, SQLException{
		return DatabaseServices.deleteItem(itemNumber);
	}*/
	
}
