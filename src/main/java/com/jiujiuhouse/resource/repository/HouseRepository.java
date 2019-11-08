package com.jiujiuhouse.resource.repository;

import com.jiujiuhouse.resource.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author zihao.zhao
 */
@RepositoryRestResource
public interface HouseRepository extends JpaRepository<House, Integer> {

}
