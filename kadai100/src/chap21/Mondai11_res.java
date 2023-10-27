package chap21;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;



@WebServlet(urlPatterns={"/chap21/mondai11/update"})




public class Mondai11_res extends HttpServlet {



    public void doGet  (HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
            PrintWriter out = response.getWriter();
            Page.header(out);



        		try{

        			String a = request.getParameter("id");
        			request.getRequestDispatcher("../mondai11_res.jsp")
        			.forward(request, response);


        			out.println(a);
        		}catch (Exception e){
        			e.printStackTrace(out);
        		}




            Page.footer(out);

    }

        }
