import javax.swing.*;
import java.awt.event.*;

/**
 * @author ll （ created: 2022-06-25 1:13 )
 */
public class Main {
    private JTextArea curbooks;
    private JButton sell;
    private JButton endButton;
    private JButton strategyButton;
    private JTextField stateField;
    private PricingStrategyFactory pricingStrategyFactory = PricingStrategyFactory.getInstance();
    private JLabel bookslabel;
    private JPanel store;
    private Sale sale = new Sale();
    public Main() {
        sale.addItem(new SaleLineItem(2, new ProductSpecification("test", 18, "UML与模式应用", 1), pricingStrategyFactory.getPricingStrategy(1)));
        sale.addItem(new SaleLineItem(2, new ProductSpecification("test", 34, "Java与模式", 3), pricingStrategyFactory.getPricingStrategy(3)));
        sale.addItem(new SaleLineItem(1, new ProductSpecification("test", 58, "Head First 设计模式", 3), pricingStrategyFactory.getPricingStrategy(3)));
        sale.addItem(new SaleLineItem(3, new ProductSpecification("test", 30, "爱丽丝历险记", 2), pricingStrategyFactory.getPricingStrategy(2)));
        sale.addItem(new SaleLineItem(1, new ProductSpecification("test", 20, "煲汤大全", 4), pricingStrategyFactory.getPricingStrategy(4)));
        curbooks.setText(sale.toString());
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order order = new Order(sale, curbooks);
                order.setSize(350, 300);
                order.setLocation(10, 100);
                order.setVisible(true);
            }
        });
        strategyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Strategy order = new Strategy();
                order.setSize(340, 180);
                order.setLocation(10, 400);
                order.setVisible(true);
            }
        });
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sale.reset();
                curbooks.setText(sale.toString());
            }
        });
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        JFrame frame = new JFrame("Init");
        frame.setContentPane(new Main().store);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
