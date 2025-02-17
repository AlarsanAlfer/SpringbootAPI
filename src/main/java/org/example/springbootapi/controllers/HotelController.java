package org.example.springbootapi.controllers;

import org.example.springbootapi.models.Hotel;
import org.example.springbootapi.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHoteles() {
        return ResponseEntity.ok(hotelService.findAllHoteles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.findHotelById(id);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/mas-estrellas/{stars}")
    public ResponseEntity<List<Hotel>> getHotelsByStars(@PathVariable int stars) {
        return ResponseEntity.ok(hotelService.findHotelsByMinStars(stars));
    }





    /// //////////////////////////////////////////////////

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
    }

    @PutMapping("/u{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        hotel.setId(id);
        return ResponseEntity.ok(hotelService.saveHotel(hotel));
    }

    @DeleteMapping("/d{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}
