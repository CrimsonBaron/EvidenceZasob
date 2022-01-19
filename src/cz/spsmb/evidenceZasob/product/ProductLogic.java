package cz.spsmb.evidenceZasob.product;

import cz.spsmb.evidenceZasob.utils.ProductType;

public class ProductLogic implements Product{

    private String name;
    private ProductType type;
    private int price;
    private int count;


    public ProductLogic(String name, ProductType type, int price, int count) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.count = count;
    }

    @Override
    public ProductType getProductType() {
        return type;
    }

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public int getProductPrice() {
        return price;
    }

    @Override
    public int getProductCount() {
        return count;
    }

    @Override
    public void setProductPrice(int n) {
        this.price = n;
    }

    @Override
    public void setProductCount(int n) {
        this.count = n;
    }
}
