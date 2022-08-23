/**
 * @author ll （ created: 2022-07-01 3:45 )
 */
public class PercentageStrategy implements IPricingStrategy{
    private int discountPercentage;

    public PercentageStrategy(int _discountPercentage) {
        discountPercentage = _discountPercentage;
    }

    @Override
    public double getSubTotal(SaleLineItem saleLineItem) {
        double price = saleLineItem.getProdSpec().getPrice() * (1 - discountPercentage / 100.0);
        if (price < 0)  return 0;
        return price * saleLineItem.getCopies();
    }
}
