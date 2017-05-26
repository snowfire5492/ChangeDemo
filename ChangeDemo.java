// Demonstrate a change listener and the button model.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ChangeDemo {

  JButton jbtn;
  JLabel jlab;

  ChangeDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Button Change Events");

    // Specify FlowLayout for the layout manager.
    jfrm.getContentPane().setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(250, 160);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create an empty label.
    jlab = new JLabel();

    // Make a button.
    jbtn = new JButton("Press for Change Event Test");
    
    jbtn.setActionCommand("button");

    // Add change listener.
    jbtn.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent ce) {
        ButtonModel mod = jbtn.getModel();
        String what = "";
        
        if(jbtn.getActionCommand().equals("button")){						
// had to add code to make program work
        	mod.setArmed(true);
        }

        if(mod.isEnabled()) what += "Enabled<br>";
        if(mod.isRollover()) what += "Rollover<br>";
        if(mod.isArmed()) what += "Armed<br>";
        if(mod.isPressed()) what += "Pressed<br>";

        // Notice that this label's text is HTML.
        jlab.setText("<html>Current state:<br>" + what);
      }
    });

    // Add the components to the content pane.
    jfrm.getContentPane().add(jbtn);
    jfrm.getContentPane().add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }


  public static void main(String args[]) {
    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new ChangeDemo();
      }
    });
  }
}
