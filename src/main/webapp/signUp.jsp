<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
            jQuery.validator.addMethod("checkemail", function(value, element) {
                return /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value) || /^[0-9]{10}$/.test(value);
            });
            jQuery(document).ready(function($) {
                $("#signup").validate({
                    //ignore: [],
                    rules: {
                        name: {
                            required: true
                        },
                        email: {
                            required: true,
                            checkemail: true
                        },
                        phone: {
                            required: true,
                            minlength: 10,
                            maxlength: 10
                        },
                        pin: {
                            required: true,
                            minlength: 6
                        },
                        rmypin: {
                            required: true,
                            minlength: 6,
                            equalTo: "#pin"
                        },
                        amount:{
                        required:true,
                        min:500
                        },
                    },
                    messages: {
                        name: {
                            required: "Please enter the name."
                        },
                        email: {
                            required: "Please enter the email.",
                            email: "Please enter valid email id"
                        },
                        phone: {
                            required: "Please enter the number.",
                            minlength: "Please enter the  10 digit number .",
                            maxlength: "more than 10 digits."
                        },
                        pin: {
                            required: "Please enter the password.",
                            minlength: "Please enter the password greater than or equal to  6.",
                        },
                        rmypin: {
                            required: "Please reenter the password.",
                            minlength: "Please enter the password greater than or equal to 6.",
                            equalTo: "mismatch password"
                        },
                        amount:{
                        required:"Please enter the amount",
                        min:"The amount should greater than or equal to 500",
                        }
                    },
                });
            });
        </script>
<style type="text/css">
#firstdiv{
    height: 450px;
    width: 300px;
    padding: 10px;
    text-align: center;
    background-color: rgb(65, 134, 134);
    margin: auto;
    margin-top: 20px;
    box-shadow: 10px 10px;
}
input{
    margin-top: 10px;
    padding:5px ;
    margin: 10px;
    border-radius: 5px;
    background-color: rgb(16, 16, 46);
    color: white;

}
input:hover{
    background-color: antiquewhite;
    color: black;
}
li{
    list-style: none;
    padding: 5px;
}
button{
    background-color:rgb(51, 6, 216);
}
button:hover{
    background-color: azure;
}
</style>
</head>
<body>
<form action="signUp" method="post" id="signup">
<div id="firstdiv">
        <h1>Create Account</h1>
        <%String res=(String)session.getAttribute("accNo");
        if(res!=null){ %>
       <p id="res"><%= res%> </p>
        <%} %>	
        <% String resp=(String)session.getAttribute("error");
         if(resp!=null){ %>
       <p id="res"><%= res%>> </p>
        <%} %>	
        <label for="">Name</label>
        <input type="text"  id="name" name="name" ><br>
        <label for="">Enter PIn</label>
        <input type="password" name="pin"  id="pin"><br>
        <label for="">Re-Enter Pin</label>
        <input type="password" name="rmypin" id="mypin">
        <label for="">Mobile_No</label>
        <input type="text" name="myno" id="myno"><br>
        <label> Address</label>
        <input type="text" name="address" id="addess"><br>
        <label>Enter_Amount</label>
        <input type="number" name="balance" id="amt"><br>
        <input type="submit" id="mysubmit" value="Register" >
    </div>
</form>
</body>
</html>