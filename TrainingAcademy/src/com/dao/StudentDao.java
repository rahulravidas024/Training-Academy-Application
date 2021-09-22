package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao {

	Student getStudent(int studentId);
	
	Student getName(int studentId);

	List<Student> getAllStudent();

	int insertStudent(Student student);

	int deleteStudent(int studentId);

	int updateStudent(Student student);
}
