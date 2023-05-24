package edu.bzu.ecommerce.service;

import edu.bzu.ecommerce.model.Order;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Validated
public interface OrderService {

    @NotNull Iterable<Order> getAllOrders();

    Iterable<Order> GetAllOrdersByStatusAndDateCreatedGreaterThan();

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}
