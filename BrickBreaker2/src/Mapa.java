import java.awt.*;

public class Mapa {

    public int map[][],szerokosc,wysokosc;


    //pobiera z ustawien ilosc wierszy i kolumn
    public Mapa(int wiersz, int kolumna) {
        map = new int[wiersz][kolumna];
        for (int i = 0; i < map.length; i++) {
            //od nowa (polowa)
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }
        //szerokosc ekranu wynosi 600
        szerokosc = 500 / kolumna;
        //wysokosc ekranu wynosi 500
        wysokosc = 150 / wiersz;

    }

        //Rysuj dla każdej poszczególnej
        public void draw(Graphics2D graphics2D) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] > 0) {
                        graphics2D.setColor(Color.BLACK);
                        //polozenie kwadratow na ekranie zeby polowa nie byla poza oknem
                        graphics2D.fillRect(j * szerokosc + 50, i * wysokosc + 50, szerokosc, wysokosc);
                        //Linie oddzielajace kwadraty
                        graphics2D.setStroke(new BasicStroke(2));
                        graphics2D.setColor(Color.WHITE);
                        graphics2D.drawRect(j * szerokosc + 50, i * wysokosc + 50, szerokosc, wysokosc);
                    }
                }
            }
        }
            public void Punkty(int punkty,int wiersz,int kolumna){
             map[wiersz][kolumna]=punkty;

            }
            }



