package com.elasticsearch.Elastic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.Elastic.ElasticApplication;
import com.elasticsearch.Elastic.entity.ccplain;
import com.elasticsearch.Elastic.repositories.ClientstoreRepository;
import com.elasticsearch.Elastic.service.CcplainService;
import com.fasterxml.jackson.databind.ObjectMapper;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/elastic")
public class Controller {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private CcplainService ccplainService;
	
	@GetMapping(value = "/{user}/all")
	public ResponseEntity<List<ccplain>> getAll(@PathVariable String user) throws IOException{
		ElasticApplication.user = user;
		return new ResponseEntity(ccplainService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{user}/{paymentInstrumentType}/{cardType}")
	public ResponseEntity<List<ccplain>> searchBypaymentInstrumentTypeNdCardType(@PathVariable String user,@PathVariable String paymentInstrumentType,@PathVariable String cardType) throws IOException{
		ElasticApplication.user = user;
		return new ResponseEntity(ccplainService.searchBypaymentInstrumentTypeNdCardType(paymentInstrumentType, cardType),HttpStatus.OK);
	}
	
	@GetMapping(value = "/accountId/{user}/{accountId}")
	public ResponseEntity findByAccountId(@PathVariable String user,@PathVariable String accountId){
		ElasticApplication.user = user;
		ccplain ccPlain = ccplainService.findByAccountId(accountId.trim());
		if(ccPlain!=null)
			return new ResponseEntity(ccPlain,HttpStatus.FOUND);
		
		return new ResponseEntity("Record not found for this AccountId : "+accountId,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/transactionID/{user}/{transactionID}")
	public ResponseEntity findBytransactionID(@PathVariable String user,@PathVariable String transactionID){
		ElasticApplication.user = user;
		ccplain ccPlain = ccplainService.findBytransactionID(transactionID.trim());
		if(ccPlain!=null)
			return new ResponseEntity(ccPlain,HttpStatus.FOUND);
		
		return new ResponseEntity("Record not found for this transactionID : "+transactionID,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/paymentInstrumentType/{user}/{paymentInstrumentType}")
	public ResponseEntity findBypaymentInstrumentType(@PathVariable String user,@PathVariable String paymentInstrumentType){
		ElasticApplication.user = user;
		ccplain ccPlain = ccplainService.findBypaymentInstrumentType(paymentInstrumentType.trim());
		if(ccPlain!=null)
			return new ResponseEntity(ccPlain,HttpStatus.FOUND);
		
		return new ResponseEntity("Record not found for this paymentInstrumentType : "+paymentInstrumentType,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/cardType/{user}/{cardType}")
	public ResponseEntity findBycardType(@PathVariable String user,@PathVariable String cardType){
		ElasticApplication.user = user;
		ccplain ccPlain = ccplainService.findBycardType(cardType.trim());
		if(ccPlain!=null)
			return new ResponseEntity(ccPlain,HttpStatus.FOUND);
		
		return new ResponseEntity("Record not found for this cardType : "+cardType,HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping(value = "/any/{user}/{text}")
	public ResponseEntity<List<ccplain>> findByAny(@PathVariable String user,@PathVariable String text) throws IOException{
		ElasticApplication.user = user;
		return new ResponseEntity(ccplainService.searchAny(text),HttpStatus.OK);
	}



}
