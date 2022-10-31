public class main {
    public static void main(String[] args) {
        Cripto crip = new Cripto();
        // p = 7  -- 3
        // q = 11  -- 5
        // n = 77 -- 15
        // 0 = 60 -- 8
        // e = 17 -- 7
        // d = 53 -- 7

        double enc = crip.enc(3, 5, 7,13);

        crip.inc(enc, 7);
    }
}