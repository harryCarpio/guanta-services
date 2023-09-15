package org.ojoseco.guanta.api.controllers;

import org.ojoseco.guanta.domain.entities.documents.ProcesoDocument;
import org.ojoseco.guanta.domain.repositories.mongo.ProcesoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProcesoController {
    Logger logger = LoggerFactory.getLogger(ProcesoController.class);
    @Autowired
    ProcesoRepository procesoDocumentRepository;
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot 22!";
    }

    @GetMapping("/proceso/{id}")
    public ResponseEntity<ProcesoDocument> getProcesoById(@PathVariable("id") String id) {
        Optional<ProcesoDocument> procesoData = procesoDocumentRepository.findById(id);
        return procesoData.map(procesoDocument -> new ResponseEntity<>(procesoDocument, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
