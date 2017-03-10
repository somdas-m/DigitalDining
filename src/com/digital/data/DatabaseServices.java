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

import com.digital.pojo.Transaction;
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
			Connection connection = DatabaseConnectivity.getConnected();
			if (connection != null) {
				Statement st = connection.createStatement();
				String insertQuery = "INSERT INTO MYEXPENSES(date, particulars, amount, category, isdebit, dname, dsettled, iscredit, cname, csettled, timestamp) VALUES (to_date('"+transaction.getTransactionDate()+"', 'YYYY-MM-DD'),'"+transaction.getTransactionParticulars()+"','"+ transaction.getTransactionAmount()+"','"+transaction.getTransactionCategory()+"',"+ transaction.isTransactionBorrowed()+",'"+transaction.getTransactionDebitedFrom()+"',"+transaction.isTransactionDebitSettled()+","+ transaction.isTransactionCredited()+",'"+transaction.getTransactionCreditedTo()+"',"+transaction.isTransactionCreditSettled()+",'"+transaction.getTransactionTimestamp()+"');";
				st.executeUpdate(insertQuery);
				return true;
		 	}
			else{
				return false;
			}
	}
	
	public static JSONArray getAllItems() throws ClassNotFoundException, URISyntaxException, SQLException, JSONException{
		Connection connection = DatabaseConnectivity.getConnected();
		JSONArray jsonArray = new JSONArray();
		if (connection != null) {
			Statement st = connection.createStatement();
			String query = "SELECT * FROM MYEXPENSES";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put(expenseManagerConstants.T_ID,rs.getInt(1));
				jsonObject.put(expenseManagerConstants.T_Date,rs.getString(2));
				jsonObject.put(expenseManagerConstants.T_Particulars,rs.getString(3));
				jsonObject.put(expenseManagerConstants.T_Amount,rs.getDouble(4));
				jsonObject.put(expenseManagerConstants.T_Category,rs.getString(5));
				jsonObject.put(expenseManagerConstants.T_isDebit,rs.getBoolean(6));
				jsonObject.put(expenseManagerConstants.T_DebitedFrom,rs.getString(7));
				jsonObject.put(expenseManagerConstants.T_DebitSettled,rs.getBoolean(8));
				jsonObject.put(expenseManagerConstants.T_isCredit,rs.getBoolean(9));
				jsonObject.put(expenseManagerConstants.T_CreditTo,rs.getString(10));
				jsonObject.put(expenseManagerConstants.T_CreditSettled,rs.getBoolean(11));
				jsonObject.put(expenseManagerConstants.T_Timestamp,rs.getString(12));
				jsonArray.put(jsonObject);
			}
			rs.close();
		}
		connection.close();
		return jsonArray;
	}
	
		
	/*public static String deleteItem(String itemNumber) throws ClassNotFoundException, URISyntaxException, SQLException{
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
