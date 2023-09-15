package org.ojoseco.guanta.domain.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

@Document("procesos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProcesoDocument implements Serializable {
    @Id
    private String _id;
    private BigInteger id;
    private String amount;
    //private String budget;
    private String buyer;
    private String date;
    private String description;
    private String internal_type;
    private String locality;
    private String method;
    private int month;
    private String ocid;
    private String region;
    private String suppliers;
    private String title;
    private int year;
}
