package edu.bzu.ecommerce.repository;

import edu.bzu.ecommerce.model.OrderProduct;
import edu.bzu.ecommerce.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {

}
