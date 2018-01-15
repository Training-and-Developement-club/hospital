package TheDevineHospital.GUI_NotStarted;

import TheDevineHospital.EntityClasses.Hospital;
import TheDevineHospital.SortPackage.SortByName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;


/*
 * This class contains all Grafical User Interface.
 */
public class MyGUI {
    private Hospital hospital;
    JButton button;
    JButton button1;
    JFrame frame;
    JLabel label;



    public void goGui(Hospital hospital) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        button = new JButton("sortByName");
        button.addActionListener(new ButtonListener());

        //label = new JLabel("I am a label.");

        frame.getContentPane().add(BorderLayout.NORTH,button);
       // frame.getContentPane().add(BorderLayout.EAST,label);


        frame.setSize(400, 400);
        frame.setVisible(true);

    }
    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(hospital.getDoctors().toString());
            Collections.sort(hospital.getDoctors(), new SortByName());
            System.out.println(hospital.getDoctors().toString());
        }
    }

















    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

}
