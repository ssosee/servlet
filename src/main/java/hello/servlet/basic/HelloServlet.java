package hello.servlet.basic;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    /***
     * 서블릿이 호출되면
     * 아래 서비스 메서드가 호출된다.
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        super.service(req, resp);
//        System.out.println("req = " + req);
//        System.out.println("resp = " + resp);
//
//        String username = req.getParameter("username");
//        System.out.println("username = " + username);
//
//        resp.setContentType("text/plain");
//        resp.setCharacterEncoding("utf-8");
//        resp.getWriter().write("hello "+username); //http body에 데이터 삽입
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("HelloServlet.init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.doPost");
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet.destroy");
    }
}
