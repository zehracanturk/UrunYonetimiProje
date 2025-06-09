package com.example.urunyonetim.service;

import com.example.urunyonetim.model.Urun;
import com.example.urunyonetim.repository.UrunRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

@Service
public class UrunService extends GenericService<Urun, Long> {

    private final UrunRepository urunRepository;

    public UrunService(UrunRepository urunRepository) {
        super(urunRepository); // GenericService constructor çağrısı
        this.urunRepository = urunRepository;
    }

    public List<Urun> stogaGoreFiltrele(int minStok) {
        return urunRepository.findAll()
                .stream()
                .filter(urun -> urun.getStok() >= minStok)
                .collect(Collectors.toList());
    }

    public List<Urun> sirala(String kriter) {
        return urunRepository.findAll()
                .stream()
                .sorted((u1, u2) -> {
                    if ("fiyat".equalsIgnoreCase(kriter)) {
                        return Double.compare(u1.getFiyat(), u2.getFiyat());
                    } else if ("isim".equalsIgnoreCase(kriter)) {
                        return u1.getIsim().compareToIgnoreCase(u2.getIsim());
                    } else {
                        return 0;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Urun> isimleAra(String isim) {
        return urunRepository.findByIsimContainingIgnoreCase(isim);
    }

    public List<Urun> urunAra(String isim, String kategori, Double minFiyat, Double maxFiyat) {
        return urunRepository.findAll()
                .stream()
                .filter(urun -> {
                    boolean isimUygun = (isim == null || urun.getIsim().toLowerCase().contains(isim.toLowerCase()));
                    boolean kategoriUygun = (kategori == null || urun.getKategori().toLowerCase().contains(kategori.toLowerCase()));
                    boolean minFiyatUygun = (minFiyat == null || urun.getFiyat() >= minFiyat);
                    boolean maxFiyatUygun = (maxFiyat == null || urun.getFiyat() <= maxFiyat);
                    return isimUygun && kategoriUygun && minFiyatUygun && maxFiyatUygun;
                })
                .collect(Collectors.toList());
    }
    public List<Urun> bubbleSortByFiyat(List<Urun> urunler) {
        List<Urun> sortedList = new ArrayList<>(urunler);
        int n = sortedList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sortedList.get(j).getFiyat() > sortedList.get(j + 1).getFiyat()) {
                    // Swap
                    Urun temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        return sortedList;
    }
}
