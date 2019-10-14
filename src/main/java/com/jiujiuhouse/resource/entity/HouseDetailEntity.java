package com.jiujiuhouse.resource.entity;

import com.jiujiuhouse.resource.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @author zzh
 */
@Data
@Entity
@Table(name = "jj_house_detail")
public class HouseDetailEntity  extends BaseEntity {
    @Id
    @SequenceGenerator(sequenceName = "house_detail_sequence", name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "id")
    private Integer id;
}
