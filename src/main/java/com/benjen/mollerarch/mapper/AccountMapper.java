package com.benjen.mollerarch.mapper;


import com.benjen.mollerarch.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public Account getAcct(Long id);
}


