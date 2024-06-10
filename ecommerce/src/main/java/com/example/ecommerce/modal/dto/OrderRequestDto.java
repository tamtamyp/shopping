package com.example.ecommerce.modal.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderRequestDto {

    private int productId;
    private int accountId;

    @Positive
    private int quantityOrder;
}
