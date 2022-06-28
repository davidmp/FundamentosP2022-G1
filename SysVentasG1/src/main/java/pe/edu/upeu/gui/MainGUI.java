package pe.edu.upeu.gui;

import javax.swing.JFrame;
import pe.edu.upeu.util.UtilsX;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MainGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    int numeros;
    JPanel panel;
    JTextField texto;
    JScrollPane scrollPane = new JScrollPane();
    BufferedImage image;
    JTable table;
    JMenuBar mb;
    JMenu m1;
    JMenu m2;
    JMenuItem m11;
    JMenuItem m22;
    UtilsX obj = new UtilsX();
    JPanel panelFoot;
    JButton send, reset;

    public MainGUI() {
        this.setTitle("SystemMain@DMP");
        mb = new JMenuBar();
        m1 = new JMenu("Archivo");
        m2 = new JMenu("Ayuda");
        m11 = new JMenuItem("Listar");
        m22 = new JMenuItem("Guardar como");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, screenSize.height - 36));
        mb.add(m1);
        mb.add(m2);
        m11.addActionListener(this);
        m1.add(m11);
        m1.add(m22);
        panelFoot = new JPanel();
        send = new JButton("Generar");
        reset = new JButton("Borrar");
        texto = new JTextField("6");
        texto.setPreferredSize(new Dimension(100, 25));
        send.addActionListener(this);
        panelFoot.add(texto);
        panelFoot.add(send);
        panelFoot.add(reset);
        this.getContentPane().add(BorderLayout.SOUTH, panelFoot);
        this.getContentPane().add(BorderLayout.NORTH, mb);
        this.setVisible(true);
    }

    public void panelTabla(Container contai) {
        contai.setBackground(new Color(0, 0, 255));
        table = new JTable(obj.reporData());
        scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.invalidate();
        scrollPane.validate();
        scrollPane.repaint();
        contai.add(BorderLayout.CENTER, scrollPane);
        contai.invalidate();
        contai.validate();
        contai.repaint();
    }

    public void pintarConejos(Graphics g) {
        int fibo = 0;
        int incx = 0;
        int incy = 0;
        for (int x = 1; x <= numeros; x++) {
            fibo = obj.fibonaciRecur(x);
            for (int y = 1; y <= fibo; y++) {
                g.drawImage(image, incx, incy, null);
                incx = incx + 100;
            }
            incx = 0;
            incy = incy + 100;
        }
    }

    public void panelDibujoImagen(Container contai) {
        numeros = Integer.parseInt(texto.getText());
        try {
            image = ImageIO.read(obj.getFile("images/conejo3.png"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                pintarConejos(g);
            }
        };
        panel.setPreferredSize(new Dimension(2000, 1000));
        scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.invalidate();
        scrollPane.validate();
        scrollPane.repaint();
        contai.add(BorderLayout.CENTER, scrollPane);
        contai.invalidate();
        contai.validate();
        contai.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        Container contai = this.getContentPane();
        contai.remove(scrollPane);
        if (e.getSource() == m11) {
            panelTabla(contai);
        }
        if (e.getSource() == send) {
            panelDibujoImagen(contai);
        }
    }

}
