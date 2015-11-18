<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>详细信息</h1>
   <table>
         <tr>
           <td>姓名</td>
           <td>${user.username }</td>
         </tr>
         <tr>
           <td>学号</td>

              <td>${user.student_id}</td>

         </tr>
         <tr>
         <td>发布时间</td>
           <td>${user.publish_time }</td>
         </tr>
         <tr>  
            <td>事件名称</td>
            <td>${user.event_name}</td>
         </tr>
         <tr>
            <td>社团名称</td>
            <td>${user.community_name }</td>
         </tr>
        
          <tr>
			<td>事件内容</td>
			<td>
				${user.event_content}
			</td>
		</tr>
		   </table>
</body>
</html>