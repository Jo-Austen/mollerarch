package com.benjen.mollerarch.service.impl;

import com.benjen.mollerarch.mapper.TestCaseMapper;
import com.benjen.mollerarch.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    TestCaseMapper testCaseMapper;

    @Override
    public void insertCase(Map<String, Object> paramsMap) {
        testCaseMapper.addCase(paramsMap);
    }
    
    @Override
    public List<LinkedHashMap<String, Object>> selectBysql(String sql) {
        return testCaseMapper.selectBysql(sql);
    }
}
