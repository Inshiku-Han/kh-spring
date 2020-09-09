/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//구매상품 수량 변경 시.
	$(document).on('change keyup click', '.buyCnt', function() {
		//총가격 계산 : 단가 * 수량 + 배송비
		var goodsPrice = $(this).parent().prev().prev().text();
		var cnt = $(this).val();
		var goodsDeliveryPrice = $(this).parent().next().text();
		var price = goodsPrice * cnt + parseInt(goodsDeliveryPrice);
		$(this).parent().next().next().text(price);
		$('#totalPrice').text(price);
		$('.hiddenPrice').val(price);
	});
	
	//구매버튼 클릭 시
	$(document).on('click', '#buyBtn', function() {
		$('#buyForm').submit();
	});

});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
})(jQuery);


