import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Fenetre extends JFrame {

    private final JPanel container = new JPanel();
    private final JPanel container_haut = new JPanel();
    private final JPanel container_centre = new JPanel();
    private final JPanel container_droite = new JPanel();
    private final JPanel container_gauche = new JPanel();

    private final JTextArea zone_calc = new JTextArea();
    private final JButton bout_clear = new JButton("c");
    private final JButton bout_0 = new JButton("0");
    private final JButton bout_1 = new JButton("1");
    private final JButton bout_2 = new JButton("2");
    private final JButton bout_3 = new JButton("3");
    private final JButton bout_4 = new JButton("4");
    private final JButton bout_5 = new JButton("5");
    private final JButton bout_6 = new JButton("6");
    private final JButton bout_7 = new JButton("7");
    private final JButton bout_8 = new JButton("8");
    private final JButton bout_9 = new JButton("9");
    private final JButton bout_addition = new JButton("+");
    private final JButton bout_soustraction = new JButton("-");
    private final JButton bout_multiplication = new JButton("*");
    private final JButton bout_division = new JButton("/");
    private final JButton bout_egal = new JButton("=");

    private final JButton bout_cos = new JButton("cos");
    private final JButton bout_sin = new JButton("sin");
    private final JButton bout_sqrt = new JButton("sqrt");
    private final JButton bout_puissance = new JButton("x^n");

    private double chiffre1;
    private String operateur = "";
    private boolean clicOperateur = false;
    private boolean update = false;

    private final ActionsListener actionslistener = new ActionsListener();

    public Fenetre() {
        this.setVisible(true);
        this.setTitle("Calculatrice");
        this.setSize(255, 200);
        this.getContentPane().add(container);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(this.getClass().getResource("icone.png")).getImage());

        container.setLayout(new BorderLayout());

        init_container_haut();
        init_container_centre();
        init_container_droite();
        init_container_gauche();
        setListener();
    }

    public static void main(String[] args) {
        new Fenetre();
    }

    private void init_container_haut() {
        container.add(container_haut, BorderLayout.NORTH);

        container_haut.add(zone_calc);
        zone_calc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zone_calc.setPreferredSize(new Dimension(170, 20));
        zone_calc.setEditable(false);
        container_haut.add(bout_clear);
        bout_clear.setToolTipText("Effacer le texte");
        bout_clear.setContentAreaFilled(false);
    }

    private void init_container_centre() {
        container.add(container_centre, BorderLayout.CENTER);

        container_centre.add(bout_1);
        bout_1.setContentAreaFilled(false);
        container_centre.add(bout_2);
        bout_2.setContentAreaFilled(false);
        container_centre.add(bout_3);
        bout_3.setContentAreaFilled(false);
        container_centre.add(bout_4);
        bout_4.setContentAreaFilled(false);
        container_centre.add(bout_5);
        bout_5.setContentAreaFilled(false);
        container_centre.add(bout_6);
        bout_6.setContentAreaFilled(false);
        container_centre.add(bout_7);
        bout_7.setContentAreaFilled(false);
        container_centre.add(bout_8);
        bout_8.setContentAreaFilled(false);
        container_centre.add(bout_9);
        bout_9.setContentAreaFilled(false);
        container_centre.add(bout_0);
        bout_0.setContentAreaFilled(false);
        container_centre.add(bout_egal);
        bout_egal.setPreferredSize(new Dimension(65, 29));
        bout_egal.setContentAreaFilled(false);
    }

    private void init_container_droite() {
        container.add(container_droite, BorderLayout.EAST);
        container_droite.setPreferredSize(new Dimension(50, 220));

        container_droite.add(bout_addition);
        bout_addition.setContentAreaFilled(false);
        bout_addition.setBorderPainted(false);
        container_droite.add(bout_soustraction);
        bout_soustraction.setContentAreaFilled(false);
        bout_soustraction.setBorderPainted(false);
        container_droite.add(bout_division);
        bout_division.setContentAreaFilled(false);
        bout_division.setBorderPainted(false);
        container_droite.add(bout_multiplication);
        bout_multiplication.setContentAreaFilled(false);
        bout_multiplication.setBorderPainted(false);
    }

    private void init_container_gauche() {
        container.add(container_gauche, BorderLayout.WEST);
        container_gauche.setPreferredSize(new Dimension(52, 220));

        container_gauche.add(bout_cos);
        bout_cos.setFont(new Font("Verdana", Font.PLAIN, 12));
        bout_cos.setContentAreaFilled(false);
        bout_cos.setBorderPainted(false);
        container_gauche.add(bout_sin);
        bout_sin.setFont(new Font("Verdana", Font.PLAIN, 12));
        bout_sin.setContentAreaFilled(false);
        bout_sin.setBorderPainted(false);
        container_gauche.add(bout_puissance);
        bout_puissance.setFont(new Font("Verdana", Font.PLAIN, 12));
        bout_puissance.setContentAreaFilled(false);
        bout_puissance.setBorderPainted(false);
        container_gauche.add(bout_sqrt);
        bout_sqrt.setFont(new Font("Verdana", Font.PLAIN, 12));
        bout_sqrt.setContentAreaFilled(false);
        bout_sqrt.setBorderPainted(false);
    }

    private void setListener() {
        bout_clear.addActionListener(actionslistener);
        bout_0.addActionListener(actionslistener);
        bout_1.addActionListener(actionslistener);
        bout_2.addActionListener(actionslistener);
        bout_3.addActionListener(actionslistener);
        bout_4.addActionListener(actionslistener);
        bout_5.addActionListener(actionslistener);
        bout_6.addActionListener(actionslistener);
        bout_7.addActionListener(actionslistener);
        bout_8.addActionListener(actionslistener);
        bout_9.addActionListener(actionslistener);
        bout_cos.addActionListener(actionslistener);
        bout_sin.addActionListener(actionslistener);
        bout_puissance.addActionListener(actionslistener);
        bout_sqrt.addActionListener(actionslistener);
        bout_addition.addActionListener(actionslistener);
        bout_soustraction.addActionListener(actionslistener);
        bout_multiplication.addActionListener(actionslistener);
        bout_division.addActionListener(actionslistener);
        bout_egal.addActionListener(actionslistener);
    }

    private void calculer() {
        switch (operateur) {
            case "+":
                chiffre1 = chiffre1 + Double.valueOf(zone_calc.getText());
                zone_calc.setText(String.valueOf(chiffre1));
                break;
            case "-":
                chiffre1 = chiffre1 - Double.valueOf(zone_calc.getText());
                zone_calc.setText(String.valueOf(chiffre1));
                break;
            case "*":
                chiffre1 = chiffre1 * Double.valueOf(zone_calc.getText());
                zone_calc.setText(String.valueOf(chiffre1));
                break;
            case "/":
                chiffre1 = chiffre1 / Double.valueOf(zone_calc.getText());
                zone_calc.setText(String.valueOf(chiffre1));
                break;
            case "cos":
                chiffre1 = Math.cos(Double.valueOf(zone_calc.getText()));
                zone_calc.setText(String.valueOf(chiffre1));
                break;
            case "sin":
                chiffre1 = Math.sin(Double.valueOf(zone_calc.getText()));
                zone_calc.setText(String.valueOf(chiffre1));
                break;
            case "sqrt":
                chiffre1 = Math.sqrt(Double.valueOf(zone_calc.getText()));
                zone_calc.setText(String.valueOf(chiffre1));
                break;
            case "puissance":
                zone_calc.setText(String.valueOf(Math.pow(chiffre1, Double.valueOf(zone_calc.getText()))));
                break;
        }
    }

    class ActionsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (arg0.getSource() == bout_addition) {
                if (clicOperateur) {
                    calculer();
                    zone_calc.setText(String.valueOf(chiffre1));
                } else {
                    chiffre1 = Double.valueOf(zone_calc.getText());
                    clicOperateur = true;
                }

                operateur = "+";
                update = true;
            } else if (arg0.getSource() == bout_soustraction) {
                if (clicOperateur) {
                    calculer();
                    zone_calc.setText(String.valueOf(chiffre1));
                } else {
                    chiffre1 = Double.valueOf(zone_calc.getText());
                    clicOperateur = true;
                }

                operateur = "-";
                update = true;
            } else if (arg0.getSource() == bout_multiplication) {
                if (clicOperateur) {
                    calculer();
                    zone_calc.setText(String.valueOf(chiffre1));
                } else {
                    chiffre1 = Double.valueOf(zone_calc.getText());
                    clicOperateur = true;
                }

                operateur = "*";
                update = true;
            } else if (arg0.getSource() == bout_division) {
                if (clicOperateur) {
                    calculer();
                    zone_calc.setText(String.valueOf(chiffre1));
                } else {
                    chiffre1 = Double.valueOf(zone_calc.getText());
                    clicOperateur = true;
                }

                operateur = "/";
                update = true;
            } else if (arg0.getSource() != bout_addition && arg0.getSource() != bout_soustraction && arg0.getSource() != bout_multiplication && arg0.getSource() != bout_division && arg0.getSource() != bout_clear && arg0.getSource() != bout_egal && arg0.getSource() != bout_cos && arg0.getSource() != bout_sin && arg0.getSource() != bout_puissance && arg0.getSource() != bout_sqrt) {
                String str = ((JButton) arg0.getSource()).getText();

                if (update) {
                    update = false;
                } else {
                    if (!zone_calc.getText().equals("0")) {
                        str = zone_calc.getText() + str;
                    }
                }

                zone_calc.setText(str);
            } else if (arg0.getSource() == bout_egal) {
                calculer();
                update = true;
                clicOperateur = false;
            } else if (arg0.getSource() == bout_cos) {
                operateur = "cos";
                calculer();
            } else if (arg0.getSource() == bout_sin) {
                operateur = "sin";
                calculer();
            } else if (arg0.getSource() == bout_puissance) {
                if (clicOperateur) {
                    calculer();
                    zone_calc.setText(String.valueOf(chiffre1));
                } else {
                    clicOperateur = true;
                    chiffre1 = Double.valueOf(zone_calc.getText());
                }

                operateur = "puissance";
                update = true;
            } else if (arg0.getSource() == bout_sqrt) {
                operateur = "sqrt";
                calculer();
            } else if (arg0.getSource() == bout_clear) {
                clicOperateur = false;
                update = true;
                chiffre1 = 0;
                operateur = "";
                zone_calc.setText("");
            }

        }
    }
}
