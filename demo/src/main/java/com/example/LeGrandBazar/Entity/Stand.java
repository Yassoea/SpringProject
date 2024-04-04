// Stand.java
package com.example.LeGrandBazar.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Stand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String conventionPosition;

    @OneToMany(mappedBy = "stand")
    private List<Employee> employees;

    @OneToMany(mappedBy = "stand")
    private List<item> itemsForSale;

    @OneToMany(mappedBy = "stand")
    private List<item> itemsSold;



}
