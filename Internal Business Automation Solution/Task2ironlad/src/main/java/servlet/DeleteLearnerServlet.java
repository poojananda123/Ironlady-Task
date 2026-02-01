package servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.LearnerDAO;

@WebServlet("/delete")
public class DeleteLearnerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if(idStr != null) {
            int id = Integer.parseInt(idStr);
            LearnerDAO dao = new LearnerDAO();
            dao.deleteLearner(id); // Make sure DAO method exists
        }
        response.sendRedirect("view"); // Redirect back to dashboard
    }
}

