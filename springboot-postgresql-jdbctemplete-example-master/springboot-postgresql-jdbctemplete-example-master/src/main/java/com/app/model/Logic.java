package com.app.model;

public class Logic {

	private Integer id;
	private String name;
	private String define;
    private Integer times;
    private String addtime;
	private String edittime;
	private String f1;
	private String f2;
	private String f3;
	private String f4;
	private String f5;
	private String f6;
	private String f7;
	private String f8;
	private String f9;

	public Logic() {
		super();
	}
	public void Logic(Integer id, String name, String define, Integer times,
						 String addtime, String edittime, String f1, String f2, String f3, String f4, String f5, String f6, String f7, String f8, String f9 ) {

		this.id = id;
		this.name = name;
		this.define = define;
		this.times = times;
		this.addtime = addtime;
		this.edittime = edittime;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
		this.f6 = f6;
		this.f7 = f7;
		this.f8 = f8;
		this.f9 = f9;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefine() {
		return define;
	}
	public void setDefine(String define) {
		this.define = define;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getEdittime() {
		return edittime;
	}
	public void setEdittime(String edittime) {
		this.edittime = edittime;
	}
	public String getF1() {
		return f1;
	}
	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return f2;
	}
	public void setF2(String f2) {
		this.f2 = f2;
	}

	public String getF3() {
		return f3;
	}
	public void setF3(String f3) {
		this.f3 = f3;
	}

	public String getF4() {
		return f4;
	}
	public void setF4(String f4) {
		this.f4 = f4;
	}

	public String getF5() {
		return f5;
	}
	public void setF5(String f5) {
		this.f5 = f5;
	}


	public String getF6() {
		return f6;
	}
	public void setF6(String f6) {
		this.f6 = f6;
	}


	public String getF7() {
		return f7;
	}
	public void setF7(String f7) {
		this.f7 = f7;
	}

	public String getF8() {
		return f8;
	}
	public void setF8(String f8) {
		this.f8 = f8;
	}


	public String getF9() {
		return f9;
	}
	public void setF9(String f9) {
		this.f9 = f9;
	}

//	@Override
//	public String toString() {
//		return "Employee [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
//				+ employeeLastName + ", employeeEmail=" + employeeEmail + ", companyName=" + companyName
//				+ ", employeeSalary=" + employeeSalary + ", employeeAddress=" + employeeAddress + ", experience="
//				+ experience + ", department=" + department + ", mobileNumber=" + mobileNumber + "]";
//	}

	

}
