$(document).ready(function(){
	
	//전체금액 계산
	setTotalPrice();
	
	//제목줄의 체크박스가 클릭되면...
	$(document).on('click', '#allCheck', function() {
		//체크박스의 체크유무 확인
		let isChecked = $('#allCheck').is(':checked');
		
		if(isChecked){//체크가 되었을 때
			$('.chk').prop('checked',true);
		}else{
			$('.chk').prop('checked',false);
		}
		
		setTotalPrice();
	});
	
	
	//하위 체크박스 변경 시 제목줄의 체크박스 변경
	$(document).on('click', '.chk', function() {
		//.chk의 개수
		let chkCnt = $('.chk').length;
		//.chk 중에서 체크가 된 노드의 개수
		let checkedCnt = $('.chk:checked').length;
		
		if(chkCnt == checkedCnt){
			$('#allCheck').prop('checked',true);
		}else{
			$('#allCheck').prop('checked',false);
		}
		
		setTotalPrice();
	});
	
	//장바구니 비우기 버튼 클릭 시
	$(document).on('click', '#deleteCartBtn', function(){
		let checkedCnt = $('.chk:checked').length;
		let cartIdArr = [];
		
		if(checkedCnt == 0){
			alert('장바구니에서 비울 상품을 선택하세요.');
			return;
		}
		
		$('.chk:checked').each(function(index, element){
			cartIdArr[index] = $(element).val();
		});
		console.log(cartIdArr);
		location.href = `deleteCart.sh?cartIdArr=${cartIdArr}`;
	});
	
});

(function($){
	
	setTotalPrice = function(){
		
		let totalPrice = 0;
		
		$('.chk:checked').each(function(index, element){
			totalPrice += +$(element).parent().parent().children().last().text();
			
		});
		
		$('#totalPrice').text(totalPrice);
	};
	
	
})(jQuery);