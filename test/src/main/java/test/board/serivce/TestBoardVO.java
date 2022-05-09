package test.board.serivce;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TestBoardVO extends TestBoard  implements Serializable{
	
	
	
    /** 검색조건 */
    private String searchType = "";

    /** 검색단어 */
    private String searchKeyword = "";
	
	
	/** 현재페이지 */
    private int pageIndex = 1;

	/** 페이지갯수 */
    private int pageUnit = 10;

    /** 페이지사이즈 */
    private int pageSize = 10;

    /** 첫페이지 인덱스 */
    private int firstIndex = 1;

    /** 마지막페이지 인덱스 */
    private int lastIndex = 1;

    /** 페이지당 레코드 개수 */
    private int recordCountPerPage = 10;

    /** 레코드 번호 */
    private int rowNo = 0;

    
   

 	
    
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
}

//	private int boardSize = 10; //리스트 목록 갯수 10으로 셋팅
//	
//	private int rangeSize = 5; //페이지범위 5 
//	
//	private int page; //현재목록 페이지 번호
//	
//	private int range; //각 페이지 범위 시작 번호 예) 페이지가 7라면 1234567 중 2번째 페이지 클릭시 2가 첫번째 번호
//	
//	private int boardCnt; //전체 게시물 수
//	
//	private int pageCnt; //전체 페이지 범위
//	
//	private int startPage; //전체 페이지 시작 번호
//	
//	private int firstIndex; //게시판 시작번호
//	
//	private int endPage; //전체 페이지 끝 번호
//	
//	private boolean prev; //이전
//	
//	private boolean next; //다음
//
//	public int getBoardSize() {
//		return boardSize;
//	}
//
//	public void setBoardSize(int boardSize) {
//		this.boardSize = boardSize;
//	}
//
//	
//	public int getRangeSize() {
//		return rangeSize;
//	}
//
//	public void setRangeSize(int rangeSize) {
//		this.rangeSize = rangeSize;
//	}
//
//	public int getPage() {
//		return page;
//	}
//
//	public void setPage(int page) {
//		this.page = page;
//	}
//
//	public int getRange() {
//		return range;
//	}
//
//	public void setRange(int range) {
//		this.range = range;
//	}
//
//	public int getBoardCnt() {
//		return boardCnt;
//	}
//
//	public void setBoardCnt(int boardCnt) {
//		this.boardCnt = boardCnt;
//	}
//
//	public int getPageCnt() {
//		return pageCnt;
//	}
//
//	public void setPageCnt(int pageCnt) {
//		this.pageCnt = pageCnt;
//	}
//
//	public int getStartPage() {
//		return startPage;
//	}
//
//	public void setStartPage(int startPage) {
//		this.startPage = startPage;
//	}
//
//
//	
//	public int getFirstIndex() {
//		return firstIndex;
//	}
//
//	public void setFirstIndex(int firstIndex) {
//		this.firstIndex = firstIndex;
//	}
//
//	public int getEndPage() {
//		return endPage;
//	}
//
//	public void setEndPage(int endPage) {
//		this.endPage = endPage;
//	}
//
//	public boolean isPrev() {
//		return prev;
//	}
//
//	public void setPrev(boolean prev) {
//		this.prev = prev;
//	}
//
//	public boolean isNext() {
//		return next;
//	}
//
//	public void setNext(boolean next) {
//		this.next = next;
//	}
//	
//	public void pageInfo(int page, int range, int boardCnt) {
//		
//		this.page = page;
//		
//		this.range = range;
//		
//		this.boardCnt = boardCnt;
//		
//		this.pageCnt  = (int)Math.ceil((double)boardCnt/boardSize);
//		
//		this.startPage = (range -1) * rangeSize + 1;
//		
//		this.startPage = range* rangeSize;
//		
//		this.firstIndex = (page -1)* boardSize;
//		
//		this.prev = range == 1? false:true;
//		
//		this.next = endPage > pageCnt ? false:true;
//		if (this.endPage > this.pageCnt) {
//			this.endPage = this.pageCnt;
//			this.next = false;
//		}
//	}
//	
//	public String toString() {
//	      return super.toString();
//	}
//	
//	
//	
//}
