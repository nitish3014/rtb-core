package com.rtb.core.repository;

import com.rtb.core.entity.tenant.QuickSightDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuickSightDashboardRepository extends JpaRepository<QuickSightDashboard, UUID> {
    List<QuickSightDashboard> findByCategory(String category);

    Optional<QuickSightDashboard> findByCategoryAndReportName(String categoryName,
                                                             String reportName);
}
