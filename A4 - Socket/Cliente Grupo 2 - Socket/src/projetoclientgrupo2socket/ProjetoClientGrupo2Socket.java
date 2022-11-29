/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetoclientgrupo2socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael de Souza Costa
 */
public class ProjetoClientGrupo2Socket {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Socket socket = new Socket("192.168.0.104", 8000);
        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        BufferedReader bfr = new BufferedReader(inputStream);
        PrintWriter outputStream = new PrintWriter(socket.getOutputStream());

        String escolha;
        
        do{
         String menu = bfr.readLine();
         escolha = JOptionPane.showInputDialog(menu);

         if(escolha.equals("0")){
             System.out.println("Encerrando");
             break;
         }
         
        outputStream.println(escolha);
        outputStream.flush();
       
                String msg = bfr.readLine();

        String numeroDigitado = JOptionPane.showInputDialog(msg);        
        outputStream.println(numeroDigitado);
        outputStream.flush();

        String resultado = bfr.readLine();
        JOptionPane.showMessageDialog(null,resultado);
    }while(!escolha.equals("0"));
    }
}
