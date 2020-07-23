package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Entity.Students;
import JDBC.db;
import Operation.StudentsOperation;

public class StudentsDao {

	public void add(Students student) throws Exception {
		StudentsOperation addstudent = new StudentsOperation();
		addstudent.AddStudents(student);
	}

	public void update(Students student) throws Exception {
		StudentsOperation upstudent = new StudentsOperation();
		upstudent.UpdateStudents(student);

	}

	public List<Students> all() throws Exception {
		StudentsOperation selstudent = new StudentsOperation();
		return selstudent.selectall();

	}
	
	public List<Students> statusall() throws Exception {
		StudentsOperation selstudent = new StudentsOperation();
		return selstudent.statusselect();

	}

	public Students get(Integer student_id) throws Exception {
		StudentsOperation selstudent = new StudentsOperation();
		return selstudent.selectone(student_id);

	}
	
	

}
