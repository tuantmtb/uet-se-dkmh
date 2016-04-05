<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>
<head lang="vi">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Tạo môn học | Đăng ký môn học</title>
    <link rel="shortcut icon" href="http://dangkyhoc.daotao.vnu.edu.vn/Images/fav.png" type="image/x-icon" />
    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/courses/add" var="urlAddCourse"/>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}"><span class="glyphicon glyphicon-education"></span> Hệ thống
                đăng ký môn học | Đại học Quốc gia Hà Nội</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlAddCourse}"><span class="glyphicon glyphicon-pencil"></span> Tạo lớp
                    mới</a></li>
            </ul>
        </div>
    </div>
</nav>