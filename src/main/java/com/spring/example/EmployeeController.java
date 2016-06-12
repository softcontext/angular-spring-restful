package com.spring.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.model.Employee;

/*
 * import short-cut: ctrl+shift+o
 */
// comment: 주석
//annotation: 주해

//@Controller // HTML
@RestController // JSON 문자열
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> emps = new ArrayList<Employee>();
	
	public EmployeeController() {
		emps.add(new Employee(1, "11", "22"));
		emps.add(new Employee(2, "aa", "bb"));
		emps.add(new Employee(3, "33", "44"));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Object get(){
		return emps;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Object edit(@PathVariable int id){
		System.out.println("id: "+id);
		
		int idx = -1;
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getId() == id) {
				idx = i;
				break;
			}
		}
		
		if (idx != -1) {
			return emps.get(idx);
		}
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Object post(@RequestBody Employee emp){
		System.out.println(emp.getId()+","+emp.getFirst()+","+emp.getLast());
		Employee e = emps.get(emps.size()-1);
		emp.setId(e.getId()+1);
		emps.add(emp);
		return emp;
	}
	
	@RequestMapping(value={"/{id}"}, method=RequestMethod.DELETE)
	public Object delete(@PathVariable int id){
		System.out.println("id: "+id);
		
		int idx = -1;
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getId() == id) {
				idx = i;
				break;
			}
		}
		
		if (idx != -1) {
			emps.remove(idx);
		}
		
		return emps;
	}
}
