$(document).ready(function() {

	// 전체금액 계산
	setTotalPrice();

	// 제목줄의 체크박스가 클릭되면...
	$(document).on('click', '#allCheck', function() {
		// 체크박스의 체크유무 확인
		let isChecked = $('#allCheck').is(':checked');

		if (isChecked) {// 체크가 되었을 때
			$('.chk').prop('checked', true);
		} else {
			$('.chk').prop('checked', false);
		}

		setTotalPrice();
	});

	// 하위 체크박스 변경 시 제목줄의 체크박스 변경
	$(document).on('click', '.chk', function() {
		// .chk의 개수
		let chkCnt = $('.chk').length;
		// .chk 중에서 체크가 된 노드의 개수
		let checkedCnt = $('.chk:checked').length;

		if (chkCnt == checkedCnt) {
			$('#allCheck').prop('checked', true);
		} else {
			$('#allCheck').prop('checked', false);
		}

		setTotalPrice();
	});

	// 수량 변경 시
	$(document).on('click change keyup', '.cntQty', function() {
		
		let selectedNode = $(this);
		
		qtyAjax(selectedNode);
		
	});
	
	
	// 장바구니 비우기 버튼 클릭 시
	$(document).on('click', '#deleteCartBtn', function() {
		let checkedCnt = $('.chk:checked').length;
		let cartIdArr = [];

		if (checkedCnt == 0) {
			alert('장바구니에서 비울 상품을 선택하세요.');
			return;
		}

		$('.chk:checked').each(function(index, element) {
			cartIdArr[index] = $(element).val();
		});
		
		location.href = `deleteCart.sh?cartIdArr=${cartIdArr}`;
	});

	//구매하기 버튼 클릭 시
	$(document).on('click', '#cartBuyBtn', function(){
		let checkedCnt = $('.chk:checked').length;
		let cartIdArr = [];

		if (checkedCnt == 0) {
			alert('장바구니에서 구매할 상품 선택하세요.');
			return;
		}

		$('.chk:checked').each(function(index, element) {
			cartIdArr[index] = $(element).val();
		});
		
		location.href = `cartBuyPage.sh?cartIdArr=${cartIdArr}`;
	});
	
});

(function($) {

	// 총 금액 fun
	setTotalPrice = function() {

		let totalPrice = 0;

		$('.chk:checked').each(
				function(index, element) {
					totalPrice += +$(element).parent().parent().children()
							.last().text();
				});

		$('#totalPrice').text(totalPrice);
	};

	// 수량변경 fun
	qtyAjax = function(selectedNode) {
		
		let goodsCnt = $(selectedNode).val();
		let cartId = $(selectedNode).attr('data-cartId');
		let eachPrice = $(selectedNode).parent().prev().text();
		let eachTotalPrice = goodsCnt * eachPrice;
		let eachTotalTd = $(selectedNode).parent().next();
	
		$.ajax({
			url : 'updateCartQty.sh', // 요청경로
			type : 'post',
			data : {
				'goodsCnt' : goodsCnt,
				'cartId' : cartId
			}, // 요청경로로 던질 파라메터. '파라메터명':파라메터
			success : function(result) { // ajax 통신 성공 시 실행부분. result가 결과
				// 데이터를 가진다.

				if (result == 1) {
					$(eachTotalTd).text(eachTotalPrice);
					setTotalPrice();
				} else {
					alert('업데이트 실패')
				}

			},
			error : function() { // ajax통신 실패 시 실행부분
				alert('ajax실패');
			}
		});

	}

})(jQuery);