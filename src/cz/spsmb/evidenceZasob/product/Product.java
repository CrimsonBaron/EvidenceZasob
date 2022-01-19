package cz.spsmb.evidenceZasob.product;

import cz.spsmb.evidenceZasob.utils.ProductType;

public interface Product {
    ProductType getProductType();
    String getProductName();
    int getProductPrice();
    int getProductCount();
    void setProductPrice(int n);
    void setProductCount(int n);
}
