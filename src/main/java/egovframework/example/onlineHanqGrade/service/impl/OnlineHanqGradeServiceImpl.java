package egovframework.example.onlineHanqGrade.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.onlineHanqGrade.service.OnlineHanqGradeService;

@Service
public class OnlineHanqGradeServiceImpl implements OnlineHanqGradeService{
	
	@Resource
	OnlineHanqGradeMapper onlineHanqGradeMapper;

	@Override
	public List<String> selectonlineHanqGradeList() throws Exception {
		return onlineHanqGradeMapper.selectonlineHanqGradeList();
	}

}
