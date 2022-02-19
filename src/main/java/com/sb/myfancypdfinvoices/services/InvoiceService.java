package com.sb.myfancypdfinvoices.services;

import com.sb.myfancypdfinvoices.model.Invoice;
import com.sb.myfancypdfinvoices.model.User;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList; //Threadsafe Array list

public class InvoiceService {

    private final UserService userService;

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public InvoiceService(UserService userService)
    {
        this.userService = userService;
        System.out.println("InvoiceService: Created");
    }

    //To be used in case of GET calls
    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {

        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        // TODO real pdf creation and storing it on network server
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        System.out.println("New Invoice added; size of invoices is " + invoices.size());

        return invoice;
    }
}