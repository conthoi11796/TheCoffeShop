<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${dtos}" var="dto">
    <tr>
        <td>
           <label data-tablestatusid='<c:out value="${dto.getTablestatus().getTablestatusid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-tablestatusid='<c:out value="${dto.getTablestatus().getTablestatusid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${dto.getTablestatus().getTablestatusid()}" /></td>
        <td><c:out value="${dto.getTablestatus().getName()}" /></td>
        <td class="text-danger"><c:out value="${dto.getTablestatus().getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/table-status/table-status-add.js"></script>