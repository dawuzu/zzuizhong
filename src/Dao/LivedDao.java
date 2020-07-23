package Dao;

import java.util.List;

import Entity.Lived;
import Operation.LivedOperation;

public class LivedDao {

	public void add(Lived livemodel) throws Exception {
		LivedOperation addlived = new LivedOperation();
		addlived.AddLived(livemodel);
	}

	public void update(Lived livemodel) throws Exception {
		LivedOperation updatelive = new LivedOperation();
		updatelive.UpDateLived(livemodel);
	}

	public void delete(Lived livemodel) throws Exception {
		LivedOperation deletelive = new LivedOperation();
		deletelive.DeleteLived(livemodel);
	}

	public List<Lived> query() throws Exception {
		LivedOperation selope = new LivedOperation();
		return selope.selectall();

	}

	public Lived get(Integer student_id) throws Exception {
		LivedOperation selone = new LivedOperation();
		return selone.selectone(student_id);
	}
}
