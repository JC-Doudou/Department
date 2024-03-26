package org.example.huaxin6.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.example.huaxin6.dept.entity.Department;


@Mapper  // 创建实现类的对象，把对象添加到对象池中/IoC
public interface DepartmentDao {
	// 增
	@Insert("insert into departments values (#{departmentId}, #{departmentName}, #{managerId}, #{locationId})")
	int insert(Department department);
	
	// 删
	@Delete("delete from departments where department_id = #{departmentId}")
	int delete(int departmentId);
	
	// 改
	@Update("update departments set department_name = #{departmentName} where department_id = #{departmentId}")
	int update(Department department);
	
	// 查1：根据主键查找一行数据
	@Select("select * from departments where department_id = #{departmentId}")
	Department findById(int departmentId);
	
	// 查2：查询所有数据
	@Select("select * from departments order by department_id")
	List<Department> list();
	
}






