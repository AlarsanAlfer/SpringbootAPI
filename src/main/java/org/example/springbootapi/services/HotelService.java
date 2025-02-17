package org.example.springbootapi.services;

import jakarta.transaction.Transactional;
import org.example.springbootapi.models.Hotel;
import org.example.springbootapi.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findAllHoteles() {
        return hotelRepository.findAll();
    }

    public Hotel findHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Transactional
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Transactional
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    public List<Hotel> findHotelsByMinStars(int stars) {
        return hotelRepository.findByEstrellasGreaterThanEqual(stars);
    }

}