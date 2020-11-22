package com.vidvaan.dao;

import java.util.List;
import java.util.Map;

import com.vidvaan.bean.CarBean;

public interface CarsDao {
	
void insert (CarBean bean);
void update (CarBean bean);
void delete(int  id);
List<CarBean> getwithNamedJdbcTemplete();
CarBean getById(int srno);	
	
}
