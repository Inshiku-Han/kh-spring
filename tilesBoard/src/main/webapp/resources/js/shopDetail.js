/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//구매하기 버튼 클릭 시
	$(document).on('click', '#buyBtn', function() {
		
		//모달창에 가격정보를 세팅
		var goodsPrice = $('#goodsPrice').text();//단가
		var goodsDeliveryPrice = $('#goodsDeliveryPrice').text();//택배비
		var price = goodsPrice * cntFun() + +goodsDeliveryPrice;
		$('#modalPrice').text(price);
		
		//로그인 안되있으면..
		if(loginId() == ''){
			//로그인 하라는 alert
			alert('구매를 하시려면 로그인을 하세요.');
		}
		else{
			//구매정보 모달창 띄움
			$('#buyModal').modal();
		}
	});
	
	//모달 구매하기 버튼 클릭 시
	$(document).on('click', '#modalBuyBtn', function() {
		location.href = 'buyPage.sh?goodsId=' + goodsIdFun() + '&cnt=' +  cntFun();
	});
	
	//모달 취소하기 버튼 클릭 시
	$(document).on('click', '#modalCancelBtn', function() {
		$('#buyModal').modal('hide');
	});
	
	//장바구니 확인창
	$(document).on('click', '#cartBtn', function(){
		
		//로그인 안되있으면..
		if(loginId() == ''){
			
			//로그인 하라는 alert
			alert('장바구니로 가시려면 로그인을 하세요.');
		}else{
			
			$.ajax({
			      url: 'insertCart.sh', //요청경로
			      type: 'post',
			      data: { 'goodsId' : goodsIdFun(), 'memberId' : loginId(), 'goodsCnt' : cntFun()
			                                           }, //요청경로로 던질 파라메터. '파라메터명':파라메터
			      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
			    	  
			    	if(+result != 1){
			    		alert('성공은 했으나 실패');
			    	}else{
			    		
			    		//confirm
			    		let goCartList = confirm('아이템을 담았습니다.\n장바구니로 가시겠습니까?');
			    		if(goCartList){
			    			location.href = 'cartList.sh';
			    		}
			    	}
			    	
			      },
			      error: function(){ //ajax통신 실패 시 실행부분
			           alert('ajax 실패');
			      }
			});
			
		}
		
	});
	
	
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
	
	
	//로그인 아이디
	loginId = function(){
		return $('#loginId').val()
	}
	
	//수량
	cntFun = function(){
		return $('input[type="number"]').val()
	}
	
	//상품 아이디
	goodsIdFun = function(){
		return $('#goodsId').val()
	}
	
})(jQuery);