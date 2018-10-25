<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEADER -->
<%@ include file="./public/header.jsp"%>
<!-- ./. HEADER -->
<!-- content-wrapper -->
<div class="content-wrapper">
	<div class="row section social-section">
		<div class="col-lg-3 grid-margin stretch-card" data-toggle="modal"
			data-target="#exampleModal">
			<div class="social-card w-100 ordered-table-status">
				<div class="badge badge-pill badge-primary number-table" style="">2</div>
				<div class="social-icon">
					<div class="icon-status-table-banconguoidat"></div>
				</div>
				<div class="content">
					<p>560 000đ</p>
					<p>Bàn được đặt trước</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 grid-margin stretch-card" data-toggle="modal"
			data-target="#exampleModal">
			<div class="social-card w-100 free-table-status">
				<div class="badge badge-pill badge-primary number-table" style="">11</div>
				<div class="social-icon">
					<div class="icon-status-table-ghetrong"></div>
				</div>
				<div class="content">
					<p>0đ</p>
					<p>Đang trống</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 grid-margin stretch-card" data-toggle="modal"
			data-target="#exampleModal">
			<div class="social-card w-100 full-table-status">
				<div class="badge badge-pill badge-primary number-table" style="">4</div>
				<div class="social-icon">
					<div class="icon-status-table-menu"></div>
				</div>
				<div class="content">
					<p>450 000đ</p>
					<p>Chờ gọi món</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 grid-margin stretch-card" data-toggle="modal"
			data-target="#exampleModal">
			<div class="social-card w-100 full-table-status">
				<div class="badge badge-pill badge-primary number-table" style="">3</div>
				<div class="social-icon">
					<div class="icon-status-table-dangnau"></div>
				</div>
				<div class="content">
					<p>450 000đ</p>
					<p>Đang chế biến</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 grid-margin stretch-card" data-toggle="modal"
			data-target="#exampleModal">
			<div class="social-card w-100 full-table-status">
				<div class="badge badge-pill badge-primary number-table" style="">1</div>
				<div class="social-icon">
					<div class="icon-status-table-donmon"></div>
				</div>
				<div class="content">
					<p>450 000đ</p>
					<p>Đang dọn món</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 grid-margin stretch-card" data-toggle="modal"
			data-target="#exampleModal">
			<div class="social-card w-100 full-table-status">
				<div class="badge badge-pill badge-primary number-table" style="">7</div>
				<div class="social-icon">
					<div class="icon-status-table-dangan"></div>
				</div>
				<div class="content">
					<p>450 000đ</p>
					<p>Hoàn tất chế biến</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 grid-margin stretch-card" data-toggle="modal"
			data-target="#exampleModal" data-whatever="@mdo">
			<div class="social-card w-100 none-table-status">
				<div class="badge badge-pill badge-primary number-table" style="">9</div>
				<div class="social-icon">
					<div class="icon-status-table-none"></div>
				</div>
				<div class="content">
					<p>0đ</p>
					<p>
						<del>Không sử dụng</del>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div
		class="d-flex align-items-center justify-content-between flex-wrap">
		<p class="mb-0">Hiện bàn thứ 1 đến 10 của 57 bàn</p>
		<nav>
			<ul class="pagination rounded-separated pagination-info mt-3">
				<li class="page-item"><a class="page-link" href="#"><i
						class="mdi mdi-chevron-left"></i></a></li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#"><i
						class="mdi mdi-chevron-right"></i></a></li>
			</ul>
		</nav>
	</div>
</div>
<!-- content-wrapper ends -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Chỉnh sửa</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- Tab Menu -->
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active"
						id="food-status-tab" data-toggle="tab" href="#food-status"
						role="tab" aria-controls="food-status" aria-selected="true">Trạng
							thái món ăn</a></li>
					<li class="nav-item"><a class="nav-link" id="table-status-tab"
						data-toggle="tab" href="#table-status" role="tab"
						aria-controls="table-status" aria-selected="false">Trạng thái
							bàn</a></li>
					<li class="nav-item"><a class="nav-link" id="add-food-tab"
						data-toggle="tab" href="#add-food" role="tab"
						aria-controls="add-food" aria-selected="false">Thêm món ăn</a></li>
					<li class="nav-item"><a class="nav-link" id="bill-tab"
						data-toggle="tab" href="#bill" role="tab" aria-controls="bill"
						aria-selected="false">Hóa đơn</a></li>
				</ul>
				<!-- End Tab Menu -->
				<!-- Body Tab Menu -->
				<div class="tab-content" id="nav-tabContent">
					<div class="tab-pane fade  active" id="food-status" role="tabpanel"
						aria-labelledby="food-status-tab">
						<form class="forms-sample">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<div class="form-radio form-radio-flat">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" name="flatRadios" id="flatRadios1"
												value="" checked=""> Đang chế biến <i
												class="input-helper"></i></label>
										</div>
										<div class="form-radio form-radio-flat">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" name="flatRadios" id="flatRadios2"
												value="option2"> Đang dọn món <i
												class="input-helper"></i></label>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<div class="form-radio form-radio-flat">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" name="flatRadios" id="flatRadios1"
												value=""> Hoàn tất chế biến <i class="input-helper"></i></label>
										</div>
										<div class="form-radio form-radio-flat">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" name="flatRadios" id="flatRadios2"
												value="option2"> Option two <i class="input-helper"></i></label>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane fade " id="table-status" role="tabpanel"
						aria-labelledby="table-status-tab">
						<form class="forms-sample">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<div class="form-radio form-radio-flat">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" name="flatRadios" id="flatRadios1"
												value="" checked=""> Bàn trống <i
												class="input-helper"></i></label>
										</div>
										<div class="form-radio form-radio-flat">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" name="flatRadios" id="flatRadios2"
												value="option2"> Bàn chờ gọi món <i
												class="input-helper"></i></label>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<div class="form-radio form-radio-flat">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" name="flatRadios" id="flatRadios1"
												value=""> Bàn được đặt trước <i class="input-helper"></i></label>
										</div>
										<div class="form-radio form-radio-flat">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" name="flatRadios" id="flatRadios2"
												value="option2"> Bàn không sử dụng <i
												class="input-helper"></i></label>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane fade " id="add-food" role="tabpanel"
						aria-labelledby="add-food-tab">
						<div class="row add-food">
							<div class="col-md-2 grid-margin stretch-card">
								<div class="" style="margin: 5px;">
									<div class="d-flex flex-row" style="text-align: center;">
										<img
											src="../resouces/images/my-images/4584269385_876bd911e0.jpg"
											class="img-lg rounded">
									</div>
									<nav class="quanlity-product img-lg ">
										<ul class="pagination rounded-separated pagination-info">
											<li class="page-item"><a class="page-link " href="#"><i
													class="mdi mdi-chevron-left "></i></a></li>
											<li class="page-item active">
												<form method="post">
													<input style="width: 100%;" class="page-link" type="text"
														name="FirstName" value="0">
												</form>
											</li>
											<li class="page-item"><a class="page-link " href="#"><i
													class="mdi mdi-chevron-right"></i></a></li>
										</ul>
									</nav>
								</div>
							</div>
							<div class="col-md-2 grid-margin stretch-card">
								<div class="card" style="margin: 5px;">
									<div class="d-flex flex-row">
										<img
											src="../resouces/images/my-images/4584269385_876bd911e0.jpg"
											class="img-lg rounded">
									</div>
									<nav class="quanlity-product img-lg ">
										<ul class="pagination rounded-separated pagination-info">
											<li class="page-item"><a class="page-link " href="#"><i
													class="mdi mdi-chevron-left "></i></a></li>
											<li class="page-item active"><input style="width: 100%;"
												class="page-link" type="text" name="" value="6"></li>
											<li class="page-item"><a class="page-link " href="#"><i
													class="mdi mdi-chevron-right"></i></a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
						<div
							class="d-flex align-items-center justify-content-between flex-wrap">
							<form class="mt-2 mt-md-0 d-none d-lg-block search-input">
								<div class="input-group">
									<span class="input-group-addon d-flex align-items-center"><i
										class="icon-magnifier icons"></i></span> <input style="border: 0;"
										type="text" class="form-control" placeholder="Tìm kiếm...">
								</div>
							</form>
							<nav class="quanlity-product">
								<ul class="pagination rounded-separated pagination-info mt-2">
									<li class="page-item"><a class="page-link" href="#"><i
											class="mdi mdi-chevron-left"></i></a></li>
									<li class="page-item active"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#">4</a></li>
									<li class="page-item"><a class="page-link" href="#"><i
											class="mdi mdi-chevron-right"></i></a></li>
								</ul>
							</nav>
						</div>
					</div>
					<div class="tab-pane fade " id="bill" role="tabpanel"
						aria-labelledby="bill-tab">
						<div class="tab-pane fade active show" id="add-food"
							role="tabpanel" aria-labelledby="add-food-tab">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>#</th>
										<th>Tên món ăn</th>
										<th>Đơn giá</th>
										<th>Số lượng</th>
										<th>Thành tiền</th>
									</tr>
								</thead>
								<tbody>
									<tr class="table-info">
										<td>1</td>
										<td>Herman Beck</td>
										<td>Photoshop</td>
										<td>$ 77.99</td>
										<td>May 15, 2015</td>
									</tr>
									<tr class="table-warning">
										<td>2</td>
										<td>Messsy Adam</td>
										<td>Flash</td>
										<td>$245.30</td>
										<td>July 1, 2015</td>
									</tr>
									<tr class="table-danger">
										<td>3</td>
										<td>John Richards</td>
										<td>Premeire</td>
										<td>$138.00</td>
										<td>Apr 12, 2015</td>
									</tr>
									<tr class="table-success">
										<td>4</td>
										<td>Peter Meggik</td>
										<td>After effects</td>
										<td>$ 77.99</td>
										<td>May 15, 2015</td>
									</tr>
									<tr class="table-primary">
										<td>5</td>
										<td>Edward</td>
										<td>Illustrator</td>
										<td>$ 160.25</td>
										<td>May 03, 2015</td>
									</tr>
								</tbody>
							</table>
							<!-- <div class="row">
                      <p class="card-description" style="text-align: right; color: #fd3258 !important; font-size: 20px;">Tổng tiền: 10 000 000đ</p>
                      <p class="card-description" style="text-align: right; color: #fd3258 !important; font-size: 20px;">Tổng tiền: 10 000 000đ</p>  -->
							<div class="container-fluid clearfix">
								<span
									class="text-muted d-block text-center text-sm-left d-sm-inline-block"
									style="text-align: right; color: #fd3258 !important; font-size: 20px;">Tổng
									tiền: 10 000 000đ</span> <span
									class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"
									style="text-align: right; font-style: italic; font-size: 20px;">
									<p>Ngày lập: 1/9/2018</p>
									<p>Ngày thanh toán: 18/9/2018</p>
								</span>
							</div>
							<!-- </div> -->
						</div>
					</div>
				</div>
				<!-- End Body Tab Menu -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</div>
</div>
<!-- End Modal -->
<!-- partial:../resouces/partials/_footer.html -->
<!-- partial -->
</div>
<!-- row-offcanvas ends -->
</div>

<!-- FOOTER -->
<%@ include file="./public/footer.jsp"%>
<!-- ./. FOOTER -->

