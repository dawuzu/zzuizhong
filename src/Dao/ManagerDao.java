package Dao;

import java.util.List;

import Entity.Managers;
import Operation.ManagerOperation;

public class ManagerDao {

	public void add(Managers managermodel) throws Exception {
		ManagerOperation addope = new ManagerOperation();
		addope.AddManager(managermodel);
	}

	public void update(Managers managermodel) throws Exception {
		ManagerOperation updateope = new ManagerOperation();
		updateope.UpdateManager(managermodel);
	}

	public void delete(Integer manager_id) throws Exception {
		ManagerOperation delope = new ManagerOperation();
		delope.DeleteManager(manager_id);
	}

	public List<Managers> query() throws Exception {
		ManagerOperation selope = new ManagerOperation();
		return selope.query();

	}

	public Managers get(Integer manager_id) throws Exception {
		ManagerOperation selone = new ManagerOperation();
		return selone.get(manager_id);
	}
}
