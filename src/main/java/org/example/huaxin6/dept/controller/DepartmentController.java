package org.example.huaxin6.dept.controller;

import java.util.List;

import org.example.huaxin6.dept.entity.Department;
import org.example.huaxin6.dept.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	// 查询
	@RequestMapping("/")
	public String index(Model model) {
		// 查询数据库
		List<Department> list = departmentService.list();
		// 使用模型处理数据
		model.addAttribute("list", list);
		
		return "dept_list";
	}
	
	// 显示新增网页
	@RequestMapping("/add")
	public String add() {
		return "dept_add";
	}
	
	// 新增功能
	@RequestMapping("/toAdd")
	public String toAdd(DepartmentForm departmentForm, Model model) {
		boolean b = departmentService.add(departmentForm, model);
		if (b) { // 成功
			return "redirect:/dept/"; // 跳转到查询
		} else { // 失败
			return "dept_add";
		}
	}
	
	// 删除功能
	// /dept/del/10
	@RequestMapping("/del/{id}")
	public String del(@PathVariable String id, Model model) {
		boolean b = departmentService.del(id, model);
		if (b) { // 成功
			return "redirect:/dept/"; // 重定向，model数据丢失
		} else { // 失败
			return "forward:/dept/";  // 请求转发，model数据存在
		}
	}
	
	// 显示修改网页
	@RequestMapping("/update/{id}")
	public String update(@PathVariable String id, Model model) {
		// 根据id查旧数据
		departmentService.update(id, model);
		// 打开视图
		return "dept_update";
	}
	
	// 修改功能
	@RequestMapping("/toUpdate")
	public String toUpdate(DepartmentForm departmentForm, Model model) {
		boolean b = departmentService.toUpdate(departmentForm, model);
		if (b) { // 成功
			return "redirect:/dept/"; // 重新查
		} else { // 失败
			return "dept_update";
		}
	}
	
}









