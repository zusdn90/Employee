package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public interface EmpMapper {
	List<Emp> selectAll();
	List<Emp> selectAllWithDept();
	
	Emp selectByEmpno(int empno);
	Emp selectByEmpnoWithDept(int empno);
	
	int insert(Emp emp);
}
