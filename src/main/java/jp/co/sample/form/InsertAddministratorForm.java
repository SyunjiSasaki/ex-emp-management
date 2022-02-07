package jp.co.sample.form;
/**
 * 
 * @author sasak
 *
 */
public class InsertAddministratorForm {
	/**
	 * 名前
	 */
	private String name;
	
	/**
	 * mail
	 */
	private String mailAddress;
	
	/**
	 * password
	 */
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
