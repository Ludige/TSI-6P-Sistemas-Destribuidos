package corba;

import RemotoApp.RemotoPOA;
import org.omg.CORBA.ORB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Usuario
 */
public class Operacao extends RemotoPOA {
    private ORB orb ; //Object Request Broker
    
    @Override
    public int raizQuadrada(int num) {
        return (int) Math.sqrt(num);
    }

    @Override
    public int fatorial(int num) {
        int result = 1;

        for (int i = num; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    @Override
    public int menorNum(int num1, int num2, int num3) {
        if (num1 < num2 && num1 < num3) {
            return num1;
        } else if (num2 < num3) {
            return num2;
        } else {
            return num3;
        }
    }
    
    public void setOrb(ORB orb_val){
        orb = orb_val;
    }

}
