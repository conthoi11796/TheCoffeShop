<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
      
      <div class="form-group">  
        <input id="productstatusid" type="text" 
          <c:if test = "${billstatus.getBillstatusid()!=null}">
              disabled
          </c:if>
          value= '<c:out value="${billstatus.getBillstatusid()}" />' 
          class="form-control" placeholder="Mã trạng thái"/>
      </div>
      <div class="form-group">
          <input id="name" type="text" value= '<c:out value="${billstatus.getName()}" />' class="form-control" placeholder="Tên trạng thái"/>
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
<script src="../resouces/ajax-jquery/bill-status-edit.js"></script>