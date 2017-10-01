package com.hibernateex01.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;


import com.hibernateex01.pojo.Person;
import com.hibernateex01.util.HibernateUtil;

public class DatabaseOperations {
	
	private static Transaction tObj;
	private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();
	
	public void addPerson(Person p){
		try{
			tObj = sessionObj.beginTransaction();
			sessionObj.save(p);
			/*Query q = sessionObj.createQuery("Insert into Person(name, lastname, age, nationality) Values (" + p.getName() + "," + p.getLastname()+"," + p.getAge()+ "," +p.getNationality()+")");
			int result = q.executeUpdate();
			if(result > 0){
				System.out.println("Succesfully inserted.");
			}*/
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			tObj.commit();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPersons(){
		List<Person> personList = new ArrayList<Person>();
		Query q = sessionObj.createQuery("From Person ");
		personList = q.list();
		return personList;		
	}
	
	public void deletePerson(Person p){
		Query q = sessionObj.createQuery("delete from Person where personid=:PID");
		q.setParameter("PID", p.getPersonid());
		int result = q.executeUpdate();
		if(result > 0){
			System.out.println("Succesfully removed");
		}
	}
	
}
