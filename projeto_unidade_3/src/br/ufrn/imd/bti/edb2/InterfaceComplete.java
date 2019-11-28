package br.ufrn.imd.bti.edb2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfaceComplete extends JFrame implements ActionListener {
    private JTextArea text = new JTextArea();
    private JLabel resultOut = new JLabel();
    private JLabel prefix = new JLabel("Prefixo:");
    private JLabel result = new JLabel("Palavras encontradas");
    private JButton submit = new JButton("Buscar");

    private Trie t;


    public InterfaceComplete(Trie t) {
        super("Auto complete");
        this.t = t;
        this.open();
    }

    public void open() {
        setLayout(null);

        setSize(350, 300);
        //Labels
        prefix.setBounds(30, 40, 100, 20);
        result.setBounds(30, 80, 250, 20);

        resultOut.setVerticalAlignment(SwingConstants.TOP);
        resultOut.setBounds(30, 100, 280, 150);
        resultOut.setOpaque(true);
        resultOut.setBackground(Color.white);

        //Text areas
        text.setBounds(100, 40, 100, 20);

        //Buttons
        submit.setSize(100, 20);
        submit.setLocation(210, 40);
        submit.addActionListener(this);

        getContentPane().add(text);
        getContentPane().add(prefix);
        getContentPane().add(submit);
        getContentPane().add(result);
        getContentPane().add(resultOut);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (text.getText().length() == 0) {
            resultOut.setText("Informe um prefixo");
            return;
        }
        List<String> results = t.autoComplete(text.getText(), 10);

        String output = "<html>";
        if (results == null) {
            resultOut.setText("Nenhuma palavra encontrada");

        }else {
            for (String word : results) {
                output = output + word + "<br>";
            }
            output = output + "</html>";
            resultOut.setText(output);
        }
    }
}
