package jp.co.sample.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 
 * @author sasak
 *
 */
public class InsertAddministratorForm {
	/**
	 * 名前
	 */
	@NotBlank(message="名前は必須項目です")
	private String name;
	
	/**
	 * mail
	 */
	@Size(min=1,max=100,message="メールアドレスは1文字以上150文字以内で入力してください")
	private String mailAddress;
	
	/**
	 * password
	 */
	@Size(min=1,max=100,message="パスワードは1文字以上150文字以内で入力してください")
	private String password;
	
	/**
	 * getter setter 
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "InsertAddministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
	
	
}
