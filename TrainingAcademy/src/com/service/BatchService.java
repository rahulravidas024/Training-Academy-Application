package com.service;

import java.util.List;

import com.model.Batch;

public interface BatchService {
	
	List<Batch> getAllBatch();

	Batch showBatchNameWhoseAveragePercentageIsBest();
	
	Batch showWorstBatch();

}
