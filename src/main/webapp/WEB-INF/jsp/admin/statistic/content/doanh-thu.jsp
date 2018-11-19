<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-lg-6 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Thống kê theo ngày</h4>
				<canvas id="doughnutChart" style="height: 250px"></canvas>
			</div>
		</div>
	</div>
	<div class="col-lg-6 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Thống kê theo tuần</h4>
				<canvas id="scatterChart" style="height: 250px"></canvas>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-6 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Area chart</h4>
				<canvas id="areaChart" style="height: 250px"></canvas>
			</div>
		</div>
	</div>
	<div class="col-lg-6 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Line chart</h4>
				<canvas id="lineChart" style="height: 250px"></canvas>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-6 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Pie chart</h4>
				<canvas id="pieChart" style="height: 250px"></canvas>
			</div>
		</div>
	</div>
	<div class="col-lg-6 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Bar chart</h4>
				<canvas id="barChart" style="height: 230px"></canvas>
			</div>
		</div>
	</div>
</div>