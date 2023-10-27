package chap22;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import dao.CourseDAO;


@WebServlet(urlPatterns={"/chap22/mondai12/input"})
public class Mondai12 extends HttpServlet{
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try{


			CourseDAO dao=new CourseDAO();
			List<Course> list=dao.search("");

			request.setAttribute("list", list);

			request.getRequestDispatcher("../mondai12_input.jsp")
				.forward(request, response);
		}catch (Exception e){
			e.printStackTrace(out);
		}
	}

}
