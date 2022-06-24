import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Ustawienia extends JPanel implements KeyListener, ActionListener {


    boolean gra =true;
    Timer timer;
    Mapa mapka;
    //ImageIcon tlo = new ImageIcon("tlo.jpg");
    int wynik=0;
    int klocki=28;
    int KlocekX;
    int KlocekY;
    int KlocekSzerokosc;
    int KlocekWysokosc;
    //STARTER GDZIE MA SIĘ WSZYSTKO ZNAJDOWAC
     int paletka=200;
    int pilkaX=200;
    int pilkaY=320;
    int kierunekX=-1;
    int kierunekY=-2;


    /*
    PALETKA JAKO LABEL WERSJA NIEUDANA
label =new JLabel();
       label.setBackground(Color.darkGray);
       //jesli za trudne zwiększ szerokosc!
       label.setBounds(150,400,100,15);
       label.setOpaque(true);
       this.add(label);

 */

     public Ustawienia() {
         //ilosc wierszy,kolumn
         mapka= new Mapa(4,7);
         //umozliwa poruszanie sie,wczytuje dane z klawiatury
         addKeyListener(this);
         //skup sie na gierce bez tego nie bedzie sie poruszac paletka
         setFocusable(true);
         //co ile ma sie odswiezac/predkosc kulki (maksymalna predkosc to 1 bo jest jako int)
         timer = new Timer(1,this);
         timer.start();
     }




    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if(gra) {
            //pilka paletka ruch
            //interakcja pomiedzy pilka a paletka==rectangle prostokat gdzie "odbywa sie interakcja"
            //jesli pilka uderzy w okienko zmien kierunek
            //umożliwiaja rozstrzygania wzajemnego położenia->intersects miedzy pilka a paletka
            if (new Rectangle(pilkaX, pilkaY, 20, 20).intersects(new Rectangle(paletka, 400, 100, 10))) {
                kierunekY = -kierunekY;
            }
            //dla wszystkich klockow
            for(int i=0;i<mapka.map.length;i++){
                for(int j=0;j<mapka.map[0].length;j++) {
                    if(mapka.map[i][j]>0){
                         KlocekX=j* mapka.szerokosc+50;
                         KlocekY=i* mapka.wysokosc+50;
                         KlocekSzerokosc=mapka.szerokosc;
                         KlocekWysokosc=mapka.wysokosc;
                        Rectangle zbicie = new Rectangle(KlocekX,KlocekY,KlocekSzerokosc,KlocekWysokosc);
                        Rectangle zbiciepi = new Rectangle(pilkaX,pilkaY,20,20);


                        //interakcja miedzy uderzeniem pilki w klocek odwołujemy sie do funkcji Mapa punkty
                       if(zbiciepi.intersects(zbicie)){
                           mapka.Punkty(0,i,j);
                           klocki--;
                           wynik+=10;
                           //odbicie sie pilki od klocka
                           //jesli uderzy zmien kierunek pileczki
                           if(pilkaX <=zbicie.x || pilkaX >=zbicie.x+zbicie.width ){
                               kierunekX*=-1;
                           }else{
                               kierunekY*=-1;
                           }
                       }

                }
                }

            }
            pilkaX += kierunekX;
            pilkaY += kierunekY;
            //jesli walnie w sciane odbije sie ->lewa sciana
            if (pilkaX < 0) {
                kierunekX *=-1;
            }
            //jesli walnie w sciane odbije sie ->sufit
            if (pilkaY < 0) {
                kierunekY*=-1;
            }
            //jesli walnie w sciane odbije sie ->prawa sciana
            if (pilkaX > 570) {
                kierunekX*=-1;
            }

        }

        repaint();
    }

     public void paint(Graphics g){
         //Rysowanie wszystkich rzeczy
         //ustawienie tla
         g.setColor(Color.WHITE);
         g.fillRect(1,1,620,520);
         //ustawienie paletki
         g.setColor(Color.BLACK);
         g.fillRect(paletka,400,100,10);
         //ustawienie kulki
         g.setColor(Color.black);
         g.fillOval(pilkaX,pilkaY,20,20);
         //ustawienie wyniku
         g.setColor(Color.black);
         g.setFont(new Font("Monospaced", Font.BOLD, 40));
         g.drawString(""+wynik,500,450);


         //jesli piłka opadnie na -450 wyswietl komunikat
         if(pilkaY>450){
             gra=false;
             g.setColor(Color.RED);
             g.setFont(new Font("Monospaced", Font.BOLD, 40));
             g.drawString("PRZEGRAŁES",165,200);
             g.setFont(new Font("Monospaced", Font.BOLD, 40));
             g.drawString("¯\\_(ツ)_/¯",165,150);
             return;
         }

         //koniec jest jak zbijesz wszystkie klocki =280-28 blokow
         if(wynik == 280){
             gra=false;
             g.setColor(Color.GREEN);
             g.setFont(new Font("Monospaced", Font.BOLD, 40));
             g.drawString("WYGRAŁES!",165,200);
             g.setFont(new Font("Monospaced", Font.BOLD, 40));
             g.drawString("༼ つ ◕_◕ ༽つ",165,150);

         }

         //mapka ma byc narysowana na ekranie
         mapka.draw((Graphics2D)g);
     }


    @Override
    public void keyTyped(KeyEvent e) {
        // to samo co keyPressed tylko obsługuje unicode nie zareaguje na przyciski funkcyjne
    }

    @Override
    public void keyPressed(KeyEvent e) {

        /*
        //wywoływana, gdy wciśniemy przycisk
        if(e.getKeyChar() == 'a' && label.getX()>-50) {
            label.setLocation(label.getX() - 50, label.getY());
        }
        else
        if(e.getKeyChar() == 'd' && label.getX()<450){
            label.setLocation(label.getX()+50,label.getY());
                }

        }
         */

        if (e.getKeyChar() == 'd') {
            //maksymalny zasięg,po to zeby nie uciekla (prawa strona ekranu)
            if (paletka >= 500) {
                paletka = 500;
            } else
                //prawo
                paletka+=30;
        }
        //maksymalny zasięg,po to zeby nie uciekla (lewa strona ekranu)
        if (e.getKeyChar() == 'a') {
            if (paletka < 10) {
                paletka = 10;
            } else
                //lewo
                paletka-=30;
        }
    }




    @Override
    public void keyReleased(KeyEvent e) {
//wywoływana, gdy puścimy przycisk
    }
}

