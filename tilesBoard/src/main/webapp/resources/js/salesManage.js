/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$(document).on('change', 'select', function(){
		
		yearAjax($(this).val());
		
	});
	
	//매출 월 클릭 시
	$(document).on('click', '.salesMonth', function(){
		
		monthAjax($(this));
		
		
	})
	
});

/* 함수선언 영역*/
(function($){
	
	yearAjax = function(salesDate){
		
		$.ajax({
		      url: 'salesJax.ad', //요청경로
		      type: 'post',
		      data: {'salesDate': salesDate},
			 //요청경로로 던질 파라메터. '파라메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  
		    	  $('#salesPerDayDiv').empty();
		    	  $('#leftTbody').empty();
		    	  $('#scrollDiv').empty();
		    	  
		    	  let str = '';
		    	  
		    	  //객체로 이루어진 배열 result의 for문
		    	  for(let value of result){
		    		  str += `<tr><td class="salesMonth">${value.buyMonth}</td><td>${value.salesPerMonth}</td></tr>`;
		    	  }
		    	  
		    	  $('#leftTbody').append(str);
		    	  
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		           alert('실패');
		      }
		});
	}
	
	monthAjax = function(month){
		
		let yearMonth =  $('select').val() + month.text();
		
		$.ajax({
		      url: 'monthAjax.ad', //요청경로
		      type: 'post',
		      data: {"yearMonth" : yearMonth
		    	  
		      },
			 //요청경로로 던질 파라메터. '파라메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  
		    	  $('#salesPerDayDiv').empty();
		    	  $('#scrollDiv').empty();
		    	  
		  		let str1 = `<table class="table table-striped">
		  						<colgroup>
		  							<col width="50%" />
		  							<col width="50%" />
		  						</colgroup>
		  						<thead>
		  							<tr>
		  								<td>일</td>
		  								<td>매출액</td>
		  							</tr>
		  						</thead></table>`;
	  		
		  		let str2 = `<table class="table table-striped">
		  						<colgroup>
		  							<col width="50%" />
		  							<col width="50%" />
		  						</colgroup>
		  						</thead><tbody>`;
	  			for(let value of result){
	  				
  					str2 += `<tr><td>${value.buyDay}일</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${value.salesPerDay}원</td></tr>`;
  					
	  			}
	  				str2 += `</tbody></table>`;
		  		
		  		
		  		$('#salesPerDayDiv').append(str1);
		  		$('#scrollDiv').append(str2)
		    	  
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		           alert('실패');
		      }
		});
		
	}
	
	
	
})(jQuery);