public class Cripto {
    int p;
    int q;
    int n;
    double totient;

    private void obterTotient(int p, int q){
        this.n = p * q;
        this.p = p;
        this.q = q;

        this.totient = (p - 1) * (q - 1);    
        System.out.println("Toitent:"+totient);
    }

    public double enc(int p, int q, int e, int num){
        obterTotient(p, q);
        //verificar se 'e' é primo
        double enc =  Math.pow(num, e) % this.n;

        System.out.println("Encriptado: "+ enc);

        return enc;
    }

    public double inc(double encriptado, int inversoMult){
        double inc = Math.pow(encriptado, inversoMult) % this.n;

        System.out.println("Decriptado: "+ inc);
        return inc;
    }

    // public void obterInversoMult(){}
    
}
