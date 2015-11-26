/* 
 * Ersin Demirtas / 000739048
 */

//Imported libraries to make buttons functional and manage layout of the window. 
import java.awt.BorderLayout; //layout manager.
import java.awt.TextArea; //large text field.
import java.awt.event.ActionListener; //action listener for the componenets.
import java.awt.event.ActionEvent; //action event for the action lister.

//Imported all required compontents to create windows, text box, button, label and panel.
import javax.swing.JFrame; //window.
import javax.swing.JTextField; //text box.
import javax.swing.JButton; //button.
import javax.swing.JLabel; //label.
import javax.swing.JPanel; //panel.

//Imported DecimalFormat to ceate a custom format for the decimal numbers.
import java.text.DecimalFormat;


/* 
 * CheckStock class extends JFrame (Super Class) and implements interface ActionListener.
 * Becuase JFrame is extended when the CheckStock's constructor is called at the same time JFrames constructor will be called.
 */
public class CheckStock extends JFrame implements ActionListener {
    
    //instances and objects are created outside the methods for allowing methods to access from any method that is not static.
    JTextField stockNo = new JTextField(7); //New object of text field with column limit 7 passing it to constructor.
    TextArea information = new TextArea(3, 50); //New object of text area with row size of 3 and column size of 50.
    JButton check = new JButton("Check Stock"); //New objet of button with text of the button "Check Stock".
    DecimalFormat pounds = new DecimalFormat("£#,##0.00"); //New object of DecimalFormat with custom deciaml format
    
    //Constructor
    public CheckStock() {
        setLayout(new BorderLayout()); //Set layout manager to BorderLayout
        setBounds(100, 100, 450, 150); //Set possition of the window in screen. The first two integers are the position of the screen and last is the with and height of the window.
        setTitle("Check Stock"); //Set title for the window.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Set default close operation fo the window as dispose on close so that it doesn't close all the programm. 
        JPanel top = new JPanel(); //New object of JPanel for the top side of the window, this constuctor with create a panel with flow layout manager.
        top.add(new JLabel("Enter Stock Number:")); //using the add method to add JLabel.
        top.add(stockNo); //stockNo (JTextField) is added to top JPanel.
        top.add(check); //check (JButton) is added to top JPanel.
        check.addActionListener(this); //check (JButton) is registered for action listening.
        add("North", top); //top (JPanel) is added to top of the window, the first parameter defines where the conponent should be located. Because you are using BorderLayout you can only add to NORTH (top), SOUTH (bottom), EAST (right), WEST (left) and Center. 
        JPanel middle = new JPanel(); //New object of JPanel for middle of the window.
        middle.add(information); //information (JTextArea) is added to middle panel
        add("Center", middle); //middle (JPanel) is been added to "Center" of the window.

        setResizable(false); //Window resizable set to false. 
        setVisible(true); //Window visile set to true so it shows the window.
    }

    //This method is implements because its abstract method from ActionListener interface.
    //Return type declared as void so it won't return any information
    public void actionPerformed(ActionEvent e) {
        String key = stockNo.getText(); //stockNo (JTextField) 's value is assigned to key variable by using the getText().
        
        String name = StockData.getName(key); //Using StockData class with its static getName method to get the name of the item.
        
        //checking if the StockData.getName(key) returned an empty name.
        if (name == null) {
            //if the expretion above is true then, information (JTextArea) set Text to "No such item in stock".
            information.setText("No such item in stock"); 
        }
        else {
            //if the expresion is flase then this else branch will be executed.
            information.setText(name); //information (JTextArea) set Text to name of the item returned from StockData.getName(key).
            information.append("\nPrice: " + pounds.format(StockData.getPrice(key))); //appends new line in information (JTextArea) with price of the item.
            information.append("\nNumber in stock: " + StockData.getQuantity(key)); //appends new line in information (JTextArea) with number of items in stock for the item.
        }
    }
} //class CheckStock eneded