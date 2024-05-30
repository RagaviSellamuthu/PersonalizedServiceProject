package org.app.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "sis.product")
public class ProductId implements Serializable {

    @Column(name = "id", nullable = false)
    private int id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Shopper shopper;
    @Id
    @Column(name = "productId")
    private String productId;
    @Column(name = "relevancyScore")
    private Float relevancyScore;
}
