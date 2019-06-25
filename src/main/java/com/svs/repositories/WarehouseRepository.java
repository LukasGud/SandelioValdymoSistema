package com.svs.repositories;

import com.svs.domain.Warehouse;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Warehouse findWarehouseByNameOfStock(String nameOfStock);

    @Override
    List<Warehouse> findAll(Sort sort);
}
