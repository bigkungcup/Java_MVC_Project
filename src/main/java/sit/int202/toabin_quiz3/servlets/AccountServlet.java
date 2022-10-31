package sit.int202.toabin_quiz3.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.toabin_quiz3.entities.Account;
import sit.int202.toabin_quiz3.repositories.AccountRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

//Teeradet Panklai 63130500061
@WebServlet(name = "AccountServlet", value = "/account")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");

            if(action != null && action.equals("logout")){

                HttpSession session = request.getSession(false);

                if(session != null){
                    session.invalidate();
                }
                response.sendRedirect("beverage-list");
                return;
            }
            response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobileNo = request.getParameter("mobileno");
        String pinCode = request.getParameter("pincode");

        if(mobileNo != null && mobileNo.trim().length() > 0 && pinCode != null && pinCode.trim().length() >0){

            AccountRepository accountRepo = new AccountRepository();
            Account account = accountRepo.find(mobileNo);
            if(account != null){
                if(sha256(pinCode).equals(account.getPinCode())){
                HttpSession session = request.getSession(true);
                if(session.getAttribute("account") == null){
                    session.setAttribute("account", account);
                }
                response.sendRedirect("beverage-list");
                return;
                }
            }
        }
        response.sendRedirect("login.jsp");
    }

    private String sha256(final String base) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
