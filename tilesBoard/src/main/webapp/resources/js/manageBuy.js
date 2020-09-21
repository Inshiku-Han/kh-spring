/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//주문확인버튼
	$(document).on('click', '.confirmOrderBtn', function() {
		
		let orderNum = $(this).attr('data-orderNum');
		let isConfirmTd = $(this).parent();
		updateIsConfirm(orderNum, isConfirmTd);
	});
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
	
	//주문확인을 N에서 Y값으로 업데이트
	updateIsConfirm = function(orderNum, isConfirmTd){
		$.ajax({
			url: 'updateIsConfirm.ad', //요청경로
			type: 'post',
			data: {"orderNum" : orderNum
			}, //요청경로로 던질 파라메터. '파라메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				var spanText = '<span style="color: red;">확인완료</span>';
				
				if(result != 1){
					alert('업데이트 실패')
				}else{
					isConfirmTd.empty();
					isConfirmTd.append(spanText);
					
				}
				
				
				
			},
			error: function(){ //ajax통신 실패 시 실행부분
				alert('ajax실패');
			}
		});
	}
	
})(jQuery);


