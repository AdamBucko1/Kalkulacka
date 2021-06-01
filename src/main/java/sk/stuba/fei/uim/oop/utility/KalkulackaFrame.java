package sk.stuba.fei.uim.oop.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulackaFrame extends JFrame implements ActionListener, KeyListener {
    JTextField displej;
    int vysledok;
    int cislo;
    boolean ukazanyVysledok;
    String operacia;
    String zobrazenie;

    KButton[] cislice=new KButton[10];
    KButton scitanie;
    KButton odcitanie;
    KButton nasobenie;
    KButton rovnaSa;
    KButton reset;
    KButton znamienko;

    public KalkulackaFrame() {
        super("Kalkulacka");
        vysledok=0;
        cislo=0;
        ukazanyVysledok=false;
        operacia="+";
        zobrazenie="";

        displej=new JTextField(10);
        Font font1=new Font("Arial",Font.BOLD,20);

        displej.setSize(150,20);
        displej.setFont(font1);
        displej.setHorizontalAlignment(JTextField.RIGHT);
        displej.setEditable(false);
        JPanel p0=new JPanel();
        p0.add(displej);
        add(p0);
        JPanel p1=new JPanel();
        setLayout(new GridLayout(0,1));

        for (int i=0;i<10;i++) {
            cislice[i] = new KButton(Integer.toString(i));
            cislice[i].addActionListener(this);
        }
            scitanie= new KButton("+");
            scitanie.addActionListener(this);

            odcitanie= new KButton("-");
            odcitanie.addActionListener(this);

            nasobenie= new KButton("*");
            nasobenie.addActionListener(this);

            rovnaSa= new KButton("=");
            rovnaSa.addActionListener(this);

            reset= new KButton("CE");
            reset.addActionListener(this);

            znamienko= new KButton("-/+");
            znamienko.addActionListener(this);

            p1.add(cislice[0]);
            p1.add(znamienko);
            p1.add(reset);
            p1.add(rovnaSa);

            JPanel p2=new JPanel();
            p2.add(cislice[1]);
            p2.add(cislice[2]);
            p2.add(cislice[3]);
            p2.add(scitanie);


            JPanel p3=new JPanel();
            p3.add(cislice[4]);
            p3.add(cislice[5]);
            p3.add(cislice[6]);
            p3.add(odcitanie);

            JPanel p4=new JPanel();
            p4.add(cislice[7]);
            p4.add(cislice[8]);
            p4.add(cislice[9]);
            p4.add(nasobenie);

            add(p1);
            add(p2);
            add(p3);
            add(p4);

            displej.addKeyListener(this );

            setSize(300,300);
            setVisible(true);

            addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        dispose();System.exit(0);
                    }
                }
            );

            }
            public void actionPerformed(ActionEvent e){
        String bla=e.getActionCommand();
        akcia(bla);
            }
            public void keyTyped(KeyEvent e){
        String bla=Character.toString(e.getKeyChar());
        akcia(bla);
            }
            public void keyPressed(KeyEvent e){}
            public void keyReleased(KeyEvent e){}
            public void akcia(String bla){
        if ((bla.compareTo("0")>= 0)&&(bla.compareTo("9")<=0)){
            if (ukazanyVysledok==true){
                zobrazenie=bla;
            }
            else {
                zobrazenie=zobrazenie+bla;
            }
            ukazanyVysledok=false;
            cislo=Integer.parseInt(zobrazenie);
            displej.setText(zobrazenie);
        }
        if (bla.equals("-/+")){
            if (ukazanyVysledok==false){
                cislo=-cislo;
                zobrazenie=Integer.toString(cislo);
            }
            else {
                vysledok=-vysledok;
                zobrazenie=Integer.toString(vysledok);
            }
            displej.setText(zobrazenie);
        }
        if (bla.equals("CE")){
            ukazanyVysledok=false;
            cislo=0;
            zobrazenie="";
            vysledok=0;
            operacia="+";
            displej.setText(zobrazenie);

        }
        if (bla.equals("*")||bla.equals("-")||bla.equals("+")||bla.equals("=")){
            if (operacia.equals("+")){
                vysledok=vysledok+cislo;
            }
            if (operacia.equals("-")){
                vysledok=vysledok-cislo;
            }
            if (operacia.equals("*")){
                vysledok=vysledok*cislo;
            }
            zobrazenie=Integer.toString(vysledok);
            ukazanyVysledok=true;
            operacia=bla;
            displej.setText(zobrazenie);

        }
            }

        }
