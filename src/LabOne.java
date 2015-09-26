import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LabOne extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -5230739004178973444L;
	final static int maxGap = 300;
	protected JButton b1, b2, b3, b4;
    GridLayout experimentLayout = new GridLayout(0,2);
    
    public LabOne(String name) {
        super(name);
        setResizable(true);
    }
    
    
    
    /* Image Creation methods:
     * sets the source images to ImageIcons 
     * then turns them into a JLabel object so that it can
     * be used by the JDialog method
     */
    
    
    // Gets source file and creates ImageIcon object
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = LabOne.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
   
  // Making ImageIcon objects...
    ImageIcon one = createImageIcon("duke09.gif");
    ImageIcon two = createImageIcon("duke11.gif");
    ImageIcon three = createImageIcon("duke03.gif");
    ImageIcon four = createImageIcon("duke04.gif");
    ImageIcon hello = createImageIcon("hello.gif");
    ImageIcon vanilla = createImageIcon("vanilla.gif");
    ImageIcon clown = createImageIcon("clown.gif");
    ImageIcon diploma = createImageIcon("diploma.gif");
    
    
  /*ImageIcons are turned into JLabelObjects to be used by
   * the JDialogs */
    JLabel salutation = new JLabel(hello);
    JLabel coffee = new JLabel(vanilla);
    JLabel congrats = new JLabel(clown);
    JLabel graduate = new JLabel(diploma);
   

    
    public void addComponentsToPane(final Container pane) {

        final JPanel dukeGrid = new JPanel();
        dukeGrid.setLayout(experimentLayout);
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2,3));
        
        
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        dukeGrid.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
       
        

        /* Creates and adds button objects with custom Action Command Code and
        * listeners to generate the appropriate dialog and image
        */
        b1 = new JButton(null, one);
        b1.addActionListener(this);
        b1.setActionCommand("salutations");
        dukeGrid.add(b1);
 
        
        b2 = new JButton(null, two);
        b2.addActionListener(this);
        b2.setActionCommand("congratulations");
        dukeGrid.add(b2);
       
        
        b3 = new JButton(null, three);
        b3.addActionListener(this);
        b3.setActionCommand("coffee");
        dukeGrid.add(b3);
        
        b4 = new JButton(null, four);
        b4.setActionCommand("diploma");
        b4.addActionListener(this);
        dukeGrid.add(b4);
        

        // Borders and Separators       

        pane.add(dukeGrid, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);
    }
    
    // single method for creating a custom JDialog and a showMessageDialogue
    
    public void createJDialog ( int width, int height, String Title, JLabel labelImage, String message, String windowTitle){
    	
    	 JDialog dialog = new JDialog ();
         dialog.setSize(height, width);
         dialog.setTitle(Title);
         dialog.getContentPane().add(labelImage);
         dialog.setVisible(true);
        JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE);
    	
    }
    
    
    /* Sets a custom JDialog depending on the action command
     * the action command determines the JDialog that is generated
     */
    
    public void actionPerformed(ActionEvent e) {
    	if ("diploma".equals(e.getActionCommand())){
			createJDialog (588, 392, "You got your Java degree!", graduate , "Duke has Graduated from the school of java", "Yay Java Degree");
    		}
    	if("congratulations".equals(e.getActionCommand())){
    		createJDialog(351, 342, "Congrats!", congrats,"Duke would like to thank you for an explosive \n job well done!", "Thanks!!");
    	}
    	if("salutations".equals(e.getActionCommand())){
    		createJDialog(567, 378, "Just Duke saying Hi!", salutation, "Just Duke saying Hi!", "Hello!");
    	}
    	if("coffee".equals(e.getActionCommand())){
    		createJDialog(305, 363, "Duke Swimming in Coffee", coffee, "Duke sure likes his cup of java!", "Coffee!");
    	}

    }
 
 /* main method and GUI creation obtained from Java GridLayout Examples
  * in oracle tutorial web page to show a nice and proper GUI
  * source: https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
  */
    
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        LabOne frame = new LabOne("GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    
   
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}
