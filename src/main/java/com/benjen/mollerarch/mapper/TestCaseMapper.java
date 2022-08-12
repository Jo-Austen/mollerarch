package com.benjen.mollerarch.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TestCaseMapper {

    int addCase(Map<String,Object> map);

//    @Select("SELECT * FROM autotest.api_testdata_demo;")
    List<LinkedHashMap<String, Object>> selectBysql(String sql);

    List<LinkedHashMap<String, Object>> QueryAllCase(String sql);
}
