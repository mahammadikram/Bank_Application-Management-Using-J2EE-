package BankApplication.servlets;

import java.io.IOException;

import BankApplication.DAO.Customer;
import BankApplication.DAO.CustomerDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/check")
public class CheckBal extends HttpServlet {
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session=req.getSession();
			int ac_no=(int)session.getAttribute("accNo");
			int pin=Integer.parseInt(req.getParameter("pin"));
			Customer c=CustomerDAO.getCustomer(ac_no,pin);
			try {
			if(c!=null) {
				double bal=c.getBalnece();
				session.setAttribute("Balance", "You curret Balance is :"+bal);
				RequestDispatcher rs=req.getRequestDispatcher("checkBal.jsp");
				rs.include(req, resp);
			}
			else {
				session.setAttribute("Nobalance","Invalid Pin....!");
				RequestDispatcher rs=req.getRequestDispatcher("checkBal.jsp");
				rs.include(req, resp);
			}
			}catch (NumberFormatException en) {
				session.setAttribute("error1","Invalid Data Entered....!");
				resp.sendRedirect("checkBal.jsp");
			}
			catch (Exception e) {
				session.setAttribute("error2","Invalid Pin....!");
				RequestDispatcher rs=req.getRequestDispatcher("check");
				rs.forward(req, resp);
			}
}
}
