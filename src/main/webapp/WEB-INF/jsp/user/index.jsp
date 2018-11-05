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
												href="/order-product?listCart=" listNumberProduct="">Thanh
												toán <i class="fa fa-arrow-circle-right"></i>
											</a>
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

		<!-- content-wrapper -->
		<div class="container-fluid page-body-wrapper"
			style="background: url(../resouces/images/background.jpg); background-size: cover;">
			<div class="">
				<div class="content-wrapper dislpay-product"
					style="width: 100%; margin-left: 0;">
					<div class="row section social-section">
						<div class="row">
							<!-- Display Product -->
							<c:set var="i" scope="session" value="${0}" />
							<c:forEach items="${products}" var="product">
								<div class="col-lg-2 col-md-6 " style="">
									<div class="product">
										<div class="product_img">
											<div id="<c:out value="${product.getPId()}" />"
												class="carousel slide product_img" data-ride="carousel">
												<ol class="carousel-indicators">
													<i class="fa fa-circle active"
														data-target="#<c:out value="${product.getPId()}" />"
														data-slide-to="0"></i>
													<i class="fa fa-circle"
														data-target="#<c:out value="${product.getPId()}" />"
														data-slide-to="1"></i>
													<i class="fa fa-circle"
														data-target="#<c:out value="${product.getPId()}" />"
														data-slide-to="2"></i>
												</ol>
												<div class="carousel-inner ">
													<div class="carousel-item active">
														<img
															class="d-block w-100 col-lg-12 img-<c:out value="${product.getPId()}" />"
															src="../resouces/images/my-images/15015802962_d494f36194.jpg"
															alt="First slide">
													</div>
													<div class="carousel-item">
														<img class="d-block w-100 col-lg-12"
															src="../resouces/images/my-images/35487991553_3fc6715447.jpg"
															alt="Second slide">
													</div>
													<div class="carousel-item">
														<img class="d-block w-100 col-lg-12"
															src="../resouces/images/my-images/35487991553_3fc6715447.jpg"
															alt="Third slide">
													</div>
												</div>
												<a class="carousel-control-prev"
													href="#<c:out value="${product.getPId()}" />" role="button"
													data-slide="prev"> <span
													class="carousel-control-prev-icon" aria-hidden="true"></span>
													<span class="sr-only">Previous</span>
												</a> <a class="carousel-control-next"
													href="#<c:out value="${product.getPId()}" />" role="button"
													data-slide="next"> <span
													class="carousel-control-next-icon" aria-hidden="true"></span>
													<span class="sr-only">Next</span>
												</a>
											</div>
											<div class="product-label">
												<c:if test="${priceProducts[i][2]!=null}">
													<!-- product have new price -->
													<span class="sale"> <c:out
															value="${priceProducts[i][4]}" /> <c:if
															test="${priceProducts[i][5]=='0'}">
															<c:out value="Từ ${priceProducts[i][3]}" />
														</c:if> <c:if test="${priceProducts[i][5]=='1'}">
															<c:out value="Ra mắt ${priceProducts[i][3]}" />
														</c:if>
													</span>
												</c:if>
												<c:if test="${priceProducts[i][5]=='1'}">
													<span class="new">NEW</span>
												</c:if>
											</div>
										</div>
										<div class="product-body">
											<p class="product-category">
												<c:out
													value="${product.getCategoryproduct().getCgPrdName()}" />
											</p>
											<h3
												class="product-name product-name-<c:out value="${product.getPId()}" />">
												<c:out value="${product.getPName()}" />
											</h3>
											<h4
												class="product-price product-price-<c:out value="${product.getPId()}" />">
												<c:if test="${priceProducts[i][0] == product.getPId()}">
													<c:if test="${priceProducts[i][2]!=null}">
														<!-- new price -->
														<c:out value="${priceProducts[i][2]}" />
														<del class="product-old-price">
															<c:out value="${priceProducts[i][1]}" />
														</del>
													</c:if>
													<c:if test="${priceProducts[i][2]==null}">
														<c:out value="${priceProducts[i][1]}" />
													</c:if>
												</c:if>
											</h4>
											<div class="product-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i>
											</div>
											<div class="product-btns">
												<button id="IDsanpham" title="Quan tâm"
													class="add-to-wishlist" tabindex="-1">
													<i class="fa fa-heart-o"></i>
												</button>
												<button title="Xem đánh giá" class="add-to-compare"
													tabindex="-1">
													<i class="fa fa-star-half-empty"></i>
												</button>
												<button
													data-PId='<c:out value="${product.getPId()}"></c:out>'
													title="Xem nhanh" class="quick-view btn-View" tabindex="-1"
													data-toggle="modal" data-target="#exampleModal">
													<i class="fa fa-eye"></i>
												</button>
												<button
													data-PId='<c:out value="${product.getPId()}"></c:out>'
													title="Thêm vào giỏ" class="quick-view btn-add-to-cart"
													tabindex="-1">
													<i class="fa fa-shopping-cart"></i>
												</button>
											</div>
										</div>
									</div>
								</div>
								<c:set var="i" scope="session" value="${i+1}" />
							</c:forEach>
							<!-- End Display Product -->
							<!-- Detail Product -->
							<div class="modal fade show detail-product" id="exampleModal"
								tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog modal-lg" role="document">
									<div class="modal-content">
										<div class="modal-body">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">×</span>
											</button>
											<div id="detail-product" class="container row"></div>
										</div>
									</div>
								</div>
							</div>
							<!-- End Detail Product -->
						</div>
					</div>
					<div
						class="align-items-center justify-content-between flex-wrap container"
						style="text-align: center;">
						<a
							href='../index/search?page=
							<c:if test="${startPosition!=null}">
								<c:out value="${startPosition}" />
							</c:if>
							<c:if test="${startPosition==null}">
								<c:out value="0" />
							</c:if>
							&cgPrdId=
							<c:if test="${cgPrdId!=null}">
								<c:out value="${cgPrdId}" />
							</c:if>
							&strSearch=null'
							class="btn btn-inverse-light btn-rounded btn-fw btn-see-more">Xem
							thêm</a>
					</div>
				</div>
				<!-- content-wrapper ends -->

				<!-- FOOTER -->
				<%@ include file="./footer.jsp"%>
				<!-- FOOTER [END]-->