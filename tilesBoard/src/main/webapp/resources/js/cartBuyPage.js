/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	
	initTotalPrice();
		
});

/* 함수선언 영역*/
(function($){
	
	initTotalPrice = function(){
		let finalPrice = 0;
		
		$('.totalPrice').each(function(index, element){
			finalPrice += +$(element).text();
		});

		$('#finalPrice').text(finalPrice);
	}
	
})(jQuery);
