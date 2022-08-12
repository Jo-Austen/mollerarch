package com.benjen.mollerarch.mapper;

import com.benjen.mollerarch.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getByIdCC(Long id);

    @Select("select * from city")
    public List<City> queryAllCity();
}
