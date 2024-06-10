package com.example.ecommerce.search;

import com.example.ecommerce.modal.dto.search.SearchProduct;
import com.example.ecommerce.modal.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSearch {

    public static Specification<Product> buildCondition (SearchProduct searchProduct) {

        return Specification.where(buildConditionName(searchProduct)
        .or(buildConditionStatus(searchProduct)));

    }

    public static Specification<Product> buildConditionName(SearchProduct request) {
        if (request.getName() != null && !"".equals(request.getName())) {
//            Tạo điều kiện tìm kiếm với titleName
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.like(root.get("name"), "%" + request.getName() + "%");
            };

        } else {
            return null;
        }
    }

    public static Specification<Product> buildConditionStatus(SearchProduct request) {
        if (request.getStatus() != null && request.getStatus().size() > 0) {
            //             TẠO ĐIỀU KIỆN VỚI STATUS
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
//                CÁCH 1: SỬ DỤNG EQUAL ĐỂ LẤY RA GIÁ TRỊ TRONG ROOT,
//                return cri.equal(root.get("status"), request.getStatus());

//                CÁCH 2: TẠO ĐIỀU KIỆN TÌM KIẾM VỚI STATUS.    STATUS TRẢ VỀ SẼ LÀ 1 TRONG CÁC GIÁ TRỊ MÀ MÌNH TRUYỀN VÀO
                return root.get("status").in(request.getStatus());
            };
        } else {
            return null;
        }
    }
}
