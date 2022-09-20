package com.Mercury.app.controller;

import com.Mercury.app.model.InventoryDomain.Part;
import com.Mercury.app.model.Inventory.Product;
import com.Mercury.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) { this.productService = productService;}

    @GetMapping("/test")
    public List<Product> test() { return productService.findAllProducts(); }

    //Use case 5 (look up part by product)
    @GetMapping("{productId}/parts")
    public List<Part> getAllPartsOfAProduct(@PathVariable Long productId) { return productService.getPartsOfProduct(productId); }

    //Use case 8 (look up products info by sale)
    @GetMapping("/sale/{saleId}")
    public List<Product> getProductBySaleId(@PathVariable Long saleId) { return productService.getProductBySaleId(saleId); }

    //Use case 4 (create product)
    @PostMapping
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    //Use case 4 (update product)
    @PutMapping(path = {"{productId}"})
    public void updateProduct(
            @PathVariable Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) String comment)
    {
        productService.updatePart(name,productId,price,comment);
    }

    //Use case 7 'create sale' (Another method handles the backorder option)
    @GetMapping("createorder/{productName}")
    public String createOrder(@PathVariable String productName)
    {
        boolean orderCanBeMade = productService.canCreateSaleOf(productName);
        if (orderCanBeMade) { return "Order Confirmed"; }
        else
        {
            return "Product not in stock\nOly backorder can be made on product";
        }
    }

    //Use case 7 (Makes a backorder)
    @GetMapping("createbakorderfor/{productName}")
    public String createBackOrder(@PathVariable String productName )
    {
        return productService.createBackOrderSale(productName);
    }
}
