package org.example.huaxin6.dept.service;

import java.util.List;

import org.example.huaxin6.dept.controller.DepartmentForm;
import org.example.huaxin6.dept.entity.Department;
import org.springframework.ui.Model;

public interface DepartmentService {
	List<Department> list();
	
	boolean add(DepartmentForm departmentForm, Model model);
	
	boolean del(String id, Model model);
	
	boolean update(String id, Model model);
	
	boolean toUpdate(DepartmentForm departmentForm, Model model);
}
