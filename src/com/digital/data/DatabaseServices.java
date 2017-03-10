package com.digital.data;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.digital.constants.expenseManagerConstants;

public class DatabaseServices {
	private static String createQuery = "CREATE TABLE ITEMS("
			+ "ITEM_NUMBER TEXT PRIMARY KEY NOT NULL,"
			+ "ITEM_NAME TEXT NOT NULL,"
			+ "ITEM_PRICE TEXT NOT NULL,"
			+ "ITEM_CATEGORY TEXT NOT NULL);";
	
	public static String createTable() throws ClassNotFoundException, URISyntaxException,SQLException{
	Connection connection = DatabaseConnectivity.getConnected();
		if (connection != null) {
			Statement st = connection.createStatement();
			/*String createQuery = "CREATE TABLE EXPENSES (transctionId serial primary key,"+
				"date Date not null, particulars char(100) not null, amount decimal(7,3) not null, comments char(100), timestamp char(100))";*/
			/*String createQuery = "CREATE TABLE BORROWED (transctionId char(50) not null,"+
				"name char(100), isSettled boolean not null,timestamp char(100))";*/
			/*String createQuery = "CREATE TABLE USERS (uname char(50) primary key, upass char(50), key char(50))";*/
			/*String createQuery = "CREATE TABLE TOGET (transctionId char(50) not null, name char(100) not null, amount decimal(7,3) not null )";*/
			//String createQuery = "CREATE TABLE MYEXPENSES(transactionId serial primary key, date Date not null, particulars char(100) not null, amount decimal(7,3) not null, category char(50), isdebit boolean not null, dname char(50), dsettled boolean, iscredit boolean not null, cname char(50), csettled boolean, timestamp char(100))";
			String insertQuery = "INSERT INTO MYEXPENSES(date, particulars, amount, category, isdebit, dname, dsettled, iscredit, cname, csettled, timestamp) VALUES({d'2017-08-03'},'test',10.026,'testCat',false,null,false,false,null,false,'testtime');";
			//st.executeQuery(insertQuery);
			System.out.println("Query executed!");
			String getQuery= "Select * from myexpenses";
			ResultSet rs = st.executeQuery(getQuery);
			String result="";
			while(rs.next()){
				result += rs.getInt(1)+":"+rs.getDate(2)+":"+rs.getString(3)+":"+rs.getFloat(4)+",";
			}
			rs.close();
			connection.close();
			return "Success : "+result;
		}
		else
			return "Failed";
	}
	
	public static boolean insertToDB(Transaction transaction) throws ClassNotFoundException, URISyntaxException, SQLException {
		try{
			Connection connection = DatabaseConnectivity.getConnected();
			if (connection != null) {
				Statement st = connection.createStatement();
				String insertQuery = "INSERT INTO MYEXPENSES(date, particulars, amount, category, isdebit, dname, dsettled, iscredit, cname, csettled, timestamp) VALUES (transaction.getDate(), transaction.getParticulars(), transaction.getAmount(), transaction.getCategory(), transaction.getBorrowed(), transaction.getDebitedFrom(), transaction.getDebitSettled(), transaction.getCredited(), transaction.getCreditedTo(), transaction.getCreditSettled(), transaction.getTimestamp());";
				ResultSet rs = st.executeQuery(insertQuery);
				System.out.println("Query executed!");
				return true;
		 	}
		   }catch(ClassNotFoundException e){
			System.out.println("Class Not Found : "+e);
			return false;
		   }catch(URISyntaxException e){
			System.out.println("URISyntaxException : "+e);
			return false;
		   }catch(SQLException e){
			System.out.println("SQL Exception : "+e);
			return true; //for insertion operation SQLException is thrown
		   }
	}
	
	/* public static String insertToDB(HashMap<String, String> newItem)
			throws ClassNotFoundException, URISyntaxException, SQLException {
		
		Connection connection = DatabaseConnectivity.getConnected();
		if (connection != null) {
			Statement st = connection.createStatement();
			String insertQuery = "INSERT INTO ITEMS VALUES('"
					+ newItem.get(DigitalDiningConstants.ITEM_NUMBER)+"','"
					+ newItem.get(DigitalDiningConstants.ITEM_NAME)+"','"
					+ newItem.get(DigitalDiningConstants.ITEM_PRICE)+"','"
					+ newItem.get(DigitalDiningConstants.ITEM_CATEGORY)+"')";
			st.execute(insertQuery);
			System.out.println("Query executed!");
			connection.close();
			return "Success";
		}
		else
			return "Failed";

	}
	
	public static JSONArray getAllItems() throws ClassNotFoundException, URISyntaxException, SQLException, JSONException{
		Connection connection = DatabaseConnectivity.getConnected();
		JSONArray jsonArray = new JSONArray();
		if (connection != null) {
			Statement st = connection.createStatement();
			String query = "SELECT * FROM ITEMS";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put(DigitalDiningConstants.ITEM_NUMBER, rs.getString(1));
				jsonObject.put(DigitalDiningConstants.ITEM_NAME, rs.getString(2));
				jsonObject.put(DigitalDiningConstants.ITEM_PRICE, rs.getString(3));
				jsonObject.put(DigitalDiningConstants.ITEM_CATEGORY, rs.getString(4));
				jsonArray.put(jsonObject);
			}
		}
		connection.close();
		return jsonArray;
	}
	
	public static String deleteItem(String itemNumber) throws ClassNotFoundException, URISyntaxException, SQLException{
		Connection connection = DatabaseConnectivity.getConnected();
		if(connection!=null){
			Statement st = connection.createStatement();
			String deleteQuery = "DELETE FROM ITEMS WHERE ITEM_NUMBER='"+itemNumber+"';";
			st.executeUpdate(deleteQuery);
			connection.close();
		}
	return "Success";
	}*/

}
