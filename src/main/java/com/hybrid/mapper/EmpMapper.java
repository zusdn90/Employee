package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public interface EmpMapper {
	List<Emp> selectAll();
	Emp selectByEmpno(int empno);
	List<Emp> selectByDeptno(int deptno);
	

	List<Emp> selectAllWithDept();
	List<Emp> selectAllWithDeptno();
	Emp selectByEmpnoWithDept(int empno);
	
	int insert(Emp emp);
	int delete(Emp emp);
}
