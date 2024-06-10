package com.example.ecommerce.modal.dto.search;

import com.example.ecommerce.modal.entity.Product;
import com.example.ecommerce.modal.entity.ShippingUnit;
import com.example.ecommerce.modal.entity.Status;
import com.example.ecommerce.modal.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchProduct {

    private String name;

    private Set<Status> status;

    private Set<ShippingUnit> shippingUnits;

    private Set<Type> types;


}
