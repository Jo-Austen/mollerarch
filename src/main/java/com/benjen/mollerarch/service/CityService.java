package com.benjen.mollerarch.service;

import com.benjen.mollerarch.bean.City;
import com.benjen.mollerarch.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getByIdCC(id);
//        return null;
    }

    public List<City> getAllCity(){
        return cityMapper.queryAllCity();
    }
}
