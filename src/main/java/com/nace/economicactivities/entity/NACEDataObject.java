package com.nace.economicactivities.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "nace")
public class NACEDataObject {

    @Id
    @Column(name = "ordernace")
    @CsvBindByName(column = "Order")
    private String order;

    @CsvBindByName(column = "Level")
    @Column(name = "level")
    private String level;

    @CsvBindByName(column = "Code")
    @Column(name = "code")
    private String code;

    @CsvBindByName(column = "Parent")
    @Column(name = "parent")
    private String parent;

    @CsvBindByName(column = "Description")
    @Column(name = "description")
    private String description;

    @CsvBindByName(column = "This item includes")
    @Column(name = "itemincludes")
    private String itemIncl;

    @CsvBindByName(column = "This item also includes")
    @Column(name = "itemalsoincludes")
    private String itemAlsoIncl;

    @CsvBindByName(column = "Rulings")
    @Column(name = "rulings")
    private String rulings;

    @CsvBindByName(column = "This item excludes")
    @Column(name = "itemexcludes")
    private String itemExcl;

    @CsvBindByName(column = "Reference to ISIC Rev. 4")
    @Column(name = "referencetoisic")
    private String refToIsic;

}
