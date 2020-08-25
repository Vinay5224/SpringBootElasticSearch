package com.elasticsearch.Elastic.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document(indexName = "elastic", type = "elastic")
@JsonIgnoreProperties
public class Clientstore {

	@JsonProperty("Amount")
	private String Amount;
	
	@JsonProperty("Quantity")
	private String Quantity;
	
	@JsonProperty("Id")
	@org.springframework.data.annotation.Id
	private String Id;
	
	@JsonProperty("Client_Store_sk")
	private String Client_Store_sk;

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getClient_Store_sk() {
		return Client_Store_sk;
	}

	public void setClient_Store_sk(String client_Store_sk) {
		Client_Store_sk = client_Store_sk;
	}

	@Override
	public String toString() {
		return "Clientstore [Amount=" + Amount + ", Quantity=" + Quantity + ", Id=" + Id + ", Client_Store_sk="
				+ Client_Store_sk + "]";
	}
	

	
	
	
}
