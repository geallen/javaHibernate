package com.hibernateex01.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.hibernateex01.dao.DatabaseOperations;

@ManagedBean(name="personList")
@SessionScoped
public class PersonList {

	private List<Person> personList;
	private final Person person;
	public DatabaseOperations dbOp;
	
	public PersonList(){
		personList = new ArrayList<Person>();
		person = new Person();
		dbOp = new DatabaseOperations();
	}
	
	public Person getPerson(){
		return person;
	}
	
	public List<Person> getRecords(){
		personList = dbOp.getPersons();
		return personList;
	}
	
	public void addPeople(){
		dbOp.addPerson(new Person(person.getName(), person.getLastname(), person.getAge(), person.getNationality()));
		personList.add(new Person(person.getName(), person.getLastname(), person.getAge(), person.getNationality()));
		person.setName("");
		person.setLastname("");
		person.setAge(0);
		person.setNationality("");
	}
	
	public void deletePerson(Person p){
		dbOp.deletePerson(p);
		
	}
}
