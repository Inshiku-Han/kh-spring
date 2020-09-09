/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//클릭 이벤트
	//$(document).on('click', '.imgDiv', function() {
		//goDetailPage();
		//$('#bodyDiv').empty();
		//$('#bodyDiv').load('shopList.sh');
	//});
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	goDetailPage = function(){
		$.ajax({
		      url: 'ajaxStudentList.st', //요청경로
		      type: 'post',
		      data: {}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#bodyDiv').empty().load('shop/shopDetail.jsp');
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('실패');
		      }
		});
	};
	
})(jQuery);