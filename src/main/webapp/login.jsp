<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn here</title>
<style type="text/css">
  body{
            background-image: url('/BankAppliation_proj/src/main/webapp/Images/bank Picture.jpeg');
        }
        #mydiv{
            height: 270px;
            width: 250px;
            padding: 15px;
            margin: auto;
           text-align: center;
           margin-top: 100px;
            box-shadow: 5px 5px 5px 5px rgb(90, 52, 133) ;
            border-radius: 5px 10px 10px 50px;
            backdrop-filter: blur(5px);
        }
        input{
            margin-top: 20px;
            border-radius: 5px;
        }
        input:hover{
            background-color: rgb(7, 7, 65);
        }
        #submit{
            background-color: rgb(141, 33, 184);
        }
        #submit:hover{
            background-color: rgb(17, 197, 152);
        }
        #myh1{
            color:whitesmoke;
            background-color: blue;
            text-align: center;
        }
    </style>
</head>
<body>
  <h2>Login Page</h2>
     <form action="login" method="post">
        <h1 id="myh1">Welcome to the Bank</h1>
        <% String res=(String)session.getAttribute("accNo");%>
       <% if(res!=null){%>
       <%=res %>
        <%} %> 
     	<% String erro=(String)session.getAttribute("error"); %>
     	<%if(erro!=null){ %>
     	<%=erro %><%} %>
        <div id="mydiv">
            <h1>LogIn </h1>
            <input type="text" name="phoneNO" id="Phone"placeholder="Enter Account Number">
            <input type="text" name="pin" id="password" placeholder="Enter PIN"><br>
            <input type="submit" name="submit" id="submit" value="LogIn">
            <button value="Create Account"  type="button"><a href="signUp.jsp">Create Account</a></button>
        </div>
    </form>
</body>
</html>