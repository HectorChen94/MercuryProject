package csci318.demo.service;

import csci318.demo.model.Part;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SaleInteractiveQuery {

    private final InteractiveQueryService interactiveQueryService;

    //@Autowired
    public SaleInteractiveQuery(InteractiveQueryService interactiveQueryService) {
        this.interactiveQueryService = interactiveQueryService;
    }

    public long getProductSalesValue(String productSales) {
        if (saleStore().get(productSales) != null) {
            return saleStore().get(productSales);
        } else {
            throw new NoSuchElementException(); //TODO: should use a customised exception.
        }
    }

    public List<String> getSaleList() {
        List<String> saleList = new ArrayList<>();
        KeyValueIterator<String, Long> all = saleStore().all();
        while (all.hasNext()) {
            String next = all.next().key;
            saleList.add(next);
        }
        return saleList;
    }

    public List<String> getPartListBySale(String brandString) {
        List<String> partList = new ArrayList<>();
        KeyValueIterator<String, Part> all = partStore().all();
        while (all.hasNext()) {
            Part part = all.next().value;
            String sale_Number = part.getProductSales();
            String part_Name = part.getPartName();
            if (sale_Number.equals(brandString)){
                partList.add(part_Name);
            }
        }
        return partList;
    }


    public List<String> getpPartList() {
        List<String> partList = new ArrayList<>();
        KeyValueIterator<String, Part> all = partStore().all();
        while (all.hasNext()) {
            String part_Name = all.next().value.getPartName();
            partList.add(part_Name);
        }

        return partList;
    }

    private ReadOnlyKeyValueStore<String, Long> saleStore() {
        return this.interactiveQueryService.getQueryableStore(ProductStreamProcessing.SALE_STATE_STORE,
                QueryableStoreTypes.keyValueStore());
    }


    private ReadOnlyKeyValueStore<String, Part> partStore() {
        return this.interactiveQueryService.getQueryableStore(ProductStreamProcessing.PART_STATE_STORE,
                QueryableStoreTypes.keyValueStore());
    }


}
