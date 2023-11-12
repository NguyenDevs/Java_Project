<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map.Entry" %>

<html>
<head>
    <title>Receipt</title>
</head>
<body>

    <h1>Receipt Page</h1>

    <h3>Processor:</h3>
    <% 
        String processorValue = request.getParameter("processor");
        if (processorValue != null) {
            out.println("Selected Processor: " + processorValue);
        } else {
            response.sendRedirect("error.jsp");
        }
    %>

    <h3>Checkboxes:</h3>
    <% 
        Map<String, String[]> parameters = request.getParameterMap();
        boolean checkboxSelected = false;

        for (Entry<String, String[]> entry : parameters.entrySet()) {
            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();

            if (paramName.equals("checkboxA") && Arrays.asList(paramValues).contains("on")) {
                checkboxSelected = true;
                out.println("Checkbox A (Parent) is selected. ");

                // Iterate through child checkboxes
                String[] childCheckboxes = {"checkboxB", "checkboxC", "checkboxD"};
                for (String childCheckbox : childCheckboxes) {
                    if (Arrays.asList(paramValues).contains(childCheckbox)) {
                        out.println("Selected Child Checkbox: " + childCheckbox);
                    }
                }
            }
        }

        if (!checkboxSelected) {
            response.sendRedirect("error.jsp");
        }
    %>

</body>
</html>

    