<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zxx">

<head>

<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	var id = '${sessionId}';
	$my = $('[data-my]');
	
	$my.on('click', function() {
		if(id == "") {
			alert("로그인이 필요합니다.");
		}else{
			location.replace("/Project_2nd/mypage.ns");
		}
	});
	
});

</script>

    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nutrient Sunday</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    
	<style type="text/css">
    	a { color: #212529; }
    	a:hover { color: #212529; }
   	</style>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="/Project_2nd/main.ns"><img src="img/logo.png" alt=""></a>
        </div>
        <!-- <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div> -->
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <!-- <img src="img/language.png" alt=""> -->
                <div><a data-my="" style="color:#1C1C1C; cursor:pointer;">마이페이지</a></div>
                <span class="arrow_carrot-down"></span>
                <!-- <ul>
                    <li><a href="mypage.ns">내 관심상품</a></li>
                    <li><a href="#">내 문의내역</a></li>
                </ul> -->
            </div>
            <div class="header__top__right__auth">
				<c:choose>
					<c:when test="${sessionId == null}">
						<a href="/Project_2nd/login.ns"><i class="fa fa-user"></i> 로그인</a>
					</c:when>
					<c:otherwise>
						<a href="/Project_2nd/logout.ns"><i class="fa fa-user"></i> 로그아웃</a>
					</c:otherwise>
				</c:choose>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li><a href="/Project_2nd/main.ns">홈</a></li>
                <li class="active"><a href="/Project_2nd/notice.ns">공지사항</a></li>
                <li><a href="/Project_2nd/productlist.ns">영양제</a></li>
                <li><a href="/Project_2nd/healthy/getBoardList.ns">건강뉴스</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <!-- <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a> -->
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> help@nutrientsunday.co.kr</li>
                <li>매일매일 일요일처럼 활기차게! Nutrient Sunday</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> help@nutrientsunday.co.kr</li>
                                <li>매일매일 일요일처럼 활기차게! Nutrient Sunday</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <!-- <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div> -->
                            <div class="header__top__right__language">
                                <!-- <img src="img/language.png" alt=""> -->
                                <div><a data-my="" style="color:#1C1C1C; cursor:pointer;">마이페이지</a></div>
                                <!-- <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="mypage.ns">내 관심상품</a></li>
                                    <li><a href="#">내 문의내역</a></li>
                                </ul> -->
                            </div>
                            <div class="header__top__right__auth">
								<c:choose>
									<c:when test="${sessionId == null}">
										<a href="/Project_2nd/login.ns"><i class="fa fa-user"></i> 로그인</a>
									</c:when>
									<c:otherwise>
										<a href="/Project_2nd/logout.ns"><i class="fa fa-user"></i> 로그아웃</a>
									</c:otherwise>
								</c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="/Project_2nd/main.ns"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="/Project_2nd/main.ns">홈</a></li>
			                <li class="active"><a href="/Project_2nd/notice.ns">공지사항</a></li>
			                <li><a href="/Project_2nd/productlist.ns">영양제</a></li>
			                <li><a href="/Project_2nd/healthy/getBoardList.ns">건강뉴스</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <!-- <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span></span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span></span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span>$150.00</span></div> -->
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>전체 카테고리</span>
                        </div>
                        <ul>
	                        <li><a href="/Project_2nd/productlist.ns?category=멀티비타민">멀티비타민</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=비타민A">비타민A</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=비타민B">비타민B</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=비타민C">비타민C</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=비타민D">비타민D</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=비타민E">비타민E</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=비오틴">비오틴</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=기타비타민">기타비타민</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=엽산">엽산</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=아연">아연</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=철분">철분</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=칼슘">칼슘</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=마그네슘">마그네슘</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=프로폴리스">프로폴리스</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=글루코사민">글루코사민</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=오메가3">오메가3</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=감마리놀렌산">감마리놀렌산</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=루테인">루테인</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=스쿠알렌">스쿠알렌</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=쏘팔메토">쏘팔메토</a></li>
	                        <li><a href="/Project_2nd/productlist.ns?category=키토산">키토산</a></li>
                            <%-- <c:forEach var="category" items="${categoryList}">
                            	<li><a href="/Project_2nd/productlist.ns?${category}">${category}</a></li>
                            </c:forEach> --%>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="/Project_2nd/search.ns">
                                <!-- <div class="hero__search__categories">
                                    전체 카테고리
                                    <span class="arrow_carrot-down"></span>
                                </div> -->
                                <input type="text" name="keyword" placeholder="피로 개선에 효과 좋은 간 영양제, '밀크씨슬' 찾으세요?">
                                <button type="submit" class="site-btn">검색</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>0507-1404-0050</h5>
                                <span>365일 24시 고객센터</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->
    
    <!-- Blog Section Begin -->
    <section class="from-blog spad" style="padding-top:20px;">
        <div class="container">
        <div style="text-align:center;">
        	<div class="section-title">
            	<h2>공지사항</h2>
            </div>
            
            <table class="table">
			<theader>
				<tr>
					<td>No.</td>
					<td>제목</td>
					<td>최종 수정일</td>
				</tr>
			</theader>
			<tbody>
				<c:if test="${count == 0}">
					<tr>
					<td colspan="4">게시글이 현재 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${count >= 1}">
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.num}</td>
						<td align="left"><a href="/Project_2nd/form.ns?num=${list.num}">${list.title}</a></td>
						<td>${list.updatedate}</td>
					</tr>
				</c:forEach>
				</c:if>
			</tbody>
			</table>
        </div>
        </div>
    </section>
    <!-- Blog Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="/Project_2nd/main.ns"><img src="img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: hello@colorlib.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Useful Links</h6>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">About Our Shop</a></li>
                            <li><a href="#">Secure Shopping</a></li>
                            <li><a href="#">Delivery infomation</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Our Sitemap</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Who We Are</a></li>
                            <li><a href="#">Our Services</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Innovation</a></li>
                            <li><a href="#">Testimonials</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>



</body>

</html>