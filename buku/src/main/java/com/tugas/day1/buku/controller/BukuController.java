package com.tugas.day1.buku.controller;

import com.tugas.day1.buku.model.BukuModel;
import com.tugas.day1.buku.repository.BukuRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buku")
@Validated
public class BukuController {

    @Autowired
    private BukuRepository bukuRepository;


    @GetMapping
    public List<BukuModel> getAllBuku() {
        return bukuRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<BukuModel> getBukuById(@PathVariable("id") @Positive Long id) {
        Optional<BukuModel> buku = bukuRepository.findById(id);
        return buku.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<BukuModel> createBuku(@RequestBody @Valid BukuModel buku) {
        BukuModel savedBuku = bukuRepository.save(buku);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuku);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BukuModel> updateBukuAPI(@PathVariable("id") @Positive Long id, @RequestBody @Valid BukuModel buku) {
        BukuModel updatedBuku = updateBuku(id, buku);
        return updatedBuku != null ? ResponseEntity.ok(updatedBuku) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public BukuModel updateBuku(Long id, BukuModel buku) {
        if (bukuRepository.existsById(id)) {
            buku.setId(id);
            return bukuRepository.save(buku);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuku(@PathVariable("id") @Positive Long id) {
        Optional<BukuModel> buku = bukuRepository.findById(id);
        if (buku.isPresent()) {
            bukuRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
