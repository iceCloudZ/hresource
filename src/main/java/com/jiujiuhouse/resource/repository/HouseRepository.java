package com.jiujiuhouse.resource.repository;

import com.jiujiuhouse.resource.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author zihao.zhao
 */
@Repository
public interface HouseRepository extends JpaRepository<HouseEntity, Long> {

}
