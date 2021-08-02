package egovframework.example.haksaengStatus.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface HaksaengStatusService {

	// 이 추상메서드를 호출하는 컨트롤러의 메서드가 throws Exception가 붇어있으면
	// 인터페이스에서 추상메서드 작성할때도 뒤에 throws Exception를 붇어준다
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
