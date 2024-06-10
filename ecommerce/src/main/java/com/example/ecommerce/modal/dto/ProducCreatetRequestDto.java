package com.example.ecommerce.modal.dto;

import com.example.ecommerce.modal.entity.ShippingUnit;
import com.example.ecommerce.modal.entity.Status;
import com.example.ecommerce.modal.entity.Type;
import lombok.Data;

@Data
public class ProducCreatetRequestDto {

    private String name;
    private Type type;
    private Status status;
    private int price;
    private ShippingUnit shippingUnit;
    private int quantity;
}
