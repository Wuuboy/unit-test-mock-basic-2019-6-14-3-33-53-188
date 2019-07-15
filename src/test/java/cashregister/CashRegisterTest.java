package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        FakePrinter fakePrinter = new FakePrinter();
        CashRegister cashRegister = new CashRegister(fakePrinter);
        Item [] items = {new Item("apple",2.0)};
        Purchase purchase = new Purchase(items);
        //when
        cashRegister.process(purchase);
        //then
        assertTrue(fakePrinter.printMethodIsCalled());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        FakePrinter fakePrinter = new FakePrinter();
        CashRegister cashRegister = new CashRegister(fakePrinter);
        Item [] items = {new Item("apple",2.0)};
        FakePurchase fakePurchase = new FakePurchase(items);
        fakePurchase.setPurchaseString("TEST");
        //when
        cashRegister.process(fakePurchase);
        //then
        assertEquals(fakePurchase.asString(),fakePrinter.printedString());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("TEST");
        CashRegister cashRegister = new CashRegister(printer);
        //when
        cashRegister.process(purchase);
        //then
        verify(printer).print("TEST");
    }

}
