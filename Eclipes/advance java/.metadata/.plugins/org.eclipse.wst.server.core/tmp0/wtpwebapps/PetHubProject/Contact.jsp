<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>ContactUs</title>
</head>
<style>
    *{
        margin: 0;
        padding:0;
        box-sizing: border-box;
    }
    body{
        background-image: url(https://img.freepik.com/free-photo/beautiful-pet-portrait-dog_23-2149218474.jpg?t=st=1728540361~exp=1728543961~hmac=eb7902ff091ad16c0d309ee28b9e80dce3eb8b6b1b752f9e8a244f52db7a0207&w=900);
        background-repeat: no-repeat;
        background-size: cover;
        
    }
    form{
        height: 540px;
        width: 400px;
        background-color: rgba(255, 255, 255, 0.713);
        box-shadow: 0 0 20px rgb(232, 165, 165);
        position: relative;
        margin-top: 40px;
        margin-left: 850px;
        text-align: center;
        border-top-right-radius: 200px;
        border-top-left-radius: 200px;
    }
    input{
        padding: 10px;
        border-radius: 15px;
        width: 80%;
        border:2px solid rgb(208, 148, 148); 

    }
    input:focus,button:focus {
            outline: none; 
            border:2px solid rgb(208, 148, 148); 
            box-shadow: 0 0 10px rgb(208, 145, 145);;
        }
        .btn {
            position: relative;
            padding: 10px 20px;
            font-size: 18px;
            color: rgb(208, 145, 145);
            background-color: transparent;
            border: 2px solid rgb(208, 145, 145);
            border-radius: 15px;
            cursor: pointer;
            overflow: hidden;
            transition: color 0.4s;
        }

        .btn::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 0;
            height: 100%;
            background-color: rgb(208, 145, 145);
            transition: width 0.5s;
            z-index: 0;
        }

        .btn:hover::before,.btn:hover::after {
            width: 100%;
        }

        .btn:hover {
            color: white;
        }

        .btn span {
            position: relative;
            z-index: 1;
        }
    
</style>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<body>
<%@include file="Header1.jsp" %>
<% String status = (String)request.getAttribute("status"); %>
 <% if(request.getAttribute("status") != null) { %>
        <script>
            alert("<%= status %>");
        </script>
        <% } %>
        
    <form action="https://formsubmit.co/vaishnavijoshi292002@gmail.com" method="post" onsubmit="sendEmail();" reset(); return();>
        <br><br>
        <h1 style="color: rgb(208, 148, 148); ">ContactUs</h1><br>
        <input type="text" placeholder="Name" name="name"  value=<%=session.getAttribute("uname") %> required><br><br>
        <input type="email" placeholder="Email" name="email" id="email" value=<%=session.getAttribute("email") %> required><br><br>
        <input type="tel" placeholder="Phone" name="phone" id="phone" ><br><br>
        <input type="text" placeholder="Subject"name="subject" required><br><br>
        <input type="text" placeholder="Message"name="message" required><br><br>
        <input type="submit" class="btn" name="Contact" value=Contact >
        
        
       
      
    </form>
   
 
   
</body>
</html>