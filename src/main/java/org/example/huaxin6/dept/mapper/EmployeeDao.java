package org.example.huaxin6.dept.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeDao {
	
	@Select("select count(*) from employees where department_id = #{departmentId}")
	int count(String departmentId);
	
}
