package com.tugas.day1.buku.repository;

import com.tugas.day1.buku.model.BukuModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepository extends JpaRepository<BukuModel, Long> {
}
