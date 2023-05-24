package edu.bzu.ecommerce.service;

import edu.bzu.ecommerce.model.Order;
import edu.bzu.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Iterable<Order> GetAllOrdersByStatusAndDateCreatedGreaterThan() {
        //try all these methods

//        return orderRepository.findAllNative();
        return orderRepository.findAllExceptWithParam(1L);
//        return orderRepository.findAllExcept(1L);
//        return orderRepository.findAllByStatusAndDateCreatedLessThan(OrderStatus.PAID.name(), LocalDate.now());
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
