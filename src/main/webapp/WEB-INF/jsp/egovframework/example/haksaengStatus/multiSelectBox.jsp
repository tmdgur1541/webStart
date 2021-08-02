<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

function createOpts(partsDtlArr) {
	var optStr 		= "", // 부품상세 옵션 태그 추가할때 넣을 변수
		$partsDtlID = $("#partsDtl"); // 아이디가 partsDtl인 태그를 쿼리형변수 
	
		$partsDtlID.children("option").remove();
	
	if (partsDtlArr.length > 0) {
		
		// 부품상세 옵션 출력을 위한 반복문
		partsDtlArr.forEach(function(map, i) {
			optStr = "<option value=" + map.optCd + ">" + map.optNm + "</option>";
			
			$partsDtlID.append(optStr);
		});
	} else {
		optStr = "<option>없음</option>";
		
		$partsDtlID.append(optStr);
	}

	$partsDtlID.selectric("refresh");
}

$(function() {
	$(".sel").selectric(); // 클래스명이sel인 태그 들을 찾아서 .selectric()태그들을 꾸며주어라
	
	// 아이디명이 partsMst태그를 클릭하면 실행 되는 부분
	$("#partsMst").change(function() {
		
		$.ajax({
			url 		: "/selectPartsDtl.do",
			data 		: {partsCd : $("#partsMst").val()},
			
			success : function (partsDtlObj) {

				createOpts(partsDtlObj);
			},
			
			error : function (res, errorStatus, errorMsg) {
				console.log(res);
				console.log(errorStatus);
				console.log(errorMsg);
			}
		});
	})
});

</script>

<div id="contents">
	<table class="tbl type02">	
		<tbody> 
			<tr>
				<th scope="row">컴퓨터 부품 선택</th>
				<td class="ta-l">
					<select id="partsMst" name="partsMst" class="sel short">
						<option>없음</option>
						<c:forEach items="${mainPartsList}" var="mainPartsInfo" varStatus="status">
							<option value="${mainPartsInfo.partsCd}"><c:out value="${mainPartsInfo.partsNm}" /></option>
						</c:forEach>
					</select>
					<select id="partsDtl" name="partsDtl" class="sel middle">
						<option>없음</option>
					</select>        
				</td>   
			</tr>
		</tbody>
	</table>
</div>

