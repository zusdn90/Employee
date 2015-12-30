package com.hybrid.dao;

import java.util.List;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;
import com.hybrid.util.Pagination;

public class CityDao {	//Mapper와 연결 의존관계
	CityMapper cityMapper;
	
	//주입
	public void setCityMapper(CityMapper mapper)
	{
		this.cityMapper = mapper;
	}
	
	public int selectCount()
	{
		return cityMapper.selectCount();
	}
	public List<City> selectAll()
	{
		return cityMapper.selectAll();
	}
	
	public List<City> selectPage(Pagination paging)
	{
		return cityMapper.selectPage(paging);
	}
	public List<City> selectByCountryCode(String countryCode)
	{
		return cityMapper.selectByCountryCode(countryCode);
	}
	
	public City selectById(int id) {
		return cityMapper.selectById(id);
	}
	
	public int insert(City city)
	{
		int rtn = cityMapper.insert(city);
		
		return city.getId();
	}

	
	public int update(City city) {
		return cityMapper.update(city);
	}
	
	public int deleteById(int id) {
		return cityMapper.deleteById(id);
	}
	
	public int deleteAll() {
		return cityMapper.deleteAll();
	}
}
