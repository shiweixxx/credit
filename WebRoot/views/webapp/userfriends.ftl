  <#list moodlist as m>
	<div class="right_item" data-favour="true">
		<div class="right_item_content">
			<div class="right_item_name">
				<a href="#" onclick="">名字:${m.MId}</a>
			</div>
			<div class="right_item_text">
				<p onclick="" href="#" target="_blank">
					${m.mcontent}
				</p>
			</div>

			<div class="right_item_pic">
				<img onclick="" src="http://223.202.119.52/static/newsimg/201601/1958748758_14540433933270.8838866919292535_m.jpg">
			</div>
			<div class="right_item_footer">
				<!-- 评论点赞 -->
				<div class="share_box" >
					<font class="gray">时间-${m.createdTime}</font>
					<img src="../css/images/read_icon.png" alt="浏览次数" title="浏览次数" style="float:left; margin:8px 6px 0 20px;">
					<font class="gray">浏览次数-1</font>
					<#if m.moodsinfo.UIdList?index_of(m.FUid+",")!=-1>
						<a name="favour" href="javascript:alert("已赞！")" class="praisebtn_1">	
							<img src="../css/images/red_heart_icon.png" alt="已赞" title="已赞"/>
						</a>
					<#else>
						<a name="favour" href="javascript:praise(${m.MId},${uid})" class="praisebtn">	
							<img src="../css/images/fot_heart_icon.png" alt="点赞" title="点赞"/>
						</a>
					</#if>
					<font class="gray" id="p${m.MId}">点赞次数-${m.moodsinfo.praisedTimes}</font>
				</div>
				<!-- 评论点赞 -->
			</div>
		</div>
		<div class="clear"></div>
	</div>
</#list>
	<div class="clear"></div>
	<div id="more">
		<div class="clear"></div>

		<div class="loading_btn">
			<#if (moodlist?size>0) >	
			<a href="javascript:;" onclick="loadPage('all',${uid},${page});">加载更多</a>
			<#else>
			no any moods	
			</#if>
		</div>
	</div>
<script type="text/JavaScript">
    ;(function($) {
        $.extend({
            tipsBox: function(options) {
                options = $.extend({
                    obj: null,  //jq对象，要在那个html标签上显示
                    str: "+1",  //字符串，要显示的内容;也可以传一段html，如: "<b style='font-family:Microsoft YaHei;'>+1</b>"
                    startSize: "12px",  //动画开始的文字大小
                    endSize: "30px",    //动画结束的文字大小
                    interval: 600,  //动画时间间隔
                    color: "red",    //文字颜色
                    callback: function() {}    //回调函数
                }, options);
                $("body").append("<span class='num'>"+ options.str +"</span>");
                var box = $(".num");
                var left = options.obj.offset().left + options.obj.width() / 2;
                var top = options.obj.offset().top - options.obj.height();
                box.css({
                    "position": "absolute",
                    "left": left + "px",
                    "top": top + "px",
                    "z-index": 9999,
                    "font-size": options.startSize,
                    "line-height": options.endSize,
                    "color": options.color
                });
                box.animate({
                    "font-size": options.endSize,
                    "opacity": "0",
                    "top": top - parseInt(options.endSize) + "px"
                }, options.interval , function() {
                    box.remove();
                    options.callback();
                });
            }
        });
    })(jQuery);
</script>
<script type="text/JavaScript">
	$(function() {
		$(".praisebtn").click(function() {
			var className=$(this).attr("class")
			if (className == "praisebtn"){
				$(this).find("img").attr('src',"../css/images/red_heart_icon.png"); 
				$.tipsBox({
					obj: $(this),
					str: "赞+1",
	                callback: function() {
	                }
				});
				$(this).attr("class","praisebtn_1")
			}else{
				$(this).find("img").attr('src',"../css/images/fot_heart_icon.png"); 
				$.tipsBox({
					obj: $(this),
					str: "赞-1",
	                callback: function() {
	                }
				});
				$(this).attr("class","praisebtn")				
			}
		});

	});
</script>
					