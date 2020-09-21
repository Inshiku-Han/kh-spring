/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	
	//클릭 이벤트
	//$(document).on('click', '선택자', function() {

	//});
	
	
	$(document).on('change','.selectDiv > select',function(){
		
		location.href = 'studentList.do?classCode=' + $(this).val();
		
	});
	
	$(document).on('click','.searchDiv > input[type="button"]',function(){
		var classCode = $('.selectDiv > select').val();
		var stuName = $('.searchDiv > input[type="text"]').val();
		location.href= 'studentList.do?classCode=' + classCode + '&stuName=' + stuName;
	});
	
	
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
})(jQuery);