package chap22;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;


@WebServlet(urlPatterns={"/chap22/mondai12/update"})
public class Mondai12_up extends HttpServlet{
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try{


			List<Student> data = new ArrayList<>();
			StudentDAO dao=new StudentDAO();
			for (int i= 0; i < 5; i++){
				if(request.getParameter("name"+ String.valueOf(i)) != null){
					
				

				}
			}

			String name = request.getParameter("name");
			String course = request.getParameter("course");





		request.getRequestDispatcher("../mondai12_res.jsp")
			.forward(request, response);
		}catch (Exception e){
			e.printStackTrace(out);
		}
	}

}
