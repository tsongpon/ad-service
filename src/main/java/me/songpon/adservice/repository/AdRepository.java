package me.songpon.adservice.repository;

import me.songpon.adservice.domain.Ad;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class AdRepository {

    public Ad getAd(Long id) {
        // just return mock
        return new Ad(id, "BMW series 7", "BMW series 7 year model 2017", 3400000, 1L);
    }
}
