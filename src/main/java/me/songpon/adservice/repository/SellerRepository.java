package me.songpon.adservice.repository;

import me.songpon.adservice.domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Repository
public class SellerRepository {
    private RestTemplate restTemplate;

    @Autowired
    public SellerRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Seller getSeller(Long id) {
        ResponseEntity<Seller> restExchange =
                restTemplate.exchange("http://seller-service/v1/sellers/{id}",
                        HttpMethod.GET,
                        null, Seller.class, id);

        return restExchange.getBody();
    }
}
