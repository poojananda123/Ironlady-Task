package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LearnerDAO;
import model.Learner;

@WebServlet("/edit")
public class UpdateLearnerServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest req, HttpServletResponse res)
//            throws IOException {
//        Learner l = new Learner();
//        l.setId(Integer.parseInt(req.getParameter("id")));
//        l.setName(req.getParameter("name"));
//        l.setEmail(req.getParameter("email"));
//        l.setPhone(req.getParameter("phone"));
//        l.setProgram(req.getParameter("program"));
//        l.setStatus(req.getParameter("status"));
//
//        new LearnerDAO().updateLearner(l);
//        res.sendRedirect("view");
//    }
//}

protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

    int id = Integer.parseInt(req.getParameter("id"));

    LearnerDAO dao = new LearnerDAO();
    Learner learner = dao.getLearnerById(id);

    req.setAttribute("learner", learner);
    req.getRequestDispatcher("edit.jsp").forward(req, res);
}

// 2️⃣ Update learner (POST)
protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

    Learner l = new Learner();
    l.setId(Integer.parseInt(req.getParameter("id")));
    l.setName(req.getParameter("name"));
    l.setEmail(req.getParameter("email"));
    l.setPhone(req.getParameter("phone"));
    l.setProgram(req.getParameter("program"));
   // l.setStatus(req.getParameter("status"));
    String program = req.getParameter("program");
    if(program != null && !program.trim().isEmpty()) {
        l.setStatus("Enrolled");
    } else {
        l.setStatus("Enquired");
    }
    LearnerDAO dao = new LearnerDAO();
    dao.updateLearner(l);

    res.sendRedirect("view");
}
}