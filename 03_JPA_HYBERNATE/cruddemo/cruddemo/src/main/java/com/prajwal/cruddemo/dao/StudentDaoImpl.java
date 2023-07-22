package com.prajwal.cruddemo.dao;

import com.prajwal.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save model
    @Transactional
    @Override
    public void save(Student thestudent) {
        entityManager.persist(thestudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastNameAsc() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by lastName",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastNameDesc() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by lastName desc",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstNameAsc() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by firstName",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstNameDesc() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by firstName desc",Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastname(String lastName) {
        // create query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);
        // set query parameter
        typedQuery.setParameter("theData",lastName);
        // return the results
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstname(String firstName) {
        // create query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student where firstName=:theData",Student.class);
        // set query parameter
        typedQuery.setParameter("theData",firstName);
        // return the results
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student tempStudent = entityManager.find(Student.class,id);
        // delete the Student
        entityManager.remove(tempStudent);

    }
    @Override
    @Transactional
    public int deleteAll() {

        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
