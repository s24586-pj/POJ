public class Buzka implements Skalowalny,PrzedstawiaEmocje,Rysowalny{

    String u2=":-(";
    public Buzka(char c) {

        super();
    }

    @Override
    public void draw(int times) {

    }

    @Override
    public boolean czySieUsmiecha() {
        return false;
    }

    @Override
    public void przestanSieUsmiechac() {

    }

    @Override
    public void draw() {
        System.out.println(":-(");

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return u2;
    }
}
