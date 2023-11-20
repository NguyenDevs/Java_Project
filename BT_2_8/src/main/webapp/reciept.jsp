<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.stream.Stream" %>

<html>
<head>
    <title>Receipt</title>
    <style>
        table {
            border-collapse: collapse;
            width: 35%;
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
        }
        h2{
        text-align: center;}

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>

<%
    String processor = Objects.requireNonNullElse(request.getParameter("processor"), "");
    String monitor = Objects.requireNonNullElse(request.getParameter("monitor"), "");
    String[] accessories = Objects.requireNonNullElse(request.getParameterValues("accessories"), new String[]{});
%>

<%-- Check if any selection is missing, redirect to error.jsp if true --%>
<%
    if (processor.isEmpty() || monitor.isEmpty() && accessories.length == 0) {
        response.sendRedirect("error.jsp");
    }
   
%>

<%-- Display selected options in a table --%>
<% if (!processor.isEmpty() || !monitor.isEmpty() || accessories.length > 0) { %>
    <h2>Selected Options:</h2>
    <table>
    <tr>
        <th>Processor</th>
        <td><%= (processor != null) ? processor : "Not selected" %></td>
    </tr>
    <tr>
        <th>Accessories</th>
        <td>
            <%= (monitor != null) ? "Monitor" : "" %><br>
            <% if (accessories != null) {
                for (String accessory : accessories) {
                    out.println(accessory + "<br>");
                }
            } else {
                out.println("No accessories selected");
            } %>
        </td>
    </tr>
</table>
<% } else { %>
    <p>No items selected.</p>
<% } %>

</body>
</html>
