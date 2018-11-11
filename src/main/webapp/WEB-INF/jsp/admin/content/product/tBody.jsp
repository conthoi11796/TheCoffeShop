<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${products}" var="product">
    <tr>
        <td>
           <label data-productid='<c:out value="${product.getProductid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-productid='<c:out value="${product.getProductid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${product.getProductid()}" /></td>
        <td><c:out value="${product.getName()}" /></td>
        <td><c:out value="${product.getCategoryproduct().getName()}" /></td>
        <td class="text-danger"><c:out value="${product.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/product-add.js"></script>