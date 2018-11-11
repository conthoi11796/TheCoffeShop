<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${schedules}" var="schedule">
    <tr>
        <td>
           <label data-scheduleid='<c:out value="${schedule.getScheduleid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-scheduleid='<c:out value="${schedule.getScheduleid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${schedule.getScheduleid()}" /></td>
        <td><c:out value="${schedule.getStarttime()}" /></td>
        <td><c:out value="${schedule.getEndtime()}" /></td>
        <td><c:out value="${schedule.getPayrate()}" /></td>
        <td class="text-danger"><c:out value="${schedule.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/schedule-add.js"></script>