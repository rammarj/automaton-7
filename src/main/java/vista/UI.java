/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.*;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author Joaquin R. Martinez
 */
public class UI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txt_lenguaje;
    private JButton btn_info;
    private JEditorPane txta_info;
    //private JCheckBox chb_direcciones;
    private JMenuItem mnui_salir, mnui_guardar_Resultado;
    private JFileChooser fch_guardar;
    private StringBuffer strb;

    public UI() throws HeadlessException {
        super("Grafos");
        this.strb = new StringBuffer();
        char p = File.separatorChar;
        setIconImage(new ImageIcon("src" + p + "com" + p + "vista" + p
                + "imgs" + p + "Edit_24x24.png").getImage());
        this.txt_lenguaje = new JTextField(20);
        this.txta_info = new JEditorPane();
        this.txta_info.setEditorKit(new HTMLEditorKit());
        this.txta_info.setEditable(false);
//        this.txta_info.setText("<!DOCTYPE html><html>"
//                + "<head><style>div{padding: 60px; padding-left: 150px; color: gray}</style></head><body>"
//                + "<div><h1>Test de informacion &nbsp; AUTOMATAS</h1></div></body>"
//                + "</html></html>");
        //this.txta_info.setText("<DOCTYPE html><html><body><h1 style='color:red;'>joaqun</h1></body></html>");
        //this.txta_info.setSize(600, 1660);
        this.fch_guardar = new JFileChooser();
        //this.chb_direcciones = new JCheckBox("usar direcciones");
        this.txta_info.setFont(new Font("Arial", 1, 13));
        //this.txta_info.setForeground(Color.WHITE);
        //this.txta_info.setBackground(Color.BLACK);
        //this.txta_info.setEditable(false);
        this.txta_info.setSize(600, 380);
        this.btn_info = new JButton("comprobar");
        this.btn_info.addActionListener(this);
        this.mnui_guardar_Resultado = new JMenuItem("Guardar resultados");
        this.mnui_guardar_Resultado.addActionListener(this);
        this.mnui_salir = new JMenuItem("Salir");
        this.mnui_salir.addActionListener(this);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Archivo");
        jMenu.add(this.mnui_guardar_Resultado);
        jMenu.add(this.mnui_salir);
        jMenuBar.add(jMenu);
        this.setJMenuBar(jMenuBar);

        JPanel jp_input = new JPanel();

        //jp_input.add(this.chb_direcciones);
        jp_input.add(new JLabel("Lenguaje: "));
        jp_input.add(this.txt_lenguaje);
        jp_input.add(this.btn_info);

        add("North", jp_input);
        add("Center", new JScrollPane(this.txta_info));

        //add("South", new JScrollPane(this.txta_info));
        setLocationByPlatform(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(630, 400);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn_info) {
            btn_info_click();
        } else if (e.getSource() == this.mnui_guardar_Resultado) {
            try {
                guardar_click();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ocurrio un error al guardar el archivo:\n" + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == this.mnui_salir) {
            System.exit(0);
        }
    }

    void btn_info_click() {
        FiniteAutomaton afd;
        this.strb.replace(0, this.strb.length(), "");
        this.strb.append("<DOCTYPE html><head>"+
                "<style>div{border: 5px;color:black;padding-bottom: 15px; font-family: sans-serif;\n" +
"                                           font-size: 11px}</style>"
                + "</head><html><body>");
        try {
            afd = new AFD1();
            afd.evaluate(this.txt_lenguaje.getText());
            comprobar(afd,1);
            
            afd = new AFD2();
            afd.evaluate(this.txt_lenguaje.getText());
            comprobar(afd,2);
            
            afd = new AFD3();
            afd.evaluate(this.txt_lenguaje.getText());
            comprobar(afd,3);
            
            afd = new AFD4();
            afd.evaluate(this.txt_lenguaje.getText());
            comprobar(afd,4);
            
            afd = new AFD5();
            afd.evaluate(this.txt_lenguaje.getText());
            comprobar(afd,5);
            
            afd = new AFD6();
            afd.evaluate(this.txt_lenguaje.getText());
            comprobar(afd,6);
            
            afd = new AFD7();
            afd.evaluate(this.txt_lenguaje.getText());
            comprobar(afd,7);
            
        this.strb.append("</body></html>");
        this.txta_info.setText(this.strb.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    void guardar_click() throws Exception {
        int showSaveDialog = this.fch_guardar.showSaveDialog(this);
        if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
            File selectedFile = this.fch_guardar.getSelectedFile();
            try (FileWriter fileWriter = new FileWriter(selectedFile+".html")) {
                fileWriter.write(this.txta_info.getText().replace("\n", System.lineSeparator()));
                fileWriter.flush();
            }            
        }
    }

    void comprobar(FiniteAutomaton afd, int id) {
        this.strb.append("<div><span style='color:green;'>[+]</span>Testeando afd No. "+(id)+"<br>");
        afd.compile();
        if (afd.isAccepted()) {
            this.strb.append("<span style='color:green;'>[+]</span><span style='color:blue'> Aceptado");
        } else {
            this.strb.append("<span style='color:red;'>[-]</span><span style='color:#ff9933'> No aceptado. " + afd.getErrorMessage()+"</span>");
        }
        this.strb.append("</div>");
    }

}
