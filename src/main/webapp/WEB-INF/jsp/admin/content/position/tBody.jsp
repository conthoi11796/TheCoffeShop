<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${positions}" var="position">
    <tr>
        <td>
           <label data-positionid='<c:out value="${position.getPositionid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-positionid='<c:out value="${position.getPositionid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${position.getPositionid()}" /></td>
        <td><c:out value="${position.getName()}" /></td>
        <td class="text-danger"><c:out value="${position.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/position-add.js"></script>