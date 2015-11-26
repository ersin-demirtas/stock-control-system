/* 
 * Ersin Demirtas / 000739048
 */

//Imported libraries to make buttons functional and manage layout of the window. 
import java.awt.GridLayout; //layout
import javax.swing.JButton; //button
import javax.swing.JFrame; //window
import javax.swing.JLabel; //label
import javax.swing.JTextField; //text box

/* 
 * PurchaseItem class extends JFrame (Super Class)
 * Becuase JFrame is extended when the PurchaseItem's constructor is called at the same time JFrames constructor will be called.
 */
public class PurchaseItem extends JFrame{
    
    
    JTextField stockNoStr = new JTextField(7); //New object of text field with column limit 7 passing it to constructor.
    JTextField numberOfItemsStr = new JTextField(10); //New object of text field with column limit 10 passing it to constructor.
    JButton purchaseButton = new JButton("Purchase");  //New objet of button with text of the button "Purchase".

    public PurchaseItem() {
        setTitle("Purchase Item"); //set window title to "Purchase Item" 
        setSize(300, 100); //set window size
        setLayout(new GridLayout(3, 2)); //Set window layout manager, GridLayout manager with row of 3 and column of 2.

        add(new JLabel("Item number")); //added label
        add(stockNoStr); //added text box

        add(new JLabel("Number of items")); //added label
        add(numberOfItemsStr); //added text box
        add(purchaseButton); //added button

        setVisible(true); //window set visible
    }
}
