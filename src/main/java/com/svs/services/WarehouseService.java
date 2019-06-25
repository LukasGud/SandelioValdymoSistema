package com.svs.services;

import com.svs.domain.Warehouse;
import com.svs.exceptions.ProjectException;
import com.svs.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse saveOrUpdate(Warehouse warehouse) {
        try {
            warehouse.setNameOfStock(warehouse.getNameOfStock().toUpperCase());
            return warehouseRepository.save(warehouse);
        } catch (Exception e) {
            throw new ProjectException("Storage with a name '" + warehouse.getNameOfStock().toUpperCase() + "'already exists");
        }
    }

    public Warehouse findWarehouseByNameOfStock(String nameOfStock) {
        Warehouse warehouse = warehouseRepository.findWarehouseByNameOfStock(nameOfStock.toUpperCase());

        if (warehouse == null) {
            throw new ProjectException("Stock with a  name '" + nameOfStock + "'does not exist");
        }
        return warehouse;
    }

    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    public void deleteWarehouseByNameOfStock(String nameOfStock) {
        Warehouse warehouse = warehouseRepository.findWarehouseByNameOfStock(nameOfStock.toUpperCase());
        if (warehouse == null) {
            throw new ProjectException("Stock with a  name '" + nameOfStock + "'does not exist");
        }
        warehouseRepository.delete(warehouse);
    }

}
