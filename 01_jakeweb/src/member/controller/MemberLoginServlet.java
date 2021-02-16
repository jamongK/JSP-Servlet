package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * @WebServlet : web.xml에 serlvet, serlvet-mapping태그 등록을 대신해주는 annotation
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자 입력값 처리
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		
//		System.out.println("memberId@servlet = " + memberId);
//		System.out.println("password@servlet = " + password);
		
		// 3. 업무로직 : 사용자 아이디/비번이 DB에 저장된 값과 일치 여부 판단
		/**
		 * # 아이디로 member객체 조회해보자
		 * member객체가 존재할 경우
		 *	- 비밀번호가 일치하는 경우 --> 로그인 성공
		 *	- 비밀번호가 일치하지 않는 경우 --> 로그인 실패
		 * member객체가 존재하지 않을 경우 : 아이디 오류 --> 로그인 실패
		 */
		Member member = memberService.selectOne(memberId);
//		System.out.println("member@servlet = " + member);
		
		/* 로그인 성공 / 실패 메시지 지정 */
		if (member != null && password.equals(member.getPassword())) { // 로그인 성공
//			request.setAttribute("msg", "로그인 성공!"); --> 그냥 로그인 성공하면 alert창 안뜨게 하려고.
			
			/* JSP에서 로그인한 사용자의 정보를 출력하기 위해, memberLoggedIn이라는 이름으로 member를 request에 저장 */
			request.setAttribute("memberLoggedIn", member);
		} else { // 로그인 실패
			request.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			request.setAttribute("loc", request.getContextPath());
		}
		
		// 4. view단 처리 (JSP)
		request.getRequestDispatcher("/index.jsp")
			   .forward(request, response);
		
		/**
		 * 코드 쓰면서(특히 servlet 작성할때!)
		 * 서버에 [Started, Restart], [Started, Synchronized] 두가지 경우로 나타나는데,
		 * Synchronized면 변경사항이 동기화되어 잘 반영되고 있다는 것이고,
		 * Restart는 반영하려면 재시작이 필요하다는 뜻이다.
		 * Restart --> 서버 중단 후 시작버튼 다시 누르기!
		 */
		
	}

}
