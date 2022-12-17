<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="<c:url value='/views/vendor/css/home.css'/>">
</head>
<body>
	<%@include file="/views/vendor/sidebar.jsp"%>
	<%@include file="/views/vendor/add-product.jsp"%>
	<div>
		<c:forEach var="o" items="${listdm}" varStatus="STT">
			<tr class="odd gradeX">
				<td>${STT.index+1 }</td>
				<%-- <c:url value="/image?fname=${o.tenDM}" var="imgUrl"></c:url>
				<td><img height="150" width="200" src="${imgUrl}"
					alt="${cate.icon}" /></td>
				<td><img height="150" width="200"  src="<c:url value='${cate.images}'/>" alt="${cate.images}" /></td>
				<td>${o.tenDM }</td>
				<td><a
					href="<c:url value='/admin/category/edit?id=${cate.cateid}'/>"
					class="center">sửa</a> | <a
					href="<c:url value='/admin/category/delete?id=${cate.cateid}'/>"
					class="center">xóa</a></td> --%>

			</tr>
			
								
					<h1>${o.tenDM}</h1>
					 
					<c:forEach items = "${spList}" var = "sp">
					 <h2>${sp.tenSP}</h2>
					</c:forEach>
		</c:forEach>
	</div>
</body>
</html>