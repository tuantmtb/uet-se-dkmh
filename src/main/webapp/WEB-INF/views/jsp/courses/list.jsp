<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp"/>

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Danh sách môn học</h1>

    <table class="table table-striped table-bordered table-hover table-responsive">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã môn học</th>
            <th>Tên môn học</th>
            <th>Tiết</th>
            <th>Sĩ số</th>
            <th>Giáo viên</th>
            <th>Phòng học</th>
            <th>Số tín chỉ</th>
            <th>Ghi chú</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.id}</td>
                <td>${course.id_course}</td>
                <td>${course.name_course}</td>
                <td>${course.tiet}</td>
                <td>${course.si_so}</td>
                <td>${course.giao_vien}</td>
                <td>${course.phong_hoc}</td>
                <td>${course.so_tin_chi}</td>
                <td>${course.ghi_chu}</td>
                <td>
                    <spring:url value="/courses/${course.id}" var="courseUrl"/>
                    <spring:url value="/courses/${course.id}/delete" var="deleteUrl"/>
                    <spring:url value="/courses/${course.id}/update" var="updateUrl"/>

                    <button class="btn btn-info btn-sm" onclick="location.href='${courseUrl}'">Xem</button>
                </td>
                <td>
                    <button class="btn btn-primary btn-sm" onclick="location.href='${updateUrl}'">Sửa</button>
                </td>
                <td>
                    <button class="btn btn-danger btn-sm" onclick="this.disabled=true;post('${deleteUrl}')">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>