package servlet.filter;

import dao.MyDataSource;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter",urlPatterns = "/")
public class AuthFilter implements Filter {

    UserService userService = new UserService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        MyDataSource.init();
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        System.out.println("filter");
        System.out.println(login);
        System.out.println(password);
        final HttpSession session = req.getSession();

        String role = "unknown";
        long id = userService.getId(login);
        if (id > 0 && userService.isCorrectPassword(id, password)) {
            role = userService.getRoleById(id);
            req.getSession().setAttribute("id_user", id);// get id
        }
        moveToMenu(req, res, role);
    }

    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final String role)
            throws ServletException, IOException {

        if (role.equals("admin")) {
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);
        } else if (role.equals("user")) {
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }
}
