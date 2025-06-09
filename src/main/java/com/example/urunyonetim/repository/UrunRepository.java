package com.example.urunyonetim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.urunyonetim.model.Urun;


import java.util.List;

@Repository
public interface UrunRepository extends JpaRepository<Urun, Long> {
	 List<Urun> findByIsimContainingIgnoreCase(String isim);
}
