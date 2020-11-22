package com.vidvaan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vidvaan.bean.CarBean;
@Repository("Repository")
public class CarsDaoImpl implements CarsDao {
@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void inser(CarBean carBean) {
		jdbcTemplate.update("insert into cars values(?,?,?,?)", new  Object[] {carBean.getCarId(),carBean.getBrandName(),carBean.getCarName(),carBean.getCarPrice()});

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
		jdbcTemplate.update("update cars set brandname=? where srno=?",carBean.getBrandName(),carBean.getCarId());
		
		
	}

	public void deleteById(int id) {
		jdbcTemplate.update("delete from cars where srno=?",id);
		
	}

}
