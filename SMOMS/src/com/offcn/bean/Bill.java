package com.offcn.bean;

public class Bill {

	private int b_id;
	private String b_name;
	private String b_price;
	private String b_pro_id;
	private String b_desc;
	private String b_status;
	private String b_isPay;
	private String b_num;
	private String b_time;
	private String b_remark;
	
	private String pro_name;
	private int pro_id;

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_price() {
		return b_price;
	}

	public void setB_price(String b_price) {
		this.b_price = b_price;
	}

	public String getB_pro_id() {
		return b_pro_id;
	}

	public void setB_pro_id(String b_pro_id) {
		this.b_pro_id = b_pro_id;
	}

	public String getB_desc() {
		return b_desc;
	}

	public void setB_desc(String b_desc) {
		this.b_desc = b_desc;
	}

	public String getB_status() {
		return b_status;
	}

	public void setB_status(String b_status) {
		this.b_status = b_status;
	}

	public String getB_isPay() {
		return b_isPay;
	}

	public void setB_isPay(String b_isPay) {
		this.b_isPay = b_isPay;
	}

	public String getB_num() {
		return b_num;
	}

	public void setB_num(String b_num) {
		this.b_num = b_num;
	}

	public String getB_time() {
		return b_time;
	}

	public void setB_time(String b_time) {
		this.b_time = b_time;
	}

	public String getB_remark() {
		return b_remark;
	}

	public void setB_remark(String b_remark) {
		this.b_remark = b_remark;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

}
