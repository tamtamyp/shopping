package com.example.ecommerce.service.implement;

import com.example.ecommerce.modal.dto.ProducCreatetRequestDto;
import com.example.ecommerce.modal.dto.ProductUpdateRequestDto;
import com.example.ecommerce.modal.dto.search.SearchProduct;
import com.example.ecommerce.modal.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    Page<Product> getAll(Pageable pageable);

    Product create(ProducCreatetRequestDto dto);

    Product get_by_id(int id);

    Page<Product> search(SearchProduct request, Pageable pageable);

    Product update(ProductUpdateRequestDto dto);

    void delete(int id);
}
