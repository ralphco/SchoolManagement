package com.schoolmanagement.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entity.Course;
import com.schoolmanagement.entity.Student;
import com.schoolmanagement.entity.StudentDetailsView;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Student> getStudents() {
		
		/*Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
		
		List<Student> theStudents = theQuery.getResultList();
				
		return theStudents;*/
		
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Student > cq = cb.createQuery(Student.class);
        Root < Student > root = cq.from(Student.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        
        System.out.println(query.getResultList());
            
        return query.getResultList();
	}

	@Override
	public void saveStudent(Student theStudent) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//save the customer
		currentSession.saveOrUpdate(theStudent);		
	}

	@Override
	public StudentDetailsView getStudent(int studentId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "FROM StudentDetailsView"
                    + " WHERE id = :id";
		
		 
		StudentDetailsView theStudent = (StudentDetailsView) currentSession.createQuery(sql, StudentDetailsView.class)
				                       .setParameter("id", studentId)
				                       .uniqueResult();
		
		return theStudent;
	}

	@Override
	public List<Course> getCourses() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);
		
		List<Course> theCourses = theQuery.getResultList();
				
		return theCourses;
	}
	
	

}
