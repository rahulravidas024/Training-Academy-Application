package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.dao.StudentDaoImplementation;
import com.model.Student;

public class StudentServiceImplementation implements StudentService{

	StudentDao studentDao;
	
	public StudentServiceImplementation() {
		studentDao=new StudentDaoImplementation();
	}
	
	public StudentServiceImplementation(StudentDao studentdao) {
		this.studentDao = studentdao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student getStudent(int studentId) {
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}

	@Override
	public int insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	@Override
	public int deleteStudent(int studentId) {
		return studentDao.deleteStudent(studentId);
	}

	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
	

}
