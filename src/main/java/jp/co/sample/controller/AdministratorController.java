package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAddministratorForm;
import jp.co.sample.service.AdministratorService;
/**
 * 
 * @author sasak
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	 private AdministratorService administratorsService; 
	
	/**
	 * インスタンス化
	 * @return
	 */
	@ModelAttribute
	public InsertAddministratorForm setUpInsertAddministratorForm() {
		return new InsertAddministratorForm();
	}
	
	/**
	 * "administrator/insert.html"にフォワード
	 * @return
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
}
