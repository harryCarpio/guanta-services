package org.ojoseco.guanta.domain.repositories.mongo;

import org.ojoseco.guanta.domain.entities.documents.ProcesoDocument;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ProcesoRepository extends MongoRepository<ProcesoDocument, String> {
    Optional<List<ProcesoDocument>> findByYear(Integer year);

    @Query(value="{ '$group': { '_id': '$locality', 'count': { '$count': {} } } }", fields="{name : 1, _id : 0}")
    Optional<List<Document>> getByLocality();
}
