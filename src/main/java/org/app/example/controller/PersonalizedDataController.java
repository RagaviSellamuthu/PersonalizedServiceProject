package org.app.example.controller;

import org.app.example.model.ProductMetaData;
import org.app.example.model.Shopper;
import org.app.example.model.ShopperInformation;
import org.app.example.service.PersonalizedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eCommerce/personalizedData")
public class PersonalizedDataController {

    private final PersonalizedService personalizedService;

    public PersonalizedDataController(final PersonalizedService personalizedService){
        this.personalizedService = personalizedService;
    }

    @GetMapping(path = "/getProducts/{shopperId}")
    public List<ShopperInformation> getProductsByShopperID(@PathVariable String shopperId, ProductMetaData product){
        return personalizedService.getProductsByShopperID(shopperId, product);
    }

    @PostMapping(path = "/saveProducts")
    public void saveProducts(@RequestBody Shopper shopper) {
        personalizedService.saveProducts(shopper);
    }
    @PostMapping(path = "/saveProductMetadata")
    public void saveProductMetaData(@RequestBody ProductMetaData product) {
        personalizedService.saveProductMetaData(product);
    }
}
