package com.example.ecommerce.modal.dto;

import com.example.ecommerce.modal.entity.ShippingUnit;
import com.example.ecommerce.modal.entity.Status;
import com.example.ecommerce.modal.entity.Type;
import lombok.Data;

@Data
public class ProductUpdateRequestDto {

    private int id;
    private Type type;
    private String name;
    private int price;
    private Status status;
    private ShippingUnit shippingUnit;
    private int quantity;
}
