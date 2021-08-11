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
	$all = $('[data-all]');
	$delete = $('[data-delete]');
	$select = $('[data-select]');
	$shop = $('[data-shop]');
	
	$all.on('click', function() {		
		if(confirm('관심상품을 전체삭제합니다.')) {
			$.ajax({
				url: "wishlistPro.ns",
				success: function(result){
					if(result == "10"){
						alert("관심상품 전체삭제 완료");
						location.reload();
					}
				}
			})
		}else{
			/* 취소 클릭 */
		}
	});
	
	$delete.on('click', function() {
		if(confirm('관심상품에서 삭제하시겠습니까?')) {
			
			$.ajax({
				url: "wishlistPro.ns",
				data: { num: $(this).data("delete") },
				success: function(result){
					if(result == "0"){
						alert("관심상품 삭제 완료");
						location.reload();
					}
				}
			})
		}else{
			/* 취소 클릭 */
		}
	});
	
	$select.on('click', function() {
		if(confirm('선택한 상품을 삭제하시겠습니까?')) {
			var length = $("input[name='num']").length;
			var count = 0;
			var str = '';
			for(var i = 0; i < length; i++){
				if(document.getElementsByName("num")[i].checked == true){
					count += 1;
					var num = document.getElementsByName("num")[i].value;
					if(i == length-1){
						str += num;
					}else{
						str += num+"&";
					}
				}
			}
			if(count == 0){
				alert("선택된 상품이 없습니다.");
				return false;
			}else{
				$.ajax({
					url: "wishlistPro.ns",
					data: { str: str },
					success: function(result){
						if(result == "100"){
							alert("관심상품 선택삭제 완료");
							location.reload();
						}
					}
				})
			}
		}
			
	});
	
	$shop.on('click', function() {
		var num = $(this).data("shop");
		window.open("loading.ns?num="+num);
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
                <div><a href="/Project_2nd/mypage.ns"style="color:#1C1C1C; cursor:pointer;">마이페이지</a></div>
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
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
				<li class="active"><a href="/Project_2nd/main.ns">홈</a></li>
			    <li><a href="/Project_2nd/notice.ns">공지사항</a></li>
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
                                <div><a href="/Project_2nd/mypage.ns"style="color:#1C1C1C; cursor:pointer;">마이페이지</a></div>
                                <!-- <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a data->내 관심상품</a></li>
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
                            <li class="active"><a href="/Project_2nd/main.ns">홈</a></li>
						    <li><a href="/Project_2nd/notice.ns">공지사항</a></li>
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
                            <c:forEach var="category" items="${categoryList}">
                            	<li><a href="/Project_2nd/productlist.ns?${category}">${category}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="/Project_2nd/search.ns">
                                <!-- <div class="hero__search__categories">
                                    All Categories
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
    
    <!-- Featured Section Begin -->
    <section class="feature spad">
        <div class="container">
       		<div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <a href="/Project_2nd/mypage.ns"><h2>내 관심상품</h2></a>
                    </div>
                    <div class="featured__controls">
                    	<div class="blog__sidebar__item">
                            <h4>Search By</h4>
                            <div class="blog__sidebar__item__tags">
								<c:forEach var="category" items="${categoryList}">
	                            	<a href="/Project_2nd/mypage.ns?category=${category}">${category}</a>
	                            </c:forEach>
                            </div>
                        </div>
                        <%-- <ul>
                            <li class="active" data-filter="*">All</li>
                            <c:forEach var="">
                            	<li data-filter=".oranges">Oranges</li>
                            </c:forEach>
                            
                            <li data-filter=".fresh-meat">Fresh Meat</li>
                            <li data-filter=".vegetables">Vegetables</li>
                            <li data-filter=".fastfood">Fastfood</li>
                        </ul> --%>
                    </div>
                </div>
            </div>
            <div class="row featured__filter">
            <c:if test="${mypageList == null}">
	            <div style="text-align:center; width:100%;">
	            	<p>관심상품이 없습니다.</p>
	            </div>
            </c:if>
            <c:forEach var="dto" items="${mypageList}" varStatus="status">
            	<div class="col-lg-3 col-md-4 col-sm-6 mix vegetables fastfood">
                    <div class="featured__item">
                    	<input type="checkbox" name="num" value="${dto.num}" />
                        <div class="featured__item__pic set-bg" data-setbg="${dto.imgurl}">
                        	<ul class="featured__item__pic__hover">
                                <!-- <li><a data-wish="${dto.num}"><i class="fa fa-heart"></i></a></li> -->
                                <!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
                                <li><a data-shop="${dto.num}" style="cursor:pointer;"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6>${dto.subtag}</h6>
                            <h5>${dto.name}</h5>
                            <div class="blog__item__text">
                            	<a data-delete="${dto.num}" class="blog__btn">삭제</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </div>
            
            <div class="col-lg-12">                                                                                       
			    <div class="product__pagination" style="text-align:center;">                                                                         
			                                                                                                              
			    <c:if test="${mypagePdCount > 0}">                                                                        
			    	<c:set var="pageCount" value="${mypagePdCount / pageSize + (mypagePdCount%pageSize == 0 ? 0:1)}" />   
			    	<c:set var="pageBlock" value="${10}" />                                                               
			    	<fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />                       
			    	<c:set var="startPage" value="${result * 10 + 1}" />                                                  
			    	<c:set var="endPage" value="${startPage + pageBlock -1}" />                                           
			    	<c:if test="${endPage > pageCount}">                                                                  
			    		<c:set var="endPage" value="${pageCount}" />                                                      
			    	</c:if>                                                                                               
			    	<c:if test="${startPage > 10}">                                                                       
			    		<a href="/Project_2nd/mypage.ns?pageNum=${startPage-10}"><i class="fa fa-long-arrow-left"></i></a>             
			    	</c:if>                                                                                               
			    	                                                                                                      
			    	<c:forEach var="i" begin="${startPage}" end="${endPage}">                                             
			    		<a href="/Project_2nd/mypage.ns?pageNum=${i}">${i}</a>                                                         
			    	</c:forEach>                                                                                          
			    	                                                                                                      
			    	<c:if test="${endPage < pageCount}">                                                                  
			    		<a href="/Project_2nd/mypage.ns?pageNum=${startPage+10}"><i class="fa fa-long-arrow-right"></i></a>            
			    	</c:if>                                                                                               
			                                                                                                              
			    </c:if>                                                                                                   
			                                                                                                              
			    </div> <!-- product__pagination End -->                                                                                            
			</div>                                                                                                        
            
            <div class="blog__item__text">
            	<a data-all="" class="blog__btn">전체삭제<!-- <span class="arrow_right"></span> --></a>
				<a data-select="" class="blog__btn">선택삭제<!-- <span class="arrow_right"></span> --></a>
            	<div class="blog__sidebar__search" style="display:inline-block; float:right;">
	                <form action="/Project_2nd/mypage.ns">
		                <input type="text" name="mykeyword" placeholder="내 관심상품 검색">
		                <button type="submit"><span class="icon_search"></span></button>
	                </form>
                </div>
            </div>
			
        </div>
        
    </section>
    <!-- Featured Section End -->
	
    <!-- Blog Section Begin -->
    <%-- <section class="blog spad">
        <div class="container">
            
        <table border="1" width="1150">
        <c:if test="">
        </c:if>
        	<tr>
        	<c:forEach var="dto" items="${mypageList}" varStatus="i">
           	
           	<c:if test="${i.count%col==0}"> 
           		<tr align='center'>
           	</c:if>
           		<td>
           			<table width="230" height="360" align='center'>
           				<tr align='left'> <!-- checkbox -->
           				<td>
           					<input type="checkbox" name="num" value="${dto.num}" checked />
           				</td>
           				</tr>
           				
           				<tr align='center'> <!-- imgurl -->
           				<td>
           					<img src="${dto.imgurl}"/>
           				</td>
           				</tr>
           				
           				<tr align='center'> <!-- subtag -->
           				<td>
           					<h6>${dto.subtag}</h6>
           				</td>
           				</tr>
           				
           				<tr align='center'> <!-- name -->
           				<td>
           					<h5><strong>${dto.name}</strong></h5>
           				</td>
           				</tr>
           			</table>
           		
           		
           	</c:forEach>
           	</tr>	
        </table>
           	
        </div>
    </section> --%>

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