package test.board.serivce;

import java.util.Map;

import egovframework.rte.fdl.cmmn.exception.FdlException;

public interface TestBoardService {

	/* 게시글 목록 조회*/
	public Map<String, Object> selectList(TestBoardVO boardVO) throws Exception ; 
	
	/* 등록 */
	public void insertBoard(TestBoardVO boardVO) throws Exception; 	
		
    /* 게시물 확인 */
	public TestBoardVO selectDetail(TestBoardVO boardVO) throws Exception ;
    
    /* 게시물 수정 */
	public void updateBoard(TestBoardVO boardVO) throws Exception ;

    /* 게시물 삭제 */
	public void deleteBoard(TestBoardVO boardVO) throws Exception;


}
