package com.app.dao;



import java.util.List;
import java.util.Map;

import com.app.model.Simple;
import com.app.rowmapper.SimpleRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;
import com.app.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	private static final Logger logger = LogManager.getLogger(EmployeeDaoImpl.class);
	
	

	
		public void addEmployee(Employee employee) {

				
				if(employee!=null) {
					String addEmployee_sql = "INSERT INTO word (name,define, times,addtime,"
                         	+ "edittime,f1,f2,f3,f4,f5,f6,f7,f8,f9)"
                            + " VALUES (:name, :define, :times, :addtime, :edittime,"
                            + " :f1, :f2, :f3, :f4,:f5,:f6,:f7,:f8,:f9)";

	     KeyHolder holder=new GeneratedKeyHolder() ;
		SqlParameterSource param = new MapSqlParameterSource()

				.addValue("name", employee.getName())
				.addValue("define", employee.getDefine())
				.addValue("times", employee.getTimes())
				.addValue("addtime", employee.getAddtime())
				.addValue("edittime", employee.getEdittime())
				.addValue("f1", employee.getF1())
				.addValue("f2", employee.getF2())
				.addValue("f3", employee.getF3())
				.addValue("f4", employee.getF4())
				.addValue("f5", employee.getF5())
				.addValue("f6", employee.getF6())
				.addValue("f7", employee.getF7())
				.addValue("f8", employee.getF8())
				.addValue("f9", employee.getF9());
		logger.info(addEmployee_sql);

							
													template.update(addEmployee_sql ,param,holder);
							}
	}



		public List<Employee> getEmployees()  {
		
			String sql="select * from word";
			logger.info(sql);
			List<Employee> employee=template.query(sql, new EmployeeRowMapper()); 

			return employee;
			
		}

	public List<Employee> findEmployeeByName(String name)  {

		String sql="select * from word where name ='"+name+"'";
		logger.info(sql);
		List<Employee> employee=template.query(sql, new EmployeeRowMapper());
		return employee;
	}


		@Override
		 public Employee findEmployeeById(int id) {
		  String query = "SELECT * FROM word WHERE id = ?";
		 
		  Employee employee = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), id);
		  
		  return employee;
		 }






		
		public boolean existsById(Integer id) {
		    return jdbcTemplate.queryForObject(
		        "SELECT EXISTS(SELECT 1 FROM word where id=?)", Boolean.class, id);
		}


		public void updateEmployee(Employee employee){
			String sql="update word set name=:name,"
					+ "define=:define,times=:times,addtime=:addtime,"
					+ "edittime= :edittime,f1= :f1,f2= :f2,f3= :f3,f4= :f4,f5= :f5,f6= :f6 ,f7= :f7 ,f8= :f8 ,f9= :f9"
					+ " where id= :id";
			     KeyHolder holder=new GeneratedKeyHolder() ;
			    SqlParameterSource param = new MapSqlParameterSource()
						.addValue("id", employee.getId())
						.addValue("name", employee.getName())
						.addValue("define", employee.getDefine())
						.addValue("times", employee.getTimes())
						.addValue("addtime", employee.getAddtime())
						.addValue("edittime", employee.getEdittime())
						.addValue("f1", employee.getF1())
						.addValue("f2", employee.getF2())
						.addValue("f3", employee.getF3())
						.addValue("f4", employee.getF4())
						.addValue("f5", employee.getF5())
						.addValue("f6", employee.getF6())
						.addValue("f7", employee.getF7())
						.addValue("f8", employee.getF8())
						.addValue("f9", employee.getF9());
								        template.update(sql ,param,holder);
	}
		@Override
		public void deleteEmployee(Integer id) {
			
			String sql="DELETE FROM word WHERE id= ?";
		    jdbcTemplate.update(sql,id);
		}
					

}
