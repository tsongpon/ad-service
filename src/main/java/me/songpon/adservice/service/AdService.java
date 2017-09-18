package me.songpon.adservice.service;

import me.songpon.adservice.domain.Ad;
import me.songpon.adservice.domain.Seller;
import me.songpon.adservice.repository.AdRepository;
import me.songpon.adservice.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class AdService {
    private AdRepository adRepository;
    private SellerRepository sellerRepository;

    @Autowired
    public AdService(AdRepository adRepository, SellerRepository sellerRepository) {
        this.adRepository = adRepository;
        this.sellerRepository = sellerRepository;
    }

    public Ad getAd(Long id) {
        Ad ad = adRepository.getAd(id);
        Seller seller = sellerRepository.getSeller(ad.getMemberId());
        ad.setName(seller.getName());
        ad.setEmail(seller.getEmail());

        return ad;
    }
}
