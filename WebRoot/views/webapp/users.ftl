<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="../img/favicon.ico" rel="" />
		<link href="../css/userinfo.css" rel=stylesheet>
		<link href="../css/my.css" rel=stylesheet>
		<link href="../css/css.css" rel=stylesheet>
		<script src="../js/jquery-1.11.2.min.js"></script>
		<script src="../js/jquery-html.js"></script>
		<title>demo</title>
	</head>
	<body>
		<div align="center" class="containter">

			<div class="bank10" style="height: 15px;"></div>
			<div class="content">
				<!--leftmenu-->
				<div class="left">
					<!-- user info -->
					<div class="recom1 left-menu">
						欢迎<a href="#">${user.username}</a>登陆
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<img scr="../css/images/sys.png"/>						
						<a href="#">系统设置</a>
					</div>
					<!-- order1 -->
					<div class="recom2 left-menu">
						<p>推荐1</p>
						<p>推荐1</p>
						<p>推荐1</p>
						<p>推荐1</p>
						<p>推荐1</p>
					</div>
					<!-- order2 -->
					<div class="recom3 left-menu">
						<p>推荐1</p>
						<p>推荐1</p>
						<p>推荐1</p>
						<p>推荐1</p>
						<p>推荐1</p>
						<p>
							<a href="#"><img src="../img/mail.gif"/></a>
							<a herf="#"><img src="../img/41.gif"/></a>
							<style type="text/css">
								a{cursor:pointer;}
							</style>
							<#if (msglist?size>0) >	
							 	You have an message!
								<div id="msgid">
									<#list msglist as msg>
										${msg_index},${msg.content}<br/>
									</#list>
								</div>
								<script type="text/javascript">
										window.setInterval(showmsg, 2000);
										function showmsg()
										{
											fresh_per_time (${user.UId})
										}
								</script>
							<#else>
								no any moods!	
							</#if>
							
						</p>
					</div>
				</div>					 
				<!--end leftmenu-->

				<div class="right">
					<!-- 置顶菜单 -->
					<!--header-->
					<div class="menu" id="menuDivId" style="position: relative;text-align: left;">
						<ul>
							<li><a name="menu" href="#" onclick="show(0,'userfriends',0,${user.UId});">好友状态</a></li>
							<li><a name="menu" href="#" onclick="show(0,'userpersonal',1);">个人动态</a></li>
							<li><a name="menu" href="#" onclick="show(0,'userpersonalinfo',2);">个人信息</a></li>
							<li><a name="menu" href="#" onclick="alert('待开发')">相册</a></li>
							<li><a name="menu" href="#" onclick="alert('待开发')">日志</a></li>
							<li><a name="menu" href="#" onclick="show(0,'orders',3);">其他</a></li>
						</ul>
					</div>
					<!--end header-->
					<!-- 右侧自由div -->
					<div class="colde_top">
						<label id="timeShow" style="text-align: center"></lable>
					</div>
					<div class="return_top" style="">
						<a href="#" title="返回顶部" onclick="headerGo();" style=""></a>
					</div>
					<!--end-->
					<!-- main -->
					<div id="mainList">
						<!--加载朋友圈-->
						 <script type="text/javascript">
						 		show(0,'userfriends',0,${user.UId});
						 </script>
					</div>
					<div class="bank20"></div>
				</div>
				<!--start footer-->
				<!-- clear -->
				<div class="clear"></div>
				<!-- footer -->
				<div class="footer">
					2016-01-27.wl
				</div>
				<!--end footer-->
			</div>
		</div>
	</body>
</html>