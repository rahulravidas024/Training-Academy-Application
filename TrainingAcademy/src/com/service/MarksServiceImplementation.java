package com.service;

import java.util.List;

import com.dao.MarksDao;
import com.dao.MarksDaoImplementation;
import com.model.Marks;

public class MarksServiceImplementation implements MarksService {

	MarksDao marksDao;

	public MarksServiceImplementation() {
		marksDao = new MarksDaoImplementation();
	}

	public MarksServiceImplementation(MarksDao marksdao) {
		this.marksDao = marksdao;
	}

	public MarksDao getMarksDao() {
		return marksDao;
	}

	public void setMarksDao(MarksDao marksDao) {
		this.marksDao = marksDao;
	}

	public Marks getMarks(int studentId) {
		return marksDao.getMarks(studentId);
	}

	@Override
	public List<Marks> getAllMarks() {
		return marksDao.getAllMarks();
	}

	@Override
	public int insertMarks(Marks marks) {
		return marksDao.insertMarks(marks);
	}

	@Override
	public int deleteMarks(int studentId) {
		return marksDao.deleteMarks(studentId);
	}

	@Override
	public int updateMarks(Marks marks) {
		return marksDao.updateMarks(marks);
	}


}
