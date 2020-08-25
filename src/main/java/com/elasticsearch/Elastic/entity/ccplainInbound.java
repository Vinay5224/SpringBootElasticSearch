package com.elasticsearch.Elastic.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(indexName = "ccenc", type = "_doc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ccplainInbound {
	
	private String isProxyIP;
	private String ipPostcode;
	private String paymentBillingState;
	private double transactionAmountUSD;
	private int localHour;
	private int transactionTime;
	private String paymentInstrumentType;
	private String transactionID;
	private String paymentBillingPostalCode;
	private String accountID;
	private double transactionAmount;
	private String transactionCurrencyCode;
	private double transactionIPaddress;
	private String cvvVerifyResult;
	private int digitalItemCount;
	private int physicalItemCount;
	private String browserLanguage;
	private String transactionScenario;
	private String cardType;
	private String ipCountryCode;
	private int transactionDate;
	private String transactionType;
	private String paymentBillingCountryCode;
	private String ipState;
	public String getIsProxyIP() {
		return isProxyIP;
	}
	public void setIsProxyIP(String isProxyIP) {
		this.isProxyIP = isProxyIP;
	}
	public String getIpPostcode() {
		return ipPostcode;
	}
	public void setIpPostcode(String ipPostcode) {
		this.ipPostcode = ipPostcode;
	}
	public String getPaymentBillingState() {
		return paymentBillingState;
	}
	public void setPaymentBillingState(String paymentBillingState) {
		this.paymentBillingState = paymentBillingState;
	}
	public double getTransactionAmountUSD() {
		return transactionAmountUSD;
	}
	public void setTransactionAmountUSD(double transactionAmountUSD) {
		this.transactionAmountUSD = transactionAmountUSD;
	}
	public int getLocalHour() {
		return localHour;
	}
	public void setLocalHour(int localHour) {
		this.localHour = localHour;
	}
	public int getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(int transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getPaymentInstrumentType() {
		return paymentInstrumentType;
	}
	public void setPaymentInstrumentType(String paymentInstrumentType) {
		this.paymentInstrumentType = paymentInstrumentType;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getPaymentBillingPostalCode() {
		return paymentBillingPostalCode;
	}
	public void setPaymentBillingPostalCode(String paymentBillingPostalCode) {
		this.paymentBillingPostalCode = paymentBillingPostalCode;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCurrencyCode() {
		return transactionCurrencyCode;
	}
	public void setTransactionCurrencyCode(String transactionCurrencyCode) {
		this.transactionCurrencyCode = transactionCurrencyCode;
	}
	public double getTransactionIPaddress() {
		return transactionIPaddress;
	}
	public void setTransactionIPaddress(double transactionIPaddress) {
		this.transactionIPaddress = transactionIPaddress;
	}
	public String getCvvVerifyResult() {
		return cvvVerifyResult;
	}
	public void setCvvVerifyResult(String cvvVerifyResult) {
		this.cvvVerifyResult = cvvVerifyResult;
	}
	public int getDigitalItemCount() {
		return digitalItemCount;
	}
	public void setDigitalItemCount(int digitalItemCount) {
		this.digitalItemCount = digitalItemCount;
	}
	public int getPhysicalItemCount() {
		return physicalItemCount;
	}
	public void setPhysicalItemCount(int physicalItemCount) {
		this.physicalItemCount = physicalItemCount;
	}
	public String getBrowserLanguage() {
		return browserLanguage;
	}
	public void setBrowserLanguage(String browserLanguage) {
		this.browserLanguage = browserLanguage;
	}
	public String getTransactionScenario() {
		return transactionScenario;
	}
	public void setTransactionScenario(String transactionScenario) {
		this.transactionScenario = transactionScenario;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getIpCountryCode() {
		return ipCountryCode;
	}
	public void setIpCountryCode(String ipCountryCode) {
		this.ipCountryCode = ipCountryCode;
	}
	public int getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(int transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getPaymentBillingCountryCode() {
		return paymentBillingCountryCode;
	}
	public void setPaymentBillingCountryCode(String paymentBillingCountryCode) {
		this.paymentBillingCountryCode = paymentBillingCountryCode;
	}
	public String getIpState() {
		return ipState;
	}
	public void setIpState(String ipState) {
		this.ipState = ipState;
	}
	@Override
	public String toString() {
		return "ccplain [isProxyIP=" + isProxyIP + ", ipPostcode=" + ipPostcode + ", paymentBillingState="
				+ paymentBillingState + ", transactionAmountUSD=" + transactionAmountUSD + ", localHour=" + localHour
				+ ", transactionTime=" + transactionTime + ", paymentInstrumentType=" + paymentInstrumentType
				+ ", transactionID=" + transactionID + ", paymentBillingPostalCode=" + paymentBillingPostalCode
				+ ", accountID=" + accountID + ", transactionAmount=" + transactionAmount + ", transactionCurrencyCode="
				+ transactionCurrencyCode + ", transactionIPaddress=" + transactionIPaddress + ", cvvVerifyResult="
				+ cvvVerifyResult + ", digitalItemCount=" + digitalItemCount + ", physicalItemCount="
				+ physicalItemCount + ", browserLanguage=" + browserLanguage + ", transactionScenario="
				+ transactionScenario + ", cardType=" + cardType + ", ipCountryCode=" + ipCountryCode
				+ ", transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ ", paymentBillingCountryCode=" + paymentBillingCountryCode + ", ipState=" + ipState + "]";
	}
	
	

}
