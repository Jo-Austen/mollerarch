package com.benjen.zgous.service.Impl;


import com.benjen.zgous.domain.Account;
import com.benjen.zgous.domain.TestCase;
import com.benjen.zgous.repo.AccountRepo;
import com.benjen.zgous.repo.TestCaseRepo;
import com.benjen.zgous.service.AccountService;
import com.benjen.zgous.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseRepo testCaseRepo;

    @Autowired
    private AccountRepo accountRepo;



    public TestCase saveTestCase(TestCase testCase) {
//        Account account = accountRepo.findStudentByEmail("bbmac@outlook");
//        testCase.setAccount();
        return testCaseRepo.save(testCase);
    }


}
