package com.service;

import java.util.List;

import com.model.Marks;
import com.model.Student;

public interface MarksService {
	
	Marks getMarks(int studentId);

	List<Marks> getAllMarks();

	int insertMarks(Marks marks);

	int deleteMarks(int studentId);

	int updateMarks(Marks marks);

}
