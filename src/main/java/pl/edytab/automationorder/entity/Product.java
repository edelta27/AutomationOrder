package pl.edytab.automationorder.entity;

import jakarta.persistence.*;
import pl.edytab.automationorder.enums.ProductCategory;
import pl.edytab.automationorder.enums.ProductStatus;

import java.math.BigDecimal;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private BigDecimal netPrice;
    private BigDecimal vatRare;

    @Enumerated(EnumType.STRING)
    private ProductStatus status = ProductStatus.ACTIVE;

    public Product() {
    }

    public Product(Long id, String symbol, String name, ProductCategory category,
                   BigDecimal netPrice, BigDecimal vatRare) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.category = category;
        this.netPrice = netPrice;
        this.vatRare = vatRare;
        this.status = ProductStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigDecimal getVatRare() {
        return vatRare;
    }

    public void setVatRare(BigDecimal vatRare) {
        this.vatRare = vatRare;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
