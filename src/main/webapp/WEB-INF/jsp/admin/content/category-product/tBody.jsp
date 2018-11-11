<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${categoryproducts}" var="categoryproduct">
    <tr>
        <td>
           <label data-categoryproductid='<c:out value="${categoryproduct.getCategoryproductid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-categoryproductid='<c:out value="${categoryproduct.getCategoryproductid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${categoryproduct.getCategoryproductid()}" /></td>
        <td><c:out value="${categoryproduct.getName()}" /></td>
        <td class="text-danger"><c:out value="${categoryproduct.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/category-product-add.js"></script>