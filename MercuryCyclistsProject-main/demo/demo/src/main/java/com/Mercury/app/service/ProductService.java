package com.Mercury.app.service;
import com.Mercury.app.model.InventoryDomain.Aggregate.Part;
import com.Mercury.app.model.InventoryDomain.Aggregate.Product;
import com.Mercury.app.model.InventoryDomain.ValueObject.Comment;
import com.Mercury.app.model.InventoryDomain.ValueObject.Price;
import com.Mercury.app.model.InventoryDomain.ValueObject.ProductName;
import com.Mercury.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> findAllProducts() { return productRepository.findAll();}
    public void addNewProduct(Product product){
        Optional<Product>productOptional=productRepository.findProductById(product.getProductId());
        if(productOptional.isPresent()) {
            throw new IllegalStateException("Product already exists with Id: " + product.getProductId());
        }
        productRepository.save(product);

    }
    @Transactional
    public void updatePart(ProductName productName, Long productId, Price price, Comment comment){
        Product product=productRepository.findProductById(productId).orElseThrow( () -> new IllegalStateException("No contact found with email address " + productId));
        if (productName!=null && productName.length()>0 && !Objects.equals(product.getProductName(),productName)) { product.setProductName(productName); }
        if (productId>0 && !Objects.equals(product.getProductId(),productId)) { product.setProductId(productId); }
        if (!Objects.equals(product.getPrice(),price)) { product.setPrice(price); }
        if(comment!=null && comment.length()>0 && !Objects.equals(product.getComment(),comment)){product.setComment(comment);}
    }

    //Use case 5
    //Returns the parts of a product if the product exists
    public List<Part> getPartsOfProduct(Long productId)
    {
        Optional<Product>productOptional=productRepository.findProductById(productId);
        if(!(productOptional.isPresent())) {
            throw new IllegalStateException("No product found with ID " + productId);
        }

        return productOptional.get().getParts();
    }

    //Use case 8
    public List<Product> getProductBySaleId(Long saleId)
    {
        List<Product> allProducts = productRepository.findAll();
        ArrayList<Product> validProducts = new ArrayList<>();
        for (Product product:allProducts)
        {
            if (product.getProductId() == saleId) { validProducts.add(product); }
        }
        //In case nothing is found
        if (validProducts.size() == 0)
        {
            throw new IllegalStateException("No products found that contain a sale with sale ID: " + saleId);
        }
        return validProducts;
    }

    //Use case 7 'create sale' (the backorder is handled in another method)
    public boolean canCreateSaleOf(String productName)
    {
        Optional<Product> productOptional = productRepository.findProductByName(productName);
        if (productOptional.isPresent()) return true;
        return false;
    }

    //Use case 7 'create sale' (the backorder)
    public String createBackOrderSale(String productName)
    {
        Optional<Product> productOptional = productRepository.findProductByName(productName);
        if (productOptional.isPresent())
        {
            //Kafka stuff goes here
            return "Epic";
        }
        throw new IllegalStateException("No products found with name: " + productName);
    }
}
