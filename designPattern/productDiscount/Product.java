package all_projects.src.designPattern.productDiscount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Product {

    private String name;
    double originalPrice;
    ProductType productType;

    public Product(String name, double originalPrice, ProductType productType) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.productType = productType;
    }

    public Product() {
    }

    public abstract double getPrice();

    public static void main(String[] args) {
        Product product=new Item1("cbbcbdh", 44, ProductType.ELECTRONIC);
        Product product2=new Item1("bcnbdnb", 22, ProductType.GROCERY);
        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product2);
        System.out.println(shoppingCart.getTotalPrice());


    }
}

enum ProductType{
    ELECTRONIC, FOOD, GROCERY
}

class Item1 extends Product{

    public Item1(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}

class Item2 extends Product{

    public Item2(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}

class ShoppingCart{
   List<Product> products=new ArrayList<>();

    ShoppingCart(){
    }


    public void addProduct(Product product){
        Product productWithDiscount = new PercentageDiscount(new TypeDiscount(product, 30), 10);
        products.add(productWithDiscount);
    }

    public double getTotalPrice(){
        double total=0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

abstract class ProductCoupon extends Product{



}

class PercentageDiscount extends ProductCoupon{

    Product product;
    int percentage;

    public PercentageDiscount(Product product, int percentage) {
        this.product = product;
        this.percentage = percentage;
    }

    @Override
    public double getPrice() {
        return product.getPrice() -  (product.getPrice() * percentage) /100;
    }

}


class TypeDiscount extends ProductCoupon{


    static List<ProductType> products;
    static {
        products = Arrays.asList(ProductType.ELECTRONIC, ProductType.FOOD);
    }
    Product product;
    int price;

    public TypeDiscount(Product product, int priceDiscount ) {
        this.product = product;
        this.price = priceDiscount;
    }

    @Override
    public double getPrice() {
        if(products.contains(product.productType)){
            return product.getPrice()- price;
        }

        return product.getPrice();
    }
}