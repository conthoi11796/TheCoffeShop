<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${listTablestatus}" var="Tablestatus">
    <tr>
        <td>
           <label data-tablestatusid='<c:out value="${Tablestatus.getTablestatusid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-tablestatusid='<c:out value="${Tablestatus.getTablestatusid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${Tablestatus.getTablestatusid()}" /></td>
        <td><c:out value="${Tablestatus.getName()}" /></td>
        <td class="text-danger"><c:out value="${Tablestatus.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/table-status-add.js"></script>