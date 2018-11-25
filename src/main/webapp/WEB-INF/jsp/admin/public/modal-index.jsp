<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Tab Menu -->
<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item"><a class="nav-link" id="table-status-tab"
		data-toggle="tab" href="#table-status" role="tab"
		aria-controls="table-status" aria-selected="false">Trạng thái bàn</a></li>
	<li class="nav-item"><a class="nav-link" id="add-food-tab"
		data-toggle="tab" href="#add-food" role="tab" aria-controls="add-food"
		aria-selected="false">Thêm món ăn</a></li>
	<li class="nav-item"><a class="nav-link" id="bill-tab"
		data-toggle="tab" href="#bill" role="tab" aria-controls="bill"
		aria-selected="false">Hóa đơn</a></li>
</ul>
<!-- End Tab Menu -->
<!-- Body Tab Menu -->
<div class="tab-content" id="nav-tabContent">
	<!-- Trạng thái bàn -->
	<div class="tab-pane fade " id="table-status" role="tabpanel"
		aria-labelledby="table-status-tab">
		<form class="forms-sample">
			<div class="row">
				<c:forEach items="${listTablestatus}" var="tablestatus">
					<div class="col-md-6">
						<div class="form-group">
							<div class="form-radio form-radio-flat">
								<label class="form-check-label"> <input type="radio"
									<c:if test="${dinnertable.getTablestatus().getTablestatusid() == tablestatus.getTablestatusid()}">
														checked
													</c:if>
									class="form-check-input" name="tablestatusid"
									id="tablestatusid"
									value='<c:out value="${tablestatus.getTablestatusid()}"></c:out>'>
									<c:out value="${tablestatus.getName() }"></c:out> <i
									class="input-helper"></i></label>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
			<div class="container-fluid clearfix">
				<span
					class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"
					style="text-align: right; font-style: italic; font-size: 20px;">
					<button id="btnCapNhatTrangThaiBan" type="button"
						class="btn btn-primary">Cập nhật trạng thái</button>
				</span>
			</div>
		</form>
	</div>
	<!-- Trạng thái bàn [END]-->
	<!-- Sản phẩm -->
	<div class="tab-pane fade " id="add-food" role="tabpanel"
		aria-labelledby="add-food-tab">
		<div class="row add-food">

			<c:forEach items="${productDTOs}" var="productDTO">
				<div class="col-md-2 grid-margin stretch-card">
					<div class="" style="margin: 5px;">
						<div class="d-flex flex-row" style="text-align: center;">
							<img
								src='../resouces/images/my-images/<c:out value="${productDTO.getImages().get(0).getName() }"></c:out>'
								class="img-lg rounded">
						</div>
						<nav class="quanlity-product img-lg" style="text-align: center;">
							<label class="badge badge-warning" style="width: 100%;"><c:out
									value="${productDTO.getProduct().getName() }"></c:out></label>
							<div class="btn-group soluong1" role="group"
								aria-label="Basic example">
								<!-- <button type="button" class="btn btn-danger icon-btn ">
									<i class="fa fa-backward"></i>
								</button> -->
								<input class="form-control border-danger"
									data-productid='<c:out value="${productDTO.getProduct().getProductid() }"></c:out>'
									<c:if test = "${productDTO.getQuantity() > 0}">
									value='<c:out value="${productDTO.getQuantity() }"></c:out>'
								 </c:if>
									type="number" />
								<!-- <button type="button" class="btn btn-danger icon-btn ">
									<i class="fa fa-forward"></i>
								</button> -->
							</div>
						</nav>
					</div>
				</div>
			</c:forEach>

		</div>
		<div
			class="d-flex align-items-center justify-content-between flex-wrap">
			<form class="mt-2 mt-md-0 d-none d-lg-block search-input btn btn-inverse-light btn-fw">
				<div class="input-group">
					<input id="inputSearch" style="border: 0;" type="text" class="form-control "
						placeholder="Tìm kiếm..."> <span id="btnSearch"
						class="input-group-addon d-flex align-items-center"><i
						class="icon-magnifier icons"></i></span>
				</div>
			</form>
			<nav>
				<input id="totalPage"
					value="
						<c:if test="${totalPage == null}">
							1
						</c:if>
						<c:if test="${totalPage != null}">
							<c:out value="${totalPage}" />
						</c:if>"
						type="hidden">
					<ul class="pagination separated pagination-secondary">
						
					</ul>
			</nav>
		</div>
		<div class="container-fluid clearfix">
			<span
				class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"
				style="text-align: right; font-style: italic; font-size: 20px;">
				<button id='btnThemVaoHoaDon' type="button" class="btn btn-primary">Thêm
					vào hóa đơn</button>
			</span>
		</div>
	</div>
	<!-- Sản phẩm [END]-->
	<!-- Hóa đơn -->
	<div class="tab-pane fade " id="bill" role="tabpanel"
		aria-labelledby="bill-tab">
		<div class="tab-pane fade active show" id="add-food" role="tabpanel"
			aria-labelledby="add-food-tab">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Sản phẩm</th>
						<th>Đơn giá</th>
						<th>Số lượng</th>
						<th>Thành tiền</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:set var="i" scope="session" value="0" />
					<c:set var="j" scope="session" value="1" />
					<c:set var="trClass" scope="session" value="" />
					<c:forEach items="${dtos}" var="dto">

						<c:if test="${i == 0}">
							<c:set var="trClass" scope="session" value="table-info" />
						</c:if>
						<c:if test="${i == 1}">
							<c:set var="trClass" scope="session" value="table-warning" />
						</c:if>
						<c:if test="${i == 2}">
							<c:set var="trClass" scope="session" value="table-danger" />
						</c:if>
						<c:if test="${i == 3}">
							<c:set var="trClass" scope="session" value="table-success" />
						</c:if>
						<c:if test="${i == 4}">
							<c:set var="trClass" scope="session" value="table-primary" />
						</c:if>
						<tr id="<c:out value="${dto.getBilldetail().getProduct().getProductid()}"></c:out>" data-productid="<c:out value="${dto.getBilldetail().getProduct().getProductid()}"></c:out>" class='<c:out value="${trClass}"></c:out>'>
							<td><c:out value="${j}"></c:out></td>
							<td><c:out value="${dto.getBilldetail().getProduct().getName()}"></c:out></td>
							<td><c:out value="${dto.getSinglePrice()}"></c:out></td>
							<td><c:out value="${dto.getBilldetail().getQuantity()}"></c:out></td>
							<td><c:out value="${dto.getTotalPrice()}"></c:out></td>
							<td><label data-productid='<c:out value="${dto.getBilldetail().getProduct().getProductid()}"></c:out>' class="badge badge-danger remove"><i class="fa fa-times"></i></label></td>
						</tr>

						<c:if test="${i == 4}">
							<c:set var="i" scope="session" value="0" />
						</c:if>
						<c:set var="i" scope="session" value="${i + 1}" />
						<c:set var="j" scope="session" value="${j + 1}" />
					</c:forEach>
				</tbody>
			</table>
			<div class="container-fluid clearfix">
				<span
					class="text-muted d-block text-center text-sm-left d-sm-inline-block"
					style="text-align: right; color: #fd3258 !important; font-size: 20px;">Tổng
					tiền: <c:out value="${totalPriceBill}đ"></c:out>
				</span> <span
					class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"
					style="text-align: right; font-style: italic; font-size: 20px;">
					<p>
						Ngày lập:
						<c:out value="${bill.getStartdatetime()}"></c:out>
					</p>
					<button id="btnLuuChinhSua"
						data-billid='<c:out value="${bill.getBillid()}"></c:out>'
						type="button" class="btn btn-primary">Lưu chỉnh sửa</button>
					<button id="btnThanhToan"
						data-billid='<c:out value="${bill.getBillid()}"></c:out>'
						type="button" class="btn btn-primary">Thanh toán</button>
				</span>
			</div>
			<!-- </div> -->
		</div>
	</div>
	<!-- Hóa đơn [END]-->
</div>
<!-- End Body Tab Menu -->


<script src="../resouces/ajax-jquery/loadTable.js"></script>
<script src="../resouces/ajax-jquery/admin/index-update.js"></script>