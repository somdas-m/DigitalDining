package com.digital.pojo;

import java.sql.Date;

public class Transaction {

	private String  transactionID ;
	private Date    transactionDate ;
	private String  transactionParticulars ;
	private String  transactionAmount ;
	private String  transactionCategory ;
	private boolean  transactionBorrowed ;
	private String  transactionDebitedFrom ;
	private boolean  transactionDebitSettled ;
	private boolean  transactionCredited ;
	private String  transactionCreditedTo ;
	private boolean  transactionCreditSettled ;
	private String  transactionTimestamp ;
	public Transaction() {
		super();
	}
	public Transaction(String transactionID, Date transactionDate, String transactionParticulars,
			String transactionAmount, String transactionCategory, boolean transactionBorrowed,
			String transactionDebitedFrom, boolean transactionDebitSettled, boolean transactionCredited,
			String transactionCreditedTo, boolean transactionCreditSettled, String transactionTimestamp) {
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
	public boolean isTransactionBorrowed() {
		return transactionBorrowed;
	}
	public void setTransactionBorrowed(boolean transactionBorrowed) {
		this.transactionBorrowed = transactionBorrowed;
	}
	public String getTransactionDebitedFrom() {
		return transactionDebitedFrom;
	}
	public void setTransactionDebitedFrom(String transactionDebitedFrom) {
		this.transactionDebitedFrom = transactionDebitedFrom;
	}
	public boolean isTransactionDebitSettled() {
		return transactionDebitSettled;
	}
	public void setTransactionDebitSettled(boolean transactionDebitSettled) {
		this.transactionDebitSettled = transactionDebitSettled;
	}
	public boolean isTransactionCredited() {
		return transactionCredited;
	}
	public void setTransactionCredited(boolean transactionCredited) {
		this.transactionCredited = transactionCredited;
	}
	public String getTransactionCreditedTo() {
		return transactionCreditedTo;
	}
	public void setTransactionCreditedTo(String transactionCreditedTo) {
		this.transactionCreditedTo = transactionCreditedTo;
	}
	public boolean isTransactionCreditSettled() {
		return transactionCreditSettled;
	}
	public void setTransactionCreditSettled(boolean transactionCreditSettled) {
		this.transactionCreditSettled = transactionCreditSettled;
	}
	public String getTransactionTimestamp() {
		return transactionTimestamp;
	}
	public void setTransactionTimestamp(String transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionDate=" + transactionDate
				+ ", transactionParticulars=" + transactionParticulars + ", transactionAmount=" + transactionAmount
				+ ", transactionCategory=" + transactionCategory + ", transactionBorrowed=" + transactionBorrowed
				+ ", transactionDebitedFrom=" + transactionDebitedFrom + ", transactionDebitSettled="
				+ transactionDebitSettled + ", transactionCredited=" + transactionCredited + ", transactionCreditedTo="
				+ transactionCreditedTo + ", transactionCreditSettled=" + transactionCreditSettled
				+ ", transactionTimestamp=" + transactionTimestamp + "]";
	}
}
