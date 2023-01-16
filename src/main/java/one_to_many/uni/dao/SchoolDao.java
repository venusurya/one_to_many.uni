package one_to_many.uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many.uni1dto.School;
import one_to_many.uni1dto.Student;

 

public class SchoolDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("venu");
		return entityManagerFactory.createEntityManager();
	}
	
	public void saveSchool(School school) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();

		
		entityManager.persist(school);
		
		entityTransaction.commit();
	}
	
	
	public void saveStudents(School school,int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school2=entityManager.find(School.class, id);
		school.setId(id);
		school.setName(school2.getName());
		school.setCode(school2.getCode());
		
		entityTransaction.begin();
		List<Student>student=school.getList();
		for (Student student2 : student) {
			entityManager.persist(student2);
		}
		
		entityManager.merge(school);
		
		entityTransaction.commit();
	}
	
	
	
	
	
	
	public void updateSchool(int id,School school) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school2=entityManager.find(School.class, id);
		if(school2!=null) {
			school.setId(id);
			school.setList(school.getList());
			entityTransaction.begin();
			entityManager.merge(school);
			entityTransaction.commit();
			
		}
		else
			System.out.println("Such school is not exist");
	}
	
	public void deleteSchool(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school=entityManager.find(School.class, id);
		if(school!=null)
		{
			entityTransaction.begin();
			entityManager.remove(school);
			entityTransaction.commit();
		}
		else
			System.out.println("Not exist the school");
	}
	
	public void getdetails(int id) {
		EntityManager entityManager=getEntityManager();
		School school= entityManager.find(School.class, id);
		if(school!=null)
		System.out.println(school);
		else
			System.out.println("No such school");
	}
	
	public void getDetailsAllSchool() {
		EntityManager entityManager=getEntityManager();
		Query  query=entityManager.createQuery("select a from School a");
		List<School> school=query.getResultList();
		System.out.println(school);
	}

}
