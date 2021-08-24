package com.codegate01.dividendmaster.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private Long portfolioId;

    private String name;

    @ManyToMany(mappedBy = "portfolio")
    private List<Stock> stocks;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


}
