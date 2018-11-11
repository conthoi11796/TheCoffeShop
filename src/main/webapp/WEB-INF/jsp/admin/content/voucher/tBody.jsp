<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${vouchers}" var="voucher">
    <tr>
        <td>
           <label data-voucherid='<c:out value="${voucher.getVoucherid()}" />' class="badge badge-info edit" ><i class="fa fa-wrench x"></i></label>
            <label data-voucherid='<c:out value="${voucher.getVoucherid()}" />' class="badge badge-danger remove"><i class="fa fa-times"></i></label>
        </td>
        <td><c:out value="${voucher.getVoucherid()}" /></td>
        <td><c:out value="${voucher.getName()}" /></td>
        <td><c:out value="${voucher.getStartdatetime()}" /></td>
        <td><c:out value="${voucher.getEnddate()}" /></td>
        <td><c:out value="${voucher.getNumber()}" /></td>
        <td><c:out value="${voucher.getCount()}" /></td>
        <td><c:out value="${voucher.getSaleof()}" /></td>
        <td class="text-danger"><c:out value="${voucher.getUpdateat()}" /></td>
    </tr>
</c:forEach>
<script src="../resouces/ajax-jquery/voucher-add.js"></script>