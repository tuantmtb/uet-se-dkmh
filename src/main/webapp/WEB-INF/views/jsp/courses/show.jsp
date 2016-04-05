<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp"/>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Chi tiết môn học</h1>
    <br/>


    <table class="table table-striped table-bordered table-hover table-responsive">
        <tr>

           <td class="col-sm-2"><label>ID</label></td>
            <td class="col-sm-10">${course.id}</td>
        </tr>
        <tr>
            <td class="col-sm-2"><label>Mã môn học</label></td>
            <td class="col-sm-10">${course.id_course}</td>
        </tr>
        <tr>
        <td class="col-sm-2"><label>Tên môn học</label></td>

            <td class="col-sm-10">${course.name_course}</td>
        </tr>
        <tr>
            <td class="col-sm-2"><label>Tiết</label></td>
            <td class="col-sm-10">${course.tiet}</td>
        </tr>
        <tr>
            <td class="col-sm-2"><label>Sĩ số</label></td>
            <td class="col-sm-10">${course.si_so}</td>
        </tr>
        <tr>
            <td class="col-sm-2"><label>Giảng viên</label></td>
            <td class="col-sm-10">${course.giao_vien}</td>
        </tr>
        <tr>
            <td class="col-sm-2"><label>Phòng học</label></td>
            <td class="col-sm-10">${course.phong_hoc}</td>
        </tr>
        <tr>
            <td class="col-sm-2"><label>Số tín chỉ</label></td>
            <td class="col-sm-10">${course.so_tin_chi}</td>
        </tr>
        <tr>
            <td class="col-sm-2"><label>Ghi chú</label></td>
            <td class="col-sm-10">${course.ghi_chu}</td>
        </tr>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>