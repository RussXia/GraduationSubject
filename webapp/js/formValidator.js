/**
 * 教师删除所带的学生 操作
 * @returns {Boolean}
 */
function deleteMyStudent(subjectResultId)
{
	var form = $("#"+subjectResultId);
	Modal.confirm(
			  {
			    msg: "你确定要删除该学生？"
			  })
			  .on( function () {
				  $.ajax({
			            cache: true,
			            type: "POST",
			            url:'../teacherSubject/deleteMyStudent',
			            data:form.serialize(),// 你的formid
			            async: false,
			            error: function(request) {
			                Modal.alert(
			            			  {
			            				 msg: "Connection error",
			            			    title: '教师端删除学生',
			            			    btnok: '确定',
			            			  });
			            },
			            success: function(data) {
			            	Modal.alert(
			            			  {
			            				 msg: data,
			            			    title: '教师端删除学生',
			            			    btnok: '确定',
			            			  });
			            	$("#deleteMyStudent"+subjectResultId).hide();
			            }
				  });
			  });

	
}

/**
 * 教师确认选题操作
 * @returns {Boolean}
 */
function teacherIdealConfirm(subjectIdealId)
{
	var form = $("#"+subjectIdealId);
	$.ajax({
        cache: true,
        type: "POST",
        url:'../teacherSubject/confirmIdeal',
        data:form.serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	if(data == "success"){
        		Modal.alert(
          			  {
          			    msg: "操作成功,您已成功选择该学生!",
          			    title: '教师端选题管理',
          			    btnok: '确定',
          			  });
        		$("#teacherIdeal"+subjectIdealId).hide();
        	}else{
        		Modal.alert(
            			  {
            			    msg: data,
            			    title: '学生端选择课题',
            			    btnok: '确定',
            			  });
        	}
        },
    });
}


/**
 * 教师否决选题操作
 * @returns {Boolean}
 */
function teacherIdealRefuse(subjectIdealId)
{
	var form = $("#"+subjectIdealId);
	$.ajax({
        cache: true,
        type: "POST",
        url:'../teacherSubject/refuseIdeal',
        data:form.serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	if(data == "success"){
        		Modal.alert(
          			  {
          			    msg: "操作成功,您已成功否决该学生!",
          			    title: '教师端选题管理',
          			    btnok: '确定',
          			  });
        		$("#teacherIdeal"+subjectIdealId).hide();
        	}else{
        		Modal.alert(
            			  {
            			    msg: data,
            			    title: '学生端选择课题',
            			    btnok: '确定',
            			  });
        	}
        },
    });
}

/**
 * 教师端 我的选题管理的 删除异步提交
 * @returns {Boolean}
 */
$(".deleteSubject").click(function(){
	var url = this.href;
	var graduationSubjectId = url.split("/teacherSubject/deleteSubject/");
	var args = {};
  $.post(url, args, function(data){
	  if(data == "success"){
  		Modal.alert(
    			  {
    			    msg: "删除选题成功!",
    			    title: '教师端 我的选题管理',
    			    btnok: '确定',
    			  });
  		$("#teacherSubject"+graduationSubjectId[1]).hide();
  	}else{
  		Modal.alert(
      			  {
      			    msg: data,
      			    title: '教师端 我的选题管理',
      			    btnok: '确定',
      			  });
  	}
  });
  return false;
});
/**
 * 教师端 我的选题管理的 修改异步提交
 * @returns {Boolean}
 */
function teacherUpdateSubject(index)
{
	
   var form = $(".teacherSubjectForm").eq(index);
	$.ajax({
        cache: true,
        type: "POST",
        url:'../teacherSubject/updateSubject',
        data:form.serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	if(data == "success"){
        		Modal.alert(
          			  {
          			    msg: "修改选题成功!",
          			    title: '教师端 我的选题管理',
          			    btnok: '确定',
          			  });
        	}else{
        		Modal.alert(
            			  {
            			    msg: data,
            			    title: '教师端 我的选题管理',
            			    btnok: '确定',
            			  });
        	}
        },
    });
}
/**
 * 学生选题的异步提交
 * @returns {Boolean}
 */
function stuChooseSubject(graduationSubjectId)
{
	var form = $("#"+graduationSubjectId);
	$.ajax({
        cache: true,
        type: "POST",
        url:'../studentSubject/chooseSubject',
        data:form.serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	if(data == "success"){
        		Modal.alert(
          			  {
          			    msg: "选题成功,请等待邮件通知!",
          			    title: '学生端选择课题',
          			    btnok: '确定',
          			  });
        		$("#stuChooseSubject"+graduationSubjectId).hide();
        	}else{
        		Modal.alert(
            			  {
            			    msg: data,
            			    title: '学生端选择课题',
            			    btnok: '确定',
            			  });
        	}
        },
    });
}

/**
 * 学生端删除选题的异步提交
 * @returns {Boolean}
 */
function stuDeleteSubject(graduationSubjectId)
{
	var form = $("#"+graduationSubjectId);
	$.ajax({
        cache: true,
        type: "POST",
        url:'../studentSubject/deleteSubject',
        data:form.serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	if(data == "success"){
        		Modal.alert(
          			  {
          			    msg: "删除选题成功!",
          			    title: '学生端个人选题管理',
          			    btnok: '确定',
          			  });
        		$("#stuDeleteSubject"+graduationSubjectId).hide();
        	}else{
        		Modal.alert(
            			  {
            			    msg: data,
            			    title: '学生端个人选题管理',
            			    btnok: '确定',
            			  });
        	}
        },
    });
}

/**
 * 验证登陆页面表单的填写是否正确，并提交表单
 * @returns {Boolean}
 */
function validateLogin()
{
	 $(".message-box").remove();
	var username = $("#username");
	if(username.val() =="" || username.val().length<6){
		  var errorMsg = '请输入至少6位的用户名.';
		  $("#registerForm").append(' <div class="form-group message-box" ><div class="col-xs-12 "><div class="alert alert-danger" role="alert">'
		  +errorMsg+' </div></div></div>');
		  return false;
	}
	
	
	
	var password = $("#password");
	if(password.val() =="" ){
		  var errorMsg = '请输入密码';
		  $("#registerForm").append(' <div class="form-group message-box"><div class="col-xs-12 "><div class="alert alert-danger" role="alert">'
		  +errorMsg+' </div></div></div>');
		  return false;
	}
	
	$("#registerForm").submit();
}

/**
 * 验证学生页面修改个人密码表单的填写是否正确，并提交表单
 * @returns {Boolean}
 */
function validateStuChangePassword()
{
	var oldPassword = $("#oldPassword");
	var newPassword = $("#newPassword");
	var newPasswordConfirm = $("#newPasswordConfirm");

	if(oldPassword.val() =="" ){
		Modal.alert(
  			  {
  			    msg: '请输入原密码',
  			    title: '学生端修改密码',
  			    btnok: '确定',
  			  });
		 return false;
	}
	if(newPassword.val() =="" ){
		Modal.alert(
  			  {
  			    msg: '新密码不能为空',
  			    title: '学生端修改密码',
  			    btnok: '确定',
  			  });
		 return false;
	}
	if(newPasswordConfirm.val() =="" ){
		Modal.alert(
  			  {
  			    msg: '"新密码确认"不能为空',
  			    title: '学生端修改密码',
  			    btnok: '确定',
  			  });
		 return false;
	}
	if(newPasswordConfirm.val() != newPassword.val() ){
		Modal.alert(
  			  {
  			    msg: '两次密码不一致',
  			    title: '学生端修改密码',
  			    btnok: '确定',
  			  });
		 return false;
	}
	
	$.ajax({
        cache: true,
        type: "POST",
        url:'../studentInfo/changePassword',
        data:$('#changePassword').serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	Modal.alert(
        			  {
        			    msg: data,
        			    title: '学生端修改密码',
        			    btnok: '确定',
        			  });
            var password =   $('#changePassword').find("input[type='password']");
            password.each(function(){
               $(this).val("");
            });
        }
    });
}

/**
 * 验证教师页面修改个人密码表单的填写是否正确，并提交表单
 * @returns {Boolean}
 */
function validateTeacherChangePassword()
{
	var oldPassword = $("#oldPassword");
	var newPassword = $("#newPassword");
	var newPasswordConfirm = $("#newPasswordConfirm");

	if(oldPassword.val() =="" ){
		Modal.alert(
	  			  {
	  			    msg: '请输入原密码',
	  			    title: '教师端修改密码',
	  			    btnok: '确定',
	  			  });
		 return false;
	}
	if(newPassword.val() =="" ){
		Modal.alert(
	  			  {
	  			    msg: '请输入新密码',
	  			    title: '教师端修改密码',
	  			    btnok: '确定',
	  			  });
		 return false;
	}
	if(newPasswordConfirm.val() =="" ){
		Modal.alert(
	  			  {
	  				 msg: '"新密码确认"不能为空',
	  			    title: '教师端修改密码',
	  			    btnok: '确定',
	  			  });
		 return false;
	}
	if(newPasswordConfirm.val() != newPassword.val() ){
		Modal.alert(
	  			  {
	  				 msg: '两次输入的密码不一致，请重新输入!',
	  			    title: '教师端修改密码',
	  			    btnok: '确定',
	  			  });
		 return false;
	}
	
	$.ajax({
        cache: true,
        type: "POST",
        url:'../teacherInfo/changePassword',
        data:$('#changePassword').serialize(),// 你的formid
        async: false,
        error: function(request) {
            Modal.alert(
  	  			  {
  	  				 msg: 'Connection error',
  	  			    title: '教师端修改密码',
  	  			    btnok: '确定',
  	  			  });
        },
        success: function(data) {
            Modal.alert(
    	  			  {
    	  				 msg: data,
    	  			    title: '教师端修改密码',
    	  			    btnok: '确定',
    	  			  });
            var password =   $('#changePassword').find("input[type='password']");
            password.each(function(){
               $(this).val("");
            });
        }
    });
}

/**
 * 验证学生页面修改个人邮箱表单的填写是否正确，并提交表单
 * @returns {Boolean}
 */
function validateStuChangeEmail()
{	
	var oldEmail = $('#oldEmail');
	var newEmail = $('#newEmail');
	if(newEmail.val().length == 0){
	  Modal.alert(
  			  {
  				 msg: "新邮箱不能为空",
  			    title: '学生端邮箱账号变更',
  			    btnok: '确定',
  			  });
		return false;
	}	
	
	if (!newEmail.val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) { 
	  Modal.alert(
  			  {
  				 msg: "邮箱格式不正确",
  			    title: '学生端邮箱账号变更',
  			    btnok: '确定',
  			  });
		$("#email").focus(); 
		return false; 
	} 
	Modal.confirm(
		  {
		    msg: "选题信息的通知将会以邮件的方式发送到您的邮箱，确定要变更邮箱？"
		  })
		  .on( function () {
			  $.ajax({
		            cache: true,
		            type: "POST",
		            url:'../studentInfo/changeEmail',
		            data:$('#changeEmail').serialize(),// 你的formid
		            async: false,
		            error: function(request) {
		                Modal.alert(
		            			  {
		            				 msg: "Connection error",
		            			    title: '学生端邮箱账号变更',
		            			    btnok: '确定',
		            			  });
		            },
		            success: function(data) {
		            	Modal.alert(
		            			  {
		            				 msg: data,
		            			    title: '学生端邮箱账号变更',
		            			    btnok: '确定',
		            			  });
		                oldEmail.val(newEmail.val());
		                newEmail.val("");
		            }
			  });
		  });
}

/**
 * 验证教师页面修改个人邮箱表单的填写是否正确，并提交表单
 * @returns {Boolean}
 */
function validateTeacherChangeEmail()
{	
	var oldEmail = $('#oldEmail');
	var newEmail = $('#newEmail');
	if(newEmail.val().length == 0){
		Modal.alert(
  			  {
  				 msg: "新邮箱不能为空",
  			    title: '教师端邮箱账号变更',
  			    btnok: '确定',
  			  });
		return false;
	}	
	
	if (!newEmail.val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) { 
		Modal.alert(
	  			  {
	  				 msg: "邮箱格式不正确",
	  			    title: '教师端邮箱账号变更',
	  			    btnok: '确定',
	  			  });
		$("#email").focus(); 
		return false; 
	} 
	Modal.confirm(
			  {
			    msg: "选题信息的通知将会以邮件的方式发送到您的邮箱，确定要变更邮箱？"
			  })
			  .on( function () {
				  $.ajax({
			            cache: true,
			            type: "POST",
			            url:'../teacherInfo/changeEmail',
			            data:$('#changeEmail').serialize(),// 你的formid
			            async: false,
			            error: function(request) {
			                Modal.alert(
			            			  {
			            				 msg: "Connection error",
			            			    title: '教师端邮箱账号变更',
			            			    btnok: '确定',
			            			  });
			            },
			            success: function(data) {
			            	Modal.alert(
			            			  {
			            				 msg: data,
			            			    title: '教师端邮箱账号变更',
			            			    btnok: '确定',
			            			  });
			                oldEmail.val(newEmail.val());
			                newEmail.val("");
			            }
				  });
			  });
}

/**
 * 验证学生页面修改个人信息表单的填写是否正确，并提交表单
 * @returns {Boolean}
 */
function validateStudentPersonalData()
{	
	var cellPhone = $('#cellPhone');
	var birth = $('#birth');
	if(cellPhone.val().length == 0){
		Modal.alert(
  			  {
  				 msg: "手机号不能为空",
  			    title: '学生端个人资料变更',
  			    btnok: '确定',
  			  });
		return false;
	}	
	if (!cellPhone.val().match(/^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/)) { 
		Modal.alert(
	  			  {
	  				 msg: "手机号码格式不正确！",
	  			    title: '学生端个人资料变更',
	  			    btnok: '确定',
	  			  });
		$("#cellPhone").focus(); 
		return false; 
	} 
	if(birth.val().length == 0){
		Modal.alert(
	  			  {
	  				 msg: "出生日期不能为空！",
	  			    title: '学生端个人资料变更',
	  			    btnok: '确定',
	  			  });
		return false;
	}	
	
	$.ajax({
        cache: true,
        type: "POST",
        url:'../studentInfo/updateStudentInfo',
        data:$('#personalDate').serialize(),// 你的formid
        async: false,
        error: function(request) {
        	Modal.alert(
  	  			  {
  	  				 msg: "Connection error！",
  	  			    title: '学生端个人资料变更',
  	  			    btnok: '确定',
  	  			  });
        },
        success: function(data) {
            Modal.alert(
    	  			  {
    	  				 msg: data,
    	  			    title: '学生端个人资料变更',
    	  			    btnok: '确定',
    	  			  });
        }
    });
}

/**
 * 验证教师页面修改个人信息表单的填写是否正确，并提交表单
 * @returns {Boolean}
 */
function validateTeacherPersonalData()
{	
	var cellPhone = $('#cellPhone');
	var introduction = $('#introduction');
	if(cellPhone.val().length == 0){
		 Modal.alert(
	  			  {
	  				 msg: "手机号不能为空!",
	  			    title: '教师端个人资料变更',
	  			    btnok: '确定',
	  			  });
		return false;
	}	
	if (!cellPhone.val().match(/^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/)) { 
		 Modal.alert(
	  			  {
	  				 msg: "手机号码格式不正确!",
	  			    title: '教师端个人资料变更',
	  			    btnok: '确定',
	  			  });
		$("#cellPhone").focus(); 
		return false; 
	} 
	if(introduction.val().length == 0){
		Modal.alert(
	  			  {
	  				 msg: "简介信息不能为空!",
	  			    title: '教师端个人资料变更',
	  			    btnok: '确定',
	  			  });
		return false;
	}	
	
	$.ajax({
        cache: true,
        type: "POST",
        url:'../teacherInfo/updateTeacherInfo',
        data:$('#personalDate').serialize(),// 你的formid
        async: false,
        error: function(request) {
            Modal.alert(
  	  			  {
  	  				 msg: "Connection error!",
  	  			    title: '教师端个人资料变更',
  	  			    btnok: '确定',
  	  			  });
        },
        success: function(data) {
            Modal.alert(
    	  			  {
    	  				 msg: data,
    	  			    title: '教师端个人资料变更',
    	  			    btnok: '确定',
    	  			  });
        }
    });
}

/**
 * 验证教师页面发布课题表单的填写是否正确，并提交表单
 * @returns {Boolean}
 */
function validateAddGraduationSubject()
{	
	var subjectName = $('#subjectName');
	var subjectOrientation = $('#subjectOrientation');
	if(subjectName.val().length == 0){
		 Modal.alert(
	  			  {
	  				 msg: "课题名称不能为空!",
	  			    title: '教师端发布课题',
	  			    btnok: '确定',
	  			  });
		return false;
	}
	if(subjectOrientation.val().length == 0){
		Modal.alert(
	  			  {
	  				 msg: "课题方向不能为空!",
	  			    title: '教师端发布课题',
	  			    btnok: '确定',
	  			  });
		return false;
	}	
	
	$.ajax({
        cache: true,
        type: "POST",
        url:'../teacherSubject/addGraduationSubject',
        data:$('#addGraduationSubject').serialize(),// 你的formid
        async: false,
        error: function(request) {
            Modal.alert(
  	  			  {
  	  				 msg: "Connection error!",
  	  			    title: '教师端发布课题',
  	  			    btnok: '确定',
  	  			  });
        },
        success: function(data) {
            Modal.alert(
    	  			  {
    	  				 msg: data,
    	  			    title: '教师端个人资料变更',
    	  			    btnok: '确定',
    	  			  });
            $('#addGraduationSubject input[type="text"]').val("");
        }
    });
}

/**
 * 利用bootstrap的模态框设计的弹出框
 */
;
$(function () {
  window.Modal = function () {
    var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
    var alr = $("#ycf-alert");
    var ahtml = alr.html();

    //关闭时恢复 modal html 原样，供下次调用时 replace 用
    //var _init = function () {
    //	alr.on("hidden.bs.modal", function (e) {
    //		$(this).html(ahtml);
    //	});
    //}();

    /* html 复原不在 _init() 里面做了，重复调用时会有问题，直接在 _alert/_confirm 里面做 */


    var _alert = function (options) {
      alr.html(ahtml);	// 复原
      alr.find('.ok').removeClass('btn-success').addClass('btn-primary');
      alr.find('.cancel').hide();
      _dialog(options);

      return {
        on: function (callback) {
          if (callback && callback instanceof Function) {
            alr.find('.ok').click(function () { callback(true) });
          }
        }
      };
    };

    var _confirm = function (options) {
      alr.html(ahtml); // 复原
      alr.find('.ok').removeClass('btn-primary').addClass('btn-success');
      alr.find('.cancel').show();
      _dialog(options);

      return {
        on: function (callback) {
          if (callback && callback instanceof Function) {
            alr.find('.ok').click(function () { callback(true) });
            alr.find('.cancel').click(function () { $("#ycf-alert").modal('hide');});
          }
        }
      };
    };

    var _dialog = function (options) {
      var ops = {
        msg: "提示内容",
        title: "操作提示",
        btnok: "确定",
        btncl: "取消"
      };

      $.extend(ops, options);

      console.log(alr);

      var html = alr.html().replace(reg, function (node, key) {
        return {
          Title: ops.title,
          Message: ops.msg,
          BtnOk: ops.btnok,
          BtnCancel: ops.btncl
        }[key];
      });
      
      alr.html(html);
      alr.modal({
        width: 500,
        backdrop: 'static'
      });
    }

    return {
      alert: _alert,
      confirm: _confirm
    }

  }();
});