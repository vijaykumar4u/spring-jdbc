package com.vidvaan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.vidvaan.bean.CarBean;

public class CarsDaoImpl implements CarsDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void inser(CarBean carBean) {
		jdbcTemplate.update("insert into cars values(?,?,?,?)", new Object[] { carBean.getCarId(),
				carBean.getBrandName(), carBean.getCarName(), carBean.getCarPrice() });

	}

	public List<CarBean> getAllCars() {

		return jdbcTemplate.query("select * from Cars", new RowMapper() {

			public CarBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				CarBean carBean = new CarBean();
				carBean.setCarId(rs.getInt(1));
				carBean.setBrandName(rs.getString(2));
				carBean.setCarName(rs.getString(3));
				carBean.setCarPrice(rs.getDouble(4));

				return carBean;
			}
		});
	}

	public void update(CarBean carBean) {
		jdbcTemplate.update("update cars set brandname=? where srno=?", carBean.getBrandName(), carBean.getCarId());

	}

	public void deleteById(int id) {
		jdbcTemplate.update("delete from cars where srno=?", id);

	}

	public Map<String, Float> getCars() {

		return jdbcTemplate.query("select * from cars", new ResultSetExtractorImpl());
	}

	public List<CarBean> getAll() {
		RowMapper<CarBean> beanMapper = new BeanPropertyRowMapper<CarBean>(CarBean.class);

		return jdbcTemplate.query("select * from cars", beanMapper);
	}

}
