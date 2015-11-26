/* 
 * Ersin Demirtas / 000739048
 */

//Imported libraries to add components and layout manager to manage layout of the window. 
import java.awt.GridLayout; //layout
import javax.swing.JButton; //button
import javax.swing.JFrame; //window
import javax.swing.JLabel; //label
import javax.swing.JTextField; //text box

/* 
 * UpdateStock class extends JFrame (Super Class)
 * Becuase JFrame is extended when the UpdateStock's constructor is called at the same time JFrames constructor will be called.
 */
public class UpdateStock extends JFrame{
    
    //instances and objects are created outside the methods for allowing methods to access from any method that is not static.
    JTextField stockNoStr = new JTextField(7); //New object of text field with column limit 7 passing it to constructor.
    JTextField numberOfItemsStr = new JTextField(10); //New object of text field with column limit 10 passing it to constructor.
    JButton updateButton = new JButton("Update");  //New objet of button with text of the button "Update".
    
    public UpdateStock() {
        setTitle("Update Stock"); //Set title for the window.    
        setLayout(new GridLayout(3, 2)); //Set window layout manager, GridLayout manager with row of 3 and column of 2.

        add(new JLabel("Item number")); //added label
        add(stockNoStr); //added text box
        add(new JLabel("Number of new items")); //added label
        add(numberOfItemsStr); //added text box
        add(updateButton); //added button
        
        setSize(300, 100); //Set window size
        setVisible(true); //window set visible
    }

}
