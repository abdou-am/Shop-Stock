public class Product {
    private String name;
    private String code;
    private double price;
    public Product(String name , String code , double price){
        this.name = name;
        this.code = code;
        this.price = price;
    }

    // getters

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public double getPrice(){
        return price;
    }

    // setters

    public void setName(String name){
        this.name = name;
    }
    public void setCode(String code){
        this.code = code;
    }
    public void setName(double price){
        this.price = price;
    }

    
}
