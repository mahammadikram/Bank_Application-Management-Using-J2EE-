<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Web Application</title>
    <style>
        /* Add your styling for the navigation bar here */
        /* For simplicity, a basic styling is included */
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: right;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111;
        }
    </style>
</head>
<body>
<nav id="mynav">
    <ul>
     
        <li><a href="forgetPin.jsp">Reset Password</a></li>
        <li><a href="deposite.jsp">Deposit</a></li>
        <li><a href="withdrawl.jsp">Withdrawal</a></li>
        <li><a href="checkBal.jsp">Check Balance</a></li>
          <li><a href="home.jsp">Home</a></li>
    </ul>
   <% String success=(String)session.getAttribute("custName"); %>
<%if(success!=null){%>
	<h4>Welcome <%= success %></h4>
<%} %>
    
    
   </nav>

</body>
</html>
