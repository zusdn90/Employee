package com.hybrid.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.Emp;

public class EmpDao {

	static Log log = LogFactory.getLog(EmpDao.class);
	EmpMapper empMapper;
	
	public void setEmpMapper(EmpMapper mapper)
	{
		this.empMapper = mapper;
	}
	
	public List<Emp> selectAll()
	{
		return empMapper.selectAll();
	}
	
	public Emp selectByEmpno(int empno)
	{
		return empMapper.selectByEmpno(empno);
	}
	public List<Emp> selectAllWithDept()
	{
		return empMapper.selectAllWithDept();
	}
	public Emp selectByEmpnoWithDept(int empno)
	{
		return empMapper.selectByEmpnoWithDept(empno);
	}
	
	public int insert(Emp emp)
	{
		return empMapper.insert(emp);
	}
	
}