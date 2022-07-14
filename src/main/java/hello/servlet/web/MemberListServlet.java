package hello.servlet.web;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("    <meta charset=\"UTF-8\">\n");
        w.write("    <title>Title</title>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<a href=\"/index.html\">메인</a>\n");
        w.write("<table>\n");
        w.write("    <thead>\n");
        w.write("    <th>id</th>\n");
        w.write("    <th>username</th>\n");
        w.write("    <th>age</th>\n");
        w.write("    </thead>\n");
        w.write("    <tbody>\n");

        for (Member member : members) {
            w.write("    <tr>\n");
            w.write("        <td>" + member.getId() + "</td>\n");
            w.write("        <td>" + member.getUsername() + "</td>\n");
            w.write("        <td>" + member.getAge() + "</td>\n");
            w.write("    </tr>\n");
        }
        w.write("    </tbody>\n");
        w.write("</table>\n");
        w.write("</body>\n");
        w.write("</html>\n");
    }
}
