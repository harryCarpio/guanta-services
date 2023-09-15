package org.ojoseco.guanta.domain.repositories.mongo;

import org.ojoseco.guanta.domain.entities.documents.ProcesoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ProcesoRepository extends MongoRepository<ProcesoDocument, String> {
    Optional<List<ProcesoDocument>> findByYear(Integer year);
}
