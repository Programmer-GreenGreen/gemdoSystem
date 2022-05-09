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
<script type="text/javascript"></script>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
      <link href="<c:url value='/css/egovframework/com/board/board.css' />" rel="stylesheet" type="text/css">
    <title>게시글 작성</title>
</head>

<body>

    <script>

        function fn_write() {
            window.location.href = "<c:url value='/board/boardUpsertWrite.do'/>";
        }

        
        /*페이징 처리*/
        function fn_egov_select_linkPage(pageNo){
        	document.searchForm.pageIndex.value = pageNo;
        	document.searchForm.action = "<c:url value='/board/boardList.do'/>";
           	document.searchForm.submit();
        }
        /*검색*/
        function fn_egov_search_article(){
        	document.searchForm.pageIndex.value = 1;
        	document.searchForm.submit();
        }
        
        /*Detaile*/
        function fn_view(board_id) {
        	document.searchForm.board_id.value = board_id;
          	document.searchForm.action = "<c:url value='/board/boardDetail.do'/>";
          	document.searchForm.submit();
        }
</script>


   <h1><a href="<c:url value='/board/boardList.do'/>"  >게시판List</a></h1>              
    <div class="boardlist">
      <!-- 검색 form -->
       <form name="searchForm" action="<c:url value='/board/boardList.do'/>"  id="searchForm"  method="post" onSubmit="fn_egov_search_article(); return false;"> 
       <!-- 하단 버튼 -->
		<div class="search_box">
		<ul>
			<li>
				<select name="searchType" id="searchType" title="검색조건 선택">
					<option value="title"  <c:if test="${searchVO.searchType == 'title'}">selected="selected"</c:if> >제목</option><!-- 글 제목  -->
					<option value="content"  <c:if test="${searchVO.searchType == 'content'}">selected="selected"</c:if> >내용</option><!-- 글 내용 -->
					<option value="writer"  <c:if test="${searchVO.searchType == 'wrtier'}">selected="selected"</c:if> >작성자</option><!-- 작성자 -->
				</select>
			</li>
			<!-- 검색키워드 및 조회버튼 -->
			<li>
				<input class="s_input" id = "Keyword" name="searchKeyword" type="text"  size="35" title="검색어입력" value='<c:out value="${searchVO.searchKeyword}"/>'  maxlength="155" >
				<input type="submit" class="s_btn" value="조회"	title="조회버튼" /><!-- 조회 -->
			</li>
		</ul>
	</div>

	<input name="pageIndex" type="hidden" value="">	
	</form>
    
  <!--  <form name="searchForm" action="<c:url value='/board/boardList.do'/>"  id="searchForm"  method="post" onSubmit="fn_egov_search_article(); return false;">  -->

            <table class="list_table">
                <colgroup>
                	<col style="width: 9%;">              
					<col style="width: 40%;">
					<col style="width: 13%;">
					<col style="width: 13%;">
					<col style="width: 13%;">
                </colgroup>

                <tbody>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>등록일자</th>
                            <th>수정일자</th>
                        </tr>
    				
    				<c:set var="num" value="${paginationInfo.totalRecordCount - (searchVO.pageIndex-1) * searchVO.pageSize }" />
    				
                    <c:forEach items="${resultList}" var="result" varStatus="status">
                        <tr>
							<td>${num}</td>
						<td>
                         <form name="subForm" method="post" action="<c:url value='/board/boardDetail.do'/>">
							<input name="board_id" type="hidden" value="<c:out value='${result.board_id}'/>"> 
							<input name="searchType" type="hidden" value="<c:out value='${searchVO.searchType}'/>"> 
							<input name="searchKeyword" type="hidden" value="<c:out value='${searchVO.searchKeyword}'/>"> 
							<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
							<input type="submit"  name="title"  value="<c:out value='${result.title}'/>" style="border:0px solid #e0e0e0;" />
						</form>
                        </td>
                           
                            <td>
                                <c:out value="${result.writer}" />
                            </td>
                            <td>
                                <c:out value="${result.regDate}" />
                            </td>
                            <td>
                                <c:out value="${result.udt_Date}" />
                            </td>
                        </tr>
                         <c:set var="num" value="${num-1 }"></c:set>
                    </c:forEach>
                </tbody>
            </table>

	<div class="pagination">
		<ul>
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_linkPage"/>
		</ul>
	</div>

    <button id="writer" type="button" onclick="fn_write()" class="btn_writer">등록</button>

</div>
</body>

</html>