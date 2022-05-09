package test.bbs.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import test.bbs.service.BbsListVO;
import test.bbs.service.BbsService;

@Controller
public class BbsController {

	@Resource(name="bbsService")
	private BbsService bbsService;
	
	
	
	 /**
	 * @param bbslistVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bbsList.do")
	    public String selectList(BbsListVO bbslistVO, ModelMap model)
	            throws Exception {
	        model.addAttribute("list", bbsService.selectList(bbslistVO));	       	        
	        return "egovframework/com/bbs/bbsList";
	    
	              
    }	
	
	@RequestMapping("/bbsListTest.do")
		public String test() throws Exception {
		return "egovframework/com/bbs/bbsModify";
	}
}    

