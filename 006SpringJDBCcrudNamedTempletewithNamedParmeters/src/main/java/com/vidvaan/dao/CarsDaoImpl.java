package com.vidvaan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.vidvaan.bean.CarBean;

public class CarsDaoImpl implements CarsDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<CarBean> getwithNamedJdbcTemplete() {
		String sql = "Select * from cars";
		List<CarBean> listCars = (List) namedParameterJdbcTemplate.query(sql, new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				CarBean carBean = new CarBean();
				carBean.setCarId(rs.getInt("Srno"));// here we can give index No or coumnName(1)
				carBean.setBrandName(rs.getString("brandName"));
				carBean.setCarName(rs.getString("carName"));
				carBean.setCarPrice(rs.getDouble("carPrice"));
				return carBean;
			}
		});
		return listCars;

	}

	public void insert(CarBean bean) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("srno", bean.getCarId());
		paramMap.put("brandname", bean.getBrandName());
		paramMap.put("carname", bean.getCarName());
		paramMap.put("carPrice", bean.getCarPrice());
		namedParameterJdbcTemplate.update("insert into cars values(:srno,:brandname,:carname,:carPrice)", paramMap);

	}

	public void delete(int id) {
		String sql = "delete from cars where srno=:id";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", Integer.valueOf(id));
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		System.out.println("record deleted");

	}

	public CarBean getById(int srno) {
		String sql = "select * from Cars where srno=:srno";
		SqlParameterSource namedParameterSource = new MapSqlParameterSource("srno", Integer.valueOf(srno));
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameterSource, new RowMapper() {

			public CarBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				CarBean carBean = new CarBean();
				carBean.setCarId(rs.getInt("srno"));
				carBean.setBrandName(rs.getString("brandname"));
				carBean.setCarName(rs.getString("brandName"));
				carBean.setCarPrice(rs.getDouble("carPrice"));

				return carBean;

			}
		});

	}
//first way to update
//	public void update(CarBean bean) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("brandName", bean.getBrandName());
//		map.put("carName", bean.getCarName());
//		map.put("carId", bean.getCarId());
//		String sql = "update cars set brandName=:brandName,carName=:carName where srno=:carId";
//		namedParameterJdbcTemplate.update(sql, map);
//		System.out.println("updated>>>>>>>>>>>......");
//		
//	}
//second way to update
	public void update(CarBean carBean) {
		String sql = "update cars set brandName=:brandName,carName=:carName where srno=:carId";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(carBean);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		System.out.println("Bean updated");

}
}
