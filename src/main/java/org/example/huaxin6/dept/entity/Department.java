package org.example.huaxin6.dept.entity;

import lombok.Data;

// 实体类
// _ => 小驼峰规则
@Data
public class Department {
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;

}
