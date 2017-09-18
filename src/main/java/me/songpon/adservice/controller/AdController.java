package me.songpon.adservice.controller;

import me.songpon.adservice.domain.Ad;
import me.songpon.adservice.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class AdController {

    private AdService adService;

    @Autowired
    public AdController(AdService service) {
        this.adService = service;
    }

    @GetMapping(value = "/v1/ads/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAd(@PathVariable Long id) {
        Ad ad = adService.getAd(id);

        return ResponseEntity.ok().body(ad);
    }
}
