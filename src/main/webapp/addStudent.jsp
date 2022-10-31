<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMApp - Add student</title>
<%--ashadaki ilk 4 setr kodlar bootstrapi burdaistifade etmek ucun yazilir --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<%--Java kodlarini kicikdir faiz ichinde yaziriq  --%>
<div class="container">
    <h1 style="text-align: center">SMApp - ADD STUDENT</h1>
<%--    addAddStudent-in dizayn hissesi ucun form-dan istifade edirik--%>
    <form action="/Group06WebApp1_war_exploded/student-servlet?action=addStudent" method="post">
<%--        Request methodlari  novune daxildi post. Her hansi melumati bazaya daxil etmek istiyirikse
 umumiyyetle deyishiklik etmek istiyirikse bu method novunden istifade olunur. yox sadece baxmaq istiyirikse
  onda Requestin Get method novunden istifade olunur. Ordaki action-da href funksiyasini dasiyir, yeni
  ichine URL yaziriq--%>
        <div class="form-group">
            <label for="formGroupName">Name</label>
            <input name="name" type="text" class="form-control" id="formGroupName" placeholder="Student Name">
        </div>
        <div class="form-group">
            <label for="formGroupSurname">Surname</label>
            <input name="surname" type="text" class="form-control" id="formGroupSurname" placeholder="Student Surname">
        </div>

        <div class="form-group">
            <label for="formGroupEmail">Email</label>
            <input name="email" type="text" class="form-control" id="formGroupEmail" placeholder="Student Email">
        </div>

        <div class="form-group">
            <label for="formGroupPhone">Phone</label>
            <input name="phone" type="text" class="form-control" id="formGroupPhone" placeholder="Student Phone">
<%--            inputlarin icindeki name deyisenleri inputa ad qoyur--%>
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
