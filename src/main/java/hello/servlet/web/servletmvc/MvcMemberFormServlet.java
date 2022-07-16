package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MVC 패턴 적용
 * 서블릿: 컨트롤러
 * JSP: 뷰
 * 모델: HttpServletRequest 객체
 * (request는 내부에 데이터 저장소를 갖고 있는데,
 * request.setAttribute(), request.getAttribute()를 사용하면 데이터를 보관하고 조회 가능)
 */
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    /**
     * 클라이언트에서 MvcMemberFormServlet 호출
     * MvcMemberFormServlet의 service에서 jsp 호출(forward이기 때문에 서버 내부에서 호출한다.)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * WEB-INF 이 경로안에 JSP가 있으면 외부에서 직접 JSP를 호출할 수 없다.
         * 항상 컨트롤러를 통해서 JSP를 호출하는 것
         */
        String viewPath ="/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        /**
         * 다른 서블릿이나 JSP로 이동할 수 있는 기능이다.
         * 서버 내부에서 호출이 발생
         */
        dispatcher.forward(request, response);

        /**
         * redirect vs forward
         * 리다이렉트는 실제 클라이언트에 응답이 나갔다가, 클라이언트가 리다이렉트 경로로 다시 요청한다.
         * 따라서 클라이언트가 인지할 수 있고, URL 경로도 실제로 변경
         * 반면에, 포워드는 서버 내부에서 일어나는 호출이기 때문에 클라이언트가 인식 할 수 없다.
         */
    }
}
