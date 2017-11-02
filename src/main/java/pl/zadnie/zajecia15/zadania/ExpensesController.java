package pl.zadnie.zajecia15.zadania;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExpensesController {

    @Autowired
    private ExpensesRepository expensesRepository;

    @RequestMapping("/expense")
    @ResponseBody
    public String getAllExpenses(){
        List<Expenses> allExpenses = expensesRepository.getAllExpenses();
        String result="";
        double result2= 0;
        for (Expenses allExpens : allExpenses) {
            result += allExpens.toString()+ "</br>";
            result2 += allExpens.getPrice();

        }
        return result + "Sum of all expenses: " + result2;

    }

    @PostMapping("/add")
    public String addExpenses(@RequestParam String name, double price, String category){
        Expenses expense = new Expenses(name, price, category);
        expensesRepository.addExpenses(expense);
        return "redirect:/expense";
    }

    @GetMapping("/category")
    @ResponseBody
    public String categoryExpenses(@RequestParam String category){
        List<Expenses> allExpenses = expensesRepository.getAllExpenses();
        String result="";
        double result2= 0;
        for (Expenses allExpens : allExpenses) {
            if (allExpens.getCategory().equals(category)) {
                result += allExpens.toString()+ "</br>";
                result2 += allExpens.getPrice();
            }
        }
        return result + "Sum of all expenses: " + result2;
    }

}
