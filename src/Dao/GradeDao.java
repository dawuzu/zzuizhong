package Dao;

import java.util.List;

import Entity.Grade;
import Operation.GradeOperation;

public class GradeDao {
	public void add(Grade Grademodel) throws Exception {
		GradeOperation addgrade = new GradeOperation();
		addgrade.AddGrade(Grademodel);
	}

	public void update(Grade grademodel) throws Exception {
		GradeOperation updatelive = new GradeOperation();
		updatelive.DeleteLived(grademodel);
	}

	public void delete(Grade grademodel) throws Exception {
		GradeOperation deletelive = new GradeOperation();
		deletelive.DeleteLived(grademodel);
	}

	public List<Grade> query() throws Exception {
		GradeOperation selope = new GradeOperation();
		return selope.selectall();

	}

	public Grade get(Integer student_id) throws Exception {
		GradeOperation selone = new GradeOperation();
		return selone.selectone(student_id);
	}

}
