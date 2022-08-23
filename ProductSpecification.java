/**
 * @author ll （ created: 2022-07-01 3:43 )
 */

public class ProductSpecification {
    private String isbn;
    private double price;
    private String title;

    public ProductSpecification(String isbn, double price, String title, int type) {
        this.isbn = isbn;
        this.price = price;
        this.title = title;
        this.type = type;
    }

    /* 1 - textbook, 2 - comic, 3 - cs, 4 - else */
    private int type;

    public double getPrice() {
        return price;
    }


    public int getType() {
        return type;
    }

    public String toString(){
        String str =  "[" + title + "]" + " isbn:" + isbn + " price:";
        str += String.format("%.2f", price);
        String bookType = "";
        switch (type){
            case 1:
                bookType = "Textbook";
                break;
            case 2:
                bookType = "Comic";
                break;
            case 3:
                bookType = "Computer-Science Book";
                break;
        }
        return bookType + str;
    }
}
