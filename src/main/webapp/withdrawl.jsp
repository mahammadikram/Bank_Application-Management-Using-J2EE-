<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-image: url('Images/img.jpeg');
}

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
        input{
         margin-bottom:20px;
        }
        
</style>
</head>
<body>
 <jsp:include page="header1.jsp" />
  <form action="withdrawl" method="post">
    
    <div id="mydiv">
        <h4>Withdrawl Form </h1>
        <% String success1=(String)session.getAttribute("credited"); %>
        <% if(success1!=null){ %>
        <%=success1%>
        <%} %>
        <% String error=(String)session.getAttribute("notCredit"); %>
         <% if(error!=null){ %>
        <%=error%>
        <%} %>
    <Label>Enter the Amount </Label>
    <input type="number" name="amt" id="amt"><br>
    <input type="submit" name="submit" value="deposite">
    </div>
   </form>
   <jsp:include page="footer.jsp" />
</body>
</html>