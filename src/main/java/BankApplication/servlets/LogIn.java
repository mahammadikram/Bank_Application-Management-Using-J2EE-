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
@WebServlet("/login")
public class LogIn extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			
			int  Account_no=Integer.parseInt(req.getParameter("phoneNO"));
			int  pin=Integer.parseInt(req.getParameter("pin"));
			
			//CustomerDAO cd=new CustomerDAO();
			Customer c=CustomerDAO.getCustomer(Account_no, pin);
			HttpSession session=req.getSession();
			try {
			if(c!=null) {
				session.setMaxInactiveInterval(-1);
				session.setAttribute("accNo", Account_no);
				session.setAttribute("pin", pin);
				session.setAttribute("custName", c.getName());
				session.setAttribute("success", "you have LoggedIn Successfully through "+c.getMobile_no());
				resp.sendRedirect("home.jsp");
			}
			else {
				session.setAttribute("error","You have Entered Inavalid Data");
				resp.sendRedirect("login.jsp");
			}
			}
			catch (NumberFormatException en){
				session.setAttribute("error", "You have Entered the wrong data");
				resp.sendRedirect("login.jsp");
			}
	}
}