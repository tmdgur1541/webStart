package egovframework.example.onlineHanqGrade.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.onlineHanqGrade.service.OnlineHanqGradeService;

@Controller
public class OnlineHanqGradeController {

	@Resource
	OnlineHanqGradeService onlineHanqGradeService;
	
	@RequestMapping(value = "/intiOnlineHanqGrade.do")
	public String intiOnlineHanqGrade() throws Exception {
		
		List<String> hanqGradeList = onlineHanqGradeService.selectonlineHanqGradeList();
		
		return null;
	}
}
