

<%@page import="beans.User"%>
<%@page import="service.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="webapp/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/signup.css">

    <!-- Main css -->
    <style>
        body{
            background-image: url(images/368326.jpg);
        }
    </style>
</head>
<body>
<%
	if(session.getAttribute("id") != null){
	response.sendRedirect("hotels.jsp");
	}
%>

<div class="main">

    <section class="signup">
        <!-- <img src="images/signup-bg.jpg" alt=""> -->
        <div class="container">
            <div class="signup-content">
                <form action="Signup" method="Post" id="signup-form" class="signup-form">
                    <h2 class="fs-2">Create account </h2>
                   	<h5 class="text-danger text-center">
                   		<%
                   			if(request.getAttribute("message") != null){
                   			out.println(request.getAttribute("message"));
                   			}
               			%>
   					</h5>
   					<p class="text-danger text-center mt-5">
                   		<%
                   			if(request.getAttribute("nom") != null){
                   			out.println(request.getAttribute("nom"));
                   			}
               			%>
   					</p>
                    <div class="form-group">
                        <input type="text" class="form-input" name="nom" id="name" placeholder="Your Name"/>
                    </div>
   					<p class="text-danger text-center mt-2">
                   		<%
                   			if(request.getAttribute("prenom") != null){
                   			out.println(request.getAttribute("prenom"));
                   			}
               			%>
   					</p>
                    <div class="form-group">
                        <input type="text" class="form-input" name="prenom" id="prenom" placeholder="Your first name"/>
                    </div>
                  	<p class="text-danger text-center mt-2">
                   		<%
                   			if(request.getAttribute("email") != null){
                   			out.println(request.getAttribute("email"));
                   			}
               			%>
   					</p>
                    <div class="form-group">
                        <input type="email" class="form-input" name="email" id="email" placeholder="Your Email"/>
                    </div>
   					<p class="text-danger text-center mt-2">
                   		<%
                   			if(request.getAttribute("pass") != null){
                   			out.println(request.getAttribute("pass"));
                   			}
               			%>
   					</p>
                    <div class="form-group">
                        <input type="password" class="form-input" name="password" id="password" placeholder="Password"/>
                        <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                    </div>
   					<p class="text-danger text-center mt-2">
                   		<%
                   			if(request.getAttribute("repass") != null){
                   			out.println(request.getAttribute("repass"));
                   			}
               			%>
   					</p>
                    <div class="form-group">
                        <input type="password" class="form-input" name="re_password" id="re_password" placeholder="Repeat your password"/>
                    </div>
                    
                    <div class="form-group">
                        <input type="checkbox" class="form-check-input" id="checkbox" required>
                        <label for="checkbox" class="label-agree-term">I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                    </div>
                </form>
                <p class="loginhere">
                    Have already an account ? <a href="/projet_hotel/login.jsp" class="loginhere-link">Login here</a>
                </p>
            </div>
        </div>
    </section>

</div>

<!-- JS -->
<script>
	
</script>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>