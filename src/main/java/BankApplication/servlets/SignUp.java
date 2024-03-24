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
@WebServlet("/signUp")
public class SignUp  extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				  CustomerDAO	cd=new CustomerDAO();
				  Customer c=new Customer();
				  HttpSession hs=req.getSession();
				  	String name=req.getParameter("name");
					String pin=req.getParameter("pin");
					String rpin=req.getParameter("rmypin");
					String phno=req.getParameter("myno");
					String address=req.getParameter("address");
					String amt=req.getParameter("balance");
					int Pin=Integer.parseInt(pin);
					int Rpin=Integer.parseInt(rpin);
					double amount=Double.parseDouble(amt);
					if( (Pin==Rpin)&&amount>=500) {
						
						long Mobile_No=Long.parseLong(phno);
					 if(CustomerDAO.addCustomer(name, Mobile_No, Pin, address, amount)) {
						c=CustomerDAO.getCustomer(Mobile_No);
						int AccNo=c.getAccount_no();
						hs.setAttribute("accNo", "Your Account_No:"+c.getAccount_no());
						resp.sendRedirect("login.jsp");
						
					 }
					 else {
						 hs.setAttribute("error", "Invalid account!");
						 resp.sendRedirect("signUp.jsp");
					 }
					}
					else {
						hs.setAttribute("error","Initial Amount should be 500 or More!");
					}
		}
}
