package com.portfolio.loadcsv.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parts_tb")
public class CarParts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID partId;

    private String largeClassification;
    private  String middleClassification;
    private  String smallClassification;
    private  String detailClassification;
}
