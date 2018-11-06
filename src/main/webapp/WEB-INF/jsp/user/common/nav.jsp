
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
									<c:if test="${cgPrdId!=null && cgPrdId==categoryProduct.getCategoryproductid()}">
													<c:out value="selected" />
											</c:if>
									value='<c:out value = "${categoryProduct.getCategoryproductid()}" />'>
									<c:out value="${categoryProduct.getName() }" />
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