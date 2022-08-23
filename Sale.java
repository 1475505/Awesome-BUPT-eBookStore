import java.util.ArrayList;

/**
 * @author ll （ created: 2022-07-01 3:43 )
 */
public class Sale {
    private ArrayList<SaleLineItem> items;

    public Sale() {
        items = new ArrayList<>();
    }

    public double getTotal(){
        double ret = 0;
        for (SaleLineItem saleLineItem : items){
            ret += saleLineItem.getSubTotal();
        }
        return ret;
    }

    public void reset(){
        items.clear();
    }

    public String toString(){
        StringBuilder ret = new StringBuilder();
        for (SaleLineItem saleLineItem : items){
            ret.append(saleLineItem.toString()).append("->").append(String.format("%.2f", saleLineItem.getSubTotal()));
            ret.append("\n");
        }
        ret.append("==========================\n");
        ret.append("Total Price: ").append(String.format("%.2f", getTotal()));
        return ret.toString();
    }

    public void addItem(SaleLineItem saleLineItem){
        items.add(saleLineItem);
    }

}
