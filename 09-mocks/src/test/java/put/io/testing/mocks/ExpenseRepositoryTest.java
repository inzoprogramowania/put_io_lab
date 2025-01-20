package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        ExpenseRepository expenseRepository = new ExpenseRepository(new MyDatabase());
        expenseRepository.loadExpenses();
        assertEquals(0, expenseRepository.getExpenses().size());
    }

    @Test
    void loadExpenses2() {
        IFancyDatabase mock_obj = mock(IFancyDatabase.class);
        when(mock_obj.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository expenseRepository = new ExpenseRepository(mock_obj);
        expenseRepository.loadExpenses();
        InOrder inOrder = inOrder(mock_obj);
        inOrder.verify(mock_obj).connect();
        inOrder.verify(mock_obj).queryAll();
        inOrder.verify(mock_obj).close();

        assertEquals(0,expenseRepository.getExpenses().size());

    }

    @Test
    void saveExpenses() {
        IFancyDatabase mock_obj = mock(IFancyDatabase.class);
        when(mock_obj.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository expenseRepository = new ExpenseRepository(mock_obj);

        expenseRepository.addExpense(new Expense());
        expenseRepository.saveExpenses();
        InOrder inOrder = inOrder(mock_obj);
        inOrder.verify(mock_obj).connect();
        inOrder.verify(mock_obj).persist(any(Expense.class));
        inOrder.verify(mock_obj).close();

        verify(mock_obj,atLeastOnce()).persist(any(Expense.class));

        assertEquals(1,expenseRepository.getExpenses().size());
    }

    @Test
    void saveExpenses2() {
        IFancyDatabase mock_obj = mock(IFancyDatabase.class);
        when(mock_obj.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository expenseRepository = new ExpenseRepository(mock_obj);

        for (int i = 0; i < 5; i++) {
            expenseRepository.addExpense(new Expense());
        }
        expenseRepository.saveExpenses();

        verify(mock_obj, times(5)).persist(any(Expense.class));
        assertEquals(5,expenseRepository.getExpenses().size());
    }



}
