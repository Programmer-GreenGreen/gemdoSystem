package test.bbs.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import test.bbs.service.BbsListVO;
import test.bbs.service.BbsService;




@Service("bbsService")
public class BbsServiceImpl implements BbsService {	
	
	@Resource(name = "bbsListDAO")
	private BbsListDAO bbsListDAO;

	@Override
	public List<BbsListVO> selectList(BbsListVO bbsListVO) throws Exception {
		// TODO Auto-generated method stub
		return bbsListDAO.selectList(bbsListVO);
	}

}
