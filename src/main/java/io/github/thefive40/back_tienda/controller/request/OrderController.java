package io.github.thefive40.back_tienda.controller.request;

import io.github.thefive40.back_tienda.model.dto.OrderDTO;
import io.github.thefive40.back_tienda.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/orders")
public class OrderController {
    @Autowired
    private OrderService service;
    @GetMapping("/city/{city}")
    public List<OrderDTO> findByCity( @PathVariable String city){
        return service.findByCity ( city );
    }
}
