package com.spring.example.model;

/*
 * 데이터를 그룹핑해서 관리하는 목적으로 사용하는 클래스
 * Model Object, Value Object, Domain Object, Entity Object, 
 * Data Transfer Object
 */
public class Employee {

	private int id;
	private String first;
	private String last;
	
	public Employee() {}
	
	public Employee(int id, String first, String last) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
}
