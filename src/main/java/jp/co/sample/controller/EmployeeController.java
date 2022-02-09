package jp.co.sample.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 
 * @author sasak
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute
	public UpdateEmployeeForm setUpForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 従業員一覧画面
	 * 
	 * @return 従業員一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		
		if(session.getAttribute("administratorName") == null) {
			return "administrator/login";
		}
		
		List<Employee> employeeList = employeeService.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}

	/**
	 * 従業員詳細画面
	 * 
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	/**
	 * 従業員詳細更新.
	 * 
	 */
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return showDetail(form.getId(), model);
		}

		Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));

		/** 扶養人数 */
		employee.setDependentsCount(form.getIntDependentsCount());

		/** 名前 */
		employee.setName(form.getName());

		/** 住所 */
		employee.setAddress(form.getAddress());

		/** メールアドレス */
		employee.setMailAddress(form.getMailAddress());

		/** 電話番号 */
		employee.setTelephone(form.getTelephone());

		/** 郵便番号 */
		employee.setZipCode(form.getZipCode());

		/** 性別 */
		employee.setGender(form.getGender());

		/** 給料 */
		employee.setSalary(form.getIntSalary());

		/** 入社日 */
		employee.setHireDate(java.sql.Date.valueOf(form.getHireDate()));

		/** 特徴 */
		employee.setCharacteristics(form.getCharacteristics());

		employeeService.update(employee);

		return "redirect:/employee/showList";
	}
}