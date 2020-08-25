package com.elasticsearch.Elastic.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elasticsearch.Elastic.entity.ccplain;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CcplainService {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CcplainService.class);
	
	@Autowired
	private RestHighLevelClient client;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public List<ccplain> findAll(){
		List<ccplain> ccPlain = new ArrayList<>();
		try{
			SearchRequest searchRequest = new SearchRequest("ccenc"); //Restricts to Single Index
			searchRequest.setPreFilterShardSize(1);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchAllQuery());
			searchRequest.source(searchSourceBuilder);
			SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
			ccPlain = getSearchResult(response);
		}catch (IOException e) {
			LOGGER.error("SearchRequest Failed!!!");
			LOGGER.error(e.getMessage());
		}

		return ccPlain;
	}
	
	public ccplain findByAccountId(String accountId){
		ccplain ccPlain = null;
		try{
			LOGGER.info("AccountId : "+accountId);
			SearchRequest searchRequest = new SearchRequest("ccenc"); //Restricts to Single Index
			searchRequest.setPreFilterShardSize(1);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchQuery("accountID", accountId));
			searchRequest.source(searchSourceBuilder);
			SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
			if(response.getHits().getHits().length > 0){
				ccPlain = objectMapper.convertValue(response.getHits().getHits()[0].getSourceAsMap(),ccplain.class);
			}
		}catch(IOException e){
			LOGGER.error("SearchRequest Failed!!!");
			LOGGER.error(e.getMessage());
		}
		return ccPlain;
	}
	
	public List<ccplain> searchAny(String text){
		List<ccplain> ccPlain = new ArrayList<>();
		try{
			SearchRequest searchRequest = new SearchRequest("ccenc"); //Restricts to Single Index
			searchRequest.setPreFilterShardSize(1);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.multiMatchQuery(text, "*"));
			searchRequest.source(searchSourceBuilder);
			SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
			ccPlain = getSearchResult(response);
		}catch (IOException e) {
			LOGGER.error("SearchRequest Failed!!!");
			LOGGER.error(e.getMessage());
		}

		return ccPlain;
	}
	
	private List<ccplain> getSearchResult(SearchResponse response) {
		
		SearchHit[] searchHit = response.getHits().getHits();

        List<ccplain> ccplains = new ArrayList<>();
        LOGGER.debug("Seachhits Size  "+searchHit.length);
        if (searchHit.length > 0) {

            Arrays.stream(searchHit)
                    .forEach(hit -> ccplains
                            .add(objectMapper
                                    .convertValue(hit.getSourceAsMap(),
                                    		ccplain.class))
                    );
        }

        return ccplains;
    }

	public ccplain findBytransactionID(String transactionID) {

		return searchRequest("transactionID", transactionID);
	}

	public ccplain findBypaymentInstrumentType(String paymentInstrumentType) {

		return searchRequest("paymentInstrumentType", paymentInstrumentType);
	}

	public ccplain findBycardType(String cardType) {

		return searchRequest("cardType", cardType);
	}
	
	public List<ccplain> searchBypaymentInstrumentTypeNdCardType(String paymentInstrumentType, String cardType){
		List<ccplain> ccPlain = new ArrayList<>();
		try{
			SearchRequest searchRequest = new SearchRequest("ccenc"); //Restricts to Single Index
			searchRequest.types("_doc");
			searchRequest.setPreFilterShardSize(1);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchQuery("paymentInstrumentType", paymentInstrumentType));
			searchSourceBuilder.query(QueryBuilders.matchQuery("cardType", cardType));
			searchRequest.source(searchSourceBuilder);
			SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
			ccPlain = getSearchResult(response);
		}catch (IOException e) {
			LOGGER.error("SearchRequest Failed!!!");
			LOGGER.error(e.getMessage());
		}

		return ccPlain;
	}
	
	private ccplain searchRequest(String colName, String value){
		ccplain ccPlain = null;

		try{
			LOGGER.info(colName+" : "+value);
			SearchRequest searchRequest = new SearchRequest("ccenc"); //Restricts to Single Index
			searchRequest.setPreFilterShardSize(1);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchQuery(colName, value));
			searchRequest.source(searchSourceBuilder);
			SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
			if(response.getHits().getHits().length > 0){
				ccPlain = objectMapper.convertValue(response.getHits().getHits()[0].getSourceAsMap(),ccplain.class);
			}
		}catch(IOException e){
			LOGGER.error("SearchRequest Failed!!!");
			LOGGER.error(e.getMessage());
		}
		return ccPlain;
	}
}
