package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LearnerDAO;
import model.Learner;

@WebServlet("/add")
public class AddLearnerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        Learner l = new Learner();
        l.setName(req.getParameter("name"));
        l.setEmail(req.getParameter("email"));
        l.setPhone(req.getParameter("phone"));
        l.setProgram(req.getParameter("program"));
        //l.setStatus(req.getParameter("status"));
        String program = req.getParameter("program");
        if(program != null && !program.trim().isEmpty()) {
            l.setStatus("Enrolled");
        } else {
            l.setStatus("Enquired");
        }
        new LearnerDAO().addLearner(l);
        res.sendRedirect("view");
    }
}

