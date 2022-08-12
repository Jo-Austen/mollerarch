package com.benjen.mollerarch;

import com.benjen.mollerarch.mapper.TestCaseMapper;
import com.benjen.mollerarch.service.TestCaseService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

//@MapperScan("com.benjen.mollerarch.mapper")
@SpringBootApplication
@Slf4j
public class MollerarchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MollerarchApplication.class, args);
	}
}
