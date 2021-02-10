# JSP
: Java Server Page, 
주로, WEB-INF에 두고 관리함.
JSP에서는 HttpServletRequest, HttpServletResponse객체에 선언없이 접근할 수 있다.

```
// JSP 시작부분에 있는 아래 코드
<%@ //page 지시자 %>

<% //스크립틀릿(scriptlet) %>

<%= //JSP 표현식 %>

<%-- JSP 주석 --%>
```

1. **page 지시자** : JSP 파일 정보(설정) 나타내는 곳
2. **스크립틀릿** : Java코드를 적는 곳
3. **JSP 표현식** : 변수, 메소드의 리턴 값 등을 출력할 때 사용. ; (세미콜론 사용 금지)

&nbsp;

# Dynamic Web Project
Dynamic Web Project는 두 개의 라이브러리를 참조해야 함.
- jdk(JRE System Library)
- SRE(Server Runtime Environment;서버실시간실행환경이라고 이해하면 됨.)

HttpServlet, GenericServlet, Servlet 클래스는 톰캣 라이브러리 jar안에 있음.

&nbsp;

### ETC.
1. x 표시 에러가 아닌 ! 느낌표 에러가 났을 때

    → 참조하고 있는 라이브러리에 문제가 있다는 뜻.
2. 프로젝트명 클릭 → ```Alt + Enter``` → 해당 프로젝트에 대한 Properties 창이 뜸.