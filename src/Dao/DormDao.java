package Dao;

import java.util.List;

import Entity.Dorm;
import Entity.Grade;
import Operation.DormOperation;
import Operation.GradeOperation;

public class DormDao {

	public void add(Dorm dormmodel) throws Exception {
		DormOperation addgrade = new DormOperation();
		addgrade.AddDorm(dormmodel);
	}

	public void update(Dorm dormmodel) throws Exception {
		DormOperation updatedorm = new DormOperation();
		updatedorm.UpDateDorm(dormmodel);
	}

	public void delete(Dorm dormmodel) throws Exception {
		DormOperation deletedorm = new DormOperation();
		deletedorm.DeleteDorm(dormmodel);
	}

	public List<Dorm> query() throws Exception {
		DormOperation selope = new DormOperation();
		return selope.selectall();

	}

	public Dorm get(String dorm_id) throws Exception {
		DormOperation selone = new DormOperation();
		return selone.selectone(dorm_id);
	}

}
