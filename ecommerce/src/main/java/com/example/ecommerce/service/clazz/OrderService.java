package com.example.ecommerce.service.clazz;

import com.example.ecommerce.exception.AppException;
import com.example.ecommerce.modal.dto.OrderRequestDto;
import com.example.ecommerce.modal.entity.Account;
import com.example.ecommerce.modal.entity.Order;
import com.example.ecommerce.modal.entity.OrderStatus;
import com.example.ecommerce.modal.entity.Product;
import com.example.ecommerce.repository.AccountRepo;
import com.example.ecommerce.repository.OrderRepo;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.service.implement.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private  AccountRepo accountRepo;
    @Autowired
    private  ProductRepo productRepo;
    @Autowired
    private  OrderRepo orderRepo;


    @Override
    public void create(OrderRequestDto dto) {
        Optional<Account> optionalAccount = accountRepo.findById(dto.getAccountId());
        if(optionalAccount.isEmpty()){
            throw new AppException(404, "Not Found User");
        }

        Optional<Product> optionalProduct = productRepo.findById(dto.getProductId());
        if(optionalProduct.isEmpty()){
            throw new AppException(404, "Not Found Product");
        }

        if (dto.getQuantityOrder() <= optionalProduct.get().getQuantity()) {
            Account account = optionalAccount.get();
            Product product = optionalProduct.get();

//            TẠO RA MỘT ORDER MỚI
            Order order = new Order();
            order.setAccount(account);
            order.setProduct(product);
            order.setOrderStatus(OrderStatus.PENDING);
            order.setQuantity(dto.getQuantityOrder());
            orderRepo.save(order);

//            CẬP NHẬT LẠI DATA CỦA SỐ LƯỢNG PRODUCT SAU KHI USER ĐÃ MUA HÀNG

            int updateQuantity = product.getQuantity() - dto.getQuantityOrder();

            product.setQuantity(updateQuantity);
            productRepo.save(product);

        } else {
            throw new AppException(505, "Qua so luong dat hang");
        }
    }

    @Override
    public Order buyProduct(int orderId) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setOrderStatus(OrderStatus.DONE);
            return orderRepo.save(order);

        }
        return null;
    }

    @Override
    public Order cancelProduct(int orderId) {
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setOrderStatus(OrderStatus.CANCEL);
            return orderRepo.save(order);

        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> findByStatus(OrderStatus oderStatus, int accountId) {
        return null;
    }

    @Override
    public Page<Order> history(Account account,Pageable pageable) {
        return orderRepo.findByAccount(account, pageable);
    }
}
