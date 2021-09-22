package com.model;

public class Marks {

	private int studentId;
	private int english;
	private int physics;
	private int chemistry;
	private int maths;
	private int biology;
	private int totalMarks;
	private float percentage;

	public Marks() {
	}

	public Marks(int studentId, int english, int physics, int chemistry, int maths, int biology, int totalMarks,
			float percentage) {
		super();
		this.studentId = studentId;
		this.english = english;
		this.physics = physics;
		this.chemistry = chemistry;
		this.maths = maths;
		this.biology = biology;
		this.totalMarks = totalMarks;
		this.percentage = percentage;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getBiology() {
		return biology;
	}

	public void setBiology(int biology) {
		this.biology = biology;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Marks [studentId=" + studentId + ", english=" + english + ", physics=" + physics + ", chemistry="
				+ chemistry + ", maths=" + maths + ", biology=" + biology + ", totalMarks=" + totalMarks
				+ ", percentage=" + percentage + "]";
	}

	
}
