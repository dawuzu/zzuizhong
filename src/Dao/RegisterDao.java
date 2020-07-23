package Dao;


import java.util.List;

import Entity.Register;
import Operation.RegisterOperation;

public class RegisterDao {

	public void add(Register regis) throws Exception {
		RegisterOperation addreg = new RegisterOperation();
		addreg.Addregisterstudent(regis);
	}

	public void update(Register regis) throws Exception {
		RegisterOperation upreg = new RegisterOperation();
		upreg.Update(regis);

	}

	public void delete(Integer account) throws Exception {
		RegisterOperation delreg = new RegisterOperation();
		delreg.Delete(account);

	}

	public List<Register> reall() throws Exception {
		RegisterOperation selreg = new RegisterOperation();
		return selreg.selectall();
	}

	public Register get(Integer account) throws Exception {
		RegisterOperation selreg = new RegisterOperation();
		return selreg.selectone(account);
	}

	public Register get(String text) {
		return null;
	}
}
