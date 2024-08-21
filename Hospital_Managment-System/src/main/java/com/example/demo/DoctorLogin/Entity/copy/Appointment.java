package com.example.demo.DoctorLogin.Entity.copy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String age;
	private String symtoms;
	private String number;
	public Appointment(int id, String name, String age, String symtoms, String number) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.symtoms = symtoms;
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSymtoms() {
		return symtoms;
	}
	public void setSymtoms(String symtoms) {
		this.symtoms = symtoms;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
