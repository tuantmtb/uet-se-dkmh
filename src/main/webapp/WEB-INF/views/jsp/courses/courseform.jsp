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

	<c:choose>
		<c:when test="${courseForm['new']}">
			<h1>Tạo mới môn học</h1>
		</c:when>
		<c:otherwise>
			<h1>Chỉnh sửa môn học</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/courses" var="courseActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="courseForm" action="${courseActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="id_course">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Mã môn học</label>
				<div class="col-sm-10">
					<form:input path="id_course" type="text" class="form-control " id="id_course" placeholder="Nhập mã môn học" />
					<form:errors path="id_course" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="name_course">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Tên môn học</label>
				<div class="col-sm-10">
					<form:input path="name_course" type="text" class="form-control " id="id_course" placeholder="Tên môn học" />
					<form:errors path="name_course" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="tiet">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Tên môn học</label>
				<div class="col-sm-10">
					<form:input path="tiet" type="text" class="form-control " id="tiet" placeholder="Tiết" />
					<form:errors path="tiet" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="si_so">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Sĩ số</label>
				<div class="col-sm-10">
					<form:input path="si_so" class="form-control" id="si_so" placeholder="Sĩ số" />
					<form:errors path="si_so" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="giao_vien">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Giáo viên</label>
				<div class="col-sm-10">
					<form:input path="giao_vien" class="form-control" id="giao_vien" placeholder="Giáo viên" />
					<form:errors path="giao_vien" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="phong_hoc">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Phòng học</label>
				<div class="col-sm-10">
					<form:input path="phong_hoc" rows="5" class="form-control" id="phong_hoc" placeholder="Phòng học" />
					<form:errors path="phong_hoc" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="so_tin_chi">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Số tín chỉ</label>
				<div class="col-sm-10">
					<form:input path="so_tin_chi" rows="5" class="form-control" id="so_tin_chi" placeholder="Số tín chỉ" />
					<form:errors path="so_tin_chi" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="ghi_chu">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Ghi chú</label>
				<div class="col-sm-10">
					<form:textarea path="ghi_chu" rows="5" class="form-control" id="ghi_chu" placeholder="Ghi chú" />
					<form:errors path="ghi_chu" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${courseForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Tạo môn học</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Cập nhật</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>