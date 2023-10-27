package chap22;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;


@WebServlet(urlPatterns={"/chap22/mondai12EX/input"})
public class Mondai12EX extends HttpServlet{
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try{
			StudentDAO dao=new StudentDAO();
			List<Student> list=dao.searchGod("");


		request.setAttribute("list", list);

		request.getRequestDispatcher("../mondai12_input.jsp")
			.forward(request, response);
		}catch (Exception e){
			e.printStackTrace(out);
		}
	}

}
