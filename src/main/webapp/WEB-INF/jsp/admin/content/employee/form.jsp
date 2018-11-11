<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
      
      <div class="form-group">  
        <input id="employeeid" type="text" 
          <c:if test = "${employee.getEmployeeid()!=null}">
              disabled
          </c:if>
          value= '<c:out value="${employee.getEmployeeid()}" />' 
          class="form-control" placeholder="Mã nhân viên"/>
      </div> 
      <div class="form-group">
            <input id="name" type="text" value= '<c:out value="${employee.getName()}" />' class="form-control" placeholder="Tên nhân viên"/>
        </div>
      <div class="form-group">
          <div class="row">
            <div class="form-radio form-radio-flat">
                    <label class="form-check-label">
                      <input type="radio" class="form-check-input" name="Male" id="Male" value="Male" checked="">
                      Nam
                    <i class="input-helper"></i></label>
                  </div>
                  <div class="form-radio form-radio-flat">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" name="FeMale" id="FeMale" value="FeMale" >
                          Nữ
                        <i class="input-helper"></i></label>
                      </div></div>
        </div>
        <div class="form-group">
                <input id="phone" type="text" value= '<c:out value="${employee.getPhone()}" />' class="form-control" placeholder="Số điện thoại"/>
            </div>
            <div class="form-group">
                    <input id="address" type="text" value= '<c:out value="${employee.getAddress()}" />' class="form-control" placeholder="Địa chỉ"/>
                </div>
                <c:if test = "${employee.getEmployeeid()==null}">
                <div class="form-group">
                        <input id="usename" type="text" class="form-control" placeholder="Tài khoản"/>
                    </div>
                    <div class="form-group">
                            <input id="password" type="password" value= '<c:out value="${billstatus.getName()}" />' class="form-control" placeholder="Mật khẩu"/>
                        </div>
                    </c:if>
                        <div class="form-group">
                                <select class="form-control"
        id="position">
        <option value="-1">Phân loại</option>
        <c:forEach items="${positions}" var="position">
            <option
                <c:if test="${xx.getCategoryproduct().getCategoryproductid()==position.getPositionid()}">
                                selected
                        </c:if>
                value='<c:out value = "${position.getPositionid()}" />'>
                <c:out value="${position.getName() }" />
            </option>
        </c:forEach>
    </select>
                            </div>
                            <div class="form-group">
                                        <input id="salaryonhour" type="number" value= '<c:out value="${ employee.getSalary().getSalaryonhour()}" />' class="form-control" placeholder="Lương / giờ"/>
                          
                                
                            </div>
                            <div class="form-group">
                                        <input id="startdate" type="date" value= '<c:out value="${ employee.getSalary().getSalaryonhour()}" />' class="form-control" placeholder="Ngày bắt đầu làm"/>
                          
                                
                            </div>
        <c:if test = "${billstatus.getBillstatusid()==null}">
            <button id="btnSave" type="button" class="btn btn-success mr-2">
              Thêm
            </button>
        </c:if>
        <c:if test = "${billstatus.getBillstatusid()!=null}">
            <button id="btnUpdate" type="button" class="btn btn-success mr-2">
              Cập nhật
            </button>
        </c:if>
      <button id="btnClear" class="btn btn-light">Làm mới</button>
<script src="../resouces/ajax-jquery/employee-edit.js"></script>