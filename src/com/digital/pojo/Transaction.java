package com.digital.pojo;

import java.sql.Date;

public class Transaction {

	private String  transactionID ;
	private Date    transactionDate ;
	private String  transactionParticulars ;
	private String  transactionAmount ;
	private String  transactionCategory ;
	private String  transactionBorrowed ;
	private String  transactionDebitedFrom ;
	private String  transactionDebitSettled ;
	private String  transactionCredited ;
	private String  transactionCreditedTo ;
	private String  transactionCreditSettled ;
	private String  transactionTimestamp ;
	public Transaction(String transactionID, Date transactionDate,
			String transactionParticulars, String transactionAmount,
			String transactionCategory, String transactionBorrowed,
			String transactionDebitedFrom, String transactionDebitSettled,
			String transactionCredited, String transactionCreditedTo,
			String transactionCreditSettled, String transactionTimestamp) {
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.transactionParticulars = transactionParticulars;
		this.transactionAmount = transactionAmount;
		this.transactionCategory = transactionCategory;
		this.transactionBorrowed = transactionBorrowed;
		this.transactionDebitedFrom = transactionDebitedFrom;
		this.transactionDebitSettled = transactionDebitSettled;
		this.transactionCredited = transactionCredited;
		this.transactionCreditedTo = transactionCreditedTo;
		this.transactionCreditSettled = transactionCreditSettled;
		this.transactionTimestamp = transactionTimestamp;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionParticulars() {
		return transactionParticulars;
	}
	public void setTransactionParticulars(String transactionParticulars) {
		this.transactionParticulars = transactionParticulars;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCategory() {
		return transactionCategory;
	}
	public void setTransactionCategory(String transactionCategory) {
		this.transactionCategory = transactionCategory;
	}
	public String getTransactionBorrowed() {
		return transactionBorrowed;
	}
	public void setTransactionBorrowed(String transactionBorrowed) {
		this.transactionBorrowed = transactionBorrowed;
	}
	public String getTransactionDebitedFrom() {
		return transactionDebitedFrom;
	}
	public void setTransactionDebitedFrom(String transactionDebitedFrom) {
		this.transactionDebitedFrom = transactionDebitedFrom;
	}
	public String getTransactionDebitSettled() {
		return transactionDebitSettled;
	}
	public void setTransactionDebitSettled(String transactionDebitSettled) {
		this.transactionDebitSettled = transactionDebitSettled;
	}
	public String getTransactionCredited() {
		return transactionCredited;
	}
	public void setTransactionCredited(String transactionCredited) {
		this.transactionCredited = transactionCredited;
	}
	public String getTransactionCreditedTo() {
		return transactionCreditedTo;
	}
	public void setTransactionCreditedTo(String transactionCreditedTo) {
		this.transactionCreditedTo = transactionCreditedTo;
	}
	public String getTransactionCreditSettled() {
		return transactionCreditSettled;
	}
	public void setTransactionCreditSettled(String transactionCreditSettled) {
		this.transactionCreditSettled = transactionCreditSettled;
	}
	public String getTransactionTimestamp() {
		return transactionTimestamp;
	}
	public void setTransactionTimestamp(String transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}
	

}
