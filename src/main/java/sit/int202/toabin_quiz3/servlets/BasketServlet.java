package sit.int202.toabin_quiz3.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.toabin_quiz3.entities.Account;
import sit.int202.toabin_quiz3.entities.Drink;
import sit.int202.toabin_quiz3.entities.Transaction;
import sit.int202.toabin_quiz3.repositories.AccountRepository;
import sit.int202.toabin_quiz3.repositories.DrinkRepository;
import sit.int202.toabin_quiz3.repositories.TransactionRepository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//Teeradet Panklai 63130500061
@WebServlet(name = "BasketServlet", value = "/basket")
public class BasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String strid = request.getParameter("id");

        HttpSession session = request.getSession(false);
        Account account = (Account) session.getAttribute("account");

        TransactionRepository transactionRepo = new TransactionRepository();
        AccountRepository accountRepo = new AccountRepository();
        DrinkRepository drinkRepo = new DrinkRepository();

        if (action != null && action.equals("buy")) {
            Long id = Long.parseLong(strid);
            Drink drink = drinkRepo.find(id);
            request.setAttribute("drink", drink);
            getServletContext().getRequestDispatcher("/basket.jsp").forward(request, response);
            return;
        } else if (action != null && action.equals("buyDrink") && session.getAttribute("account") == null) {
            response.sendRedirect("login.jsp");
            return;
        } else if (action != null && action.equals("buyDrink")) {
            Long id = Long.parseLong(strid);
            Drink drink = drinkRepo.find(id);
            Transaction transaction = new Transaction();
            try{
                Date tranDate = new Date();
                transaction.setPrice(drink.getPrice());
                transaction.setAmount(drink.getPrice());
                transaction.setDrinkId(drink);
                transaction.setQty(1);
                transaction.setAccountNo(account);
                transaction.setTranDate(tranDate);
                List<Transaction> transactionList = transactionRepo.findAll();
                transactionList.add(transaction);
                account.setTransactions(transactionList);
                account.setLastBuy(tranDate);
                account.setTotalAmount(account.getTotalAmount() + drink.getPrice());
                accountRepo.update(account);
                response.sendRedirect("basket");
                return;
            }catch (Exception ex){
                System.out.println("---------------------" + ex.getMessage());
            }
        } else {
            request.setAttribute("account", account);
            getServletContext().getRequestDispatcher("/account.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("beverage-list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
