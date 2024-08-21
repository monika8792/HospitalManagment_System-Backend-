package com.example.demo.DoctorLogin.Entity.copy2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Madicines")
public class Madicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String drugsname;
	private String stock;
	public Madicine(int id, String drugsname, String stock) {
		super();
		this.id = id;
		this.drugsname = drugsname;
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDrugsname() {
		return drugsname;
	}
	public void setDrugsname(String drugsname) {
		this.drugsname = drugsname;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Madicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
