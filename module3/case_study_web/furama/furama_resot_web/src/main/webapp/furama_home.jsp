<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09/11/2022
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row" style="background-color: whitesmoke">
        <div class="col ">
            <a href="https://furamavietnam.com/vi/">
                <img style="width: 170px;height: 120px;margin-left: 100px"
                     src="https://static.topcv.vn/company_logos/oruz4IPeY3cyRu9HaWwRFrSdfWfDnw60_1635916800____08c8e444e64ab28b2cef44fb69347361.png">
            </a>
        </div>
        <div class="col ">
            <a href="https://www.tripadvisor.com/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang.html">
                <img style="width: 150px;height: 100px;margin-top: 10px"
                     src="https://www.kindpng.com/picc/m/606-6060823_trip-advisor-graphic-design-hd-png-download.png">
            </a>
        </div>
        <div class="col ">
            <a style="text-decoration: none"
               href="https://www.google.com/maps/place/Furama+Resort+Danang/@16.0399456,108.2488741,17z/data=!3m1!4b1!4m8!3m7!1s0x31420fdbc8cc38ef:0x9a6a3e31121225d2!5m2!4m1!1i2!8m2!3d16.0399456!4d108.2510681?hl=vi-VN">
                <p style="width: 70%;"><img style="width: 30px;height: 30px;margin-top: 10px;"
                                            src="https://png.pngtree.com/png-clipart/20190924/original/pngtree-location-icon-for-your-project-png-image_4853602.jpg">
                    103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam
                </p>
            </a>
        </div>
        <div class="col">
            <p><img style="width: 30px;height: 30px;margin-top: 15px"
                    src="https://media.istockphoto.com/vectors/telephone-icon-logo-vector-id1279896450">
                84-236-3847 333/888</p>
            <p><img style="width: 30px;height: 30px"
                    src="https://image.shutterstock.com/image-vector/mail-logo-260nw-468389300.jpg">
                reservation@furamavietnam.com</p>
        </div>
    </div>
</div>

<div class="row">
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="padding: 0;line-height: 50px">
            <div class="container-fluid" style="background-color:#218c74">
                <a class="navbar-brand a" href="" style="margin-left: 100px;color: white">Home</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active a" aria-current="page" href="/furama_web?action=showCutomer"
                               style="margin-left: 60px;color: white">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link a" href="/furama_web?action=showCutomer" style="color: white;margin-left: 60px">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link a" href="http://localhost:63342/furama_resort/src/furama_html/furama_home/facility_list.html?_ijt=jl53r35ma5a793m1gvnkevj7rh&_ij_reload=RELOAD_ON_SAVE#" style="color: white;margin-left: 60px">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled a" style="color: white;margin-left: 60px">Contract</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid">
    <div class="row" style="justify-content: center;background-color:white">
        <div class="col-md-12" style="padding: 0;">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img  style="width: 100%;height: 730px" src="https://cdn.homedy.com/store/images/2019/11/21/furama-resort-danang-637099424690383278.jpg" class="d-block w-100" alt="ảnh 1">
                    </div>
                    <div class="carousel-item">
                        <img  style="width: 100%;height: 730px" src="https://fantasea.vn/wp-content/uploads/2017/10/Furama-%C4%90%C3%A0-N%E1%BA%B5ng-Resort.jpg" class="d-block w-100" alt="ảnh 2">
                    </div>
                    <div class="carousel-item">
                        <img  style="width: 100%;height: 730px" src="http://data.batdongsan.com.vn//Projects/110114/CKE/images/Phoi%20canh%20Ho%20Coc%20(FILEminimizer).jpg" class="d-block w-100" alt="ảnh 3">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
</div>
<div class="footer">2022 Design By QuocTrung.Net</div>
<script src="../../bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</body>
</html>