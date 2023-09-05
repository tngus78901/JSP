<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<script>
	$(function(){
		
		$('.btnNext').click(function(){
			
			const chk1 = $('input[name=chk1]').is(':checked');
			const chk2 = $('input[name=chk2]').is(':checked');
			
			if(!chk1){
				alert('사이트 이용약관에 동의체크 하시기 바랍니다.');
				return false;
			}
			
			if(!chk2){
				alert('개인정보 취급방침 약관에 동의체크 하시기 바랍니다.');
				return false;
			}	
			
			return true;
		});
	});

</script>
<div id="user">
	<section class="terms">
        <table>
            <caption>사이트 이용약관</caption>
            <tr>
                <td>
                    <textarea readonly>${dto.terms}</textarea>
                    <p>
                        <label><input type="checkbox" name="chk1"/>동의합니다.</label>
                    </p>
                </td>
            </tr>
        </table>
        <table>
            <caption>개인정보 취급방침</caption>
            <tr>
                <td>
                    <textarea readonly>${dto.privacy}</textarea>
                    <p>
                        <label><input type="checkbox" name="chk2"/>동의합니다.</label>
                    </p>
                </td>
            </tr>
        </table>
        <div>
        	<!-- 
				ctxPath
				 - Context Root 경로 전역변수 
				 - _header.jsp 5줄 참고
			-->
            <a href="${ctxPath}/user/login.do" class="btnCancel">취소</a>
            <a href="${ctxPath}/user/register.do" class="btnNext">다음</a>
        </div>
    </section>
</div>
<%@ include file="../_footer.jsp" %>