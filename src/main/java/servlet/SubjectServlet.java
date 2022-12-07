package servlet;

import dao.MyDataSource;
import model.Subject;
import service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubjectServlet", value = "/sub")
public class SubjectServlet extends HttpServlet {
    SubjectService subjectService = new SubjectService();

    @Override
    public void init() throws ServletException {
        MyDataSource.init();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        List<Subject> all = subjectService.getAll();

        req.setAttribute("sub", all);
        req.getRequestDispatcher("/WEB-INF/view/sub.jsp").forward(req,resp);

    }


}
