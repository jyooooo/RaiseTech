package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.DomainForm;
import com.example.service.CalcuService;

@Controller
@RequestMapping("/")

public class MainController {

	@Autowired
	public CalcuService calcuService;

	//全件表示
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("Calculation", calcuService.findAll());
		//index.htmlに画面遷移
		return "index";
	}

	//新規登録画面に遷移
	@GetMapping("/register")
	public String indexregister() {
		return "register";
	}

	//新規登録
	@PostMapping("/create")
	public String create(@Validated @ModelAttribute DomainForm domainform,
			BindingResult result, Model model) {
		//バリデーション(新規)
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
				model.addAttribute("validationError", errorList);
				System.out.println(errorList);
				return "register";
			}


		//登録処理
		calcuService.save(domainform);
		System.out.println(domainform + "が登録されました");

		return "redirect:/";

		}


	//編集
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable String id, Model model) {

		model.addAttribute("Calculations", calcuService.findOne(id));
		return "edit";
	}

	//更新
	@PostMapping("/{id}/update")
	public String update(@Validated @ModelAttribute DomainForm domainform,
			BindingResult results, @PathVariable String id, Model model) {
		//バリデーション(更新)
		if (results.hasErrors()) {
			List<String> errorLists = new ArrayList<String>();
			for (ObjectError error : results.getAllErrors()) {
				errorLists.add(error.getDefaultMessage());
			}

			model.addAttribute("validationError", errorLists);
			System.out.println("更新時のエラーは"+errorLists+"です");
			return "edit";
		}
		//更新処理
		domainform.setId(id);
		calcuService.update(domainform);
		System.out.println("日付ID"+id+"を更新しました ");
		return "redirect:/";
	}

	//削除
	@PostMapping("{id}")
	public String destroy(@PathVariable String id) {

		calcuService.delete(id);
		return "redirect:/";
	}

}
