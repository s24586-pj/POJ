import javax.swing.*;

public class BrickBreaker2 {
    public static void main(String[] args) {

        JFrame Okno =new JFrame();
        Okno.setTitle("Brick Breaker");
        Ustawienia Ustawienia = new Ustawienia();
        Okno.setBounds(30,30,600,500); //ustawienia  okna
        Okno.setVisible(true);
        Okno.add(Ustawienia);
        Okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
