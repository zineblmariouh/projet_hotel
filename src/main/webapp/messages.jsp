<%@page import="java.sql.*" errorPage="error.jsp"%>
<%@page import="beans.Message"%>
<%@page import="service.MessageService"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SUNRISE HOTEL</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
     <!-- Morris Chart Styles-->
   
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <style type="text/css">
    body {
        font-size: 0.98rem;
       
    }
    .cursorPointer {
        cursor: pointer;
    }
    .titles {
        color: #007BA6;
    }
    .threeDots{
    outline: none;
    box-shadow: none;
    border: none;
    background: none;
	}
	.usersImages{
    width: 65px !important;
    height: 65px !important;
	}
	.rounded-circles{
    width: 20px;
    height: 20px;
    border-radius: 50%;
    color: transparent;
	}
  
    </style>
    
    
</head>
<body>

<%
	if(session.getAttribute("id") == null || session.getAttribute("admin") == null){
	response.sendRedirect("login.jsp");
	}
%>
   
       
             <div class="col-md-11"></div>
                <div class="col-md-1">
                      <div class="d-flex align-items-center justify-content-start">
        <a href="/projet_hotel/"><button class="btn titles cursorPointer"><i class="fas fa-chevron-left"></i> &ensp; Home</button></a>
    				</div>
                    </div>

      
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation" style="background-image: url(images/368326.jpg);">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    
                    <li>
                        <a class="active-menu" href="messages.jsp"><i class="fa fa-desktop"></i> News Letters</a>
                    </li>
					<li>
                        <a href="admin.jsp"><i class="fa fa-bar-chart-o"></i>Room Booking</a>
                    </li>
                    
                    
                    <li>
                        <a href="" ><form action="Logout">
					<button type="submit" class="threeDots dropdown-item"><i class="fas fa-sign-out-alt"></i>&ensp; Logout</button>
					</form></a>
                    </li>
                    


                    
            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                           List of messages
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
				
				 <div class="row">
        
						<div class="panel-body">
                           
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Compose News Letter</h4>
                                        </div>
										<form method="post">
                                        <div class="modal-body">
                                            <div class="form-group">
                                            <label>Title</label>
                                            <input name="title" class="form-control" placeholder="Enter Title">
											</div>
										</div>
										<div class="modal-body">
                                            <div class="form-group">
                                            <label>Subject</label>
                                            <input name="subject" class="form-control" placeholder="Enter Subject">
											</div>
                                        </div>
										<div class="modal-body">
										<div class="form-group">
										  <label for="comment">News</label>
										  <textarea name="news" class="form-control" rows="5" id="comment"></textarea>
										</div>
										 </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											
                                           <input type="submit" name="log" value="Send" class="btn btn-primary">
										  </form>
										   
                                        </div>
                                    </div>
                                </div>
                            </div>
                      
						
                          
                   
                </div>
            </div>
             
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Full name</th>
                                           <th>Email</th>
											<th>Phone Number</th>
                                            
                                           
										
											<th>Message</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    MessageService cs = new MessageService();
										for(Message c : cs.findAll()){
	
									%>
                                    
                                        
									<tr>
                                            <td><% out.println(c.getFullname()); %></td>
											<td><% out.println(c.getEmail()); %></td>
                                            <td><% out.println(c.getPhone()); %></td>
                                            <td><% out.println(c.getMessage()); %></td>
                                           
                                            
                                            
                                        </tr>
                                        <%
										}
	
									%>
                                        
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
            
                </div>
               
            </div>
        
               
    </div>
             <!-- /. PAGE INNER  -->
          
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
         <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
