package org.example.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "sis.shopper")
public class Shopper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "shopper_id")
    private String shopperId;
    @JoinColumn(name = "id")
    @OneToMany(cascade = {CascadeType.ALL})
    private Set<ProductId> shelf = new HashSet<>();
}
