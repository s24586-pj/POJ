public class Zajecia {
    public static void main(String[] args) {
            String[]tablica={"1","3","1"};
        System.out.println(count(tablica,1));
    }

    public static int count(String str, int word) {
        String tablica[] = str.split(" ");


        int count = 0;
        for (int i = 0; i < tablica.length; i++)
        {

            if (word.equals(tablica[i]))
                count++;
        }

        return count;
    }
    }




