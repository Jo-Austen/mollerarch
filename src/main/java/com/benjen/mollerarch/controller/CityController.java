package com.benjen.mollerarch.controller;

import com.benjen.mollerarch.bean.Account;
import com.benjen.mollerarch.bean.City;
import com.benjen.mollerarch.service.AccountService;
import com.benjen.mollerarch.service.CityService;
import com.benjen.mollerarch.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
//@ResponseBody
@CrossOrigin()
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    AccountService accountService;

    @Autowired
    TestCaseService testCaseService;

    @Value("${mybatis.mapper-locations:}")
    String path;

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
//        System.out.println(path);
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/allCity")
    public List<City> getAllCity(){
        return cityService.getAllCity();
    }

    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id){
        return accountService.getAcctByid(id);
    }

    @ResponseBody
    @GetMapping("/hello")
    public String helloWorld(){
        return "hello,World";
    }


    @ResponseBody
    @PostMapping("/adduser")
    public Map saveCase(@RequestParam Map<String,Object> paramsMap){
        try{
            testCaseService.insertCase(paramsMap);
            return paramsMap;
        }catch (Exception e) {
            System.out.println(e);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("status","insert fail");
            return resultMap;
        }
    }
}
