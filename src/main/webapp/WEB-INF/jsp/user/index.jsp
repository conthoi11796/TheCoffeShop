<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>The Coffe Shop</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="../resouces/node_modules/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="../resouces/node_modules/simple-line-icons/css/simple-line-icons.css">
  <link rel="stylesheet" href="../resouces/node_modules/flag-icon-css/css/flag-icon.min.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <link rel="stylesheet" href="../resouces/node_modules/font-awesome/css/font-awesome.min.css" />
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="../resouces/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="../resouces/images/favicon.png" />
  <!-- my-style-css -->
  <link rel="stylesheet" href="../resouces/css/my-style-v2.css">

  <!-- plugins:js -->
  <script src="../resouces/node_modules/jquery/dist/jquery.min.js"></script>
  <!-- end plugins:js -->
</head>

<body class="">
  <div class="container-scroller">
    <!-- partial:../resouces/partials/_navbar.html -->
    <nav style="background: url(../resouces/images/background2.jpg); background-size: cover;" class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row nav-bar-display-product">
      <div class="text-center navbar-brand-wrapper ">
        <a class="navbar-brand brand-logo logo" href="index.html"><img src="../resouces/images/logo-full.png" alt="logo"></a>
        <a class="navbar-brand brand-logo-mini logo" href="index.html"><img  src="../resouces/images/logo.png" alt="logo"></a>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center nav-bar-display-product-ul">
        <ul class="navbar-nav ml-lg-auto">
          <li class="nav-item">
            <div class="row" >
              <div class="header-search">
                <select class="form-control form-control-sm nav-search" id="exampleFormControlSelect3">
                  <option>Phân loại</option>
                  <option>2</option>
                  <option>3</option>
                  <option>4</option>
                  <option>5</option>
                </select>
              </div>
              <div class="header-search">
                <form class="nav-search">
                  <input class="input" placeholder="Từ khóa ...">
                  <i id="boloc" class="fa fa-sliders" data-toggle="popover" data-placement="bottom" data-title="Bộ lọc" data-content=
"
<div class='form-check form-check-flat'><label class='form-check-label'><input type='checkbox' class='form-check-input'  >Bán chạy nhất<i class='input-helper'></i></label></div><div class='form-check form-check-flat'><label class='form-check-label'><input type='checkbox' class='form-check-input'  >Đánh giá cao<i class='input-helper'></i></label></div><div class='form-check form-check-flat'><label class='form-check-label'><input type='checkbox' class='form-check-input'  >Sắp xếp giá tăng<i class='input-helper'></i></label></div><div class='form-check form-check-flat'><label class='form-check-label'><input type='checkbox' class='form-check-input'  >Sắp xếp giá giảm<i class='input-helper'></i></label></div><button class='btn btn-success nav-tooltip-btn'>Tìm kiếm</button><button class='btn btn-outline-danger nav-tooltip-btn'>Xóa bộ lọc</button>" data-html= "true"></i>
                  <button class="search-btn"><i class="icon-magnifier icons"></i></button>
                </form>
              </div>
              <div class="header-ctn">
                <!-- Cart -->
                <div class="dropdown">
                  <a id="dropdownMenuButton" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-shopping-cart"></i>
                    <span>Giỏ hàng</span>
                    <div class="qty">3</div>
                  </a>
                  <div class="dropdown-menu cart-dropdown your-card"  aria-labelledby="dropdownMenuButton">
                    <div class="cart-list">
                      <div class="product-widget">
                        <div class="product-img">
                          <img src="../resouces/images/my-images/25881311567_bc11131457.jpg" alt="">
                        </div>
                        <div class="product-body">
                          <h3 class="product-name"><a href="#">Caffe sữa</a></h3>
                          <h4 class="product-price"><span class="qty">1x</span>980.000đ</h4>
                        </div>
                        <button class="delete"><i class="fa fa-close"></i></button>
                      </div>

                      <div class="product-widget">
                        <div class="product-img">
                          <img src="../resouces/images/my-images/25881311567_bc11131457.jpg" alt="">
                        </div>
                        <div class="product-body">
                          <h3 class="product-name"><a href="#">Trà sữa</a></h3>
                          <h4 class="product-price"><span class="qty">3x</span>980.000đ</h4>
                        </div>
                        <button class="delete"><i class="fa fa-close"></i></button>
                      </div>
                    </div>
                    <div class="cart-summary">
                      <small>2 sản phẩm được chọn</small>
                      <h5>Tổng tiền: 294.000đ</h5>
                    </div>
                    <div class="cart-btns row">
                      <a href="#">Làm mới</a>
                      <a href="#">Thanh toán  <i class="fa fa-arrow-circle-right"></i></a>
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
    <div class="container-fluid page-body-wrapper" style="background: url(../resouces/images/background.jpg); background-size: cover;">
      <div class="">
        <div class="content-wrapper dislpay-product" style=" width: 100%; margin-left: 0;">
          <div class="row section social-section">
            <div class="row">
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button id="IDsanpham" title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_01" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_01" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_01" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_01" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_01" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"  data-toggle="modal" data-target="#exampleModal"><i class="fa fa-eye"></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
              </div>
            </div> 
              <!-- End Display Product -->
              <!-- Display Product -->
              <div class="col-lg-2 col-md-6 " style="">
                <div class="product">
                  <div class="product_img">
                    <div id="product_02" class="carousel slide product_img" data-ride="carousel">
                      <ol class="carousel-indicators">
                        <i class="fa fa-circle active" data-target="#product_02" data-slide-to="0"></i>
                        <i class="fa fa-circle" data-target="#product_02" data-slide-to="1"></i>
                        <i class="fa fa-circle" data-target="#product_02" data-slide-to="2"></i>
                      </ol>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                        </div>
                      </div>
                      <a class="carousel-control-prev" href="#product_02" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#product_02" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                  <div class="product-label">
                    <span class="sale">-30%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-category">Đồ uống</p>
                  <h3 class="product-name">Caffe sữa đá</h3>
                  <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                      <button title="Quan tâm" class="add-to-wishlist" tabindex="-1"><i class="fa fa-heart-o"></i></button>
                      <button title="Xem đánh giá" class="add-to-compare" tabindex="-1"><i class="fa fa-star-half-empty"></i></button>
                      <button title="Xem nhanh" class="quick-view" tabindex="-1"><i class="fa fa-eye" ></i></button>
                      <button title="Thêm vào giỏ" class="quick-view" tabindex="-1"><i class="fa fa-shopping-cart"></i></button>
                  </div>
                </div> 
                </div>
              </div> 
              <!-- End Display Product -->
              <!-- Detail Product -->
                  <div class="modal fade show detail-product" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                    <div class="modal-dialog modal-lg" role="document">
                      <div class="modal-content">
                        <div class="modal-body">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                          </button>
                          <div class="container row">
                            <div class="col-lg-8">
                              <div id="product_details" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                  <i class="fa fa-caret-left active" data-target="#product_details" data-slide-to="0"></i>
                                  <i class="fa fa-square " data-target="#product_details" data-slide-to="1"></i>
                                  <i class="fa fa-caret-right" data-target="#product_details" data-slide-to="2"></i>
                                </ol>
                                <div class="carousel-inner">
                                  <div class="carousel-item active">
                                    <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/15015802962_d494f36194.jpg" alt="First slide">
                                  </div>
                                  <div class="carousel-item ">
                                    <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Second slide">
                                  </div>
                                  <div class="carousel-item">
                                    <img class="d-block w-100 col-lg-12" src="../resouces/images/my-images/35487991553_3fc6715447.jpg" alt="Third slide">
                                  </div>
                                </div>
                                <a class="carousel-control-prev" href="#product_details" role="button" data-slide="prev">
                                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#product_details" role="button" data-slide="next">
                                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Next</span>
                                </a>
                              </div>
                            </div>
                            <div class="col-lg-4">
                              <div class="card-body">
                                <h4 class="card-title">Mô tả sản phẩm</h4>
                                <div class="card rounded border mb-2 alert-success">
                                  <div class="card-body p-3">
                                    <div class="media">
                                      
                                      <div class="media-body">
                                        <h6 class="mb-1">
                                          <i class="mdi mdi-check-all icon-sm text-success align-self-center mr-3"></i>
                                          Tên sản hẩm</h6>
                                        <p class="mb-0 text-muted detail-product-name">
                                          Caffe sữa đá
                                        </p>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                <div class="card rounded border mb-2 alert-danger">
                                  <div class="card-body p-3">
                                    <div class="media">
                                      
                                      <div class="media-body">
                                        <h6 class="mb-1"><i class="mdi mdi-check-all icon-sm text-success align-self-center mr-3"></i>Giá</h6>
                                        <p class="mb-0 text-muted detail-product-price">
                                          90.000đ
                                        </p>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                <div class="card rounded border mb-2 alert-info">
                                  <div class="card-body p-3">
                                    <div class="media">
                                      <div class="media-body">
                                        <h6 class="mb-1"><i class="mdi mdi-check-all icon-sm text-success align-self-center mr-3"></i>Mô tả</h6>
                                        <p class="mb-0 text-muted">
                                          Trà sữa trân châu chỉ bao gồm trà sữa và trân châu đen, dành riêng cho tín đồ thích trà sữa trân châu truyền thống.
                                        </p>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
              <!-- End Detail Product -->
            </div>
          </div>
          <div class="align-items-center justify-content-between flex-wrap container" style="text-align: center;">
            <button type="button" class="btn btn-inverse-light btn-rounded btn-fw btn-see-more">Xem thêm</button>
          </div>        
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../resouces/partials/_footer.html -->
        <footer class="footer" style="">
          <div class="container-fluid clearfix">
            <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © 2018 <a href="http://www.bootstrapdash.com/" target="_blank">Bootstrapdash</a>. All rights reserved.</span>
          </div>
        </footer>
        <!-- partial -->
        <!-- messenger -->
        <div id="div-box-chat" class="messenger nav-link count-indicator d-none d-lg-block fixed-bottom dropup " style="">
          <!-- chat-online -->
          <div class="popover fade show bs-popover-right chat-online" role="tooltip" >
            <h3 id="btn-show" class="popover-header" onclick="" >Tư vấn trức tuyến</h3>
            <h3 id="btn-hidden" class="popover-header" onclick="">Tư vấn trức tuyến</h3>
            <div id="display-chat">
              <div class="form-group "  >
                  <div class="container-fluid">
                      <p class="mes-employee">
                          <img src="../resouces/images/my-images/11820887136_ee58b64ba7.jpg" alt="image">
                          Chào bạn
                      </p>
                  </div>
                  <div class="container-fluid float-right" style="">
                      <p class="mes-client">
                          Chào Admin
                          <img src="../resouces/images/my-images/11820887136_ee58b64ba7.jpg" alt="image">
                      </p>
                  </div>
              </div>
              <div class="input-group popover-header form-chat-online" >
                  <div class="input-group">
                     <input type="text" class="form-control" placeholder="Nhập tin nhắn..." aria-label="Username" aria-describedby="colored-addon3">
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
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="../resouces/node_modules/popper.js/dist/umd/popper.min.js"></script>
  <script src="../resouces/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="../resouces/js/off-canvas.js"></script>
  <script src="../resouces/js/misc.js"></script>
  <!-- Modal -->
  <script src="../resouces/style-js/my-style.js"></script>
  <!-- End Modal -->
  <!-- Dropdown Cart -->

  <!-- End Dropdown Cart -->
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="../resouces/js/popover.js"></script>
  <!-- End custom js for this page-->

          

</body>

</html>
