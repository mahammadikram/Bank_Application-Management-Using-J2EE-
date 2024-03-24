<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
    <style>
        body{
            background-image: url('hospital1.jpg');
        }
        #firstdiv{
            height: 270px;
            width: 250px;
            padding: 15px;
            margin: auto;
           text-align: center;
           margin-top: 50px;
            box-shadow: 5px 5px 5px 5px rgb(90, 52, 133) ;
            border-radius: 5px 10px 10px 50px;
            backdrop-filter: blur(5px);
        }
        input{
            margin-top: 20px;
            background-color:rgb(13, 13, 48);
            color:whitesmoke;
            border: 2px dotted,white;
            border-radius: 5px;
        }
        #Reset{
            background-color: rgb(255, 60, 0);
        }
        #welcome{
        color:rgb(80, 10, 80);
        text-align: center;
        }
    </style>
        <script>
            function checkPass(from){
                const password1=document.getElementById("pass").value;
                const password2=document.getElementById("Re-Enter").value;
                if (password1 == '') 
                 window.alert("Enter the password")
                else if (password2 == '')                    
                   window.alert("Re Enter the Password")   
                else if (password1 != password2) { 
                 window.alert("Password Missmatch please Enter correct Password");
                    //window.location='index.html';
                    return false; 
                } 
                else{ 
                 //window.alert("Password Updated Successfully");
                    return true; 
                } 
            } 
        </script>
</head>
<body>
    <div id="welcome"><h1>Welcome to Your Bank</h1></div>
    <div id="firstdiv">
        <form  action="reset" method="post"   onsubmit="return checkPass(this)">
        <h3>Reset Your Password Here</h3>
        <input type="text" name="phoneNO" id="phoneNO" placeholder="Enter Phone Number ">
        <input type="password"  name="pass"  id="pass" placeholder=" Set New Password">
        <input type="password" name="Pass"  id="Re-Enter" placeholder="Re-Enter the password" ><br>
        <input type="submit" name="update" id="Reset" value="update">
        <button><a href="login.jsp">Goto LogIn</a></button>
        <p id="myupdate"></p>
    </form>
    </div>
</body>
</html>