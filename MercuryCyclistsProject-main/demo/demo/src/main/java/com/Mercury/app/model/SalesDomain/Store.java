package com.Mercury.app.model.SalesDomain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store
{
    @Id
    @GeneratedValue
    private Long id;
    private String address;
    private String manager;

    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Sale> inStoreSales;

    public Store() {}
    public Store(Long id, String address, String manager, List<Sale> inStoreSales) {
        this.id = id;
        this.address = address;
        this.manager = manager;
        this.inStoreSales = inStoreSales;
    }

    public Long getId() {return id;}
    public String getAddress() {return address;}
    public String getManager() {return manager;}
    public List<Sale> getInStoreSales() {return inStoreSales;}

    public void setId(Long id) {id = id;}
    public void setAddress(String address) {this.address = address;}
    public void setManager(String manager) {this.manager = manager;}

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
