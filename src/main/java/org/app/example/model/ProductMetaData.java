package org.app.example.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "sis.product_metadata")
public class ProductMetaData implements Serializable {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    private String brand;
    @Transient
    private Integer limit;
}
