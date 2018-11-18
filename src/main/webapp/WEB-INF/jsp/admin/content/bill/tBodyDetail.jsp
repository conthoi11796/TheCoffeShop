<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${dtos}" var="dto">
	<tr>
		<td><label
			data-billid='<c:out value="${dto.getBilldetail().getProduct().getProductid()}" />'
			class="badge badge-info edit"><i class="fa fa-wrench"></i></label> <c:if
				test="">
				<label
					data-billid='<c:out value="${dto.getBilldetail().getProduct().getProductid()}" />'
					class="badge badge-danger remove"><i class="fa fa-times"></i></label>
			</c:if></td>
		<td><c:out value="${dto.getBilldetail().getProduct().getName()}" /></td>
		<td class="text-danger"></td>
		<td></td>
		<td></td>
	</tr>
</c:forEach>
<script src="../resouces/ajax-jquery/bill/bill-add.js"></script>