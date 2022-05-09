<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>

<c:set var="pageTitle"><spring:message code="comboardmsg.testBoardVO.title"/></c:set>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFiles.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/utl/EgovCmmUtl.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/html/egovframework/com/cmm/utl/ckeditor/ckeditor.js?t=B37D54V'/>" ></script>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="testBoardVO" staticJavascript="false" xhtml="true" cdata="false"/>
<title>${title}</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<script>


function btn_upsert(form) {

	//input item Client-Side validate
	if (!validateTestBoardVO(form)) {
		return false;
	} else {
		var validateForm = document.getElementById("testBoardVO");

		if (confirm("<spring:message code="common.update.msg" />")==true) {
			form.submit();
		}
		else {
			return ;
		}
	}
}

function btn_write(form) {
	/* if (!validateTestBoardVO(form)) {
		return false;
	} else {
		var validateForm = document.getElementById("testBoardVO");

 */		if (confirm("<spring:message code="common.regist.msg" />")==true) {
			
			form.action= "<c:url value='/board/boardInsert.do'/>";
			form.submit();
		}
		else {
			return ;
		}
	
}

</script>
<body>

 
<form:form commandName="testBoardVO" action="boardUpdate.do" method="post" onSubmit="btn_upsert(document.forms[0]); return false;" enctype="multipart/form-data">
		<c:set var="board_id" value="${testBoardVO.board_id}"/>
		<div class="wTableFrm">
			<h2>${pageTitle} <spring:message code="title.update" /></h2>

			<!-- 수정폼 -->
			<table class="wTable" summary="<spring:message code="common.summary.update" arguments="${pageTitle}" />">
				<caption>${pageTitle} <spring:message code="title.update" /></caption>
				<colgroup>
					<col style="width: 20%;">
					<col style="width:;">
					<col style="width:;">
				</colgroup>
				<tbody>
	
				
					<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
					<!-- 작성자 -->
					<c:set var="writer"><spring:message code="comboardmsg.testBoardVO.udt.writer"/> </c:set>
					<tr>
					<th><label for="writer">작성자 <span class="pilsu">*</span></label></th>
					<td class="nopd" colspan="3">
					<form:input path="writer" title="${inputTxt}"/>
					<div><form:errors path="writer" cssClass="error" /></div>  
						</td>
						</tr>
						<!-- 글 제목   -->
		<c:set var="title"><spring:message code="comboardmsg.testBoardVO.udt.title"/> </c:set>
		<tr>
			<th><label for="title">${title} <span class="pilsu">*</span></label></th>
			<td class="left">
			    <form:input path="title" title="${inputTxt}" size="70" maxlength="70"/>
   				<div><form:errors path="title" cssClass="error" /></div>     
			</td>
			
		</tr>
		
		<!-- 글 내용  -->
		<c:set var="content"><spring:message code="comboardmsg.testBoardVO.udt.content"/> </c:set>
		<tr>
			<th><label for="content">내용 <span class="pilsu">*</span></label></th>
			<td class="nopd" colspan="3">
				<form:textarea path="content" title="${inputTxt}" cols="300" rows="20"/>   
				<div><form:errors path="content" cssClass="error" /></div>  
			</td>
			</table>

			<!-- 하단 버튼 -->
			<div class="btn">
				
			<c:choose>
			<c:when test="${board_id ne 0}">
			<input type="submit" class="s_submit" value="<spring:message code="button.update" />" title="<spring:message code="button.update" /> <spring:message code="input.button" />" /><!-- 수정 -->
			</c:when>
			<c:when test="${board_id eq 0}">
			<input type="button" class="s_submit" value="<spring:message code="button.create" />" title="<spring:message code="button.create" /> <spring:message code="input.button" />" 
			onclick="return btn_write(this.form);" /><!-- 등록 -->
			</c:when>
			</c:choose>
			<span class="btn_previous"><a href="<c:url value='boardList.do' />?pageIndex=${searchVO.pageIndex}&searchType=${searchVO.searchType}&searchKeyword=${searchVO.searchKeyword}"  
			title="<spring:message code="button.list" />  <spring:message code="input.button" />"><spring:message code="button.list" /></a></span>
	
			</div>
			<div style="clear: both;"></div>

		</div>
			<input type="hidden" name="board_id"  value="<c:out value="${testBoardVO.board_id}" />"/>
			<input name="searchType" type="hidden" value="<c:out value='${searchVO.searchType}'/>"> 
			<input name="searchKeyword" type="hidden" value="<c:out value='${searchVO.searchKeyword}'/>"> 
			<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
	</form:form>

</body>
</html>
