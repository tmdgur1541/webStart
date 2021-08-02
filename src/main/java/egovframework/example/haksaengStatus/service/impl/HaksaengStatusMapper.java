package egovframework.example.haksaengStatus.service.impl;

import java.util.List;

import egovframework.example.haksaengStatus.service.HaksaengStatusVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

// @Mapper - 이거는 ServiceImpl이 없다
// 그래서 인터페이스를 임포트 해주면된다.
@Mapper
public interface HaksaengStatusMapper {

	List<EgovMap> selectHaksaengStatusServiceList() throws Exception;
	
	List<EgovMap> selectHaksaengStatusChartServiceList() throws Exception;

	List<EgovMap> selectHaksaengStatusServiceList(EgovMap egovMap) throws Exception;

	List<EgovMap> stringParam(String paramStr) throws Exception;

	List<EgovMap> paramVO(HaksaengStatusVO haksaengStatusVO) throws Exception;

	List<EgovMap> selectClassServiceList() throws Exception;

	List<EgovMap> selectMainPartsServiceList() throws Exception;

	List<EgovMap> selectPartsDtlServiceList(String partsCd) throws Exception;

	List<EgovMap> selectNikeClothesServiceList() throws Exception;

	List<EgovMap> selectNikeClothesDtlServiceList(int cloNo) throws Exception;
}
