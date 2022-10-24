package com.Mercury.app.model.InventoryDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Comment {

    private String comment;

    public Comment(){}

    public Comment(String comment){this.comment = comment;}

    public void setComment(String comment){this.comment = comment;}

    public String getComment(){return this.comment;}

    public int length() {
        return 0;
    }
}
