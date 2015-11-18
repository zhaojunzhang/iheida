<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	// 按钮 全部选中，全部取消
	function changeSelectState() {
		// 判断全选按钮 是选中 还是 取消
		var selectAll = document.getElementById("selectAll");
		if (selectAll.checked) {
			// 选中
			var nodelist = document.getElementsByName("ids");
			for (var i = 0; i < nodelist.length; i++) {
				nodelist[i].checked = true;
			}
		} else {
			// 取消
			var nodelist = document.getElementsByName("ids");
			for (var i = 0; i < nodelist.length; i++) {
				nodelist[i].checked = false;
			}
		}
	}

	function jump() {
		//获得用户输入页码
		var pNum = document.getElementById("pNum").value;
		location.href = "pagequery.act?pNum=" + pNum;

	}
</script>
</head>
<body>

	<c:if test="${empty users}">
		<h1>信息港没有信息</h1>
	</c:if>
	<c:if test="${not empty users}">
		<form action="ConditionSelectinfo.act" method="post">
			<!-- 选择条件查询字段 -->
			<select name="conditionName">
				<option value="username">姓名</option>
				<option value="event_name">事件名称</option>
				<option value="community_name">社团名称</option>
			</select> <input type="text" name="conditionValue" /> <input type="submit"
				value="查询" />
		</form>
		<!-- 批量删除 -->
		<form action="DelBacthUserinfo.act" method="post">
			<table border="1" width="100%">
				<tr>
					<th>全选<input type="checkbox" id="selectAll"
						onclick="changeSelectState();"></th>
					<th>客户编号</th>
					<th>姓名</th>
					<th>学号</th>
					<th>发布时间</th>
					<th>事件名称</th>
					<th>社团名称</th>
					<th>事件内容</th>
					<th>数据变动</th>


				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><input type="checkbox" name="ids" value="${user.id}"></td>
						<td>${user.id}</td>
						<td>${user.username }</td>
						<td>${user.student_id}</td>
						<td>${user.publish_time }</td>
						<td>${user.event_name}</td>
						<td>${user.community_name }</td>
						<td>${user.event_content}</td>

						<td><a href="DelUserinfo.act?id=${user.id}"
							onClick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')">删除</a> <a
							href="pulishinfo.act?id=${user.id}">发布</a> <a
							href="selectidinfo.act?id=${user.id}">详情</a></td>
					</tr>

				</c:forEach>
				<tr>
					<td colspan="9" align="center">
						<!-- 显示首页 --> <c:if test="${pageBean.pNum==1}">
                                           首页      上一页
               </c:if> <c:if test="${pageBean.pNum!=1}">
							<a href="pagequery.act?pNum=1">首页</a>
							<a href="pagequery.act?pNum=${pageBean.pNum-1}">上一页</a>
						</c:if> <!-- 当前页为中心前后各显示10页 --> <c:set var="begin" value="1" scope="page" />
						<c:set var="end" value="${pageBean.totalPageNum}" scope="page" />


						<!-- 判断前面有没有10页 --> <c:if test="${pageBean.pNum-10>0}">
							<c:set var="begin" value="${pageBean.pNum-10}" scope="page" />
						</c:if> <!-- 判断后面有没有10页 --> <c:if
							test="${pageBean.pNum+10<pageBean.totalPageNum}">
							<c:set var="end" value="${pageBean.pNum+10}" scope="page" />
						</c:if> <!-- 当前页不显示链接 --> <c:forEach begin="${begin}" end="${end}"
							var="i">
							<c:if test="${pageBean.pNum==i}">
               ${i}
               </c:if>
							<c:if test="${pageBean.pNum!=i}">
								<a href="pagequery.act?pNum=${i} ">${i} </a>

							</c:if>

						</c:forEach> <!-- 显示尾页 --> <c:if
							test="${pageBean.pNum==pageBean.totalPageNum}">
                                                 下一页   尾页
               </c:if> <c:if test="${pageBean.pNum!=pageBean.totalPageNum}">


							<a href="pagequery.act?pNum=${pageBean.pNum+1}">下一页</a>
							<a href="pagequery.act?pNum=${ pageBean.totalPageNum}">尾页</a>
						</c:if> <input type="text" id="pNum" size="2" /><input type="button"
						value="go" onclick="jump();" />
					</td>
				</tr>
				<tr>
					<td colspan="12"><input type="submit" value="删除选中信息" /></td>
				</tr>
			</table>
		</form>
	</c:if>

</body>
</html>