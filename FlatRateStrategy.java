/**
 * @author ll （ created: 2022-07-01 3:44 )
 */
public class FlatRateStrategy implements IPricingStrategy{
    private double discountPerBook;

    public FlatRateStrategy(double discountPerbook) {
        discountPerBook = discountPerbook;
    }

    @Override
    public double getSubTotal(SaleLineItem saleLineItem) {
        double price = saleLineItem.getProdSpec().getPrice() - discountPerBook;
        if (price < 0)  return 0;
        return price * saleLineItem.getCopies();
    }
}
