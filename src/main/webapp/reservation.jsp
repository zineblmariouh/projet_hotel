<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RESERVATION SUNRISE HOTEL</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   
    <style>
        body{
            background-image: url(images/368326.jpg);
            
        }
    </style>
</head>
<body>


<%
	if(session.getAttribute("id") == null || request.getAttribute("id") == null){
	response.sendRedirect("login.jsp");
	}
%>
  
           
          <div id="page-inner">
			 <div class="row">
                    <div class="col-md-10">
                        
                    </div>
                    <div class="col-md-2">
                         <ul class="nav" id="main-menu">

                   			 <li>
                       			 <a  href="../index.jsp"><i class="fa fa-home"></i> Homepage</a>
                   			 </li>
                    
					</ul>
                    </div>
                  
                </div> 
                 
               <br><br><br> <br><br><br><br>         
            <div class="row">
                
                 <div class="col-md-3 col-sm-3"></div>
               
                
                  <form action="ReservationController" method="POST">
                  <input type="hidden" class=img-fluid name="id" value="<%=request.getAttribute("id")%>" />
            <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            RESERVATION INFORMATION
                        </div>
                        <div class="panel-body">
                        <p class="text-danger text-center mt-5">
                        <%
                   			if(request.getAttribute("First_name") != null){
                   			out.println(request.getAttribute("First_name"));
                   			}
               			%>
               			</p>
                        <div class="form-group">
                                            <label>First Name</label>
                                            <input name="fname" class="form-control" required>
                                            
                               </div>
                               <p class="text-danger text-center mt-5">
                               <!-- pas encore termine -->
                               <%
                   					if(request.getAttribute("Last_name") != null){
                   					out.println(request.getAttribute("Last_name"));
                   					}
               					%>
               					</p>
							   <div class="form-group">
                                            <label>Last Name</label>
                                            <input name="lname" class="form-control" required>
                                            
                               </div>
                               <p class="text-danger text-center mt-5">
                               <!-- pas encore termine -->
                               <%
                   					if(request.getAttribute("Email") != null){
                   					out.println(request.getAttribute("Email"));
                   					}
               					%>
               					</p>
							   <div class="form-group">
                                            <label>Email</label>
                                            <input name="email" type="email" class="form-control" required>
                                            
                               </div>
							   
<%
String countries[] = {"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island","Islands", "Colombia", "Comoros", "Congo", "Congo the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See ", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands", "Virgin Islands", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};

%>
								<p class="text-danger text-center mt-5">
								<!-- pas encore termine -->
                              	 	<%
                   					if(request.getAttribute("Country") != null){
                   					out.println(request.getAttribute("Country"));
                   					}
               						%>
               					</p>
								<div class="form-group">
                                            <label> Country</label>
                                            <select name="country" class="form-control" required>
						<option value selected ></option>
                                                <%
						for(String value:countries){%>
						<option value="<%=value%>"><%=value%></option>;
				<%}%>
                                            </select>
								</div>
								<p class="text-danger text-center mt-5">
								<!-- pas encore termine -->
                               <%
                   					if(request.getAttribute("Phone") != null){
                   					out.println(request.getAttribute("Phone"));
                   					}
               					%>
               					</p>
								<div class="form-group">
                                            <label>Phone Number</label>
                                            <input name="phone" type ="text" class="form-control" required>
                                            
                               </div>
                              
                              <p class="text-danger text-center mt-5">
                              <!-- pas encore termine -->
                               <%
                   					if(request.getAttribute("dateDebut") != null){
                   					out.println(request.getAttribute("dateDebut"));
                   					}
               					%>
               					</p>
							  <div class="form-group">
                                            <label>Check-In</label>
                                            <input name="cin" type ="date" class="form-control">
                                            
                               </div>
                               <p class="text-danger text-center mt-5">
                               <!-- pas encore termine -->
                               <%
                   					if(request.getAttribute("dateFin") != null){
                   					out.println(request.getAttribute("dateFin"));
                   					}
               					%>
               					</p>
							   <div class="form-group">
                                            <label>Check-Out</label>
                                            <input name="cout" type ="date" class="form-control">
                                            
                               </div>
                       </div>
                        
                    </div>
                </div>
                <div class="col-md-1 col-sm-1"></div>
				
				<div class="col-md-9 col-sm-9">
				</div>
                <div class="col-md-2 col-sm-2">
                   <button type="submit" class="btn btn-primary btn-block value="Sign up"">Submit</button>
                </div>
            </div>
           </form>
                
                </div>
                    
            
				
					</div>
			 <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
