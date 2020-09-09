/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//구매하기 버튼 클릭 시
	$(document).on('click', '#buyBtn', function() {
		var memberId = $('#loginId').val();
		
		//모달창에 가격정보를 세팅
		var cnt = $('input[type="number"]').val();//수량
		var goodsPrice = $('#goodsPrice').text();//단가
		var goodsDeliveryPrice = $('#goodsDeliveryPrice').text();//택배비
		var price = goodsPrice * cnt + parseInt(goodsDeliveryPrice);
		$('#modalPrice').text(price);
		
		//로그인 안되있으면..
		if(memberId == ''){
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
		var goodsId = $('#goodsId').val();
		var cnt = $('input[type="number"]').val();
		location.href = 'buyPage.sh?goodsId=' + goodsId + '&cnt=' + cnt;
	});
	
	//모달 취소하기 버튼 클릭 시
	$(document).on('click', '#modalCancelBtn', function() {
		$('#buyModal').modal('hide');
	});
	
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
})(jQuery);