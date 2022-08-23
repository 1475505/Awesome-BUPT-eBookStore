/**
 * @author ll （ created: 2022-07-01 3:45 )
 */
public class NoDiscountStrategy implements IPricingStrategy{
    @Override
    public double getSubTotal(SaleLineItem saleLineItem) {
        double price = saleLineItem.getProdSpec().getPrice();
        return price * saleLineItem.getCopies();
    }
}
