package Operation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JViewport;

import ButtonFrame.StudentSearch;
import Entity.Students;
import JDBC.db;

//学生操作
public class StudentsOperation {
	public static Students re = null;
	JTextField[] textbox;
	String student_id;

	//添加学生
	public void AddStudents(Students addall) throws Exception {
		Connection conn = db.getConnection();
		PreparedStatement prepare = conn
				.prepareStatement(" insert into students " + " values(?,?,?,?,?,?,?,?,?,?,?,?)");
		prepare.setString(1, addall.getName());
		prepare.setString(2, addall.getSex());
		prepare.setString(3, getfromtime(addall.getBirthday()));
		prepare.setString(4, addall.getAddress());
		prepare.setString(5, addall.getContact());
		prepare.setInt(6, addall.getStudent_id());
		prepare.setString(7, addall.getCollege());
		prepare.setString(8, addall.getMajor());
		prepare.setString(9, addall.getClasses());
		prepare.setString(10, addall.getDorm_id());
		prepare.setInt(11, addall.getBed_id());
		prepare.setString(12, addall.getStatus());
		prepare.execute();
	}
/**
 * 删除时更新字段状态
 */
	public void UpdateStatusStudents(int object) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement prepareupdate = conn
				.prepareStatement(" update students set status = ?   where student_id = ? ");
		prepareupdate.setInt(1, 1);
		prepareupdate.setInt(2, object);
		prepareupdate.execute();
	}

	public void UpdateStudents(Students update) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement prepareupdate = conn.prepareStatement(
				" update students set name = ? ,sex = ? , birthday = ? , address = ? , contact = ? , student_id = ? , college = ? , major = ? , classes = ? , dorm_id = ? , bed_id = ? , status = ? where student_id = ? ) ");
		prepareupdate.setString(1, update.getName());
		prepareupdate.setString(2, update.getSex());
		prepareupdate.setString(3, update.getBirthday());
		prepareupdate.setString(4, update.getAddress());
		prepareupdate.setString(5, update.getContact());
		prepareupdate.setInt(6, update.getStudent_id());
		prepareupdate.setString(7, update.getCollege());
		prepareupdate.setString(8, update.getMajor());
		prepareupdate.setString(9, update.getClasses());
		prepareupdate.setString(10, update.getDorm_id());
		prepareupdate.setInt(11, update.getBed_id());
		prepareupdate.setString(12, update.getStatus());
		prepareupdate.execute();
	}
	
	public  void UpdateoneStudents(String student_id,JTextField[] textbox) throws SQLException {
		this.student_id = student_id;
		this.textbox = textbox;
		Connection conn = db.getConnection();
		PreparedStatement prepareupdate = conn.prepareStatement(
				" update students set name = ? ,sex = ? , birthday = ? , addresss = ? , contact = ? ,  college = ? , major = ? ,  dorm_id = ? ,classes = ? , bed_id = ?   where student_id = ? ");
		prepareupdate.setString(1, textbox[0].getText());
		prepareupdate.setString(2, textbox[1].getText());
		prepareupdate.setString(3, getfromtime(textbox[2].getText()));
		prepareupdate.setString(4, textbox[3].getText());
		prepareupdate.setString(5, textbox[4].getText());
		prepareupdate.setString(6, textbox[6].getText());
		prepareupdate.setString(7, textbox[7].getText());
		prepareupdate.setString(8, textbox[9].getText());
		prepareupdate.setString(9, textbox[8].getText());
		prepareupdate.setString(10, textbox[10].getText());
		prepareupdate.setString(11, textbox[5].getText());
		prepareupdate.execute();
	}
	
	public void Delete(Integer account) throws SQLException {
		Connection conn = db.getConnection();
		PreparedStatement delete = conn.prepareStatement(" delete from register where account = ? ");
		delete.setInt(1, account);
		delete.execute();
	}

	/**
	 * 学生表状态字段内容
	 * @return
	 * @throws Exception
	 */
	public List<Students> statusselect() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select status from students ");
		List<Students> student = new ArrayList<Students>();
		Students selectstudents = null;
		while (rs.next()) {
			selectstudents = new Students();
			selectstudents.setStatus(rs.getString("status"));
			student.add(selectstudents);
		}
		return student;
	}
	
	public static List<Students> contactselect() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select contact from students ");
		List<Students> student = new ArrayList<Students>();
		Students selectstudents = null;
		while (rs.next()) {
			selectstudents = new Students();
			selectstudents.setContact(rs.getString("contact"));
			student.add(selectstudents);
		}
		return student;
	}
	
	public static List<Students> studentidselect() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select student_id from students ");
		List<Students> student = new ArrayList<Students>();
		Students selectstudents = null;
		while (rs.next()) {
			selectstudents = new Students();
			selectstudents.setStudent_id(Integer.parseInt(rs.getString("student_id")));
			student.add(selectstudents);
		}
		return student;
	}
	
	
	
	public List<Students> selectall() throws Exception {
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select * from students where status = 0");
		List<Students> student = new ArrayList<Students>();
		Students selectstudents = null;
		while (rs.next()) {
			selectstudents = new Students();
			selectstudents.setName(rs.getString("name"));
			selectstudents.setSex(rs.getString("sex"));
			selectstudents.setBirthday(rs.getString("birthday"));
			selectstudents.setAddress(rs.getString("addresss"));
			selectstudents.setContact(rs.getString("contact"));
			selectstudents.setStudent_id(rs.getInt("student_id"));
			selectstudents.setCollege(rs.getString("college"));
			selectstudents.setMajor(rs.getString("major"));
			selectstudents.setClasses(rs.getString("classes"));
			selectstudents.setDorm_id(rs.getString("dorm_id"));
			selectstudents.setBed_id(rs.getInt("bed_id"));
			student.add(selectstudents);
		}
		return student;
	}
	
	/**
	 * 床号
	 * @return
	 * @throws Exception
	 */
	public static List<Students> selectdorm(String dorm_id) throws Exception {	
		Connection conn = db.getConnection();
		Statement sme = conn.createStatement();
		ResultSet rs = sme.executeQuery(" select bed_id from students where dorm_id = '"+dorm_id+"'");
		List<Students> student = new ArrayList<Students>();
		Students selectstudents = null;
		while (rs.next()) {
			selectstudents = new Students();
			selectstudents.setBed_id(rs.getInt("bed_id"));
			student.add(selectstudents);
		}
		return student;
	}
	
/**
 * 转成日期形式
 * @param unix
 * @return
 */
	public static String getfromunix(String unix) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss"); 
		
		String date = null;
		Connection conn = db.getConnection();
		Statement sme;
		try {
			sme = conn.createStatement();
			ResultSet rs = sme.executeQuery(" select from_unixtime(" + unix + ")");
			while (rs.next()) {
				
				date = rs.getString(1);
			}
			date=date.substring(0, 19);
			date=getdate(date)+"000000";
			java.util.Date d=simpleDateFormat1.parse(date);
			date=simpleDateFormat.format(d);		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String getdate(String date){
		String str = "select date_format('" + date+ "','%Y%m%d')";
		String date1 = null;
		Connection conn = db.getConnection();
		Statement sme;
		try {
			sme = conn.createStatement();
			ResultSet rs = sme.executeQuery(str);
			while (rs.next()) {
				
				date1 = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return date1;
		
	}
/**
 * 时间戳
 * @param unix
 * @return
 */
	public static String getfromtime(String unix) {
		String date = null;
		Connection conn = db.getConnection();
		Statement sme;
		try {
			sme = conn.createStatement();
			ResultSet rs = sme.executeQuery(" select unix_timestamp ('" + unix + "')");
			while (rs.next()) {
				date = rs.getString(1);
				//System.out.println(date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	

	public static Students selectone(Integer student_id) throws Exception {
		Connection conn = db.getConnection();
		PreparedStatement selectstudent = conn.prepareStatement(" select * from students where student_id =  ? ");
		selectstudent.setInt(1, student_id);
		// 返回结果集
		ResultSet rs = selectstudent.executeQuery();
		while (rs.next()) {
			re = new Students();
			re.setName(rs.getString("name"));			
			re.setSex(rs.getString("sex"));
			re.setBirthday(getfromunix(rs.getString("birthday")));
			re.setAddress(rs.getString("addresss"));
			re.setContact(rs.getString("contact"));
			re.setStudent_id(rs.getInt("student_id"));
			re.setCollege(rs.getString("college"));
			re.setMajor(rs.getString("major"));
			re.setClasses(rs.getString("classes"));
			re.setDorm_id(rs.getString("dorm_id"));
			re.setBed_id(rs.getInt("bed_id"));
			if(rs.getInt("status")==0){
				re.setStatus("在校");
			}else if(rs.getInt("status")==1){
				re.setStatus("毕业");
			}else{
				re.setStatus("失踪");
			}
			
		}
		return re;

		
	}
	public Students mode(){
		return re;
		
	}

	public static Students selectstudentone(String student_id) throws Exception {
		Connection conn = db.getConnection();
		PreparedStatement selectstudent = conn.prepareStatement(" select * from students where student_id =  ? ");
		selectstudent.setString(1, student_id);
		// 返回结果集
		ResultSet rs = selectstudent.executeQuery();
		
		while (rs.next()) {
			re = new Students();
			re.setName(rs.getString("name"));			
			re.setSex(rs.getString("sex"));
			re.setBirthday(getfromunix(rs.getString("birthday")));
			re.setAddress(rs.getString("addresss"));
			re.setContact(rs.getString("contact"));
			re.setStudent_id(rs.getInt("student_id"));
			re.setCollege(rs.getString("college"));
			re.setMajor(rs.getString("major"));
			re.setClasses(rs.getString("classes"));
			re.setDorm_id(rs.getString("dorm_id"));
			re.setBed_id(rs.getInt("bed_id"));
			if(rs.getInt("status")==0){
				re.setStatus("在校");
			}else if(rs.getInt("status")==1){
				re.setStatus("毕业");
			}else{
				re.setStatus("失踪");
			}
			
		}
		return re;

		
	}

	}

