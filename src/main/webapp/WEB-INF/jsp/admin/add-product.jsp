<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEADER -->
<%@ include file="./public/header.jsp"%>
<!-- HEADER [END] -->
<div class="content-wrapper">
	<div class="row user-profile">
		<div class="col-lg-8 side-left stretch-card">
			<div class="card">
				<div class="card-body">
					<div
						class="wrapper d-block d-sm-flex align-items-center justify-content-between">
						<h4 class="card-title mb-0">Thêm sản phẩm</h4>
						<ul class="nav nav-tabs tab-solid tab-solid-primary mb-0"
							id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link" id="info-tab"
								data-toggle="tab" href="#info" role="tab" aria-controls="info"
								aria-expanded="true" aria-selected="false">Sản phẩm</a></li>
							<li class="nav-item"><a class="nav-link active show"
								id="security-tab" data-toggle="tab" href="#security" role="tab"
								aria-controls="security" aria-selected="true">Loại sản phẩm</a>
							</li>
							<li class="nav-item"><a class="nav-link" id="avatar-tab"
								data-toggle="tab" href="#avatar" role="tab"
								aria-controls="avatar" aria-selected="false">Hình ảnh</a></li>
						</ul>
					</div>
					<div class="wrapper">
						<hr>
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade" id="info" role="tabpanel"
								aria-labelledby="info">
								<form id="formProduct" method="post">
									<div class="form-group">
										<label for="PId">Mã sản phẩm</label> <input type="text"
											class="form-control" id="PId" name="PId" placeholder="#"
											disabled="disabled">
									</div>
									<div class="form-group">
										<label for="PName">Tên (*)</label> <input type="text"
											class="form-control" id="PName" name="PName"
											placeholder="Tên sản phẩm ...">
									</div>
									<div class="form-group">
										<label for="PDescription">Mô tả</label>
										<textarea name="PDescription" id="PDescription"
											name="PDescription" rows="4" class="form-control"
											placeholder="Mô tả ..."></textarea>
									</div>
									<div class="form-group row">
										<div class="col-sm-6">
											<label for="prPrice">Giá (*)</label> <input type="number"
												class="form-control" id="prPrice" name="prPrice"
												placeholder="Giá sản phẩm ...">
										</div>
										<div class="col-sm-6">
											<label for="prDatestart">Ngày áp dụng (*)</label> <input
												type="date" class="form-control" id="prDatestart"
												name="prDatestart" placeholder="Ngày áp dụng...">
										</div>
									</div>
									<div class="form-group mt-5">
										<button type="button" class="btn btn-outline-danger">Làm
											mới</button>
										<button id="btnStep1"  type="button"
											class="btn mr-2 btn-disable">Bước tiếp</button>
									</div>
								</form>
							</div>
							<!-- tab content ends -->
							<div class="tab-pane fade active show" id="security"
								role="tabpanel" aria-labelledby="security-tab">
								<form id="formCateGoryProduct" method="post">
									<div class="form-group">
										<label for="cgPrdId">Mã loại</label> <input
											type="text" class="form-control" id="cgPrdId"
											placeholder="#" disabled="disabled">
									</div>
									<div class="form-group">
										<select class="form-control" id="cgPrdName">
											<option disabled="disabled" selected="selected">---Chọn
												loại sản phẩm---</option>
											<c:forEach items="${categoryproducts}" var="categoryproduct">
												<option
													value="<c:out value = "${categoryproduct.getCgPrdId()}"/>">
													<c:out value="${categoryproduct.getCgPrdName()}" />
												</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group mt-5">
										<button type="button" class="btn btn-outline-danger">Cancel</button>
										<button id="btnStep2" type="button" class="btn btn-disable mr-2">Bước tiếp</button>
									</div>
								</form>
							</div>
							<div class="tab-pane fade" id="avatar" role="tabpanel"
								aria-labelledby="avatar-tab">

								<div class="wrapper mb-5 mt-4">
									<span class="badge badge-warning text-white">Chú ý : </span>
									<p class="d-inline ml-3 text-muted">Hình ảnh phải nhỏ hơn
										1MB .</p>
								</div>
								<form id="formImagesOfProduct" method="post" action="#">
									<input type="file" class="dropify" data-max-file-size="1mb"
										data-default-file="../../images/faces/face6.jpg">
									<div class="form-group mt-5">
										<button id="btnStep3" type="button" class="btn btn-success mr-2">Hoàn tất</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-lg-4 side-right d-flex align-items-stretch">
			<div class="row">
				<div class="col-12 stretch-card">
					<div class="card">
						<div class="card-body overview">
							<div class="wrapper about-user">
								<h4 class="card-title mt-4 mb-3">Sản phẩm vừa thêm</h4>
							</div>
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
								<figure class="effect-text-in">
									<img src="../../images/samples/300x300/1.jpg" alt="image">
									<figcaption>
										<h4>Photography</h4>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
									</figcaption>
								</figure>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Include JS -->
<script src="../resouces/style-js/add-product.js"></script>
<!-- Include JS [END] -->

<!-- FOOTER -->
<%@ include file="./public/footer.jsp"%>
<!-- FOOTER [END] -->