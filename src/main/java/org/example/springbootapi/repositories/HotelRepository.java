package org.example.springbootapi.repositories;

import org.example.springbootapi.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByEstrellasGreaterThanEqual(int estrellas);
}
