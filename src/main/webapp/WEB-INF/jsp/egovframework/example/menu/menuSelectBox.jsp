<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

function createOpts(menuDtlArr) {
	var optStr 		= "",	// 셀랙트박스에 들어갈 html 스트링
		$menuDtlID = $("#menuDtl"); 
	
	// 데이터를 지우지 않으면 두번째 셀랙트박스는 계속 쌓이기만 한다
	$menuDtlID.children("option").remove();
	
	// 데이터가 없을 시 없음 옵션을 넣어주기 위한 if문
	if (menuDtlArr.length > 0) {
		
		menuDtlArr.forEach(function(map, i) {
			optStr = "<option value=" + map.menuCd + ">" + map.menuNm + "</option>";
			
			$menuDtlID.append(optStr);
		});
	} else {
		optStr = "<option>없음</option>";
		
		$menuDtlID.append(optStr);
	}

	$menuDtlID.selectric("refresh");
}

$(function() {
	$(".sel").selectric();
	
	$("#menuCat").change(function () {
		
		// data는 두번째 셀랙트 where 조건인 메뉴 분류코드다(첫번째 셀랙트박스 선택값)
		$.ajax({
			url		: "/selectMenuDtl.do",
			data 	: {menuCatCd : $("#menuCat").val()},
			
			success : function (menuDtlObj) {
				
				// 두번째 셀랙트박스 데이터를 생성하는 함수
				createOpts(menuDtlObj);
			}
		})
	});
});

</script>

<div id="contents">
	<table class="tbl type02">	
		<tbody> 
			<tr>
				<th scope="row">메뉴 분류</th>
				<td class="ta-l">
					<select id="menuCat" name="menuCat" class="sel short">
						<option>없음</option>
						<c:forEach items="${menuCatList}" var="menuCatInfo" varStatus="status">
							<option value="${menuCatInfo.menuCatCd}"><c:out value="${menuCatInfo.menuCatNm}" /></option>
						</c:forEach>
					</select>
					<select id="menuDtl" name="menuDtl" class="sel middle">
						<option>없음</option>
					</select>        
				</td>   
			</tr>
		</tbody>
	</table>
</div>

