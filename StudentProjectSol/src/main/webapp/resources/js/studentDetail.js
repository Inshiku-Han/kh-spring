/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	
	//클릭 이벤트
	//$(document).on('click', '선택자', function() {

	//});
	
	$(document).on('click','#saveBtn',function(){
		$('#scoreForm').submit();
		
	});
});