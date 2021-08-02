package egovframework.example.onlineHanqGrade.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface OnlineHanqGradeMapper {

	List<String> selectonlineHanqGradeList() throws Exception;

}
