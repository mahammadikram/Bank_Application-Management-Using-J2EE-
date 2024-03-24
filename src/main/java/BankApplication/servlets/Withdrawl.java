package BankApplication.servlets;

import java.io.IOException;

import BankApplication.DAO.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/withdrawl")
public class Withdrawl extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	
	 int amt=Integer.parseInt(req.getParameter("amt"));
	 HttpSession session=req.getSession();
	 int AccNo=(int)session.getAttribute("accNo");
	 int Pin=(int)session.getAttribute("pin");
	 Customer c=CustomerDAO.getCustomer(AccNo, Pin);
	 if(c!=null && amt>=1) {
		 double Bal=c.getBalnece();
		 if(amt<Bal) {
		 Bal=Bal-amt;
		 c.setBalnece(Bal);
		 boolean res=CustomerDAO.updateCustomer(c);
		 if(res) {
			 session.setAttribute("credited", "you Balance "+amt+"has been deposited Available balance"+c.getBalnece());
			 resp.sendRedirect("withdrawl.jsp");
		 }
		 else {
			 session.setAttribute("notCredit", "Error Occured!");
			 resp.sendRedirect("checkBal.jsp");
		 }
		 }
		 else {
			 session.setAttribute("notCredit", "Error Occured!");
			 resp.sendRedirect("checkBal.jsp");
		 }
	 }
	 else {
		 session.setAttribute("error", "Invalid amount Entered");
		 resp.sendRedirect("withdrawl.jsp");
	 }
 
 }
}
