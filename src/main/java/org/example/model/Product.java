package org.example.model;

import java.math.BigDecimal;

public class Product {
    private Long number;
    private String name;
    private BigDecimal price;
    private Integer type;

    public Product() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
