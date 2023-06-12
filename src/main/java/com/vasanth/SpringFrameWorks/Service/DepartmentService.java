package com.vasanth.SpringFrameWorks.Service;

import com.vasanth.SpringFrameWorks.Entity.Department;
import com.vasanth.SpringFrameWorks.Exceptions.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFound;

     public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

    public Department fetchDepartmentByNameIgnoreCase(String departmentName);
}
