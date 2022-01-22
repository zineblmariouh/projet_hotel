<!doctype html>
<html lang="en">
<%@page import="beans.Chambre"%>
<%@page import="service.ChambreService"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <style>
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
	if(session.getAttribute("id") == null){
	response.sendRedirect("login.jsp");
	}
%>
<div class="row">
 <div class="col-md-11"></div>
 <div class="col-md-1">
    
    <div class="dropdown dropstart">
                <button class="dropdown-toggle threeDots" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                    <img class="rounded-circle usersImages" src="images/user.png" alt="">
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="/projet_hotel/admin.jsp"><i class="far fa-hotel"></i> &emsp; Reservations list</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><form action="Logout">
					<button type="submit" class="threeDots dropdown-item"><i class="fas fa-sign-out-alt"></i>&ensp; Logout</button>
					</form></li>
                </ul>
       </div>
</div>
</div>
<div class="container pt-5">
    <h1 class="text-center">Room's list</h1>
</div>

<div class="container">
    <hr />
</div>

<div class="container">
    <div class="row">
    <%
	ChambreService cs = new ChambreService();
	for(Chambre c : cs.findAll()){
	
%>

        <div class="col-md-4 mb-3">
            <div class="card h-100">
                <div class="d-flex justify-content-between position-absolute w-100">
                    <div class="label-new">
                    </div>
                </div>
                
                <%
                
                out.print("<img class=img-fluid src="+c.getImage()+"");
                %>

              
                </a>
                <div class="card-body px-2 pb-2 pt-1">
                    <div class="d-flex justify-content-between">
                        <div class="text-right">
                            <p class=" h4 "><% out.println(c.getPrix()); %></p>
                        </div>

                    </div>
                    <p class="mb-0">
                    <ul>
                         <li><i class="fa fa-bed" aria-hidden="true"> <span> <% out.println(c.getPrix()); %></span></i></li>
                         <li><i class="fa fa-lock" aria-hidden="true"> <span> In-Room safe</span></i></li>
                         <li><i class="fa fa-desktop" aria-hidden="true"> <span> Flat-screen TV</span></i> </li>
                         <li><i class="fa fa-wifi" aria-hidden="true"> <span> Complimentary Wireless Internet</span></i></li>
                         <li><i class="fa fa-phone" aria-hidden="true"> <span> Telephone</span></i></li>
                         <li><i class="fa fa-bath" aria-hidden="true"> <span> Private bath</span></i></li>
                     </ul>
                    </p>

                    <div class="d-flex justify-content-between">
                        <div class="ml-2">
                       
                       	 <div class="col-lg-8 align-self-baseline">
                       	 <form action="ReservationController" method="Get">
                       	 <input type="hidden" class=img-fluid name="id" value="<%=c.getId()%>" />
                       		 <button type="submit" class="btn btn-primary btn-clock">Book </button>
                       		 </form>
                   		 </div>
                           
                        </div>

                    </div>
                </div>
            </div>
        </div>

   <%
	}
%>
<div class="d-flex align-items-center justify-content-start">
        <a href="/projet_hotel/"><button class="btn titles cursorPointer"><i class="fas fa-chevron-left"></i> &ensp; Home</button></a>
    </div>
<div class="container">
    <hr />
</div>



<script>
    $(function () {
        $("[data-toggle=tooltip]").tooltip();

        $(".grid-view").click(function () {});
    });

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>