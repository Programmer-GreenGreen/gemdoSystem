package test.board.service.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
//import test.board.serivce.Search;
import test.board.serivce.TestBoard;
import test.board.serivce.TestBoardVO;


@Repository("TestBoardDAO")
public class TestBoardDAO extends EgovComAbstractDAO{
	
	
	public List<?> selectList(TestBoardVO boardVO) {
		return selectList("TestBoardDAO.selectList", boardVO);
	}

	public void insertBoard(TestBoardVO boardVO) {
		insert("TestBoardDAO.insertBoard", boardVO);
		
	}
	
	public TestBoardVO selectDetail(TestBoard boardVO) {
		return selectOne("TestBoardDAO.selectDetail", boardVO);
	}
	
	public void updateBoard(TestBoardVO boardVO) {
		
		update("TestBoardDAO.updateBoard", boardVO);
		
	}	
	public void deleteBoard(TestBoardVO boardVO) {
		
		delete("TestBoardDAO.deleteBoard", boardVO);
		
	}
	
	 public int selectArticleListCnt(TestBoardVO boardVO) {
	 
	 return (Integer)selectOne("TestBoardDAO.selectArticleListCnt", boardVO) ; 
	 }
	
}
