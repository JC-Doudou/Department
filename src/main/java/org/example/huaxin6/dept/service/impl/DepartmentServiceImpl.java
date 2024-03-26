package org.example.huaxin6.dept.service.impl;

import java.util.List;

import org.example.huaxin6.dept.entity.Department;
import org.example.huaxin6.dept.mapper.DepartmentDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import org.example.huaxin6.dept.controller.DepartmentForm;
import org.example.huaxin6.dept.mapper.EmployeeDao;
import org.example.huaxin6.dept.service.DepartmentService;

@Transactional // 可以省略，一个方法不涉及到2个以上增删改操作
@Service  // IoC
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired  // DI
	private DepartmentDao departmentDao;
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Department> list() {
		return departmentDao.list();
	}
	
	@Override
	public boolean add(DepartmentForm departmentForm, Model model) {
		// TODO Auto-generated method stub
		// 主键重复
		Department d = departmentDao.findById(departmentForm.getDepartmentId());
		if (d != null) { // 重复了
			model.addAttribute("departmentForm", departmentForm); // 数据回显
			model.addAttribute("msg", "主键重复");
			return false;
		}
		
		// 把DepartmentForm => Department
		Department department = new Department();
		// 拷贝属性：把第1个对象属性拷贝到第2个对象同名/同类型属性上
		BeanUtils.copyProperties(departmentForm, department);
		
		int row = departmentDao.insert(department);
		if (row == 1) {
			return true;
		} else {
			model.addAttribute("msg", "添加失败");
			model.addAttribute("departmentForm", departmentForm); // 数据回显
			return false;
		}
	}

	
	@Override
	public boolean del(String id, Model model) {
		// TODO Auto-generated method stub
		// 是否有外键引用
		int n = employeeDao.count(id);
		if (n > 0) { // 有外键引用
			model.addAttribute("msg", "有外键引用无法删除");
			return false;
		}
		
		int m = departmentDao.delete(Integer.parseInt(id)); // 类型转换
		if (m != 1) { // 失败
			model.addAttribute("msg", "删除失败");
			return false;
		}
		
		return true; // 成功
	}

	@Override
	public boolean update(String id, Model model) {
		// TODO Auto-generated method stub
		Department department = departmentDao.findById(Integer.parseInt(id));
		model.addAttribute("d", department);
		return true;
	}

	@Override
	public boolean toUpdate(DepartmentForm departmentForm, Model model) {
		// TODO Auto-generated method stub
		// 把DepartmentForm => Department
		Department department = new Department();
		BeanUtils.copyProperties(departmentForm, department);
		int row = departmentDao.update(department);
		if (row != 1) {
			model.addAttribute("msg", "修改失败");
			return false;
		}
		return true;
	}

}











