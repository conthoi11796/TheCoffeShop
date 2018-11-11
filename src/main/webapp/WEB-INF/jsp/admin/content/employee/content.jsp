<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <div class="row">
      <div class="col-md-5 d-flex align-items-stretch">
        <div class="row flex-grow">
          <div class="col-12 grid-margin">
                <div class="card">
                        <div class="card-body">
                          <h4 class="card-title">Nhân viên</h4>
                          <p id="result-form" class="card-description">
                          </p>
                          <form id="employee_form" class="forms-sample">
                              <%@ include file="./form.jsp"%>
                          </form>
                        </div>
                      </div>
          </div>
          
        </div>
      </div>
      <div class="col-md-7 grid-margin stretch-card">
            `<div class="card">
                    <div class="card-body">
                      <h4 class="card-title">Danh sách nhân viên</h4>
                      <p id="result-tbody" class="card-description"><code></code>
                      </p>
                      <table class="table table-hover">
                        <thead>
                          <tr>
                            <th></th>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Giới tính</th>
                            <th>Điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Lương hiện tại</th>
                            <th>Cập nhập lần cuối</th>
                          </tr>
                        </thead>
                        <tbody>
                           
                        </tbody>
                      </table>
                    </div>
                  </div>
      </div>
    </div>