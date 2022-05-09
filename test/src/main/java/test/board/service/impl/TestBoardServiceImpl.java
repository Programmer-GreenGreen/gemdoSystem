package test.board.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.FdlException;
//import test.board.serivce.Search;
import test.board.serivce.TestBoardService;
import test.board.serivce.TestBoardVO;
import test.board.serivce.TestBoard;



@Service("TestBoardService")
public class TestBoardServiceImpl extends EgovAbstractServiceImpl implements TestBoardService{
	
	
	
	@Resource(name ="TestBoardDAO")
	private TestBoardDAO testBoardDao;

	@Override
	public Map<String, Object>  selectList(TestBoardVO boardVO) throws Exception  {
		
		List<?> list = testBoardDao.selectList(boardVO);
		int cnt = testBoardDao.selectArticleListCnt(boardVO);
		
		 Map<String, Object> map = new HashMap<String, Object>();
		 
		 map.put("resultList", list);
		 map.put("resultCnt", Integer.toString(cnt));

		return map;
	}

	@Override
	public void insertBoard(TestBoardVO boardVO) throws Exception {

		   if (boardVO == null)
	            throw processException("info.nodata.msg");
	        
		testBoardDao.insertBoard(boardVO);
	}

	@Override
	public TestBoardVO selectDetail(TestBoardVO boardVO)throws Exception {
		return testBoardDao.selectDetail(boardVO);
	}

	@Override
	public void updateBoard(TestBoardVO boardVO) throws Exception {
		testBoardDao.updateBoard(boardVO);
		
	}

	@Override
	public void deleteBoard(TestBoardVO boardVO) throws Exception {
		testBoardDao.deleteBoard(boardVO);
		
	}

	/*
	 * @Override public int getBoardListCnt(Search serach) throws Exception {
	 * 
	 * return testBoardDao.getBoardListCnt(serach); }
	 * 
	 */





}
