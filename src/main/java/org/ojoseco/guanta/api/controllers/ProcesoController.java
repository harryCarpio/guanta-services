package org.ojoseco.guanta.api.controllers;

import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.ojoseco.guanta.domain.entities.documents.GroupCount;
import org.ojoseco.guanta.domain.entities.documents.ProcesoDocument;
import org.ojoseco.guanta.domain.repositories.mongo.ProcesoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.*;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


@RestController
@RequestMapping("/api")
public class ProcesoController {
    Logger logger = LoggerFactory.getLogger(ProcesoController.class);
    @Autowired
    ProcesoRepository procesoDocumentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/procesos/{id}")
    public ResponseEntity<ProcesoDocument> getProcesoById(@PathVariable("id") String id) {
        Optional<ProcesoDocument> procesoData = procesoDocumentRepository.findById(id);
        return procesoData.map(procesoDocument -> new ResponseEntity<>(procesoDocument, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/procesos/region/")
    public List<GroupCount> getProcesosGroupedByRegion() {
        GroupOperation countRegion = group("region").count().as("count");
        SortOperation sortByRegion = sort(Sort.by(Sort.Direction.ASC, "_id"));

        Aggregation aggregation = newAggregation(countRegion, sortByRegion);

        logger.info("------------------- 2");
        AggregationResults<GroupCount> result = mongoTemplate
                .aggregate(aggregation, "procesos", GroupCount.class);

        logger.info("------------------- 3");
        return result.getMappedResults();
    }

}
