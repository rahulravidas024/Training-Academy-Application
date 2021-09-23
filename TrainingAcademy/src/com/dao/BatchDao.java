package com.dao;

import java.util.List;

import com.model.Batch;

public interface BatchDao {

	List<Batch> getAllBatch();

	Batch showBatchNameWhoseAveragePercentageIsBest();
	
	Batch showWorstBatch();

}
