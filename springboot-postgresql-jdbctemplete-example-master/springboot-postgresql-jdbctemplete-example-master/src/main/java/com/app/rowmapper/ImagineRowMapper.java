package com.app.rowmapper;

import com.app.model.Imagine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImagineRowMapper implements RowMapper<Imagine> {

	public Imagine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Imagine employee=new Imagine();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setDefine(rs.getString("define"));
		employee.setTimes(rs.getInt("times"));
		employee.setAddtime(rs.getString("addtime"));
		employee.setEdittime(rs.getString("edittime"));
		employee.setF1(rs.getString("f1"));
		employee.setF2(rs.getString("f2"));
		employee.setF3(rs.getString("f3"));
		employee.setF4(rs.getString("f4"));
		employee.setF5(rs.getString("f5"));
		employee.setF6(rs.getString("f6"));
		employee.setF7(rs.getString("f7"));
		employee.setF8(rs.getString("f8"));
		employee.setF9(rs.getString("f9"));
		return employee;
	}

}