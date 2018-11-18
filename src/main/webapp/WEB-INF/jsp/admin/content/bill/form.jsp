<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group row">
	<label class="col-sm-3 col-form-label">Số lượng</label> <input id="name"
		name="name" type="text" required
		value='<c:out value="${billstatus.getName()}" />' class="form-control"
		placeholder="" />
</div>
<button id="btnUpdate" type="button" class="btn btn-success mr-2">
	Cập nhật</button>

<script src="../resouces/ajax-jquery/bill/bill-edit.js"></script>
