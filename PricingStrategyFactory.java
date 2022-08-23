/**
 * @author ll （ created: 2022-07-01 3:44 )
 */
public class PricingStrategyFactory {
    private static volatile PricingStrategyFactory instance;
    private double discountPerbook = 1;
    private int discountPercentageForComic = 7;
    private int discountPercentageForCS = 3;

    public static PricingStrategyFactory getInstance() {//模板
        if (instance == null) {
            synchronized (PricingStrategyFactory.class) {//双重校验锁
                if (instance == null) {
                    instance = new PricingStrategyFactory();
                }
            }
        }
        return instance;
    }

    public IPricingStrategy getPricingStrategy(int bookType) {
        IPricingStrategy ret;
        switch (bookType) {
            case 1:
                ret = new FlatRateStrategy(discountPerbook);
                break;
            case 2:
                ret = new PercentageStrategy(discountPercentageForComic);
                break;
            case 3:
                ret = new PercentageStrategy(discountPercentageForCS);
                break;
            case 4:
                ret = new NoDiscountStrategy();
                break;
            default:
                System.out.println("Book Type" + bookType + " error, default: No discount");
                ret = new NoDiscountStrategy();
                break;
        }
        return ret;
    }

    public void setDiscountPerbook(double discountPerbook) {
        this.discountPerbook = discountPerbook;
    }

    public void setDiscountPercentageForComic(int discountPercentageForComic) {
        this.discountPercentageForComic = discountPercentageForComic;
    }

    public double getDiscountPerbook() {
        return discountPerbook;
    }

    public int getDiscountPercentageForComic() {
        return discountPercentageForComic;
    }

    public int getDiscountPercentageForCS() {
        return discountPercentageForCS;
    }

    public void setDiscountPercentageForCS(int discountPercentageForCS) {
        this.discountPercentageForCS = discountPercentageForCS;
    }
}
