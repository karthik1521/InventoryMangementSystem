package com.ims.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private int pquantity;
	private double price;
	private String category;
	private String supplier;
	private LocalDate Dateofpacking;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int pid, String pname, int pquantity, double price, String category, String supplier,
			LocalDate dateofpacking) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pquantity = pquantity;
		this.price = price;
		this.category = category;
		this.supplier = supplier;
		Dateofpacking = dateofpacking;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public LocalDate getDateofpacking() {
		return Dateofpacking;
	}
	public void setDateofpacking(LocalDate dateofpacking) {
		Dateofpacking = dateofpacking;
	}
	
}
