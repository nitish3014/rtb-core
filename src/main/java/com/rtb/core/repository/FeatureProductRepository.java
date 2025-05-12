package com.rtb.core.repository;

import com.rtb.core.entity.user.FeatureProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeatureProductRepository extends JpaRepository<FeatureProduct, Long> {
    List<FeatureProduct> findByProductId(String productId);
}
