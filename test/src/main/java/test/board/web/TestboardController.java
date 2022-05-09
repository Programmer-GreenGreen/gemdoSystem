package test.board.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import test.board.serivce.TestBoardService;
import test.board.serivce.TestBoardVO;

@Controller("TestboardController")
@ControllerAdvice
public class TestboardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestboardController.class);
	@Resource(name = "TestBoardService")
	TestBoardService testboardservice;
	
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;
	
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    @Resource
    Validator validator;
 
    @InitBinder
	public void initBinder(WebDataBinder dataBinder){
		dataBinder.setValidator(this.validator);
	}
    
    
	//게시글 리스트 조회
	@RequestMapping("/board/boardList.do")
	@Validated
	public String selectBoardList(@ModelAttribute("searchVO")TestBoardVO boardVO, ModelMap model) throws Exception{
		
		boardVO.setPageUnit(propertyService.getInt("pageUnit"));
		boardVO.setPageSize(propertyService.getInt("pageSize"));
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
		paginationInfo.setPageSize(boardVO.getPageSize());

		boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
		boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
	
		Map<String, Object> map = testboardservice.selectList(boardVO);
		
		
		int totCnt = Integer.parseInt( map.get("resultCnt").toString());
	
        paginationInfo.setTotalRecordCount(totCnt); //전체게시물건수
        
        model.addAttribute("resultCnt", map.get("resuletCnt"));
        model.addAttribute("resultList" , map.get("resultList"));
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("boardVO", boardVO);
        
		 return "/egovframework/com/board/BoardList";	
		
	}
	//게시물 상세 보기
		@RequestMapping("/board/boardDetail.do")
		public String viewBoardDetail(@ModelAttribute("searchVO")TestBoardVO boardVO, Model model) throws Exception {
			
			TestBoardVO vo = testboardservice.selectDetail(boardVO);
			model.addAttribute("result", vo);
			
			return "/egovframework/com/board/BoardDetail";
		}
		
	//수정+등록 페이지 이동
		@RequestMapping("/board/boardUpsertWrite.do")
		public String upsertBoard(@ModelAttribute("searchVO")TestBoardVO testBoardVO  ,@ModelAttribute("board") TestBoardVO vo, ModelMap model) throws Exception {
			
		if(testBoardVO.getBoard_id() != 0) {
			TestBoardVO tbvo = new TestBoardVO();
			vo.setBoard_id(testBoardVO.getBoard_id());
			
			tbvo = testboardservice.selectDetail(testBoardVO);
			
			model.addAttribute("testBoardVO", tbvo);
		}
		else{
			model.addAttribute("testBoardVO", testBoardVO);
		}
		return "/egovframework/com/board/BoardUpsert";
			
	}
	
	//게시글 등록
	@RequestMapping("/board/boardInsert.do")
	public String insertBoard( @ModelAttribute("testBoardVO")  @Valid  TestBoardVO testBoardVO,  BindingResult bindingResult , ModelMap model 
		 ) throws Exception {
		

		validator.validate(testBoardVO, bindingResult);
		
		if(bindingResult.hasErrors()) {
			
			
			model.addAttribute("testBoard",testBoardVO);
			return "forward:boardUpsertWrite.do";
		}
		
		 testboardservice.insertBoard(testBoardVO);
		return "redirect:boardList.do";
	}
	
	//게시글 수정시 수정 된 상세페이지 반환 (pageIndex,board_id 가져야된)
	@RequestMapping("/board/boardUpdate.do")
	public String updateBoard(@ModelAttribute("searchVO") @Valid TestBoardVO boardVO,@ModelAttribute("testBoardVO")  @Valid TestBoardVO testBoardVO,   BindingResult bindingResult ,
		ModelMap model,HttpServletRequest request) throws Exception {
		validator.validate(testBoardVO, bindingResult);
		if(bindingResult.hasErrors()) {
			TestBoardVO tbvo = new TestBoardVO();
			tbvo = testboardservice.selectDetail(testBoardVO);
			model.addAttribute("boardVO", tbvo);
		}		
		int index = Integer.parseInt(request.getParameter("pageIndex"));
		testboardservice.updateBoard(boardVO);

		return "redirect:boardDetail.do?"+"pageIndex="+index+"&board_id="+testBoardVO.getBoard_id();
	}
	
	//게시글 삭제
	@RequestMapping("/board/boardDlt.do")
	public String deleteBoard(@ModelAttribute("boardVO") TestBoardVO boardVO ) throws Exception {
		testboardservice.deleteBoard(boardVO);		
		return "redirect:boardList.do";
	}
		
}
