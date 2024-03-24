package BankApplication.servlets;

import java.io.IOException;

import BankApplication.DAO.Customer;
import BankApplication.DAO.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/deposit")
public class Deposite extends HttpServlet {
  
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int amt=Integer.parseInt(req.getParameter("amt"));
		 HttpSession session=req.getSession();
		 int AccNo=(int)session.getAttribute("accNo");
		 int Pin=(int)session.getAttribute("pin");
		 Customer c=CustomerDAO.getCustomer(AccNo, Pin);
		 if(c!=null && amt>=1 && c.getPin()==Pin) {
			 double Bal=c.getBalnece();
			 Bal=Bal+amt;
			 c.setBalnece(Bal);
			 boolean res=CustomerDAO.updateCustomer(c);
			 if(res) {
				 session.setAttribute("deposited", "you Balance "+amt+"has been deposited Available balance"+c.getBalnece());
				 resp.sendRedirect("deposite.jsp");
			 }
			 else {
				 session.setAttribute("notDeposit", "Error Occured!");
				 resp.sendRedirect("deposite.jsp");
			 }
		 }
		 else {
			 session.setAttribute("error", "Invalid amount Entered");
		 }
	
	}
}
