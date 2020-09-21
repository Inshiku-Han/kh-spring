/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//Join Modal 열릴 때 실행,.. (모달이 닫힐 때 : hidden.bs.modal)
	$(document).on('show.bs.modal', '#joinModal', function() {
		initJoinModal();
	});
	
	//Join Modal 닫힐 때 실행...
	$(document).on('hidden.bs.modal', '#joinModal', function() {
		//input 태그의 내용을 초기화
		$('#joinModal').find('form')[0].reset();
		
		//validate된 label내용 삭제
		$('#joinForm label.error').remove();
		
		//v, x 아이콘 및 input태그 테두리 색 제거(bootstrap validate css)
		$('#joinForm div.has-feedback').removeClass('has-success has-error has-feedback');
		$('#joinForm span.glyphicon').remove();
	});
});

/* 함수선언 영역*/
(function($){
	//회원가입 모달 팝업 시 validate 연결
	initJoinModal = function(){
		$("#joinForm").validate({
		     //테스트를 위하여 유효성 검사가 완료되어도 submit을 처리하지 않음.
		     debug : false,
		     //유효성체크없이 무조건 submit. false일 경우 안함
		     //onsubmit:false,
		     //입력태그에 focus가 들어왔을때 유효성을 검사한다.
		     onfocusin: false,
		     onkeyup: false,
		     onfocusout: function(element) { 
		    	 $(element).valid(); 
		    	 
		     },
		    // success:'success',
//		     success:function(element){
//		    	 alert(element.attr('id'));
//		     },
		     //검사할 필드와 검사 항목의 나열
//		     groups:{
//		    	 socialNum : 'socialNum1 socialNum2',
//		    	 emergencyPhoneNum : 'emergencyPhoneNum2 emergencyPhoneNum3',
//		    	 phoneNum : 'phoneNum2 phoneNum3'
//		     },
		     
		     rules : {
		    	// className:{
		    	//	 required : true             //필수여부 지정
		             //digits : true,               //숫자만 입력 지정
		            // email : true,                //이메일만 입력 지정
		            // url : true,                  //url만 입력 지정
		            // minlength : 4,               //최소길이 지정
		            // maxlength : 8,               //최대길이 지정
		            // equalTo : "대상요소의 id 값" //특정 요소와 입력값이 같은지 여부 검사
		    	// },
		    	 memberId:{
		    		 required : true,
		    		 minlength : 2,
					 maxlength : 10,
					 regx:/^[a-zA-Z0-9]*$/i //영어&숫자만
		    	 },
		    	 memberPassword:{
		    		 required : true,
		    		 minlength : 4,
		    		 maxlength : 20
		    	 },
		    	 memberPassword1:{
		    		 required : true,
		    		 minlength : 4,
		    		 maxlength : 20,
		    		 equalTo : memberPassword
		    	 },
		    	 memberName:{
		    		 required : true,
		    		 minlength : 2,
		    		 maxlength : 15
		    	 },
		    	 tel1:{
		    		 required : true
		    	 },
		    	 tel2:{
		    		 required : true
		    	 },
		    	 email:{
		    		 required : true,
		    		 email : true
		    	 },
		    	 birthdayYear:{
		    		 required : true,
		    		 digits : true
		    	 },
		    	 birthdayMonth:{
		    		 required : true,
		    		 digits : true
		    	 },
		    	 birthdayDay:{
		    		 required : true,
		    		 digits : true
		    	 }
		     },
		     //검사를 충족하지 못할 경우 표시될 메시지의 나열                                                         
		     messages : {
		    	 memberId:{
		    		 required: 'ID는 필수항목입니다.',
		        	 minlength:'ID는 2자 이상 입력하세요.',
		        	 maxlength:'ID는 10자를 초과할 수 없습니다.',
		        	 regx:'영어와 숫자만 사용가능합니다.'
		    	 },
		    	 memberPassword:{
		    		 required: '비밀번호는 필수항목입니다.',
		        	 minlength:'비밀번호는 {0}자 이상 입력하세요.',
		        	 maxlength:'비밀번호는 {0}자를 초과할 수 없습니다.'
		    	 },
		    	 memberPassword1:{
		    		 required : '비밀번호는 필수항목입니다.',
		        	 minlength : '비밀번호는 {0}자 이상 입력하세요.',
		        	 maxlength : '비밀번호는 {0}자를 초과할 수 없습니다.',
		        	 equalTo : '비밀번호 입력값이 다릅니다.'
		    	 },
		    	 memberName:{
		    		 required : '이름은 필수항목입니다.',
		    		 minlength : '이름은 {0}자 이상입니다.',
		    		 maxlength : '이름은 {0}자를 초과할 수 없습니다.'
		    	 },
		    	 tel1:{
		    		 required : '연락처는 필수항목입니다.'
		    	 },
		    	 tel2:{
		    		 required : '연락처는 필수항목입니다.'
		    	 },
		    	 email:{
		    		 required : 'email은 필수항목입니다.',
		    		 email : 'email형식이 맞지 않습니다.'
		    	 },
		    	 birthdayYear:{
		    		 required : '필수항목입니다.',
		    		 digits : '숫자만 입력가능합니다.'
		    	 },
		    	 birthdayMonth:{
		    		 required : '필수항목입니다.',
		    		 digits : '숫자만 입력가능합니다.'
		    	 },
		    	 birthdayDay:{
		    		 required : '필수항목입니다.',
		    		 digits : '숫자만 입력가능합니다.'
		    	 }
		     },
		     //실패한 요소에 대해서 
		     highlight: function(element) {
		    	 //bootstrap의 validate css를 적용
		    	 $(element).closest('.form-group').removeClass('has-success has-feedback');
		         $(element).closest('.form-group').addClass('has-error has-feedback');
		         $(element).next().remove();
		         $(element).after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
		     },
		     //성공한 요소에 대해서
		     unhighlight: function(element) {
		    	//bootstrap의 validate css를 적용
		         $(element).closest('.form-group').removeClass('has-error has-feedback');
		         $(element).closest('.form-group').addClass('has-success has-feedback');
		         $(element).next().remove();
		         $(element).after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
		     },
		     //유효성 검사 실패 시 메세지의 출력 방식을 설정
		     errorPlacement: function(error, element){
		    	 error.insertAfter(element.next());
		     },
		     //유효성 검사 완료(성공) 후 실행할 코드 
		     submitHandler: function(form) {
		    	 form.submit();
		     }
		});
	};
})(jQuery);







