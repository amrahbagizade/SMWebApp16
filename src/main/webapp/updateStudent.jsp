<%@ page import="az.smapp.group06webapp1.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMApp - Update student</title>
<%--ashadaki ilk 4 setr kodlar bootstrapi burdaistifade etmek ucun yazilir --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<%--Java kodlarini kicikdir faiz ichinde yaziriq  --%>
<div class="container">

    <%
        Student student = (Student) request.getAttribute("student");
//        update jsp-de backin islemesini temin edirik. servletden ora
//        student parametri gonderdiyimiz ucun onu cast edirik
    %>
    <h1 style="text-align: center">SMApp - UPDATE STUDENT</h1>
    <form>
        <div class="form-group">
        <label for="formGroupId">Id</label>
        <input type="text" class="form-control" id="formGroupId" disabled value="<%=student.getId()%>">
        </div>
        <div class="form-group">
            <label for="formGroupName">Name</label>
            <input type="text" class="form-control" id="formGroupName" value="<%=student.getName()%>">
        </div>
        <div class="form-group">
            <label for="formGroupSurname">Surname</label>
            <input type="text" class="form-control" id="formGroupSurname" value="<%=student.getSurname()%>">
        </div>

        <div class="form-group">
            <label for="formGroupEmail">Email</label>
            <input type="text" class="form-control" id="formGroupEmail" value="<%=student.getEmail()%>">
        </div>

        <div class="form-group">
            <label for="formGroupPhone">Phone</label>
            <input type="text" class="form-control" id="formGroupPhone" value="<%student.getPhone()">
        </div>
        <button type="button" class="btn btn-success btn-lg btn-block">SAVE</button>
    </form>
</div>

<%--ashagidaki kodlar bootstrapi burda istifade etmek ucun yazilmisdir.--%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>
