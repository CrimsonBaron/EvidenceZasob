package cz.spsmb.evidenceZasob.Ui;

import cz.spsmb.evidenceZasob.product.Product;
import cz.spsmb.evidenceZasob.product.ProductLogic;
import cz.spsmb.evidenceZasob.utils.FilePrint;
import cz.spsmb.evidenceZasob.utils.ProductType;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ProductVault {
    private static final Scanner sc = new Scanner(System.in);

    private Set<Product> products;
    private FilePrint filePrint;

    public ProductVault() throws IOException {
        this.products =new HashSet<>();
        mockInit();
        filePrint = new FilePrint();

    }

    private void mockInit() {
        products.add(new ProductLogic("jablko", ProductType.OVOCE, 0, 1));
        products.add(new ProductLogic("hruska", ProductType.OVOCE, 0, 1));
        products.add(new ProductLogic("jahody", ProductType.OVOCE, 0, 1));

        products.add(new ProductLogic("brambory", ProductType.ZELENINA, 0, 1));
        products.add(new ProductLogic("mrkev",ProductType.ZELENINA, 0, 1));
        products.add(new ProductLogic("porek",ProductType.ZELENINA, 0, 1));

        products.add(new ProductLogic("kure", ProductType.MASO, 0, 1));
        products.add(new ProductLogic("veprovy_steak", ProductType.MASO, 0, 1));
        products.add(new ProductLogic("salam", ProductType.MASO, 0, 1));
    }

    private void print(){
        System.out.println("nazev | typ | cena | mnozstvi");
        for (Product p:products) {
            System.out.println(p.getProductName()+" | "+p.getProductType().toString()+" | "+p.getProductPrice()+" | "+p.getProductCount());
        }
    }

    private   void printSorted(ProductType type){
        System.out.println("nazev | typ | cena | mnozstvi");
        for (Product p:products) {
            if (p.getProductType() == type){
                System.out.println(p.getProductName()+" | "+p.getProductType().toString()+" | "+p.getProductPrice()+" | "+p.getProductCount());
            }
        }
    }

    private   void printStats() throws IOException {
        List<ProductType> types = new ArrayList<>();
        types.add(ProductType.OVOCE);
        types.add(ProductType.ZELENINA);
        types.add(ProductType.MASO);


        System.out.println("type | count");
        for (ProductType type:types) {
            int count = 0;

            for (Product p:products) {
                if (p.getProductType() == type){
                   count += p.getProductCount();
                }
            }
            System.out.println(type.toString()+" | "+count);
            filePrint.printToFile(type.toString()+" | "+count);
        }

    }

    private void printTotalPrice() throws IOException {
        System.out.println("");
        int price = 0;
        for (Product p:products) {
           price+=p.getProductPrice();
        }
        System.out.println("total Price : "+price+"kc");
        filePrint.printToFile("total Price : "+price+"kc");
    }

    private void edit(String name, int count, int price){
        for (Product p:products) {
           if (p.getProductName().equals(name)){
               p.setProductPrice(price);
               p.setProductCount(count);
           }
        }
    }

    public void menu() throws IOException {
        boolean run = true;

       while(run){
           System.out.println("chose action : printAll | edit | printSorted | stats | end");

           switch (sc.nextLine().toLowerCase().trim()){
               case "printall"->{
                   print();
               }
               case "edit"->{
                   System.out.println("edit : name price count");
                   String[] in  = sc.nextLine().split(" ");

                   edit(in[0].toLowerCase(), Integer.parseInt(in[2]), Integer.parseInt(in[1]));
                   System.out.println("edit succesfull");
               }
               case "printsorted"->{
                   printSortedMenu();
               }
               case "stats"->{
                   printStats();
                   printTotalPrice();
                   filePrint.printToFile("----------------------------------------");
               }
               case "end"->{
                   run = false;
               }
               default -> {
                   System.out.println("bad input");
               }
           }
       }


    }

    private void printSortedMenu() {
        System.out.println("printSorted : type");
        switch (sc.nextLine().toLowerCase()){
            case "ovoce"->{
                printSorted(ProductType.OVOCE);
            }
            case "maso"->{
                printSorted(ProductType.MASO);

            }
            case "zelenina"->{
                printSorted(ProductType.ZELENINA);
            }
            default -> {
                System.out.println("bad input");
            }
        }
    }


}
