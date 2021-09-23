package com.model;

public class Batch {
	
	private int batch_id;
	private String batchName;
	private String trainerName;

	public Batch() {}

	public Batch(int batch_id, String batchName, String trainerName) {
		super();
		this.batch_id = batch_id;
		this.batchName = batchName;
		this.trainerName = trainerName;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public String toString() {
		return "Batch [batch_id=" + batch_id + ", batchName=" + batchName + ", trainerName=" + trainerName + "]";
	}
	
}
