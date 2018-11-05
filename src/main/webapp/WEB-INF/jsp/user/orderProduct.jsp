
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEADER -->
<%@ include file="./header.jsp"%>
<!-- HEADER [END] -->
<body class="">
	<div class="container-scroller">
		<!-- partial:../resouces/partials/_navbar.html -->
		<nav
			style="background: url(../resouces/images/background2.jpg); background-size: cover;"
			class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row nav-bar-display-product">
			<div class="text-center navbar-brand-wrapper ">
				<a class="navbar-brand brand-logo logo" href="index.html"><img
					src="../resouces/images/logo-full.png" alt="logo"></a> <a
					class="navbar-brand brand-logo-mini logo" href="index.html"><img
					src="../resouces/images/logo.png" alt="logo"></a>
			</div>
			<div
				class="navbar-menu-wrapper d-flex align-items-center nav-bar-display-product-ul">
				<ul class="navbar-nav ml-lg-auto">
					<li class="nav-item">
						<div class="row">
							<div class="header-search">
								<select class="form-control form-control-sm nav-search"
									id="selectCategoryProduct">
									<option>Phân loại</option>
									<c:out value="${listCart }" />
									<c:forEach items="${categoryProducts}" var="categoryProduct">
										<option
											<c:if test="${cgPrdId!=null && cgPrdId==categoryProduct.getCgPrdId()}">
													<c:out value="selected" />
											</c:if>
											value='<c:out value = "${categoryProduct.getCgPrdId()}" />'>
											<c:out value="${categoryProduct.getCgPrdName() }" />
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="header-search">
								<form id="formSearch" method="GET" action="../index/search"
									class="nav-search">
									<input class="input" placeholder="Từ khóa ..."> <i
										id="boloc" class="fa fa-sliders" data-toggle="popover"
										data-placement="bottom" data-title="Bộ lọc"
										data-content="
<div class='form-check form-check-flat'><label class='form-check-label'><input type='checkbox' class='form-check-input'  >Bán chạy nhất<i class='input-helper'></i></label></div><div class='form-check form-check-flat'><label class='form-check-label'><input type='checkbox' class='form-check-input'  >Đánh giá cao<i class='input-helper'></i></label></div><div class='form-check form-check-flat'><label class='form-check-label'><input type='checkbox' class='form-check-input'  >Sắp xếp giá tăng<i class='input-helper'></i></label></div><div class='form-check form-check-flat'><label class='form-check-label'><input type='checkbox' class='form-check-input'  >Sắp xếp giá giảm<i class='input-helper'></i></label></div><button class='btn btn-success nav-tooltip-btn'>Tìm kiếm</button><button class='btn btn-outline-danger nav-tooltip-btn'>Xóa bộ lọc</button>"
										data-html="true"></i>
									<button class="search-btn">
										<i class="icon-magnifier icons"></i>
									</button>
								</form>
							</div>
							<div class="header-ctn">
								<!-- Cart -->
								<div class="dropdown">
									<a id="dropdownMenuButton" class="dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false"> <i
										class="fa fa-shopping-cart"></i> <span>Giỏ hàng</span>
										<div class="qty">0</div>
									</a>
									<div class="dropdown-menu cart-dropdown your-card"
										aria-labelledby="dropdownMenuButton">
										<div class="cart-list"></div>
										<div class="cart-summary">
											<small>2 sản phẩm được chọn</small>
											<h5>0</h5>
										</div>
										<div class="cart-btns row">
											<a id="btnClean">Làm mới</a> <a id="btnPay"
												href="/order-product?listCart=">Thanh toán <i
												class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->
							</div>
							<!--  -->
						</div>
					</li>
				</ul>
			</div>
		</nav>
		<!-- partial ends -->
		<!-- content -->
		<div class="container-fluid page-body-wrapper"
			style="background: url(../resouces/images/background.jpg); background-size: cover;">
			<div class="">
				<div class="content-wrapper dislpay-product"
					style="width: 100%; margin-left: 0;">
					<div class="row section social-section">
						<div class="col-lg-6 grid-margin stretch-card">
							<!--form mask starts-->
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Danh sách sản phẩm</h4>
									<div class="form-group row">
										<table class="table table-striped">
											<thead>
												<tr>
													<th>Sản phẩm</th>
													<th>Số lượng</th>
													<th>Đơn giá</th>
													<th>Thành tiền</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${productDTOs}" var="productDTO">
													<tr>
														<td class="py-1"><img
															src="../resouces/images/my-images/<c:out value="${productDTO.getImages().get(0).getImgName() }"></c:out>"
															alt="image"> <c:out
																value="${productDTO.getProduct().getPName() }"></c:out>
														</td>
														<td><input
															value="<c:out value='${productDTO.getNumber() }'></c:out>" />
														</td>
														<td><label class="badge badge-warning"> <c:out
																	value="${productDTO.getPrice() }"></c:out>
														</label></td>
														<td><c:out
																value="${productDTO.getPrice()*productDTO.getNumber() }"></c:out>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!--form mask ends-->
						</div>
						<div class="col-lg-6 grid-margin stretch-card">
							<!--form mask starts-->
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Thông tin khách hàng</h4>
									<form method="post" action="/order-product" class="forms-sample">
										<!-- <input id="listProduct" name="listProduct" type="hidden" class="form-control form-control-sm">
										<input id="listProduct" name="cuName" type="hidden" class="form-control form-control-sm"> -->
										<div class="form-group">
											<input id="cuName" name="cuName" type="text"
												class="form-control form-control-sm" placeholder="Họ tên:(*)">
										</div>
										<div class="form-group">
											<input id="cuAddress" name="cuAddress" type="text"
												class="form-control form-control-sm" placeholder="Địa chỉ:(*)">
										</div>
										<div class="form-group">
											<input id="cuPhoneNumber" name="cuPhoneNumber" type="text"
												class="form-control form-control-sm" placeholder="Số điện thọai:(*)">
										</div>
										<div class="form-group">
											<label>Ngày giao hàng:(*)</label>
											<input id="biDatetimeStart" name="biDatetimeStart" type="date" 
												class="form-control form-control-sm">
										</div>
										<div class="form-group">
											<textarea id="biNotice" name="biNotice" class="form-control" placeholder="Ghi chú:" rows="3"></textarea>
										</div>
										<div class="form-group">
											<input id="voId" name="voId" type="text"
												class="form-control form-control-sm" placeholder="Mã giảm giá:">
										</div>
										<button type="submit" class="btn btn-success mr-2">Hoàn
											tất</button>
										<button class="btn btn-light">Hủy</button>
									</form>
								</div>
							</div>
							<!--form mask ends-->
						</div>
					</div>

				</div>
				<!-- content-wrapper ends -->

				<!-- FOOTER -->



				<!-- partial:../resouces/partials/_footer.html -->
				<footer class="footer" style="">
					<div class="container-fluid clearfix">
						<span
							class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright
							© 2018 <a href="http://www.bootstrapdash.com/" target="_blank">Bootstrapdash</a>.
							All rights reserved.
						</span>
					</div>
				</footer>
				<!-- partial -->
				<!-- messenger -->
				<div id="div-box-chat"
					class="messenger nav-link count-indicator d-none d-lg-block fixed-bottom dropup "
					style="">
					<!-- chat-online -->
					<div class="popover fade show bs-popover-right chat-online"
						role="tooltip">
						<h3 id="btn-show" class="popover-header" onclick="">Tư vấn
							trức tuyến</h3>
						<h3 id="btn-hidden" class="popover-header" onclick=""
							style="display: none;">Tư vấn trức tuyến</h3>
						<div id="display-chat" style="display: none;">
							<div class="form-group ">
								<div class="container-fluid">
									<p class="mes-employee">
										<img
											src="../resouces/images/my-images/11820887136_ee58b64ba7.jpg"
											alt="image"> Chào bạn
									</p>
								</div>
								<div class="container-fluid float-right" style="">
									<p class="mes-client">
										Chào Admin <img
											src="../resouces/images/my-images/11820887136_ee58b64ba7.jpg"
											alt="image">
									</p>
								</div>
							</div>
							<div class="input-group popover-header form-chat-online">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Nhập tin nhắn..." aria-label="Username"
										aria-describedby="colored-addon3">
									<div class="input-group-append">
										<i class="fa fa-send"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- end chat online -->
				</div>
				<!-- end messenger -->
			</div>
			<!-- row-offcanvas ends -->
		</div>
		<!-- end content -->
	</div>
	<!-- Custom -->
	<script src="../resouces/style-js/order-product.js"></script>
	<!-- Custom[END] -->
	<!-- FOOTER -->
	<%@ include file="./footer.jsp"%>
	<!-- FOOTER [END]-->