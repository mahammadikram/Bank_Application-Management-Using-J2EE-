<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Here</title>
   <style>
        #mydiv{
            margin: auto;
            height: 200px;
            width: 250px;
            background-color: rgb(207, 142, 20);
            color: blueviolet;
            text-align: center;
            margin-top: 20%;
            border:2px solid red ;
            border-radius: 5px;
             margin-bottom: 20%;
        }
        #mynav{
            height: auto;
            width: 100%;
            background-color: rgb(221, 224, 231);
            text-align: center;
           
        }
    </style>
</head>
<body>
 <jsp:include page="header1.jsp" />
  <nav id="mynav"> <h1>Check Balence Form </h1>
    </nav>
  <form action="check" method="post">
    
    <div id="mydiv">
        <h4>Check Balence Form </h1>
         <% String success1=(String)session.getAttribute("Balance"); %>
        <% if(success1!=null){ %>
       		<h4> <%=success1%></h4>
        <%} %>
        <% String error=(String)session.getAttribute("Nobalance"); %>
         <% if(error!=null){ %>
       <h4> <%=error%></h4>
        <%} %>
    <Label>Enter the Pin</Label>
    <input type="text" name="pin" id="pin" required><br>
    <input type="submit" value="Check">
    </div>
    </form>
	 <jsp:include page="footer.jsp" />
</body>
</html>