<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Selection</title>
    <style>
        .selected {
            background-color: #4CAF50;
            color: white;
            }
        .select-group {
            width: 100px;
            display: grid;
            margin-left: 140px;
            margin-top: -126px;
            flex-direction: column;
        }
        .select-group label {
            margin-right: 10px;
            
            padding-left: 5px;
        }
         .select-group optione {
            padding-left: 5px;
        }
        body{
        display: flex;
        justify-content: center;
        }
        </style>
    </head>
    <body>

        <%
        String processor = request.getParameter("processor");
        String monitor = request.getParameter("monitor");
        String[] accessories = request.getParameterValues("accessories");
        %>

        <form action="reciept.jsp" method="post">
            <h2>Processor</h2>
            <label><input type="radio" name="processor" value="Celeron D" <%= (processor != null && processor.equals("Celeron D")) ? "checked" : "" %>> Celeron D</label> <br>
            <label><input type="radio" name="processor" value="Pentium IV" <%= (processor != null && processor.equals("Pentium IV")) ? "checked" : "" %>> Pentium IV</label> <br>
            <label><input type="radio" name="processor" value="Pentium D" <%= (processor != null && processor.equals("Pentium D")) ? "checked" : "" %>> Pentium D</label> <br>
<div class="select-group">
            <h2>Accessories:</h2>
            <label><input type="checkbox" name="monitor" value="Monitor" <%= (monitor != null) ? "checked" : "" %>> Monitor</label> <br>
            <select name="accessories" multiple>
                <option value="Camera" <%= (accessories != null && contains(accessories, "Camera")) ? "selected" : "" %>>Camera</option>
                <option value="Printer" <%= (accessories != null && contains(accessories, "Printer")) ? "selected" : "" %>>Printer</option>
                <option value="Scanner" <%= (accessories != null && contains(accessories, "Scanner")) ? "selected" : "" %>>Scanner</option>
            </select>
</div>
            <br><br>
            <input type="submit" value="Purchase">
        </form>

        <%!
        boolean contains(String[] array, String value) {
            if (array != null) {
                for (String item : array) {
                    if (item.equals(value)) {
                        return true;
                    }
                }
            }
            return false;
        }
        %>

    </body>
</html>
