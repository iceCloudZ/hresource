package com.jiujiuhouse.resource.entity;

        import com.jiujiuhouse.resource.base.BaseEntity;
        import lombok.Data;

        import javax.persistence.*;
        import java.sql.Date;

/**
 * @author zzh
 */
@Data
@Entity
@Table(name = "jj_house_detail")
public class HouseDetail  extends BaseEntity {
    @Id
//    @SequenceGenerator(sequenceName = "house_detail_sequence", name = "seq")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "hangout_date")
    private Date hangoutDate;   //挂牌日期yyyy-MM-dd

    @Column(name = "age", length = 4)
    private String age;    //年代

    @Column(name = "building_type")
    private String buildingType;    //楼房类别-板楼(不超过12曾)/塔楼(高层建筑)

    @Column(name = "total_floor", length = 2)
    private Integer totalFloor;     //总楼层

    @Column(name = "location_floor", length = 2)
    private Integer locationFloor;  //所在楼层

    @Column(name = "elevator")
    private boolean elevator;   //有无电梯

    @Column(name = "renovation")
    private String renovation;  //装修等级:毛坯,简装,精装

    @Column(name = "purpose")
    private String purpose; //住宅类型:普通住,商住

    @Column(name = "ownership")
    private String ownership;   // 所有权:商品房,经济适用房,央产房,军产房,公房,小产权房,自建住房
}
