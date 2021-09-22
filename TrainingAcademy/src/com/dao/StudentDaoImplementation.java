package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.configuration.DBConnection;
import com.model.Student;

public class StudentDaoImplementation implements StudentDao {

	public StudentDaoImplementation() {
	}

	public Student getName(int studentId) {

		try (Connection connection = DBConnection.getConnection();) {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM student WHERE student_id=?");
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Student Name: " + rs.getString("student_firstname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private Student extractStudentFromResultSet(ResultSet rs) throws SQLException {

		Student student = new Student();
		student.setStudentId(rs.getInt("student_id"));
		student.setFirstName(rs.getString("student_firstname"));
		student.setLastName(rs.getString("student_lastname"));
		student.setDateOfBirth(rs.getString("dateofbirth"));
		student.setGender(rs.getString("gender"));
		student.setEmailId(rs.getString("email_id"));
		student.setMobileNumber(rs.getString("mobile_number"));
		student.setAddress(rs.getString("address"));
		student.setBatchId(rs.getInt("batch_id"));
		return student;
	}

	public Student getStudent(int studentId) {

		try (Connection connection = DBConnection.getConnection();) {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM student WHERE student_id=?");
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Student Id: " + rs.getInt("student_id"));
				System.out.println("First Name: " + rs.getString("student_firstname"));
				System.out.println("Last Name: " + rs.getString("student_lastname"));
				System.out.println("Date Of Birth: " + rs.getString("dateofbirth"));
				System.out.println("Gender: " + rs.getString("gender"));
				System.out.println("Email ID: " + rs.getString("email_id"));
				System.out.println("Mobile Number: " + rs.getString("mobile_number"));
				System.out.println("Address: " + rs.getString("address"));
				System.out.println("Batch ID: " + rs.getInt("batch_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> getAllStudent() {
		try (Connection connection = DBConnection.getConnection();) {
			ArrayList<Student> students = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");

			while (rs.next()) {
				Student student = extractStudentFromResultSet(rs);
				students.add(student);
			}
			return students;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public int insertStudent(Student student) {

		try (Connection connection = DBConnection.getConnection();) {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, student.getStudentId());
			ps.setString(2, student.getFirstName());
			ps.setString(3, student.getLastName());
			ps.setString(4, student.getDateOfBirth());
			ps.setString(5, student.getGender());
			ps.setString(6, student.getEmailId());
			ps.setString(7, student.getMobileNumber());
			ps.setString(8, student.getAddress());
			ps.setInt(9, student.getBatchId());
			int i = ps.executeUpdate();
			if (i == 1) {
				return i;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int updateStudent(Student student) {

		try (Connection connection = DBConnection.getConnection();) {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE student SET student_firstname = ?, student_lastname = ?, dateofbirth = ?, gender = ?, email_id = ?, mobile_number = ?, address = ?, batch_id = ? where student_id = ?");
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getDateOfBirth());
			ps.setString(4, student.getGender());
			ps.setString(5, student.getEmailId());
			ps.setString(6, student.getMobileNumber());
			ps.setString(7, student.getAddress());
			ps.setInt(8, student.getBatchId());
			ps.setInt(9, student.getStudentId());
			int i = ps.executeUpdate();
			if (i == 1) {
				return i;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int deleteStudent(int studentId) {

		try (Connection connection = DBConnection.getConnection();) {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM student WHERE student_id=" + studentId);
			if (i == 1) {
				return i;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

}
