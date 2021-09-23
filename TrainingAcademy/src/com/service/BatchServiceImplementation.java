package com.service;

import java.util.List;

import com.dao.BatchDao;
import com.dao.BatchDaoImplementation;
import com.model.Batch;

public class BatchServiceImplementation implements BatchService {
	
	BatchDao batchDao;

	public BatchServiceImplementation() {
		batchDao = new BatchDaoImplementation();
	}

	@Override
	public List<Batch> getAllBatch() {
		return batchDao.getAllBatch();
	}

	@Override
	public Batch showBatchNameWhoseAveragePercentageIsBest() {
		return batchDao.showBatchNameWhoseAveragePercentageIsBest();
	}

	@Override
	public Batch showWorstBatch() {
		return batchDao.showWorstBatch();
	}

}
