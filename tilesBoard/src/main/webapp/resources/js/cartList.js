$(document).ready(function(){
	
	
	//제목줄의 체크박스가 클릭되면...
	$(document).on('click', '#allCheck', function() {
		//체크박스의 체크유무 확인
		var isChecked = $('#allCheck').is(':checked');
		
		if(isChecked){//체크가 되었을 때
			$('.severalCheck').prop('checked',true);
			
		}else{
			$('.severalCheck').prop('checked',false);
		}
		
	});
	
	
	//하위 체크박스 변경 시 제목줄의 체크박스 변경
	$(document).on('click', '.severalCheck', function() {
		//.chk의 개수
		var chkCnt = $('.severalCheck').length;
		//.chk 중에서 체크가 된 노드의 개수
		var checkedCnt = $('.severalCheck:checked').length;
		
		if(chkCnt == checkedCnt){
			$('#allCheck').prop('checked',true);
		}else{
			$('#allCheck').prop('checked',false);
		}
		
	});
	
	//총 금액
	initTotalPrice();
	
});

(function($){
	
	initTotalPrice = function(){
		
		var totalPrice = 0;
		
		$('.someTotal').each(function(index, element){
			totalPrice += +$(element).text();
		});
		
		$('#totalPrice').text(`${totalPrice} 원`);
	};
	
	
})(jQuery);