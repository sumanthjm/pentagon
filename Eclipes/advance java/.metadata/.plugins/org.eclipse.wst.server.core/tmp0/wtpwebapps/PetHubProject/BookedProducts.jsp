<%@page import="com.MVC.Model.adminOrder"%>
<%@page import="com.MVC.Model.Admin"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.MVC.Model.Registration"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Management</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" integrity="sha512-i1b/nzkVo97VN5WbEtaPebBG8REvjWeqNclJ6AItj7msdVcaveKrlIIByDpvjk5nwHjXkIqGZscVxOrTb9tsMA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <style>
        body {
            font-family: 'Arial', sans-serif;
           
            margin: 0;
            padding: 0;
            color: #333;
        }

        h1 {
            text-align: center;
            margin-top: 40px;
            font-size: 36px;
            color: #2c3e50;
            font-weight: 600;
        }

        .table-container {
            max-width: 1200px;
            margin: 40px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            margin-bottom: 20px;
            border-collapse: collapse;
        }

        table th, table td {
            padding: 14px;
            text-align: center;
            border: 1px solid #ddd;
            font-size: 14px;
        }

        table th {
            background-color: #f1c40f;
            color: #fff;
            font-size:1.2rem;
            font-weight: bold;
        }

        table td {
            background-color: #fff;
            font-size:1rem;
            font-weight:bold;
        }

        table td img {
            max-width: 80px;
            max-height: 80px;
            object-fit: cover;
        }

        .status-pending {
            color: #f39c12;
            font-weight: bold;
        }

        .status-booked {
            color: #2ecc71;
            font-weight: bold;
        }

        .status-cancelled {
            color: #e74c3c;
            font-weight: bold;
        }

        .action-buttons {
            display: flex;
            gap: 10px;
            justify-content: center;
        }

        .btn {
            padding: 8px 15px;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            transition: all 0.3s ease;
        }
.btn-success {
    background-color: #28a745;
    color: white;
    border: 2px solid #28a745;
    border-radius: 5px;
     height:50px;
            width:80px;
}

.btn-danger {
    background-color: #dc3545;
    color: white;
    border: 2px solid #dc3545;
    border-radius: 5px;
     height:50px;
            width:80px;
}

.btn-warning {
    background-color: #f1c40f;
    color: white;
    border: 2px solid #f1c40f;
    border-radius: 5px;
     height:50px;
            width:80px;
}

.btn:hover {
    opacity: 0.8;
    transform: translateY(-2px);
    border: 2px solid #333;
}


        
        .btn-closed {
            background-color: #bdc3c7; 
            color: white;
            border: none;
            height:50px;
            width:80px;
        }

        .btn:hover {
            opacity: 0.8;
            transform: translateY(-2px);
        }

        .icon {
            font-size: 20px;
        }

        .no-orders {
            font-size: 18px;
            color: #888;
            font-weight: bold;
            text-align: center;
            margin-top: 20px;
        }

        @media (max-width: 768px) {
            table th, table td {
                font-size: 12px;
                padding: 10px;
            }

            .action-buttons {
                flex-direction: column;
                gap: 5px;
            }

            .btn {
                font-size: 12px;
                padding: 6px 12px;
            }
        }
    </style>
</head>
<body>
<%@include file="Header1.jsp" %>
    <h1>Order Management</h1>

    <div class="table-container">
        <table>
            <thead>
                <tr>
                   <th>Username</th>
                    <th>Customer ID</th>
                    <th>Cost</th>
                    <th>Order Address</th>
                    <th>Order City</th>
                    <th>Order State</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Admin admin = new Admin(session);
                    ArrayList<adminOrder> orders = admin.getorderdata();  

                    if (orders.isEmpty()) {
                %>
                    <tr><td colspan="8" class="no-orders">No orders found</td></tr>
                <%
                    } else {
                        Iterator<adminOrder> itr = orders.iterator();
                        while (itr.hasNext()) {
                            adminOrder order = itr.next();
                %>
                    <tr>
                        <td><%= order.getusname() %></td>
                        <td><%= order.getc_id() %></td>
                        <td>&#8377; <%= order.getc_cost() %></td>
                        <td><%= order.getorder_address() %></td>
                        <td><%= order.getorder_city() %></td>
                        <td><%= order.getorder_state() %></td>
                        <td>
                            <span class="status-<%= order.getstatus().toLowerCase() %>"><%= order.getstatus() %></span>
                        </td>
                       <td class="action-buttons">
                            <% if ("ordered".equals(order.getstatus())) { %>
                                <form action="adminlogin" method="post" style="display: flex; gap: 10px;">
                                    <input type="hidden" name="order_id" value="<%= order.getOrder_id() %>"/>
                                    <button type="submit" class="btn-success" name="acceptevent">Accept</button>
                                    <button type="submit" class="btn-danger" name="cancel">Cancel</button>
                                </form>
                            <% } else { %>
                                <button class="btn-closed" disabled>Closed</button>
                            <% } %>
                        </td>
                    </tr>
                <% 
                        }
                    }
                %>
            </tbody>
        </table>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>
