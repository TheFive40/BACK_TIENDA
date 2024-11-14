package io.github.thefive40.back_tienda.service;

import io.github.thefive40.back_tienda.mapper.clients.COrderMapper;
import io.github.thefive40.back_tienda.model.dto.OrderDTO;
import io.github.thefive40.back_tienda.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private COrderMapper orderMapper;
    public List<OrderDTO> findByCity( String city){
        return orderMapper.toDtoList ( repository.findAllByCity ( city ) );
    }
}
