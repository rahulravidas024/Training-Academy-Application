package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.configuration.DBConnection;
import com.model.Batch;

public class BatchDaoImplementation implements BatchDao {
	
	private Batch extractBatchFromResultSet(ResultSet rs) throws SQLException {

		Batch batch = new Batch();
		batch.setBatch_id(rs.getInt("batch_id"));
		batch.setBatchName(rs.getString("batch_name"));
		batch.setTrainerName(rs.getString("trainer_name"));
		return batch;
	}

	@Override
	public List<Batch> getAllBatch() {
		try (Connection connection = DBConnection.getConnection();) {
			ArrayList<Batch> batches = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM batch");

			while (rs.next()) {
				Batch batch= extractBatchFromResultSet(rs);
				batches.add(batch);
			}
			return batches;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Batch showBatchNameWhoseAveragePercentageIsBest() {
		try (Connection connection = DBConnection.getConnection();) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select b.batch_id, b.batch_name, b.trainer_name, avg(m.percentage) as average from student s join marks m join batch b on s.batch_id=b.batch_id group by b.batch_id, b.trainer_name order by average desc limit 1");
			while (rs.next()) {
				System.out.println("Batch ID: " + rs.getInt("batch_id"));
				System.out.println("Batch Name: " + rs.getString("batch_name"));
				System.out.println("Trainer Name: " + rs.getString("trainer_name"));
				System.out.println("------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Batch showWorstBatch() {
		try (Connection connection = DBConnection.getConnection();) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select b.batch_id, b.batch_name from student s join batch b join marks m on s.batch_id=b.batch_id and s.student_id=m.student_id and m.percentage<50 group by b.batch_id order by count(s.student_id) desc limit 1");
			while (rs.next()) {
				System.out.println("Batch ID: " + rs.getInt("batch_id"));
				System.out.println("Batch Name: " + rs.getString("batch_name"));
				System.out.println("------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
