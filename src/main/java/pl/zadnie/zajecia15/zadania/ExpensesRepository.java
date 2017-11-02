package pl.zadnie.zajecia15.zadania;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpensesRepository {

    private List<Expenses> expenses;

    public ExpensesRepository() {
        expenses = new ArrayList<>();
    }

    public List<Expenses> getAllExpenses(){
        return expenses;

    }

    public void addExpenses (Expenses expense){
        expenses.add(expense);
    }

}
