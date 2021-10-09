package br.com.codenation;

import br.com.codenation.model.OrderItem;
import br.com.codenation.service.OrderService;
import br.com.codenation.service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(1l, 3l));
        items.add(new OrderItem(5l, 2l));
        System.out.println(orderService.calculateOrderValue(items));
    }
}
