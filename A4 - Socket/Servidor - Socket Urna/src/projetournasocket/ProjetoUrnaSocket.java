/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetournasocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rafael de Souza Costa
 */
public class ProjetoUrnaSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        int biroliro =0; //getRandomInt(50000000);
        int lula = 0;//getRandomInt(50000000);

        System.out.println("Auditoria: \n[13] Lula " + lula + " votos, \n[17] Biroliro " + biroliro + " votos");

        ServerSocket serverSocket = new ServerSocket(1084);
        Socket socket = serverSocket.accept();

        System.out.println("Server com Socket :1084");

        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        BufferedReader bfr = new BufferedReader(inputStream);

        PrintWriter outputStream = new PrintWriter(socket.getOutputStream());

        String user = bfr.readLine();

        if (!user.equals("user")) {
            outputStream.println("Usuário inválido");
            outputStream.flush();
            socket.close();
            return;
        }

        String password = bfr.readLine();

        if (!password.equals("admin13")) {
            outputStream.println("Senha inválida");
            outputStream.flush();

            socket.close();
            return;
        }

        outputStream.println("Token: " + getRandomInt(1000));
        outputStream.flush();

        outputStream.println("Candidatos: [13] Lula | [17] Biroliro");
        outputStream.flush();

        String voto = bfr.readLine();
        System.out.println(voto);
        switch (voto) {
            case "13":
                lula++;
                break;
            case "17":
                biroliro++;
                break;
            default:
                outputStream.println("Informe um candidato válido");
                outputStream.flush();

                socket.close();

                return;
        }

        outputStream.println("Voto contabilizado");
        outputStream.flush();

        outputStream.println("Resultado: [13] Lula " + lula + " votos, [17] Biroliro " + biroliro + " votos");
        outputStream.flush();

        socket.close();
    }

    public static int getRandomInt(int max) {
        int numAleatorio = 1 * (int) (Math.random() * max);
        return numAleatorio;
    }

}
