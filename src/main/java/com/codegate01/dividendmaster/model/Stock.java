package com.codegate01.dividendmaster.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue
    private Long stockId;

    @Column(nullable = false,unique = true )
    private String ticker;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String exchangeName;

    @Column(nullable = false)
    private String sector;

    @Column(nullable = false)
    private String businessSummary;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String website;

    private double dividendYield;
    private Date lastDividend;
    private Date exDividend;

    //@ManyToOne -> Many stocks to one portfolio
    @ManyToMany
    @JoinColumn(name = "portfolio_id")
    private List<Portfolio> portfolio;

    public Stock(String ticker, String name, String exchangeName, String sector, String businessSummary, String country, String website) {
        this.ticker = ticker;
        this.name = name;
        this.exchangeName = exchangeName;
        this.sector = sector;
        this.businessSummary = businessSummary;
        this.country = country;
        this.website = website;
    }
}
