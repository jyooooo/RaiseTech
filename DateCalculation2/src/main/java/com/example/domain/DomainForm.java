package com.example.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DomainForm {

	@NotBlank (message = "日付IDは必須項目です")
	@Size(min = 1, max = 5, message = "日付IDは1文字以上、5文字以内で日付IDを入力して")
	private String id;

//	@NotBlank(message = "日付名は必須項目です")
	@Size(min = 1, max = 5, message = "日付名は1文字以上、5文字以内で日付名を入力して")
	private String dateName;

//	@NotBlank(message = "計算式は必須項目です")
	@Size(min = 1, max = 5, message = "計算式は1文字以上、5文字以内で計算式を入力して")
	private String formula;

	//	計算基準日
	//	@Size(min = 1, max = 5, message = "Please input 5characters or Less")
	//	@NotNull
	//	private int standardDay;

	//	@Size(min = 1, max = 5, message = "Please input 5characters or Less")
	//	@NotNull
	//	private int year;
	//
	//	@Size(min = 1, max = 5, message = "Please input 5characters or Less")
	//	@NotNull
	//	private int month;
	//
	//	@Size(min = 1, max = 5, message = "Please input 5characters or Less")
	//	@NotNull
	//	private int date;

	//Getter,Setter

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	//	public int getStandardDay() {
	//		return standardDay;
	//	}
	//
	//	public void setStandardDay(int standardDay) {
	//		this.standardDay = standardDay;
	//	}

	//	public int getYear() {
	//		return year;
	//	}
	//
	//
	//	public void setYear(int year) {
	//		this.year = year;
	//	}
	//
	//
	//	public int getMonth() {
	//		return month;
	//	}
	//
	//
	//	public void setMonth(int month) {
	//		this.month = month;
	//	}
	//
	//
	//	public int getDate() {
	//		return date;
	//	}
	//
	//
	//	public void setDate(int date) {
	//		this.date = date;
	//	}

}
