import javax.swing.*;
import java.awt.event.*;

public class Strategy extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textbook;
    private JTextField comic;
    private JTextField cs;

    public Strategy() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        textbook.setText(String.valueOf(PricingStrategyFactory.getInstance().getDiscountPerbook()));
        comic.setText(String.valueOf(PricingStrategyFactory.getInstance().getDiscountPercentageForComic()));
        cs.setText(String.valueOf(PricingStrategyFactory.getInstance().getDiscountPercentageForCS()));
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
        // 在此处添加您的代码
        PricingStrategyFactory.getInstance().setDiscountPerbook(Double.parseDouble(textbook.getText()));
        PricingStrategyFactory.getInstance().setDiscountPercentageForComic(Integer.parseInt(comic.getText()));
        PricingStrategyFactory.getInstance().setDiscountPercentageForCS(Integer.parseInt(cs.getText()));
        dispose();
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

}
