package com.example.urunyonetim.controller;

import com.example.urunyonetim.model.Urun;
import com.example.urunyonetim.service.UrunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.urunyonetim.service.LoggingService;

import java.util.List;

@RestController
@RequestMapping("/urunler")
public class UrunController {

    private final UrunService urunService;
    private final LoggingService loggingService;

    // Constructor injection ile her iki service de inject edildi
    public UrunController(UrunService urunService, LoggingService loggingService) {
        this.urunService = urunService;
        this.loggingService = loggingService;
    }

    // Tüm ürünleri getir (GenericService'den geliyor)
    @GetMapping
    public List<Urun> tumUrunleriGetir() {
        return urunService.findAll();
    }

    // ID'ye göre ürün getir
    @GetMapping("/{id}")
    public ResponseEntity<Urun> urunGetir(@PathVariable Long id) {
        return urunService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Yeni ürün ekle
    @PostMapping
    public Urun urunEkle(@RequestBody Urun urun) {
        return urunService.save(urun);
    }

    // Ürün sil
    @DeleteMapping("/{id}")
    public ResponseEntity<?> urunSil(@PathVariable Long id) {
        urunService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Stok filtreleme
    @GetMapping("/stok/{minStok}")
    public List<Urun> stokFiltre(@PathVariable int minStok) {
        return urunService.stogaGoreFiltrele(minStok);
    }

    // Sıralama endpoint'i
    @GetMapping("/sirala")
    public List<Urun> urunleriSirala(@RequestParam String kriter) {
        return urunService.sirala(kriter);
    }

    // Arama endpoint'i
    @GetMapping("/ara")
    public List<Urun> urunAra(
            @RequestParam(required = false) String isim,
            @RequestParam(required = false) String kategori,
            @RequestParam(required = false) Double minFiyat,
            @RequestParam(required = false) Double maxFiyat
    ) {
        return urunService.urunAra(isim, kategori, minFiyat, maxFiyat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Urun> urunGuncelle(@PathVariable Long id, @RequestBody Urun yeniUrun) {
        return urunService.findById(id)
            .map(urun -> {
                urun.setIsim(yeniUrun.getIsim());
                urun.setFiyat(yeniUrun.getFiyat());
                urun.setStok(yeniUrun.getStok());
                urun.setKategori(yeniUrun.getKategori());
                Urun guncellenen = urunService.save(urun);
                return ResponseEntity.ok(guncellenen);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/logla")
    public ResponseEntity<String> urunleriLogla() {
        List<Urun> urunler = urunService.findAll();
        loggingService.urunleriLogla(urunler); // Asenkron olarak başlar
        return ResponseEntity.ok("Loglama işlemi başlatıldı (asenkron).");
    }
}
