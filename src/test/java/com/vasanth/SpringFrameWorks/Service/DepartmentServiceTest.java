package com.vasanth.SpringFrameWorks.Service;

import com.vasanth.SpringFrameWorks.Entity.Department;
import com.vasanth.SpringFrameWorks.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = null;

              department =   department.builder().departmentName("CSE")
                        .departmentAddress("Pune")
                        .departmentCode("CSE-06").build();

        Mockito.when(departmentRepository.findByDepartmentName("CSE")).thenReturn(department);
    }


    @Test
    @DisplayName("Get Data based on valid Department Name")
  //  @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "CSE";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }

}