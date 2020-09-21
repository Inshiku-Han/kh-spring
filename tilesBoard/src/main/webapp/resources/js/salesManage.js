/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$(document).on('change', 'select', function(){
		$.ajax({
		      url: 'salesJax.ad', //요청경로
		      type: 'post',
		      data: {'salesDate':$(this).val() },
			 //요청경로로 던질 파라메터. '파라메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  
		    
		    	  $('tbody').empty();
		    	  
		    	  let a = [];
		    	  let b = [];
		    	  let str = '';
		    	  
//		    	  $(result).each(function(index, element){
//		    		  a[index] = element.buyMonth;
//		    		  b[index] = element.salesPerMonth;
//		    		  str += `<tr><td>${a[index]}</td><td>${b[index]}</td></tr>`;
//		    	  })
		    	  
		    	  for(let i = 0; i < result.length; i++){
		    		  a[i] = result[i].buyMonth;
		    		  b[i] = result[i].salesPerMonth;
		    		  
		    		  str += `<tr><td>${a[i]}</td><td>${b[i]}</td></tr>`;
		    	  }
		    	  
		    	  $('table').append(str);
		    	  
		    	  console.log(result);
		    	  
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		           alert('실패');
		      }
		});

	});
});

/* 함수선언 영역*/
(function($){
	
	
})(jQuery);