package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;
/**
 * 
 * @author sasak
 *
 */
@Repository
public class AdministratorRepository {
	/**
	 * ROWMAPPER定義
	 */
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs,i) -> {
			Administrator administrator = new Administrator();
			administrator.setId(rs.getInt("id"));
			administrator.setName(rs.getString("name"));
			administrator.setMailAddress(rs.getString("mail_address"));
			administrator.setPassword(rs.getString("password"));
			return administrator;
			};
	
	@Autowired
	private NamedParameterJdbcTemplate template;		
			
	/**
	 * 
	 * @param administrator
	 * 挿入＆更新
	 */
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		
		if(administrator.getId()==null) {
			String insertSql = "insert into administrators(name,mail_address,password) values (:name,:mailAddress, :password)";
			template.update(insertSql, param);
		}else {
			String updateSql = "update administrators set name = :name, mail_address = :mailAddress, password = :password where id = :id";
			template.update(updateSql, param);
		}
	}
	/**
	 * 
	 * @param mailAddress
	 * @param password
	 * @return
	 * 
	 * 管理者情報を
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress,String password) {
		String sql = "select id,name,mail_address,password from administrators where mail_address = :mailAddress and password = :password";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("mail_address",mailAddress).addValue("password", password);
		
		List<Administrator> administratorList = template.query(sql, param,ADMINISTRATOR_ROW_MAPPER);
		
		if(administratorList.size() == 0) {
			return null;
		}
		
		return administratorList.get(0);
	}
	
	
}
