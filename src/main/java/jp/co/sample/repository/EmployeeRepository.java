package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;
/**
 * 
 * @author sasak
 *
 */
@Repository
public class EmployeeRepository {
	/**
	 * ROWMAPPERを定義
	 */
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs,i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hire_date"));
		employee.setMailAddress(rs.getString("mail_address"));
		employee.setZipCode(rs.getString("zip_code"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependents_count"));
		return employee;
		};
		
		
		@Autowired
		private NamedParameterJdbcTemplate template;
		
		/**
		 * 
		 * @return
		 * 従業員一覧情報を取得（入社日の降順）
		 */
		public List<Employee> findAll(){
			String sql = "select * from employees order by hire_date desc";
			
			List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
			
			if(employeeList == null) {
				return employeeList;
			}
				
			return employeeList;	
		}
		
		/**
		 * 主キーから従業員情報を取得する
		 * @param id
		 * @return
		 */
		public Employee load(Integer id) {
			String sql = "select * from employees where id = :id";
			
			SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
			
			Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
			
			return employee;
		}
		
		/**
		 * 従業員情報を変更する
		 * @param employee
		 */
		public void update(Employee employee) {
			
			SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
			
			String updateSql = "update employees set name = :name, image = :image, gender = :gender, hire_date = :hireDate, mail_address = :mailAddress, "
					+ "zip_code = :zipCode, address = :address, telephone = :telephone, salary = :salary, characteristics = :characteristics, dependends_count = :dependendsCount,"
					+ "where id = :id";
			
			template.update(updateSql, param);
			
		}
}
