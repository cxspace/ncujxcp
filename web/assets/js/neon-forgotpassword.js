/**
 *	Neon Register Script
 *
 *	Developed by Arlind Nushi - www.laborator.co
 */

var neonForgotPassword = neonForgotPassword || {};

;(function($, window, undefined)
{
	"use strict";
	
	$(document).ready(function()
	{
		neonForgotPassword.$container = $("#form_forgot_password");
		neonForgotPassword.$steps = neonForgotPassword.$container.find(".form-steps");
		neonForgotPassword.$steps_list = neonForgotPassword.$steps.find(".step");
		neonForgotPassword.step = 'step-1'; // current step
		
				
		neonForgotPassword.$container.validate({
			rules: {
				
				email: {
					required: true,
					email: true
				}
			},
			
			messages: {
				
				email: {
					email: 'Invalid E-mail.'
				}	
			},
			
			highlight: function(element){
				$(element).closest('.input-group').addClass('validate-has-error');
			},
			
			
			unhighlight: function(element)
			{
				$(element).closest('.input-group').removeClass('validate-has-error');
			},
			
			submitHandler: function(ev)
			{
				$(".login-page").addClass('logging-in');
				
				// We consider its 30% completed form inputs are filled
				neonForgotPassword.setPercentage(30, function()
				{
					// Lets move to 98%, meanwhile ajax data are sending and processing
					neonForgotPassword.setPercentage(98, function()
					{
						// Send data to the server
						$.ajax({
							url: baseurl + 'data/sample-forgotpassword-form.php',
							method: 'POST',
							dataType: 'json',
							data: {
								email: $("input#email").val(),
							},
							error: function()
							{
								alert("An error occoured!");
							},
							success: function(response)
							{
								// From response you can fetch the data object retured
								var email = response.submitted_data.email;
								
								
								// Form is fully completed, we update the percentage
								neonForgotPassword.setPercentage(100);
								
								
								// We will give some time for the animation to finish, then execute the following procedures	
								setTimeout(function()
								{
									// Hide the description title
									$(".login-page .login-header .description").slideUp();
									
									// Hide the register form (steps)
									neonForgotPassword.$steps.slideUp('normal', function()
									{
										// Remove loging-in state
										$(".login-page").removeClass('logging-in');
										
										// Now we show the success message
										$(".form-forgotpassword-success").slideDown('normal');
										
										// You can use the data returned from response variable
									});
									
								}, 1000);
							}
						});
					});
				});
			}
		});
	
		// Steps Handler
		neonForgotPassword.$steps.find('[data-step]').on('click', function(ev)
		{
			ev.preventDefault();
			
			var $current_step = neonForgotPassword.$steps_list.filter('.current'),
				next_step = $(this).data('step'),
				validator = neonForgotPassword.$container.data('validator'),
				errors = 0;
			
			neonForgotPassword.$container.valid();
			errors = validator.numberOfInvalids();
			
			if(errors)
			{
				validator.focusInvalid();
			}
			else
			{
				var $next_step = neonForgotPassword.$steps_list.filter('#' + next_step),
					$other_steps = neonForgotPassword.$steps_list.not( $next_step ),
					
					current_step_height = $current_step.data('height'),
					next_step_height = $next_step.data('height');
				
				TweenMax.set(neonForgotPassword.$steps, {css: {height: current_step_height}});
				TweenMax.to(neonForgotPassword.$steps, 0.6, {css: {height: next_step_height}});
				
				TweenMax.to($current_step, .3, {css: {autoAlpha: 0}, onComplete: function()
				{
					$current_step.attr('style', '').removeClass('current');
					
					var $form_elements = $next_step.find('.form-group');
					
					TweenMax.set($form_elements, {css: {autoAlpha: 0}});
					$next_step.addClass('current');
					
					$form_elements.each(function(i, el)
					{
						var $form_element = $(el);
						
						TweenMax.to($form_element, .2, {css: {autoAlpha: 1}, delay: i * .09});
					});
					
					setTimeout(function()
					{
						$form_elements.add($next_step).add($next_step).attr('style', '');
						$form_elements.first().find('input').focus();
						
					}, 1000 * (.5 + ($form_elements.length - 1) * .09));
				}});
			}
		});
		
		neonForgotPassword.$steps_list.each(function(i, el)
		{
			var $this = $(el),
				is_current = $this.hasClass('current'),
				margin = 20;
			
			if(is_current)
			{
				$this.data('height', $this.outerHeight() + margin);
			}
			else
			{
				$this.addClass('current').data('height', $this.outerHeight() + margin).removeClass('current');
			}
		});
		
		
		// Login Form Setup
		neonForgotPassword.$body = $(".login-page");
		neonForgotPassword.$login_progressbar_indicator = $(".login-progressbar-indicator h3");
		neonForgotPassword.$login_progressbar = neonForgotPassword.$body.find(".login-progressbar div");
		
		neonForgotPassword.$login_progressbar_indicator.html('0%');
		
		if(neonForgotPassword.$body.hasClass('login-form-fall'))
		{
			var focus_set = false;
			
			setTimeout(function(){ 
				neonForgotPassword.$body.addClass('login-form-fall-init')
				
				setTimeout(function()
				{
					if( !focus_set)
					{
						neonForgotPassword.$container.find('input:first').focus();
						focus_set = true;
					}
					
				}, 550);
				
			}, 0);
		}
		else
		{
			neonForgotPassword.$container.find('input:first').focus();
		}
		
		
		// Functions
		$.extend(neonForgotPassword, {
			setPercentage: function(pct, callback)
			{
				pct = parseInt(pct / 100 * 100, 10) + '%';
				
				// Normal Login
				neonForgotPassword.$login_progressbar_indicator.html(pct);
				neonForgotPassword.$login_progressbar.width(pct);
				
				var o = {
					pct: parseInt(neonForgotPassword.$login_progressbar.width() / neonForgotPassword.$login_progressbar.parent().width() * 100, 10)
				};
				
				TweenMax.to(o, .7, {
					pct: parseInt(pct, 10),
					roundProps: ["pct"],
					ease: Sine.easeOut,
					onUpdate: function()
					{
						neonForgotPassword.$login_progressbar_indicator.html(o.pct + '%');
					},
					onComplete: callback
				});
			}
		});
	});
	
})(jQuery, window);


/*
     @柳杰

     根据输入找到登录邮箱验证

 */

	function toEmailLogin() {

		var uurl = document.getElementById("email").value;

		if (uurl==""){
			alert("请输入邮箱号");
		}else {
			uurl = gotoEmail(uurl);
			if (uurl != "") {
				if (uurl=="other"){
					alert("没有找到相应的邮箱地址哦。。。,请您自行登录");
				}else {
					window.open("http://" + uurl, "_blank", "toolbar=yes, location=yes, directories=no, status=no, menubar=yes, scrollbars=yes, resizable=no, copyhistory=yes, width=800, height=600");
				}
			}
		}
	}
//功能：根据用户输入的Email跳转到相应的电子邮箱首页
function gotoEmail(mail) {
	var t = mail.split('@')[1];
	t = t.toLowerCase();
	if (t == '163.com') {
		return 'mail.163.com';
	} else if (t == 'vip.163.com') {
		return 'vip.163.com';
	} else if (t == '126.com') {
		return 'mail.126.com';
	} else if (t == 'qq.com' || $t == 'vip.qq.com' || $t == 'foxmail.com') {
		return 'mail.qq.com';
	} else if (t == 'gmail.com') {
		return 'mail.google.com';
	} else if (t == 'sohu.com') {
		return 'mail.sohu.com';
	} else if (t == 'tom.com') {
		return 'mail.tom.com';
	} else if (t == 'vip.sina.com') {
		return 'vip.sina.com';
	} else if (t == 'sina.com.cn' || $t == 'sina.com') {
		return 'mail.sina.com.cn';
	} else if (t == 'tom.com') {
		return 'mail.tom.com';
	} else if (t == 'yahoo.com.cn' || $t == 'yahoo.cn') {
		return 'mail.cn.yahoo.com';
	} else if (t == 'tom.com') {
		return 'mail.tom.com';
	} else if (t == 'yeah.net') {
		return 'www.yeah.net';
	} else if (t == '21cn.com') {
		return 'mail.21cn.com';
	} else if (t == 'hotmail.com') {
		return 'www.hotmail.com';
	} else if (t == 'sogou.com') {
		return 'mail.sogou.com';
	} else if (t == '188.com') {
		return 'www.188.com';
	} else if (t == '139.com') {
		return 'mail.10086.cn';
	} else if (t == '189.cn') {
		return 'webmail15.189.cn/webmail';
	} else if (t == 'wo.com.cn') {
		return 'mail.wo.com.cn/smsmail';
	} else if (t == '139.com') {
		return 'mail.10086.cn';
	} else {
		
	}
};





