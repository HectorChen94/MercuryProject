package com.Mercury.app.model.SalesDomain.Aggregate;

import com.Mercury.app.model.SalesDomain.ValueObject.Address;
import com.Mercury.app.model.SalesDomain.ValueObject.Manager;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store
{
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private Address address;
    @Embedded
    private Manager manager;

    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Sale> inStoreSales;

    public Store() {}
    public Store(Long id, Address address, Manager manager, List<Sale> inStoreSales) {
        this.id = id;
        this.address = address;
        this.manager = manager;
        this.inStoreSales = inStoreSales;
    }

    public Long getId() {return id;}
    public Address getAddress() {return address;}
    public Manager getManager() {return manager;}
    public List<Sale> getInStoreSales() {return inStoreSales;}

    public void setId(Long id) {id = id;}
    public void setAddress(Address address) {this.address = address;}
    public void setManager(Manager manager) {this.manager = manager;}

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
