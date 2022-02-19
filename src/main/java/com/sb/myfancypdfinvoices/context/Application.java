package com.sb.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.myfancypdfinvoices.services.InvoiceService;
import com.sb.myfancypdfinvoices.services.UserService;

public class Application {

    public static final UserService userService = new UserService();
    public static final InvoiceService invoiceService = new InvoiceService(userService);
    public static final ObjectMapper objectMapper = new ObjectMapper();
}