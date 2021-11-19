
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jogo {

    private static Random random;
    private static JLabel player, pontos, score;
    private static int x = 140, y = 50, p = 0, a, b;

    public static void principal() {
    
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        player = new JLabel("●");
        player.setBounds(x, y, 14, 15);
        player.setForeground(Color.BLUE);
        panel.add(player);

        pontos = new JLabel("✪");
        random = new Random();
        a = random.nextInt(100);
        b = random.nextInt(100);
        pontos.setBounds(a, b, 14, 15);
        pontos.setForeground(Color.BLACK);
        panel.add(pontos);

        score = new JLabel("Pontuação: " + p);
        score.setBounds(480, 300, 100, 50);
        panel.add(score);

        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch (codigo) {
                    case KeyEvent.VK_RIGHT:
                        x = x + 10;
                        player.setBounds(x, y, 14, 15);
                        break;
                    case KeyEvent.VK_LEFT:
                        x = x - 10;
                        player.setBounds(x, y, 14, 15);
                        break;
                    case KeyEvent.VK_UP:
                        y = y - 10;
                        player.setBounds(x, y, 14, 15);
                        break;
                    case KeyEvent.VK_DOWN:
                        y = y + 10;
                        player.setBounds(x, y, 14, 15);
                        break;
                    default:
                        System.out.println("Use as setas do teclado.");
                        break;
                }

                if ((x <= a + 5 && x >= a - 5) && (y <= b + 5 && y >= b - 5)) {
                    a = random.nextInt(300);
                    b = random.nextInt(200);
                    pontos.setBounds(a, b, 14, 15);
                    p = p + 1;
                    score.setText("Pontuação: " + p);
                }
            }
        });  

        frame.setVisible(true);
    } 
    

}