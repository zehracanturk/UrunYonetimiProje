package com.example.urunyonetim.service;

import com.example.urunyonetim.model.Urun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggingService {
	private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    @Async
    public void urunleriLogla(List<Urun> urunler) {
        logger.info("Urun loglama işlemi başladı. Thread: {}", Thread.currentThread().getName());
        for (Urun urun : urunler) {
            try {
                Thread.sleep(1000); // her ürün için 1 sn bekle
                logger.info("Ürün: {} | Fiyat: {}", urun.getIsim(), urun.getFiyat());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        logger.info("Loglama tamamlandı.");
    }
}
