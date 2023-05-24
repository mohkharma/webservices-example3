package edu.bzu.ecommerce.service;

import edu.bzu.ecommerce.model.OrderProduct;
import org.springframework.validation.annotation.Validated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}
