package com.vasanth.SpringFrameWorks.Controller;

import com.vasanth.SpringFrameWorks.Entity.Department;
import com.vasanth.SpringFrameWorks.Exceptions.DepartmentNotFound;
import com.vasanth.SpringFrameWorks.Service.DepartmentService;
import com.vasanth.SpringFrameWorks.Service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment  of DepartmentController");
       return departmentService.saveDepartment(department);

    }
   @GetMapping("/departments")
   //@RequestMapping(value="/departments", method= RequestMethod.POST)
    public List<Department> fetchDepartmentList(){
       LOGGER.info("Inside fetchDepartmentList  of DepartmentController");
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFound {
        LOGGER.info("Inside fetchDepartmentByID  of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById  of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        LOGGER.info("Inside updateDepartment  of DepartmentController");
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName  of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
        @GetMapping("/departments/ignoreCase/name/{name}")
    public Department fetchDepartmentByNameIgnoreCase(@PathVariable("name") String departmentName){
            LOGGER.info("Inside fetchDepartmentByNameIgnoreCase  of DepartmentController");
        return departmentService.fetchDepartmentByNameIgnoreCase(departmentName);
    }

}
