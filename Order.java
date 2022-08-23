import javax.swing.*;
import java.awt.event.*;

public class Order extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField bookname;
    private JTextField bookisbn;
    private JTextField bookprice;
    private JComboBox booktype;
    private JTextField NoticeField;
    private JTextField bookcount;
    private PricingStrategyFactory pricingStrategyFactory = PricingStrategyFactory.getInstance();
    private Sale sale;
    private JTextArea curbooks;
    public Order(Sale _sale, JTextArea _curbooks) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        sale = _sale;
        curbooks = _curbooks;
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 点击 X 时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        ProductSpecification productSpecification = new ProductSpecification(bookisbn.getText(),
                Double.parseDouble(bookprice.getText())
                , bookname.getText(),
                booktype.getSelectedItem().toString().charAt(0) - '0');
        SaleLineItem saleLineItem = new SaleLineItem(Integer.parseInt(bookcount.getText()), productSpecification);
        saleLineItem.setStrategy(pricingStrategyFactory.getPricingStrategy(productSpecification.getType()));
        sale.addItem(saleLineItem);
        curbooks.setText(sale.toString());
        dispose();
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

}
