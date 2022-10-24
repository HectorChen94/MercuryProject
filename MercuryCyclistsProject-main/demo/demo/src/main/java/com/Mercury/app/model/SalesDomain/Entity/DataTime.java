package com.Mercury.app.model.SalesDomain.Entity;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;


@Embeddable
public class DataTime {

    private LocalDateTime dateTime;

    public DataTime(){}

    public DataTime(LocalDateTime dateTime){this.dateTime = dateTime;}

    public void setDateTime(LocalDateTime dateTime){this.dateTime = dateTime;}

    public LocalDateTime getDateTime(){return this.dateTime;}

    public int length() {
        return 0;
    }
}

