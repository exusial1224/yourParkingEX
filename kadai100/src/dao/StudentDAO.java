package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;


public class StudentDAO extends DAO{

	public List<Student> search(String keyword) throws Exception{
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from STUDENT where STUDENT_NAME like ?");
		st.setString(1,"%" + keyword+"%" );


		ResultSet rs=st.executeQuery();


		while (rs.next()){
			Student p=new Student();
			p.setStudent_Id(rs.getInt("student_Id"));
			p.setStudent_Name(rs.getString("student_Name"));
			p.setCourse_Id(rs.getInt("course_Id"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	public List<Student> searchGod(String keyword) throws Exception{
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from student inner join course on student.course_id=course.course_id where Student_Name like ?");
		st.setString(1,"%" + keyword+"%" );


		ResultSet rs=st.executeQuery();


		while (rs.next()){
			Student p=new Student();
			p.setStudent_Id(rs.getInt("STUDENT_ID"));
			p.setStudent_Name(rs.getString("STUDENT_NAME"));
			p.setCourse_Id(rs.getInt("COURSE_ID"));
			p.setCourse_Name(rs.getString("COURSE_NAME"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	public List<Student> searchJoin(String keyword) throws Exception{
        List<Student> list=new ArrayList<>();



        Connection con = getConnection();



        PreparedStatement st = con.prepareStatement(
                "select*from student inner join course on student.course_id=course.course_id");

        ResultSet rs = st.executeQuery();



        while (rs.next()) {
            Student s =new Student();
            s.setStudent_Id(rs.getInt("student_id"));
            s.setStudent_Name(rs.getString("student_name"));
            s.setCourse_Name(rs.getString("course_name"));
            list.add(s);
        }



        st.close();
        con.close();



        return list;
    }

	public List<Student> searchone(String keyword) throws Exception{
        List<Student> list=new ArrayList<>();



        Connection con = getConnection();


        int key = Integer.parseInt(keyword);
        PreparedStatement st = con.prepareStatement(
                "select * from student inner join course on student.course_id=course.course_id where Student_Id=?");
        st.setInt(1,key );
        ResultSet rs = st.executeQuery();



        while (rs.next()) {
            Student s =new Student();
            s.setStudent_Id(rs.getInt("student_id"));
            s.setStudent_Name(rs.getString("student_name"));
            s.setCourse_Name(rs.getString("course_name"));
            list.add(s);
        }



        st.close();
        con.close();



        return list;
    }


	public int insertStudent(Student student) throws Exception{
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"insert into student values(null, ?, ?)");
		st.setString(1, student.getStudent_Name());
		st.setInt(2, student.getCourse_Id());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}


	public int insertStudents(Student student) throws Exception{
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"insert into student values(null, ?, ?)");
		st.setString(1, student.getStudent_Name());
		st.setInt(2, student.getCourse_Id());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}


}
