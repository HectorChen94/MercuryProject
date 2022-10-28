package csci318.demo.service;

import csci318.demo.model.Product;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SaleInteractiveQuery
{
    private final InteractiveQueryService interactiveQueryService;

    //@Autowired
    public SaleInteractiveQuery(InteractiveQueryService interactiveQueryService) {
        this.interactiveQueryService = interactiveQueryService;
    }

    //Gets the total sales value of a product
    public String getTotalSalesOfProduct(String productName)
    {
        if (productStore.get(productName) == null)
        {
            throw new NoSuchElementException();
        } else {
            double totalValue = 0d;
            KeyValueIterator<String, Product> all = productStore().all;
            while (all.hasNext())
            {
                Product product = all.next().value;
                totalValue += product.getPrice()*product.getProductSales();
            }
            return productName+" total value: " + totalValue;
        }
    }

    private ReadOnlyKeyValueStore<String, Product> productStore() {
        return this.interactiveQueryService.getQueryableStore(ProductStreamProcessing.PRODUCT_STATE_STORE,
                QueryableStoreTypes.keyValueStore());
    }


    private ReadOnlyKeyValueStore<String, Sale> saleStore() {
        return this.interactiveQueryService.getQueryableStore(ProductStreamProcessing.SALE_STATE_STORE,
                QueryableStoreTypes.keyValueStore());
    }
}
