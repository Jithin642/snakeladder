package models;

public class Product {
    private Integer productId;
    private String productName;
    private double productPrice;

    public Product(Integer productId, String productName, double productPrice){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public void setProductId(Integer productId){
        this.productId = productId;
    }
    public Integer getProductId(){
        return productId;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }
    public String getProductName(){
        return productName;
    }

    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
    public double getProductPrice(){
        return productPrice;
    }
}
