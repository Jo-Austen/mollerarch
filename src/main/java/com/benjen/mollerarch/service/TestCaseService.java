package com.benjen.mollerarch.service;

import com.benjen.mollerarch.bean.Account;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface TestCaseService {

     void insertCase(Map<String,Object> map);

     List<LinkedHashMap<String, Object>> selectBysql(String sql);
}
