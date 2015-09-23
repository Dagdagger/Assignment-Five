
import java.awt.*;

import javax.swing.*;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LabOne extends JFrame {
	
	private static final long serialVersionUID = -5230739004178973444L;
	final static int maxGap = 300;
	protected JButton b1, b2, b3, b4;
    GridLayout experimentLayout = new GridLayout(0,2);
    
    public LabOne(String name) {
        super(name);
        setResizable(true);
    }
  
    ImageIcon one = createImageIcon("duke09.gif");
    ImageIcon two = createImageIcon("duke11.gif");
    ImageIcon three = createImageIcon("duke03.gif");
    ImageIcon four = createImageIcon("duke04.gif");
    ImageIcon hello = createImageIcon("hello.gif");


protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = LabOne.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
   

    
    public void addComponentsToPane(final Container pane) {

        final JPanel dukeGrid = new JPanel();
        dukeGrid.setLayout(experimentLayout);
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2,3));
        
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        dukeGrid.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
        ImageIcon one = createImageIcon("duke09.gif");
        ImageIcon two = createImageIcon("duke11.gif");
        ImageIcon three = createImageIcon("duke03.gif");
        ImageIcon four = createImageIcon("duke04.gif");
        ImageIcon hello = createImageIcon("hello.gif");
        ImageIcon vanilla = createImageIcon("vanilla.gif");
        ImageIcon clown = createImageIcon("clown.gif");
        ImageIcon diploma = createImageIcon("diploma.gif");
        
        
        
        final JLabel salutation = new JLabel(hello);
        final JLabel coffee = new JLabel(vanilla);
        final JLabel congrats = new JLabel(clown);
        final JLabel graduate = new JLabel(diploma);
        
        b1 = new JButton(null, one);
        b1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
                JDialog dialog = new JDialog ();
                dialog.setSize(567, 378);
                dialog.setTitle("Just Duke saying Hi!");
                dialog.getContentPane().add(salutation);
                dialog.setVisible(true);
                JOptionPane.showMessageDialog(null, "Just Duke Saying Hi!");
            }
        });
 
        
        b2 = new JButton(null, two);
        b2.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
        		 JDialog dialog = new JDialog ();
                 dialog.setSize(351, 342);
                 dialog.setTitle("Congrats!");
                 dialog.getContentPane().add(congrats);
                 dialog.setVisible(true);
        		JOptionPane.showMessageDialog(null, "Duke would like to thank you for for an explosive \n job well done!", "Thanks!!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        b3 = new JButton(null, three);
        b3.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
                JDialog dialog = new JDialog ();
                dialog.setSize(305, 363);
                dialog.setTitle("Just Duke saying Hi!");
                dialog.getContentPane().add(coffee);
                dialog.setVisible(true);
               JOptionPane.showMessageDialog(null, "Duke sure likes his cup of java", "Coffee!!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        b4 = new JButton(null, four);
        b4.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
                JDialog dialog = new JDialog ();
                dialog.setSize(588, 392);
                dialog.setTitle("You got your Java Degree");
                dialog.getContentPane().add(graduate);
                dialog.setVisible(true);
               JOptionPane.showMessageDialog(null, "Duke has graduated from the school of java!", "yay Java degree", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        
        
        
        //Add buttons to experiment with Grid Layout
        dukeGrid.add(b1);
        dukeGrid.add(b2);
        dukeGrid.add(b3);
        dukeGrid.add(b4);

   
        
     ;
        pane.add(dukeGrid, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
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