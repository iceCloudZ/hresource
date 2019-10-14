package com.jiujiuhouse.resource.entity;

import com.jiujiuhouse.resource.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jj_house")
public class HouseEntity extends BaseEntity {

    @Id
    @SequenceGenerator(sequenceName = "house_sequence", name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "city_id")
    private Integer cityId;

    @ApiModelProperty("城市名")
    @Column(name = "city_name", length = 128)
    private String cityName;

    @Column(name = "community_id")
    private Integer communityId;

    @ApiModelProperty("小区名")
    @Column(name = "community_name", length = 128)
    private String communityName;

    @Column(name = "first_pic", length = 128)
    private String firstPic;

    @ApiModelProperty("面积,单位为dm2")
    @Column(name = "area")
    private Integer area;

    @ApiModelProperty("价格,单位为元")
    @Column(name = "price")
    private Integer price;

    public static enum Position {
        EAST,
        SOUTH,
        WEST,
        NORTH
    }

    @ApiModelProperty("朝向")
    @Enumerated(EnumType.STRING)
    private Position position = Position.SOUTH;

    public static enum HouseStatus {
        NORMAL,
        // 正常
        SELLING,
        //出售
        RENTING,
        //出租
        SELLED,
        //售出
        RENTED
        //租出
    }

    @ApiModelProperty("房屋状态")
    @Enumerated(EnumType.STRING)
    private HouseStatus houseStatus = HouseStatus.NORMAL;

    @ApiModelProperty("X室")
    @Column(name = "room_count")
    private Integer roomCount;

    @ApiModelProperty("X厅")
    @Column(name = "hall_count")
    private Integer hallCount;

    @ApiModelProperty("X卫")
    @Column(name = "bath_count")
    private Integer bathCount;
}
