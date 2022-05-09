<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="<c:url value='/css/egovframework/com/board/board.css' />" rel="stylesheet" type="text/css">
        
</head>


<body>
	<script>

    /*삭제 시 처음페이지로 이동*/
    function btn_delete(form) {
        if (confirm("정말 삭제하시겠습니까?") == true) {
        	form.submit();
        }
        else {
            return;
        }
    }

</script>        
    <div class="container">
        <table class="table table-boarded">
            <thead>
                <h1>글 상세 보기</h1>
            </thead>
            <tbody>
              
                 <tr>
                        <th>제목:</th>
                        <td><c:out value="${result.title}" /></td>
                    </tr>
                     <tr>
                        <th>작성자:</th>
                        <td><c:out value="${result.writer}"/>
                        </td>
                        
                    </tr>
                     <tr>
                        <th>내용:</th>
                        <td><c:out value="${result.content}"/>
                        </td>
                    </tr>
                     <tr>
                        <th>게시일:</th>
                        <td><c:out value="${result.regDate}"/>
                        </td>
                    </tr>
                  </tbody>
				</table>
				
		<div class="btn">                         
             <form name="articleForm" action="<c:url value='/board/boardUpsertWrite.do'/>" method="post"  style="float:left;" > <!-- 수정 -->
             	
			   <input type="hidden" name="title" value="<c:out value='${result.title}'/>" />
			   <input type="hidden" id="writer" value="<c:out value='${result.writer}'/>" />
			   <input type="hidden" id="content"  value="<c:out value="${result.content}" />"/>
			   <input type="hidden" name="board_id"  value="<c:out value="${result.board_id}" />"/>
				<input name="searchType" type="hidden" value="<c:out value='${searchVO.searchType}'/>"> 
				<input name="searchKeyword" type="hidden" value="<c:out value='${searchVO.searchKeyword}'/>"> 
				<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
				<input type="submit" class="s_submit" value="수정" title="수정"/><!-- 수정 -->
			</form>
			<form name="formDelete" action="<c:url value='/board/boardDlt.do'/>" method="post" style="float:left; margin:0 0 0 3px;">
			<input type="submit" class="s_submit" value="삭제" title="삭제하시겠습니까?" onclick="btn_delete(this.form); return false;"/><!-- 삭제 -->
			<input type="hidden" name="board_id"  value="<c:out value="${result.board_id}" />"/>
		</form>
		<form name="formList" action="<c:url value='/board/boardList.do'/>" method="post" style="float:left; margin:0 0 0 3px;">
			<input name="searchType" type="hidden" value="<c:out value='${searchVO.searchType}'/>"> 
			<input name="searchKeyword" type="hidden" value="<c:out value='${searchVO.searchKeyword}'/>"> 
			<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
			<input type="submit" class="s_submit" value="목록"><!-- 목록 -->
		</form>
			
		</div>
    </div>
</body>

	</html>