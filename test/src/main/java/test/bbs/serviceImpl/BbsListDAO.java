package test.bbs.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Repository;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import test.bbs.service.BbsListVO;

@Repository("bbsListDAO")
public class BbsListDAO extends EgovComAbstractDAO {

	
    public List<BbsListVO> selectList(BbsListVO bbsListVO) throws Exception {
        return selectList("bbsListDAO.selectList", bbsListVO);
	}
}
