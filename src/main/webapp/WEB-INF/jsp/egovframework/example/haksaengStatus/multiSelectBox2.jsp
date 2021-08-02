<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

function createOpts(d) {
	var nikeClothesDtlArr = JSON.parse(d);
	
	$("#NikeClothesDtl > option").remove();
	
	if (nikeClothesDtlArr.length > 0) {
		
		nikeClothesDtlArr.forEach(function(map, i) {
			var optStr = "<option value=" + map.cloDelNo + ">" + map.cloDelNm + "</option>";
			
			$("#NikeClothesDtl").append(optStr);
		});
	} else {
		var optStr = "<option>없음</option>";
		
		$("#NikeClothesDtl").append(optStr);
	}

	$("#NikeClothesDtl").selectric("refresh");
}

$(function () {
	$(".sel").selectric();
	
	$("#NikeClothes").change(function () {
		
		$.ajax({
			url 	: "/selectNikeClothesDtl.do",
			data 	: {
						cloNo : $("#NikeClothes").val()
					  },
			
			success : function (d) {
				
				createOpts(d);
			}
		});
	})
});

</script>

<div id="contents">
	<table class="tbl type02">	
		<tbody> 
			<tr>
				<th scope="row">옷 상세 검색</th>
				<td class="ta-l">
					<select id="NikeClothes" name="NikeClothes" class="sel short">
						<option>없음</option>
						<c:forEach items="${NikeClothesList}" var="NikeClothes" varStatus="status">
							<option value="${NikeClothes.cloNo}"><c:out value="${NikeClothes.cloNm}" /></option>
						</c:forEach>
					</select>
					<select id="NikeClothesDtl" name="NikeClothesDtl" class="sel middle">
						<option>없음</option>
					</select>        
				</td>   
			</tr>
		</tbody>
	</table>
</div>

