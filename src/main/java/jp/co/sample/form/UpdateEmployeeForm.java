package jp.co.sample.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 
 * @author sasak
 *
 */
public class UpdateEmployeeForm {
	/**
	 * id
	 */
	private String id;

	/**
	 * 扶養人数
	 */
	@Pattern(regexp = "^[0-9]+$", message = "数値で入力してください")
	private String dependentsCount;

	@NotBlank(message = "必須項目")
	private String name;

	@NotBlank(message = "必須項目")
	private String mailAddress;

	@NotBlank(message = "必須項目")
	private String zipCode;

	@NotBlank(message = "必須項目")
	private String address;

	@NotBlank(message = "必須項目")
	private String telephone;

	@NotBlank(message = "必須項目")
	private String gender;

	@NotBlank(message = "必須項目")
	private String hireDate;

	@NotBlank(message = "必須項目")
	private String salary;

	@NotBlank(message = "必須項目")
	private String characteristics;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIntId() {
		return Integer.parseInt(id);
	}

	public Integer getIntDependentsCount() {
		return Integer.parseInt(dependentsCount);
	}

	public Integer getIntSalary() {
		return Integer.parseInt(salary);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

}