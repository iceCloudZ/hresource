package com.jiujiuhouse.resource.service;

import com.jiujiuhouse.resource.entity.House;
import com.jiujiuhouse.resource.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author zzh
 */
@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public Page<House> getList(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber == null ? 0 : pageNumber,
                pageSize == null ? 10 : pageSize, Sort.Direction.ASC, "id");
        return houseRepository.findAll(pageable);
    }


}
