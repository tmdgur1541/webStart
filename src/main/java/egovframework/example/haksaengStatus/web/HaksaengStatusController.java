package egovframework.example.haksaengStatus.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.cmmn.JsonUtil;
import egovframework.example.haksaengStatus.service.HaksaengStatusService;
import egovframework.example.haksaengStatus.service.HaksaengStatusVO;
import egovframework.example.user.service.UserService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class HaksaengStatusController {
	 
	@Resource
	private HaksaengStatusService haksaengStatusService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/initHaksaengStatus.do")
	public String initHaksaengStatus(ModelMap model) throws Exception {

		List<EgovMap> haksaengList 			= haksaengStatusService.selectHaksaengStatusServiceList();
		List<EgovMap> haksaengChartList 	= haksaengStatusService.selectHaksaengStatusChartServiceList();

		model.addAttribute("haksaengList"		, haksaengList);
		model.addAttribute("haksaengChartList"	, haksaengChartList);
		
		return "haksaengStatus/haksaengStatus.tiles";
	}
	
	@RequestMapping(value = "/initHaksaengStatusChart.do")
	public String initHaksaengStatusChart(ModelMap model) throws Exception {
		
		List<EgovMap> haksaengChartList = haksaengStatusService.selectHaksaengStatusChartServiceList();
		
		model.addAttribute("haksaengChartList", haksaengChartList);
		
		return "haksaengStatus/haksaengStatusChart.tiles";
	}
	
	@RequestMapping(value = "/initHaksaengStatusTable.do")
	public String initHaksaengStatusTable(ModelMap model) throws Exception {
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
		
		model.addAttribute("haksaengList", haksaengList);
		
		return "haksaengStatus/haksaengStatusTable.tiles";
	}
	
	@RequestMapping(value = "/oneMapping.do")
	public String oneMapping(HttpServletRequest req, ModelMap model) throws Exception {
		
		String menuNm 			= req.getParameter("pageName"),
			   returnAddrStr 	= "";
		
		if (menuNm.equals("initHaksaengStatusChart")) {
			
			List<EgovMap> haksaengChartList = haksaengStatusService.selectHaksaengStatusChartServiceList();
			
			model.addAttribute("haksaengChartList", haksaengChartList);
			
			returnAddrStr = "haksaengStatus/haksaengStatusChart.tiles";
		} else if (menuNm.equals("initHaksaengStatusTable")) {
			
			EgovMap egovMap = new EgovMap();
			
			egovMap.put("userNm", req.getParameter("haksaengName"));
			
			List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList(egovMap);
			
			model.addAttribute("haksaengList", haksaengList);
				
			returnAddrStr = "haksaengStatus/haksaengStatusTable.tiles";
		}
		
		return returnAddrStr;
	}
	
	@RequestMapping(value = "/stringParam.do")
	public String initStringParam(HttpServletRequest req, ModelMap model) throws Exception {
		
		String paramStr = "한석현";
		
		System.out.println(paramStr);
		
		List<EgovMap> haksaengList = haksaengStatusService.stringParam(paramStr);
		
		model.addAttribute("haksaengList", haksaengList);

		return "haksaengStatus/haksaengStatusTable.tiles";
	}
	
	@RequestMapping(value = "/paramVO.do")
	public String initParamVO(HttpServletRequest req, ModelMap model) throws Exception {
		
		HaksaengStatusVO haksaengStatusVO = new HaksaengStatusVO();
		
		haksaengStatusVO.setUserId("hanq");
		haksaengStatusVO.setUserNm("한석현");
		haksaengStatusVO.setAge(38);
		
		List<EgovMap> haksaengList = haksaengStatusService.paramVO(haksaengStatusVO);
		
		System.out.println(haksaengList);
		
		return "haksaengStatus/haksaengStatusTable.tiles";
	}
	
	@RequestMapping(value = "/reqParam.do")
	public String initReqParam(@RequestParam Map<String, String> paramMap, ModelMap model) throws Exception {
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
		
		System.out.println(paramMap.get("userId"));
		
		model.addAttribute("haksaengList", haksaengList);
		
		return "haksaengStatus/haksaengStatusTable.tiles";
	}
	
	@RequestMapping(value = "/modelAttr.do")
	public String initModelAttr(@ModelAttribute("vo") HaksaengStatusVO vo, ModelMap model) throws Exception {
		
		EgovMap egovMap = new EgovMap();
		
		egovMap.put("userId", vo.getUserId());
		egovMap.put("userNm", vo.getUserNm());
		egovMap.put("cafeNick", vo.getCafeNick());
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList(egovMap);
		
		model.addAttribute("haksaengList", 	haksaengList);
		
		return "haksaengStatus/modelAttrTable.tiles";
	}
	
	@RequestMapping(value = "/chkBox.do")
	public String initChkBox(@RequestParam(required=false) String[] chkArr, ModelMap model) throws Exception {
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList();
		
		model.addAttribute("haksaengList"	, haksaengList);	
		model.addAttribute("chkArr"			, chkArr);
		
		return "haksaengStatus/array.tiles";
	}
	
	@RequestMapping(value = "/chkBox2.do")
	public String initChkBox2(@RequestParam(required=false) String[] chkArr, ModelMap model) throws Exception {
		
		List<EgovMap> haksaengList 	= haksaengStatusService.selectHaksaengStatusServiceList();
		List<EgovMap> classList 	= haksaengStatusService.selectClassServiceList();
		
		model.addAttribute("haksaengList", 	haksaengList);
		model.addAttribute("classList", 	classList);
		model.addAttribute("chkArr"			, chkArr);
		
		//if (chkArr != null) model.addAttribute("chkArr", chkArr);
		
		return "haksaengStatus/array2.tiles";
	}
	
	@RequestMapping(value = "/multiSelectBox.do")
	public String initMultiSelectBox(ModelMap model) throws Exception {
		
		List<EgovMap> mainPartsList = haksaengStatusService.selectMainPartsServiceList();
		
		model.addAttribute("mainPartsList", mainPartsList);
		
		return "haksaengStatus/multiSelectBox.tiles";
	}
	
	@RequestMapping(value = "/selectPartsDtl.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String selectPartsDtl(@RequestParam String partsCd) throws Exception {
			
		List<EgovMap> partsDtlList = haksaengStatusService.selectPartsDtlServiceList(partsCd);

		return JsonUtil.ListToJson(partsDtlList);
	}
	
	@RequestMapping(value = "/selectHaksaengStatusList.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String selectHaksaengStatusList(@RequestParam String param) throws Exception {
		
		EgovMap paramMap = new EgovMap();
		
		paramMap.put("classNm", param);
		
		List<EgovMap> haksaengList = haksaengStatusService.selectHaksaengStatusServiceList(paramMap);
		
		return JsonUtil.ListToJson(haksaengList);
	}
	
	@RequestMapping(value = "/multiSelectBox2.do")
	public String initMultiSelectBox2(ModelMap model) throws Exception {
		
		List<EgovMap> NikeClothesList = haksaengStatusService.selectNikeClothesServiceList();
		
		model.addAttribute("NikeClothesList", NikeClothesList);
		
		return "haksaengStatus/multiSelectBox2.tiles";
	}
	
	@RequestMapping(value = "/selectNikeClothesDtl.do")
	public void selectNikeClothesDtl(@RequestParam int cloNo, HttpServletResponse res) throws Exception {
			
		List<EgovMap> nikeClothesDtlList = haksaengStatusService.selectNikeClothesDtlServiceList(cloNo);
		
		res.setCharacterEncoding("utf-8");
		
		res.getWriter().write(JsonUtil.ListToJson(nikeClothesDtlList));	
	}
}
