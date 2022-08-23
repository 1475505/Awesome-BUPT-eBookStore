/**
 * @author ll （ created: 2022-07-01 3:43 )
 */
public class SaleLineItem {
    private int copies;
    private ProductSpecification prodSpec;
    private IPricingStrategy strategy;
    public double getSubTotal(){
        return strategy.getSubTotal(this);
    }

    public SaleLineItem(int copies, ProductSpecification prodSpec) {
        this.copies = copies;
        this.prodSpec = prodSpec;
    }

    public void setStrategy(IPricingStrategy strategy) {
        this.strategy = strategy;
    }

    public int getCopies() {
        return copies;
    }

    public SaleLineItem(int copies, ProductSpecification prodSpec, IPricingStrategy strategy) {
        this.copies = copies;
        this.prodSpec = prodSpec;
        this.strategy = strategy;
    }

    public ProductSpecification getProdSpec() {
        return prodSpec;
    }

    public String toString(){
        return prodSpec.toString() + " * " + copies;
    }
}
