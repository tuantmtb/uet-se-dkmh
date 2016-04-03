<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

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
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${course.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Mã môn học</label>
		<div class="col-sm-10">${course.id_course}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Sĩ số</label>
		<div class="col-sm-10">${course.si_so}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Giáo viên</label>
		<div class="col-sm-10">${course.giao_vien}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Phòng học</label>
		<div class="col-sm-10">${course.phong_hoc}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Số tín chỉ</label>
		<div class="col-sm-10">${course.so_tin_chi}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Ghi chú</label>
		<div class="col-sm-10">${course.ghi_chu}</div>
	</div>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>