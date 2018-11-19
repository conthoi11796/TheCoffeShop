<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${dtos}" var="dto">
	<tr>
		<td><label
			data-productid='<c:out value="${dto.getProduct().getProductid()}" />'
			class="badge badge-info edit"><i class="fa fa-wrench x"></i></label>
			<c:if test="${dto.getCanDelete()}">
				<label
					data-productid='<c:out value="${dto.getProduct().getProductid()}" />'
					class="badge badge-danger remove"><i class="fa fa-times"></i></label>
			</c:if></td>
		<td><c:out value="${dto.getProduct().getProductid()}" /></td>
		<td><c:out value="${dto.getProduct().getName()}" /></td>
		<td><c:out
				value="${dto.getProduct().getCategoryproduct().getName()}" /></td>
		<td class="text-danger"><c:out
				value="${dto.getProduct().getUpdateat()}" /></td>
	</tr>
</c:forEach>
<script src="../resouces/ajax-jquery/product/product-add.js"></script>