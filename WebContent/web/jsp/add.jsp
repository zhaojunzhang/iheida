<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加用户信息</h1>
<form action = "addinfo.act" method= "post">
   <table>
         <tr>
           <td>姓名</td>
           <td> <input type = "text" name="username"/></td>
         </tr>
         <tr>
           <td>学号</td>
           <td> 
           <input type = "text" name="student_id"/>
           </td>
         </tr>
         <tr>  
            <td>事件名称</td>
            <td><input type = "text" name = "event_name"/></td>
         </tr>
         <tr>
            <td>社团名称</td>
            <td><input type = "text" name = "community_name"></td>
         </tr>
        
          <tr>
			<td>事件内容</td>
			<td>
				<textarea rows="5" cols="60" name="event_content"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="添加信息"/>
			</td>
		</tr>
   </table>
</form>
</body>
</html>