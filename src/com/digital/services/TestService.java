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
import java.sql.Date;
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
	
	/*@POST
	@Path("/insertToDB")
	public boolean test(String payload){
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
			transaction.setTimestamp(jsonObject.getJSONObject(expenseManagerConstants.T_Timestamp).toString());
			//Date dat = new Date(jsonObject.optString(expenseManagerConstants.T_Date));
			long millis=System.currentTimeMillis();  
			Date dat = new Date(millis);
			Transaction transaction = new Transaction(dat,jsonObject.optString(expenseManagerConstants.T_Particulars),jsonObject.optString(expenseManagerConstants.T_Amount),jsonObject.optString(expenseManagerConstants.T_Category),jsonObject.opt(expenseManagerConstants.T_isDebit),jsonObject.optString(expenseManagerConstants.T_DebitedFrom),jsonObject.optString(expenseManagerConstants.T_DebitSettled),jsonObject.optString(expenseManagerConstants.T_isCredit),jsonObject.optString(expenseManagerConstants.T_CreditTo),jsonObject.optString(expenseManagerConstants.T_CreditSettled),jsonObject.optString(expenseManagerConstants.T_Timestamp));
			//return transaction.toString();
			return DatabaseServices.insertToDB(transaction);
		 }catch(Exception e){
			System.out.println("Exeption found : "+e);
			return false;
		}
	}*/
	@POST
	@Path("/insertToDB")
	public String test(Transaction transaction){
		try{
			return DatabaseServices.insertToDB(transaction);
		 }catch(Exception e){
			System.out.println("Exeption found : "+e);
			return "failed : "+e;
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
			result = "Error : "+e;
			e.printStackTrace();
		}
		return result;
	}
	/*
	@GET
	@Path("/delete/{itemNumber}")
	public String deleteItem(@PathParam("itemNumber") String itemNumber) throws ClassNotFoundException, URISyntaxException, SQLException{
		return DatabaseServices.deleteItem(itemNumber);
	}*/
	
}
