package com.hybrid.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;

public class DeptDao {

	static Log log = LogFactory.getLog(DeptDao.class);

	DeptMapper mapper;

	public void setDeptMapper(DeptMapper mapper) {
		this.mapper = mapper;
	}

	public List<Dept> selectAll() {
		log.info("dept size = " + mapper.selectAll().size());
		return mapper.selectAll();
	}

	public List<Dept> selectAllWithEmps() {
		log.info("dept size = " + mapper.selectAllWithEmps().size());
		return mapper.selectAllWithEmps();
	}

	public Dept selectByDeptno(int deptno) {
		return mapper.selectByDeptno(deptno);

	}

	public Dept seelctByDeptnoWithEmps(int deptno) {
		return mapper.selectByDeptnoWithEmps(deptno);
	}
	
	public int insert(Dept dept)
	{
		return mapper.insert(dept);
	}
}