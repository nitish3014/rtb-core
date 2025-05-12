package com.rtb.core.repository;

import com.rtb.core.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Modifying
    @Query("DELETE FROM Address a WHERE a.id = :id")
    void deleteById(Long id);
}
