<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${ListBillstatus}" var="Billstatus">
    <tr>
        <td>
           <label data-billstatusid='<c:out value="${Billstatus.getBillstatusid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-billstatusid='<c:out value="${Billstatus.getBillstatusid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${Billstatus.getBillstatusid()}" /></td>
        <td><c:out value="${Billstatus.getName()}" /></td>
        <td class="text-danger"><c:out value="${Billstatus.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/bill-status-add.js"></script>