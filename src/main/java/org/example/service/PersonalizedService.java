package org.example.service;

import org.example.model.ProductId;
import org.example.model.ProductMetaData;
import org.example.model.Shopper;
import org.example.model.ShopperInformation;
import org.example.repository.PersonalizedRepository;
import org.example.repository.ProductIdRepository;
import org.example.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class PersonalizedService {

    private final PersonalizedRepository personalizedRepository;
    private final ProductRepository productRepository;
    private final ProductIdRepository productIdRepository;

    public PersonalizedService(final PersonalizedRepository personalizedRepository,
                               final ProductRepository productRepository,
                               final ProductIdRepository productIdRepository){
        this.personalizedRepository = personalizedRepository;
        this.productRepository = productRepository;
        this.productIdRepository = productIdRepository;
    }
    public List<ShopperInformation> getProductsByShopperID(String shopperId, ProductMetaData product) {
        int limit = Objects.nonNull(product.getLimit()) ? product.getLimit() : 10;
        return personalizedRepository.findProductsByShopperId(shopperId, product.getCategory(), product.getBrand(), PageRequest.of(0, limit));
    }

    public void saveProducts(Shopper shopper) {
        Shopper shopperInformation = personalizedRepository.findByShopperId(shopper.getShopperId()).orElse(null);
        if(Objects.nonNull(shopperInformation)) {
            Set<ProductId> products = shopper.getShelf();
            products.forEach(p -> p.setId(shopperInformation.getId()));
            productIdRepository.saveAll(products);

        } else {
            personalizedRepository.save(shopper);
        }
    }

    public void saveProductMetaData(ProductMetaData product) {
        productRepository.save(product);
    }
}
