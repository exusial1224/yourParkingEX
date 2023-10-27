package chap21;



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
import tool.Page;



@WebServlet(urlPatterns={"/chap21/mondai11/input"})




public class Mondai11 extends HttpServlet {



    public void doGet  (HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
            PrintWriter out = response.getWriter();
            Page.header(out);



        		try{

        			CourseDAO dao=new CourseDAO();
        			List<Course> list=dao.search("");

        			request.setAttribute("list", list);
        			request.getRequestDispatcher("../mondai11.jsp")
        			.forward(request, response);

        		}catch (Exception e){
        			e.printStackTrace(out);
        		}




            Page.footer(out);

    }

        }
