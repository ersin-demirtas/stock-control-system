import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class Master extends JFrame implements ActionListener {

        private JButton check = new JButton("Check Stock");
        private JButton purchase = new JButton("Purchase Item");
        private JButton stock = new JButton("Update Stock");
        private JButton quit = new JButton("Exit");

    public static void main(String[] args) {
        Master jf = new Master();
    }
    
    public Master() {
        setLayout(new BorderLayout());
        setSize(450, 100);
        setTitle("Master");

        // close application only by clicking the quit button
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel top = new JPanel();
        top.add(new JLabel("Select an option by clicking one of the buttons below"));
        add("North", top);

        JPanel bottom = new JPanel();
        bottom.add(check); check.addActionListener(this);
        bottom.add(purchase); purchase.addActionListener(this);
        bottom.add(stock); stock.addActionListener(this);
        bottom.add(quit); quit.addActionListener(this);
        add("South", bottom);

        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            new CheckStock();
        } else if(e.getSource() == purchase){
            new PurchaseItem();
        } else if(e.getSource() == stock){
            new UpdateStock();
        } else if (e.getSource() == quit) {
            StockData.close();
            System.exit(0);
        }
    }
}
