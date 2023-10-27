package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Course;

public class CourseDAO extends DAO{

	public List<Course> search(String keyword) throws Exception{
		List<Course> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from COURSE where COURSE_ID like ?");
		st.setString(1,"%" + keyword+"%" );
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Course p=new Course();
			p.setCourse_Id(rs.getInt("COURSE_ID"));
			p.setCourse_Name(rs.getString("COURSE_NAME"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}
	public int insert(Course course) throws Exception{
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"insert into course values(?, ?)");
		st.setInt(1, course.getCourse_Id());
		st.setString(2, course.getCourse_Name());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
	public int update(Course course) throws Exception{
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"UPDATE COURSE SET COURSE_NAME = ? WHERE COURSE_ID =?");
		st.setInt(1, course.getCourse_Id());
		st.setString(2, course.getCourse_Name());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
