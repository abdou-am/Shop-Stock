import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;
public class ShopStock {
    
    static Scanner scanner = new Scanner(System.in);
    // defining the searching algorithm

    public static boolean codeFound(HashMap<String,Product> x , String code){
        boolean found = false;
        for (String h:x.keySet()){
            if (h.equals(code)){
                found = true;
                break;
            }
        }
        return found;
    }
    
    // defining the integer exception handling method
    public static int integerExceptionHandling(){
        int integer;
        while (true){
            try{
                integer = scanner.nextInt();
                break;
            }
            catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("only integers accepted");
                System.out.print("enter again: ");
            }
        }
        return integer;
    }

    // defining the double exception handling method

    public static double doubleExceptionHandling(){
        double floatnum;
        while (true){
            try{
                floatnum = scanner.nextDouble();
                break;
            }
            catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("only numbers accepted");
                System.out.print("enter again: ");
            }
        }
        return floatnum;
    }

    // defining the choosing method (can be used multiple times)



    public static int choosing(int choicecAmount ){
        int choice = -1;
        while ((choice < 1) || (choice > choicecAmount)){
            choice = integerExceptionHandling();
            if ((choice < 1) || (choice > choicecAmount)){
                System.out.print("choose only(");
                for (int i = 1 ; i<=choicecAmount ; i++){
                    if (i == choicecAmount){
                        System.out.print(i);
                    }
                    else{
                        System.out.print(i + "/");
                    }
                }
                System.out.print("): ");
            }
        }
        return choice;
    }






    public static void main(String[] args){
        
        HashMap<String , Product>products = new HashMap<>();
        boolean quit = false;
        System.out.println("---Welcome to << SHOP STOCK >>---");
        while (!quit){
            System.out.println("| 1)Add product");
            System.out.println("| 2)View products");
            System.out.println("| 3)Delete product");
            System.out.println("| 4)Search for product");
            System.out.println("| 5)Edit product");
            System.out.println("| 6)Sell");
            System.out.println("| 7)Recieve a delivery");
            System.out.println("| 8)Running out products");
            System.out.println("| 9)Quit");
            System.out.print("pick a number: ");
            int choice = choosing(9);
            scanner.nextLine();
            if (choice == 9){
                quit = true;
            }
            else if (choice == 1){
                System.out.print("Enter the product name: ");
                String name = scanner.nextLine();
                System.out.print("\n");
                System.out.print("Enter the product code: ");
                String code = scanner.nextLine();
                System.out.print("\n");
                System.out.print("Enter the product price: ");
                double price = -1;
                while (price <=0){
                    price = doubleExceptionHandling();
                    if (price <=0){
                        System.out.println("Price can't be negative");
                        System.out.print("enter again: ");
                    }
                }
                System.out.print("\n");
                System.out.print("Enter the product quantity: ");
                int stock = -1;
                while (stock <=0){
                    stock = integerExceptionHandling();
                    if (stock <=0){
                        System.out.print("Quantity can't be negative: ");
                    }
                }
                System.out.println("\n");
                Product product = new Product(name,price,stock);
                products.put(code,product);
                System.out.println("===Product Added Succesfully===");
            }
            else if (choice == 2){
                if (products.isEmpty()){
                    System.out.println("no product available");
                }
                else{
                    for (String x:products.keySet()){
                        System.out.print(x+"   ");
                        (products.get(x)).display();
                    }
                }
            }
            else if (choice == 3){
                if (products.isEmpty()){
                    System.out.println("no product available");
                }
                else{
                    
                    System.out.print("Enter the product code to delete: ");
                    String code = scanner.nextLine();
                    boolean found = codeFound(products, code);
                    if (!found){
                        System.out.println("Product not found");
                    }
                    else{
                        products.remove(code);
                        System.out.println("===Product Deleted Succesfully===");
                    }
                }
            }
            else if (choice == 4){
                if (products.isEmpty()){
                    System.out.println("no product available");
                }
                else{

                    System.out.print("Enter the product code: ");
                    String code = scanner.nextLine();
                    boolean found = codeFound(products, code);
                    if (!found){
                        System.out.println("Product not found");
                    }
                    else{
                        (products.get(code)).display();
                    }
                }
            }
            else if (choice == 5){
                if (products.isEmpty()){
                    System.out.println("no product available");
                }
                else{
                    System.out.print("Enter the product code to edit: ");
                    String code = scanner.nextLine();
                    boolean found = codeFound(products, code);
                    if (!found){
                        System.out.println("Product not found");
                    }
                    else{
                        System.out.println("| 1)Edit code");
                        System.out.println("| 2)Edit name");
                        System.out.println("| 3)Edit price");
                        System.out.println("| 4)Edit quantity");
                        System.out.print("pick a number: ");
                        int editChoice = choosing(4);
                        scanner.nextLine();
                        if (editChoice == 2){
                            System.out.print("Enter the new name: ");
                            String name = scanner.nextLine();
                            (products.get(code)).setName(name);
                            System.out.println("===Name Edited Succesfully===");
                            System.out.print("\n");
                        }
                        if (editChoice == 3){
                            System.out.print("Enter the new price: ");
                            double price = -1;
                            while (price <=0){
                                price = doubleExceptionHandling();
                                if (price <=0){
                                    System.out.println("Price can't be negative");
                                    System.out.print("enter again: ");
                                }
                            }
                            (products.get(code)).setPrice(price);
                            System.out.println("===Price Edited Succesfully===");
                            System.out.print("\n");
                        }
                        if (editChoice == 4){
                            System.out.print("Enter the product quantity: ");
                            int stock = -1;
                            while (stock <=0){
                                stock = integerExceptionHandling();
                                if (stock <=0){
                                    System.out.println("Quantity can't be negative");
                                }
                            }
                            (products.get(code)).setStock(stock);
                            System.out.println("===Quantity Edited Succesfully===");
                            System.out.print("\n");
                        }
                        if (editChoice == 1){
                            Product temp = new Product((products.get(code)).getName() , (products.get(code)).getPrice() , (products.get(code)).getStock());
                            System.out.print("enter the new code: ");
                            String newCode = scanner.nextLine();
                            products.put(newCode , temp);
                            products.remove(code);
                            System.out.println("===Code Edited Succesfully===");
                        }
                    }
                }
            }
            else if (choice == 6){
                if (products.isEmpty()){
                    System.out.println("No Products Available");
                }
                else{
                    System.out.print("Enter the code of the product to sell: ");
                    String code = scanner.nextLine();
                    if (!codeFound(products, code)){
                        System.out.println("Product not found");
                    }
                    else{
                        System.out.print("How much you want to sell this product: ");
                        int amount = -1;
                        while (amount<=0){
                            amount = integerExceptionHandling();
                            if (amount<=0){
                                System.out.println("You can't sell a negative amount of a product: ");
                                System.out.print("Enter again: ");

                            }
                        }
                        if (amount > (products.get(code)).getStock()){
                            System.out.println("you can't sell this quantity , only "+(products.get(code)).getStock()+" are left");
                        }
                        else{
                            System.out.println("Total price : "+((amount)*((products.get(code)).getPrice()))+"DZD");
                            (products.get(code)).setStock(((products.get(code)).getStock()) - amount);
                        }
                    }
                }
            }
            else if (choice == 7){
                if (products.isEmpty()){
                    System.out.println("No Products Available");
                }
                else{
                    System.out.print("Enter the code of the product you received: ");
                    String code = scanner.nextLine();
                    if (!codeFound(products, code)){
                        System.out.println("Product not found");
                    }
                    else{
                        System.out.print("How much you received of this product: ");
                        int amount = -1;
                        while (amount<=0){
                            amount = integerExceptionHandling();
                            if (amount<=0){
                                System.out.println("You can't receive a negative amount of a product: ");
                                System.out.print("Enter again: ");

                            }
                        }
                        (products.get(code)).setStock(((products.get(code)).getStock()) + amount);
                    }
                }
            }
            else if (choice == 8){
                if (products.isEmpty()){
                    System.out.println("No Products Available");
                }
                else{
                    boolean found = false;
                    for (String x:(products.keySet())){
                        if (((products.get(x)).getStock()) <= 5){
                            found = true;
                            break;
                        }
                    }
                    if (found){
                        System.out.println("Products running out are");
                        for (String x:(products.keySet())){
                            if (((products.get(x)).getStock()) <= 5){
                                System.out.println((products.get(x)).getName());
                            }
                        }
                    }
                    else{
                        System.out.println("No product is running out of stock");
                    }
                }
            }
        }
        scanner.close();



        
    }
    
}
