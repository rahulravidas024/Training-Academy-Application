package com.dao;

import java.util.List;

import com.model.Marks;
import com.model.Student;

public interface MarksDao {
	
	Marks getMarks(int studentId);

	List<Marks> getAllMarks();

	int insertMarks(Marks marks);

	int deleteMarks(int studentId);

	int updateMarks(Marks marks);

}
