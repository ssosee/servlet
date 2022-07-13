package hello.servlet.basic.request;

import org.springframework.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/***
 * 파라미터 전송 기능
 * http://localhost:9090/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "="+request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end\n");

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = "+age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String [] usernames = request.getParameterValues("username");
        for(String s : usernames) {
            System.out.println("username = "+s);
        }
        response.getWriter().write("ok");
    }
}
