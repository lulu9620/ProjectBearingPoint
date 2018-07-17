<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OMA tech</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<table class="table">
    <div class="card-title">
        <h4><font color="red">Projects View Panel </font></h4>

        <thead>
        <tr>
            <th>Id</th>
            <th>Project Name</th>
            <th>Manager</th>
            <th>Client</th>
            <th>Release Date</th>
            <th>Description</th>
            <th>Status</th>
            <th><font color="blue">Save</font></th>
            <th><font color="green">Add</font></th>
        </tr>
        </thead>
    </div>
    <tbody>
    <tr>
        <td>
            <input type="text" class="tdl-new form-control" placeholder="" readonly>
        </td>
        <td><input type="text" class="tdl-new form-control" name="projectName" placeholder=""></td>
        <td><span><input type="text" class="tdl-new form-control" name="manager" placeholder=""></span></td>
        <td><span><input type="text" class="tdl-new form-control" name="client" placeholder=""></span></td>
        <td><span><input type="date" class="tdl-new form-control" name="releaseDate" placeholder=""></span></td>
        <td><span><input type="text" class="tdl-new form-control" name="description" placeholder=""></span></td>
</body>
</html>
