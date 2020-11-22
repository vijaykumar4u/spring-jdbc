package com.vidvaan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ResultSetExtractorImpl implements ResultSetExtractor<Map<String, Float>>{

	public Map<String, Float> extractData(ResultSet rs) throws SQLException, DataAccessException {
	Map<String, Float> map = new HashMap<String, Float>();
	while (rs.next()) {
		map.put(rs.getString(3), rs.getFloat(4));
		
	}
	
		return map;
	}

}
