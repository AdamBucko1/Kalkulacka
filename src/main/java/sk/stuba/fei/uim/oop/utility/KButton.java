package sk.stuba.fei.uim.oop.utility;

import javax.swing.*;
import java.awt.*;

public class KButton extends JButton {
    public KButton(String napis) {
        super(napis);
        Font font=new Font("Arial",Font.BOLD,20);
        setPreferredSize(new Dimension(60,30));
        setFont(font);
    }
}
