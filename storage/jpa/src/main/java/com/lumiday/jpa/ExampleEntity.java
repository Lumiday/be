package com.lumiday.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class ExampleEntity extends BaseEntity {

    @Column
    private String exampleColumn;

    public ExampleEntity() {
    }

    public ExampleEntity(String exampleColumn) {
        this.exampleColumn = exampleColumn;
    }

}
