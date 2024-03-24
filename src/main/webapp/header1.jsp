<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        /* Add your header styles here */
        header {
            background-color: Blue;
            color: black;
            padding: 10px;
            text-align: center;
        }
        .menu {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .menu a {
            color: black;
            text-decoration: none;
            padding: 5px 10px;
        }
        .menu a:hover {
            background-color: orange;
        }
    </style>
</head>
<body>
   <header>
        <div class="menu">
            <div>
                <a href="login.jsp">Home</a>
            </div>
            <div>
                <a href="login.jsp">Sign Out</a>
            </div>
        </div>
           <% String success=(String)session.getAttribute("custName"); %>
<%if(success!=null){%>
	<h4>Welcome <%= success %> </h4>
<%} %>
    </header>
</body>
</html>