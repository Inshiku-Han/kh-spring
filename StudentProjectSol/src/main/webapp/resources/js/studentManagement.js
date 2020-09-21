/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	
	
	//셀렉트 박스
	$(document).on('change','#classSelector',function(){
		
		$('#gradeClick').hide(); // 점수 등록 버튼 숨기기
		
		$('#insertBtn').attr("type","button"); //학생추가버튼 활성화
		
		$('#gradeTable').empty(); //학생점수 비우기
		
		selectStudentList(); //학생을 조회하는 ajax가 있는 함수
		
		var value = $(this).val(); //셀렉트 value값
		
		value != 0 ? $('#insertBtn').show() : $('#insertBtn').hide(); //value가 전체(0)이면 추가 버튼 숨기기, 아니면 보이기
			
	});
	
	//학생 이름 클릭 시
	$(document).on('click','.stuName',function(){
		
		$('#gradeTable').show(); //숨긴 학생 점수 보이게 하기
		
		$('#gradeClick').show(); //숨긴 점수등록 버튼 보이게 하기
		
		var stuNum = $(this).attr('data-stuNum'); //선택자의 속성(data-stuNum)의 값
		
		selectScore(stuNum); //점수를 조회하는 ajax가 있는 함수
	});
	
	//학생 추가
	$(document).on('click','#insertBtn',function(){
		
		if($(this).val() == '학생추가'){ //선택자의 value가 '학생추가'면 내용 실행
			var str = '';
			str += '<tr>';
			str += '<td><input type="text" id="stuName"></td>';
			str += '<td><input type="number" id="stuAge"></td>';
			str += '<td><input type="text" id="stuAddr"></td>';
			str += '</tr>';
			
			$('#listTable').append(str); //html로 구성된 str문을 선택자의 제일 마지막 부분에 추가
			
			$('#insertBtn').val('등록'); //선택자의 value를 '등록'으로 변경
			
			$('.deleteBtn').hide(); //학생추가를 하는 동안에는 삭제버튼을 숨긴다
		
		}else{
			insertStudent(); //선택자의value가 '학생추가'가 아니면(이 경우에는 '등록) ajax를 이용하여 학생을 추가하는 함수 실행
		}
	});
	
	//학생 삭제 버튼
	$(document).on('click','.deleteBtn',function(){
		
		var act = confirm('정말 삭제하시겠습니까?'); //yes or no 알림창
		if(act){
			stuNum = $(this).attr('data-stuNum'); //선택자의 속성(data-stuNum)의 값
			deleteStudent(stuNum); //ajax를 이용하여 학생을 삭제하는 함수 실행
		}else{
			alert('다음부턴 신중하게 누르세요');
		}
	});
	
	//점수 등록 버튼
	$(document).on('click','#gradeClick',function(){
		
		var stuNum = $(this).attr('data-stuNum'); //속성값 가져오기
		
		//버튼의 value가 점수등록이면 value를 등록으로 바꾸고 input버튼 만드는 함수 호출
		if($(this).val() == '점수등록'){
			//버튼 value 변경
			$('#gradeClick').attr("value","등록");
			
			//인풋태그생성
			insertGradeButton();
		
		//버튼의 value가 등록이면 점수를 등록하는 함수 실행
		}else{
			insertGrade(stuNum);
			
		}
		
		
	});
	
});

/* 함수선언 영역*/
(function($){
	
	//ajax로 학생목록 함수
	selectStudentList = function(){
		var classCode = $('#classSelector').val(); //select박스의 value값
		
		$.ajax({
		      url: 'ajaxStudentList.st', //요청경로
		      type: 'post',
		      data: {'classCode' : classCode}, //요청경로로 던질 파라메터. '파라메터명':파라메터
		      
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  //테이블의 내용을 지운다.
		    	  $('#listTable').empty();
		    	  
		    	  //html코드 작성
		    	  var str = '';
		    	  str += '<tr>';
		    	  str += '<td>이름</td>';
		    	  str += '<td>나이</td>';
		    	  str += '<td>주소</td>';
		    	  str += '</tr>';
		    	  
		    	  //리스트 반복
		    	  $.each(result, function(index, element){
		    		  str += '<tr>';
		    		  str += `<td><div class="stuName" data-stuNum="${element.stuNum}">${element.stuName}</div></td>`;
		    		  str += `<td>${element.stuAge}</td>`;
		    		  str += `<td>${element.stuAddr}</td>`;
		    		  str += `<td><input type="button" value="삭제" class="deleteBtn" data-stuNum="${element.stuNum}"></td>`;
		    		  str += '</tr>';  
		    		  
	               });
		    	  
		    	  //노드 추가
		    	  $('#listTable').append(str);
		    	  
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('학생 목록 ajax 실패')
		      }
		      
		});
	};
	
	//ajax로 학생 점수 조회
	selectScore = function(stuNum){
		
		
		$.ajax({
		      url: 'ajaxSelectScore.st', //요청경로
		      type: 'post',
		      data: {'stuNum' : stuNum }, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#gradeTable').empty();
		    	  $('#gradeDiv').empty();
		    	  
		    	  var str = '';
		    	  str += '<tr>';
		    	  str += '<td>국어</td>';
		    	  str += '<td>영어</td>';
		    	  str += '<td>수학</td>';
		    	  str += '</tr>';
		    	  str += '<tr>';
		    	  
		    	  if(result.korScore == undefined){
		    		  str += '<td id="inputKor"></td>';
		    		  str += '<td id="inputEng"></td>';
		    		  str += '<td id="inputMath"></td>';
		    		  
		    		  //점수등록버튼 생성
		    		  var str2 = `<input type="button" value="점수등록" id="gradeClick" data-stuNum="${stuNum}">`;
			    	  $('#gradeDiv').append(str2);
			    	  
		    	  }
		    	  else{
		    		  str += `<td>${result.korScore}</td>`;
		    		  str += `<td>${result.engScore}</td>`;
		    		  str += `<td>${result.mathScore}</td>`;
		    	  }
		    	  
		    	  str += '</tr>';
		    	  
		    	  $('#gradeTable').append(str);
		    	  
		    	  
		    	  
		      },
		      
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('학생 점수 조회 ajax 실패')
		      }
		});

		
		//테두리
		const color = document.querySelector('#gradeTable');
		color.classList.add('tabColor');
		
	};
	
	
	//학생 등록
	insertStudent = function(){
		var stuName = $('#stuName').val(),
			stuAge = $('#stuAge').val(),
			stuAddr = $('#stuAddr').val(),
			classCode = $('#classSelector').val();
		
		$.ajax({
		      url: 'insertStudent.st', //요청경로
		      type: 'post',
		      data: {'stuName':stuName, 'stuAge':stuAge, 'stuAddr':stuAddr, 'classCode':classCode
		    	  
		      }, //요청경로로 던질 파라메터. '파라메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  if(result == 1){
		    		  alert('학생 등록 성공');
		    		  $('#insertBtn').val('학생추가'); //'등록' 버튼을 '학생추가'로 복구
		    		  $('.deleteBtn').show(); //학생등록할때 숨겼던 삭제버튼 활성화
		    		  selectStudentList(); //등록 후 학생 조회
    			  }else{
    				  alert('학생 등록 실패')
    					} 
		    			  
		    			  
		    			   
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('학생 등록 ajax 실패');
		      }
		});
	};
	
	//학생 삭제
	deleteStudent = function(stuNum){
		
		$.ajax({
		      url: 'deleteStudent.st', //요청경로
		      type: 'post',
		      data: {'stuNum' : stuNum
		                                           }, //요청경로로 던질 파라메터. '파라메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  if(result >= 1){
		    		  alert('학생 제거 성공');
		    		  selectStudentList(); //삭제 후 학생 조회
		    		  
    			  }else{
    				  alert('학생 제거 실패')
    					} 
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('학생 제거 ajax 실패');
		      }
		});

	};
	
	//점수 등록 버튼 생성 함수
	insertGradeButton = function(){
		
		var inputKor = '<input type="number" id="korScore">';
		$('#inputKor').append(inputKor);
		var inputEng = '<input type="number" id="engScore">';
		$('#inputEng').append(inputEng);
		var inputMath = '<input type="number" id="mathScore">';
		$('#inputMath').append(inputMath);
		
	};
	
	//점수 등록 함수
	insertGrade = function(stuNum){
		var korScore = $('#korScore').val(),
			engScore = $('#engScore').val(),
			mathScore = $('#mathScore').val();
		$.ajax({
		      url: 'insertGrade.st', //요청경로
		      type: 'post',
		      data: {'korScore':korScore,
		    	  	'engScore':engScore,
		    	  	'mathScore':mathScore,
		    	  	'stuNum':stuNum
		            }, //요청경로로 던질 파라메터. '파라메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  if(result == 1){
		    		  alert('점수 등록 성공');
		    		  
		    		  selectStudentList(); //점수 등록 후 전체 조회
		    		  
		    		  $('#gradeDiv').empty(); // 전체 조회 시 점수 숨기기
		    		  
		    		  $('#gradeTable').hide(); // 전체 조회 후 테이블 숨기기
		    		  
		    	  }else{
		    		  alert('점수는 들어가지 못했습니다')
		    	  }
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		           alert('점수 등록 ajax 실패');
		      }
		});

		
	};
	
	
	
})(jQuery);