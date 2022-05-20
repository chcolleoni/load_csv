package com.portfolio.loadcsv.repositories;

import com.portfolio.loadcsv.models.CarParts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICarPartsRepository extends JpaRepository<CarParts, UUID> {
}
