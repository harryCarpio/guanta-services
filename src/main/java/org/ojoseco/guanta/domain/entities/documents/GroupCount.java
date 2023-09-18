package org.ojoseco.guanta.domain.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GroupCount implements Serializable {
    @Id
    private String _id;
    private BigInteger count;
}
