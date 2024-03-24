package BankApplication.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/home")
public class Home  extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  	
  
	  HttpSession session =req.getSession();
	  int Phno=(int) session.getAttribute("Account_No");
	  int pin=(int) session.getAttribute("pin");
	  try {
		if(newCustomer(session)) {
			  HttpSession hs=req.getSession();
			  hs.setAttribute("cust_account", Phno);
			  hs.setAttribute("cust_pin", pin);
			  RequestDispatcher ds=req.getRequestDispatcher("home");
			  ds.include(req, resp);
		  }
		else {
			
			RequestDispatcher rs=req.getRequestDispatcher("logIn");
			rs.include(req, resp);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
	  private  static boolean  newCustomer(HttpSession s) {
		  if(s.isNew()||s==null) {
			  return false;
		  }
		  else {
			  return true;
		  }
  }
 
}
