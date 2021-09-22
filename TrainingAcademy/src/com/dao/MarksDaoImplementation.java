package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.configuration.DBConnection;
import com.model.Marks;
import com.model.Student;

public class MarksDaoImplementation implements MarksDao {

	public MarksDaoImplementation() {
	}
	
	private Marks extractMarksFromResultSet(ResultSet rs) throws SQLException {

		Marks marks = new Marks();
		marks.setStudentId(rs.getInt("student_id"));
		marks.setEnglish(rs.getInt("english"));
		marks.setPhysics(rs.getInt("physics"));
		marks.setChemistry(rs.getInt("chemistry"));
		marks.setMaths(rs.getInt("maths"));
		marks.setBiology(rs.getInt("biology"));
		marks.setTotalMarks(rs.getInt("total_marks"));
		marks.setPercentage(rs.getFloat("percentage"));
		return marks;
	}

	public Marks getMarks(int studentId) {

		try (Connection connection = DBConnection.getConnection();) {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM marks WHERE student_id=?");
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Student Id: " + rs.getInt("student_id"));
				System.out.println("English Marks: " + rs.getInt("english"));
				System.out.println("Physics Marks: " + rs.getInt("physics"));
				System.out.println("Chemistry Marks: " + rs.getInt("chemistry"));
				System.out.println("Maths Marks: " + rs.getInt("maths"));
				System.out.println("Biology Marks: " + rs.getInt("biology"));
				System.out.println();
				System.out.println("Total Marks: " + rs.getInt("total_marks"));
				System.out.println("Percentage: " + rs.getFloat("percentage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Marks> getAllMarks() {
		try (Connection connection = DBConnection.getConnection();) {
			ArrayList<Marks> mark = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM marks");

			while (rs.next()) {
				Marks marks = extractMarksFromResultSet(rs);
				mark.add(marks);
			}
			return mark;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public int insertMarks(Marks marks) {

		try (Connection connection = DBConnection.getConnection();) {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO marks VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, marks.getStudentId());
			ps.setInt(2, marks.getEnglish());
			ps.setInt(3, marks.getPhysics());
			ps.setInt(4, marks.getChemistry());
			ps.setInt(5, marks.getMaths());
			ps.setInt(6, marks.getBiology());
			ps.setInt(7, marks.getTotalMarks());
			ps.setFloat(8, marks.getPercentage());
			int i = ps.executeUpdate();
			if (i == 1) {
				return i;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int updateMarks(Marks marks) {

		try (Connection connection = DBConnection.getConnection();) {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE marks SET english = ?, physics = ?, chemistry = ?, maths = ?, biology = ?, total_marks = ?, percentage = ? where student_id = ?");
			ps.setInt(1, marks.getEnglish());
			ps.setInt(2, marks.getPhysics());
			ps.setInt(3, marks.getChemistry());
			ps.setInt(4, marks.getMaths());
			ps.setInt(5, marks.getBiology());
			ps.setInt(6, marks.getTotalMarks());
			ps.setFloat(7, marks.getPercentage());
			ps.setInt(8, marks.getStudentId());
			int i = ps.executeUpdate();
			if (i == 1) {
				return i;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int deleteMarks(int studentId) {

		try (Connection connection = DBConnection.getConnection();) {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM marks WHERE student_id=" + studentId);
			if (i == 1) {
				return i;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

}
