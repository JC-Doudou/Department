package org.example.huaxin6.dept.controller;

import lombok.Data;

@Data
public class DepartmentForm {
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
}
