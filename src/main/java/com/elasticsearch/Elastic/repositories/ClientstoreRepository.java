package com.elasticsearch.Elastic.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.Elastic.entity.Clientstore;

@Repository
public interface ClientstoreRepository extends ElasticsearchRepository<Clientstore, String> {

}
