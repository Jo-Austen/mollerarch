package com.benjen.zgous.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity(name = "TestCase")
@Table(
        name = "testcase_list",
        uniqueConstraints = {
                @UniqueConstraint(name = "testcase_testcasename_unique", columnNames = "project_name")
        }
)
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    @Id
    @SequenceGenerator(
            name = "case_sequence",
            sequenceName = "case_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "case_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "testcase_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String testCaseName;

    @Column(
            name = "project_name",
            nullable = false
    )
    private String projectName;
    private String ProjectModule;
    private String requestUrl;
    private String requestMethod;
    private String requestHeader;
    private Boolean isDel;
    private String expectResult;

    @ManyToOne
    @JoinColumn(
            name = "account_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "account_testcase_fk"
            )
    )
    @JsonIgnore
    private Account account;
}
