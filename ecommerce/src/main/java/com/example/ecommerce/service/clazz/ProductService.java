package com.example.ecommerce.service.clazz;

import com.example.ecommerce.exception.AppException;
import com.example.ecommerce.modal.dto.ProducCreatetRequestDto;
import com.example.ecommerce.modal.dto.ProductUpdateRequestDto;
import com.example.ecommerce.modal.dto.search.SearchProduct;
import com.example.ecommerce.modal.entity.Product;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.search.ProductSearch;
import com.example.ecommerce.service.implement.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private  ProductRepo productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product create(ProducCreatetRequestDto dto) {
        Product entity = new Product();
        BeanUtils.copyProperties(dto, entity);
        return productRepository.save(entity);
    }

    @Override
    public Product get_by_id(int id) {
        Optional<Product> findByid = productRepository.findById(id);
        if (findByid.isEmpty()) {
            throw new AppException(404, "Product not found");

        }
        return findByid.get();
    }

    @Override
    public Page<Product> search(SearchProduct request, Pageable pageable) {

            Specification<Product> condition = ProductSearch.buildCondition(request);


        return productRepository.findAll(condition, pageable);
    }


    @Override
    public Product update(ProductUpdateRequestDto dto) {
        Product entity = new Product();
        BeanUtils.copyProperties(dto, entity);
        return productRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }else {

            throw new AppException(404, "User not found");
        }
    }
}
