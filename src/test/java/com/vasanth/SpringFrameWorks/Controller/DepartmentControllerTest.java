package com.vasanth.SpringFrameWorks.Controller;

import com.vasanth.SpringFrameWorks.Entity.Department;
import com.vasanth.SpringFrameWorks.Exceptions.DepartmentNotFound;
import com.vasanth.SpringFrameWorks.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;



    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("CSE")
                .departmentAddress("CSE-06")
                .departmentCode("121")
                .departmentId(1l)
                .build();
    }



    @Test
    void saveDepartment() throws Exception {
       Department inputDepartment = Department.builder()
                .departmentName("CSE")
                .departmentAddress("CSE-06")
                .departmentCode("121")
                .departmentId(1l)
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"CSE\",\n" +
                        "\t\"departmentAddress\":\"CSE-06\",\n" +
                        "\t\"departmentCode\":\"121\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1l)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}