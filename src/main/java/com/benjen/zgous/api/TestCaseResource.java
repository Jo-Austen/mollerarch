package com.benjen.zgous.api;


import com.benjen.zgous.domain.Account;
import com.benjen.zgous.domain.TestCase;
import com.benjen.zgous.repo.AccountRepo;
import com.benjen.zgous.repo.TestCaseRepo;
import com.benjen.zgous.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TestCaseResource {

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private TestCaseRepo testCaseRepo;

    @Autowired
    private AccountRepo accountRepo;

    @PostMapping("/testcase/{email}/save")
    public ResponseEntity<TestCase> saveTestCase(@PathVariable(value = "email") String email,
                                                 @RequestBody TestCase testCase) {
        System.out.println("savetestcase start...");
        Account account = accountRepo.findAccountByEmail(email);
        testCase.setAccount(account);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/testcase/{accountId}/save").toUriString());
        return ResponseEntity.created(uri).body(testCaseService.saveTestCase(testCase));

    }

    @DeleteMapping("/testcase/{testcaseId}/delete")
    public ResponseEntity<HttpStatus> deleteTestCaseById(@PathVariable(value = "testcaseId") Long testcaseId) {
        testCaseRepo.deleteById(testcaseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/testcase/{id}")
    public ResponseEntity<TestCase> updateTutorial(@PathVariable("id") long id, @RequestBody TestCase tutorial) {
        Optional<TestCase> _tutorial = testCaseRepo.findById(id);
        if (_tutorial.isPresent()) {
            TestCase testCase = _tutorial.get();
            testCase.setTestCaseName(tutorial.getTestCaseName());
            return new ResponseEntity<>(testCaseService.saveTestCase(testCase), HttpStatus.OK);
        }
        return null;
    }

}
