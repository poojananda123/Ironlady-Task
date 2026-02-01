package servlet;

//LearnerListServlet.java
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.LearnerDAO;
import model.Learner;
@WebServlet("/dashboard")
public class LearnerListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // SESSION CHECK
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // FETCH LEARNERS
        LearnerDAO dao = new LearnerDAO();
        List<Learner> learners = dao.getAllLearners();

        // SEND TO JSP
        request.setAttribute("list", learners);
        RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
        rd.forward(request, response);
    }
}

