package sit.int202.toabin_quiz3.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.toabin_quiz3.entities.Drink;
import sit.int202.toabin_quiz3.repositories.DrinkRepository;

import java.io.IOException;
import java.util.List;

//Teeradet Panklai 63130500061
@WebServlet(name = "BeverageListServlet", value = "/beverage-list")
public class BeverageListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DrinkRepository drinkRepo = new DrinkRepository() ;
        List<Drink> drinks = drinkRepo.findAll() ;
        request.setAttribute("drinks", drinks);

        getServletContext().getRequestDispatcher("/toabin_beverage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
