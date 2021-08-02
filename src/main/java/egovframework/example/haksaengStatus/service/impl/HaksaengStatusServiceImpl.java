package egovframework.example.haksaengStatus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.haksaengStatus.service.HaksaengStatusService;
import egovframework.example.haksaengStatus.service.HaksaengStatusVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

// @Service - HaksaengStatusService를 사용하려고 작성하는 어노테이션
@Service
public class HaksaengStatusServiceImpl implements HaksaengStatusService{
	
	@Resource
	private HaksaengStatusMapper haksaengStatusMapper;

	@Override
	public List<EgovMap> selectHaksaengStatusServiceList() throws Exception {
		return haksaengStatusMapper.selectHaksaengStatusServiceList();
	}

	@Override
	public List<EgovMap> selectHaksaengStatusChartServiceList() throws Exception {
		return haksaengStatusMapper.selectHaksaengStatusChartServiceList();
	}

	@Override
	public List<EgovMap> selectHaksaengStatusServiceList(EgovMap egovMap) throws Exception {
		return haksaengStatusMapper.selectHaksaengStatusServiceList(egovMap);
	}

	@Override
	public List<EgovMap> stringParam(String paramStr) throws Exception {
		return haksaengStatusMapper.stringParam(paramStr);
	}

	@Override
	public List<EgovMap> paramVO(HaksaengStatusVO haksaengStatusVO) throws Exception {
		return haksaengStatusMapper.paramVO(haksaengStatusVO);
	}

	@Override
	public List<EgovMap> selectClassServiceList() throws Exception {
		return haksaengStatusMapper.selectClassServiceList();
	}
	
	@Override
	public List<EgovMap> selectMainPartsServiceList() throws Exception {
		return haksaengStatusMapper.selectMainPartsServiceList();
	}

	@Override
	public List<EgovMap> selectPartsDtlServiceList(String partsCd) throws Exception {
		return haksaengStatusMapper.selectPartsDtlServiceList(partsCd);
	}

	@Override
	public List<EgovMap> selectNikeClothesServiceList() throws Exception {
		return haksaengStatusMapper.selectNikeClothesServiceList();
	}

	@Override
	public List<EgovMap> selectNikeClothesDtlServiceList(int cloNo) throws Exception {
		return haksaengStatusMapper.selectNikeClothesDtlServiceList(cloNo);
	}
}
