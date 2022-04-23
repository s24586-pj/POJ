public class Usmiech extends Buzka implements Skalowalny,Rysowalny{

    String u1=":-)";

    public Usmiech(){
        super('a');
    }

    @Override
    public boolean czySieUsmiecha() {
        return true;
    }

    @Override
    public void przestanSieUsmiechac() {

    }

    @Override
    public void draw() {

    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

    @Override
    public String toString() {
        return u1 ;

    }

}
