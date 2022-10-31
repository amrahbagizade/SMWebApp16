<%@ page import="az.smapp.group06webapp1.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMApp - Student</title>
<%--ashadaki ilk 4 setr kodlar bootstrapi burdaistifade etmek ucun yazilir --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<%--Java kodlarini kicikdir faiz ichinde yaziriq  --%>
<h1 style="text-align: center">SMApp - Student</h1>
<%--text-align vasitesile SMApp -Student yazisini ortadami yoxsa kunclerdemi yazilmasini teyin edirik--%>
<div class="container">
<%--    container yazilarin cox kuncde olmasini duzeldir--%>
    <a href="/Group06WebApp1_war_exploded/student-servlet?action=addStudentView" type="button" class="btn btn-success btn-lg btn-block mb-3">ADD NEW STUDENT</a>
<%--    buttona URL elave etmekle bir nov hemin butonu canlandiririq. Ve class icinin sonunuda elave etdiyimiz mb-3 yazili cerciveni arali qoymaq ucundur--%>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">NAME</th>
            <th scope="col">SURNAME</th>
            <th scope="col">EMAIL</th>
            <th scope="col">PHONE</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Student> studentList = (List<Student>) request.getAttribute("list");
            for (Student student : studentList) {
        %>


        <tr>
            <th scope="row">
            <td><%=student.getId()%> </th>
            <td><%=student.getName()%></td>
            <td><%=student.getSurname()%></td>
            <td><%=student.getEmail()%></td>
            <td><%=student.getPhone()%></td>
            <td>
                <a href="/Group06WebApp1_war_exploded/student-servlet?action=updateStudentView&id=<%=student.getId()%>" style = "color: white" type="button" class="btn btn-warning">EDIT</a>

            </td>
            <td>
                <button  data-toggle="modal" data-target="#exampleModal" type="button" class="btn btn-danger">DELETE</button>
            </td>
        </tr>

        <%
            }
        %>
        </tbody>
    </table>

<%--    <!-- Modal -->  Delete duymesine basdiqda yuxaridan sorusmasini bu modulla edirik.--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Istifadecini silmeye eminsizin?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">CLOSE</button>
                    <button type="button" class="btn btn-danger">DELETE</button>
                </div>
            </div>
        </div>
    </div>

</div>

<%--ashagidaki kodlar bootstrapi burda istifade etmek ucun yazilmisdir.--%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>
