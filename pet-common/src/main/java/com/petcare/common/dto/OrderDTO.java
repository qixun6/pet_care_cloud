package com.petcare.common.dto;

import java.math.BigDecimal;

public class OrderDTO {
    private Long id;
    private String itemName;
    private BigDecimal amount;
    private UserDTO user;
    private ProductDTO product;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String itemName, BigDecimal amount, UserDTO user, ProductDTO product) {
        this.id = id;
        this.itemName = itemName;
        this.amount = amount;
        this.user = user;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
