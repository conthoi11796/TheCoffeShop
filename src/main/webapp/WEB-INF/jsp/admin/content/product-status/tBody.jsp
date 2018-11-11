<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${listProductstatus}" var="productstatus">
    <tr>
        <td>
           <label data-billstatusid='<c:out value="${productstatus.getProductstatusid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-billstatusid='<c:out value="${productstatus.getProductstatusid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${productstatus.getProductstatusid()}" /></td>
        <td><c:out value="${productstatus.getName()}" /></td>
        <td class="text-danger"><c:out value="${productstatus.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/product-status-add.js"></script>