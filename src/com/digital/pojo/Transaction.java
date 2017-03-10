package com.digital.pojo;

import java.sql.Date;

public class Transaction {

	private static String  transactionID ;
	private static Date    transactionDate ;
	private static String  transactionParticulars ;
	private static String  transactionAmount ;
	private static String  transactionCategory ;
	private static String  transactionBorrowed ;
	private static String  transactionDebitedFrom ;
	private static String  transactionDebitSettled ;
	private static String  transactionCredited ;
	private static String  transactionCreditedTo ;
	private static String  transactionCreditSettled ;
	private static String  transactionTimestamp ;
	public static String getTransactionID() {
		return transactionID;
	}
	public static void setTransactionID(String transactionID) {
		Transaction.transactionID = transactionID;
	}
	public static Date getTransactionDate() {
		return transactionDate;
	}
	public static void setTransactionDate(Date transactionDate) {
		Transaction.transactionDate = transactionDate;
	}
	public static String getTransactionParticulars() {
		return transactionParticulars;
	}
	public static void setTransactionParticulars(String transactionParticulars) {
		Transaction.transactionParticulars = transactionParticulars;
	}
	public static String getTransactionAmount() {
		return transactionAmount;
	}
	public static void setTransactionAmount(String transactionAmount) {
		Transaction.transactionAmount = transactionAmount;
	}
	public static String getTransactionCategory() {
		return transactionCategory;
	}
	public static void setTransactionCategory(String transactionCategory) {
		Transaction.transactionCategory = transactionCategory;
	}
	public static String getTransactionBorrowed() {
		return transactionBorrowed;
	}
	public static void setTransactionBorrowed(String transactionBorrowed) {
		Transaction.transactionBorrowed = transactionBorrowed;
	}
	public static String getTransactionDebitedFrom() {
		return transactionDebitedFrom;
	}
	public static void setTransactionDebitedFrom(String transactionDebitedFrom) {
		Transaction.transactionDebitedFrom = transactionDebitedFrom;
	}
	public static String getTransactionDebitSettled() {
		return transactionDebitSettled;
	}
	public static void setTransactionDebitSettled(String transactionDebitSettled) {
		Transaction.transactionDebitSettled = transactionDebitSettled;
	}
	public static String getTransactionCredited() {
		return transactionCredited;
	}
	public static void setTransactionCredited(String transactionCredited) {
		Transaction.transactionCredited = transactionCredited;
	}
	public static String getTransactionCreditedTo() {
		return transactionCreditedTo;
	}
	public static void setTransactionCreditedTo(String transactionCreditedTo) {
		Transaction.transactionCreditedTo = transactionCreditedTo;
	}
	public static String getTransactionCreditSettled() {
		return transactionCreditSettled;
	}
	public static void setTransactionCreditSettled(String transactionCreditSettled) {
		Transaction.transactionCreditSettled = transactionCreditSettled;
	}
	public static String getTransactionTimestamp() {
		return transactionTimestamp;
	}
	public static void setTransactionTimestamp(String transactionTimestamp) {
		Transaction.transactionTimestamp = transactionTimestamp;
	}
	
	
}
