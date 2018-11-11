<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${employees}" var="employee">
    <tr>
        <td>
           <label data-billstatusid='<c:out value="${employee.getEmployeeid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-billstatusid='<c:out value="${employee.getEmployeeid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${employee.getEmployeeid()}" /></td>
        <td><c:out value="${employee.getName()}" /></td>
        <td class="text-danger"><c:out value="${employee.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/employee-add.js"></script>