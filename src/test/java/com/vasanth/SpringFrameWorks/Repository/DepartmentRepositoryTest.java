package com.vasanth.SpringFrameWorks.Repository;

import com.vasanth.SpringFrameWorks.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

        Department department  = Department.builder()
                .departmentCode("121")
                .departmentAddress("CSE-06")
                .departmentName("CSE")
                .build();

        testEntityManager.persist(department);
    }
    @Test
    public void whenFindId_thenReturnDepartment(){
        Department department = departmentRepository.findById(1l).get();
        assertEquals(department.getDepartmentName(),"CSE");

    }

}