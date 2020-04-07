package ui;

import domain.FilmDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ui.Servlet")
public class Servlet extends HttpServlet {

    private FilmDB filmDB = new FilmDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = "overzicht.jsp";
        request.setAttribute("alleFilms", filmDB.vindAlle());
        request.setAttribute("langsteSpeelduur", filmDB.filmMetLangsteSpeelduur());

        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }
}
