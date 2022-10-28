package csci318.demo.service;

import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SaleInteractiveQuery
{
    private final InteractiveQueryService interactiveQueryService;

    //@Autowired
    public SaleInteractiveQuery(InteractiveQueryService interactiveQueryService) {
        this.interactiveQueryService = interactiveQueryService;
    }

    public long getProductSales(String productName)
    {
        if (productStore().get(productName) != null){
            return productStore().get(productName);
        } else {
            throw new NoSuchElementException();
        }
    }

    public List<String> getProductList()
    {
        List<String> productList = new ArrayList<>();
        KeyValueIterator<String, Long> all = productStore().all();
        while (all.hasNext())
        {
            String next = all.next().key;
            productList.add(next);
        }
        return productList;
    }


    public List<String> getTotalSalesOfProduct(String prodcutName)
    {
        if (productStore().get(productName) == null){
            throw new NoSuchElementException();
        } else {

        }
    }
    /*
    public List<String> getEquipmentListByBrand(String brandString) {
        List<String> equipmentList = new ArrayList<>();
        KeyValueIterator<String, Equipment> all = equipmentStore().all();
        while (all.hasNext()) {
            Equipment equipment = all.next().value;
            String brand_name = equipment.getBrand();
            String equipment_name = equipment.getEquipment();
            if (brand_name.equals(brandString)){
                equipmentList.add(equipment_name);
            }
        }
        return equipmentList;
    }


    public List<String> getEquipmentList() {
        List<String> equipmentList = new ArrayList<>();
        KeyValueIterator<String, Equipment> all = equipmentStore().all();
        while (all.hasNext()) {
            String equipment_name = all.next().value.getEquipment();
            equipmentList.add(equipment_name);
        }

        return equipmentList;
    }
    */

    private ReadOnlyKeyValueStore<String, Long> productStore() {
        return this.interactiveQueryService.getQueryableStore(ProductStreamProcessing.BRAND_STATE_STORE,
                QueryableStoreTypes.keyValueStore());
    }


    private ReadOnlyKeyValueStore<String, Sale> saleStore() {
        return this.interactiveQueryService.getQueryableStore(ProductStreamProcessing.EQUIPMENT_STATE_STORE,
                QueryableStoreTypes.keyValueStore());
    }
}

