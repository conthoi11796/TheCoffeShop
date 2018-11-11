<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
      
      <div class="form-group">  
        <input id="scheduleid" type="text" 
          <c:if test = "${schedule.getScheduleid()!=null}">
              disabled
          </c:if>
          value= '<c:out value="${schedule.getScheduleid()}" />' 
          class="form-control" placeholder="Mã ca làm"/>
      </div>
      <div class="form-group">
          <input id="starttime" type="time" value= '<c:out value="${schedule.getStarttime()}" />' class="form-control" placeholder="Giờ bắt đầu"/>
      </div>
      <div class="form-group">
            <input id="endtime" type="time" value= '<c:out value="${schedule.getEndtime()}" />' class="form-control" placeholder="Giờ kết thúc"/>
        </div>
        <div class="form-group">
                <input id="payrate" type="number" value= '<c:out value="${schedule.getPayrate()}" />' class="form-control" placeholder="Chỉ số lương"/>
            </div>
        <c:if test = "${schedule.getScheduleid()==null}">
            <button id="btnSave" type="button" class="btn btn-success mr-2">
              Thêm
            </button>
        </c:if>
        <c:if test = "${schedule.getScheduleid()!=null}">
            <button id="btnUpdate" type="button" class="btn btn-success mr-2">
              Cập nhật
            </button>
        </c:if>
      <button id="btnClear" class="btn btn-light">Làm mới</button>
<script src="../resouces/ajax-jquery/schedule-edit.js"></script>