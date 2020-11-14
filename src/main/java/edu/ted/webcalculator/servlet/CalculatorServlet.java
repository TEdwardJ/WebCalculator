package edu.ted.webcalculator.servlet;

import edu.ted.webcalculator.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {

    private CalculatorService service = new CalculatorService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        int operand2 = Integer.parseInt(req.getParameter("operand2"));
        String operation = req.getParameter("operation");
        String more = req.getParameter("more");
        if (operation.equals("add")) {
            int result = service.add(operand1, operand2);
            out.println(result);
        } else if (operation.equals("subtract")) {
            int result = service.subtract(operand1, operand2);
            out.println(result);
        } else if (operation.equals("multiply")) {
            int result = service.multiply(operand1, operand2);
            out.println(result);
        } else if (operation.equals("divide")) {
            double result = service.divide(operand1, operand2);
            out.println(result);
        }
        if (more.equals("1")) {
            out.println("<a href='/'>More</a>");
        }
        out.flush();
    }
}
