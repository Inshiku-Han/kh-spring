/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	
	//클릭 이벤트
	//$(document).on('click', '선택자', function() {

	//});
	
	$(document).on('change', '.selectBox', function() {
		sel = $(this).val();
		location.href='studentList.do?classCode=' + sel;
	});
	
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
})(jQuery);