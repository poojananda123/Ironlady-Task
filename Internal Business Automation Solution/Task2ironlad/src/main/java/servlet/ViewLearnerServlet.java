package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LearnerDAO;
import model.Learner;

@WebServlet("/view")
public class ViewLearnerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        List<Learner> list = new LearnerDAO().getAllLearners();
        req.setAttribute("list", list);
        req.getRequestDispatcher("view-learners.jsp").forward(req, res);
    }
}

