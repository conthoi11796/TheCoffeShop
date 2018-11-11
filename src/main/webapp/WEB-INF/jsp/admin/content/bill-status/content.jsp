<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-5 d-flex align-items-stretch">
		<div class="row flex-grow">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Trạng thái hóa đơn</h4>
						<p id="result-form" class="card-description"></p>
						<form id="billStatus_form" class="forms-sample">
							<%@ include file="./form.jsp"%>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-7 grid-margin stretch-card">
		`
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Danh sách trạng thái hoá đơn</h4>
				<p id="result-tbody" class="card-description">
					<code></code>
				</p>
				<table id="order-listing" class="table table-hover">
					<thead>
						<tr>
							<th></th>
							<th>ID</th>
							<th>Tên</th>
							<th>Cập nhập lần cuối</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<nav>
					<ul class="pagination separated pagination-secondary">
						<li class="page-item"><a class="page-link" href="#"><i
								class="mdi mdi-chevron-left"></i></a></li>
						<c:if test="${startPosition == null}">
							<c:set var="startPosition" scope="session" value="1" />
						</c:if>
						<c:set var="temb" scope="session" value="1" />
						<c:forEach var="i" begin="1" end="5">
							<c:if test="${temb <= totalPage}">
								<c:if test="${startPosition == temb}">
									<li class="page-item active"><a class="page-link" href="#"><c:out
												value="${temb}" /></a></li>
								</c:if>
								<c:if test="${startPosition != temb}">
									<li class="page-item "><a class="page-link" href="#"><c:out
												value="${temb}" /></a></li>
								</c:if>
								<c:set var="temb" scope="session" value="${temb = temb + 1}" />
							</c:if>
						</c:forEach>


						<li class="page-item"><a class="page-link" href="#"><i
								class="mdi mdi-chevron-right"></i></a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>