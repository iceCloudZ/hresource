package com.jiujiuhouse.resource.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jj_house_detail")
public class HouseDetailEntity {
    @Id
    @SequenceGenerator(sequenceName = "house_detail_sequence", name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "id")
    private Integer id;
}
