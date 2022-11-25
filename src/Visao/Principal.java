package Visao;

import java.util.ArrayList;
import java.util.Scanner;
import Dominio.*;
import Persistencia.ClienteDAO;

public class Principal {
    public static void main(String[] args) {

        // variaveis
        Scanner teclado = new Scanner(System.in);
        int op, i;
        String cpfaux;
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente clienteDominio;
        // fim das variaveis

        // CPF/NOME/LOGIN/SENHA/ATIVO

        // programa
        do {
            System.out.println("MENU");
            System.out.println("INSERIR");
            System.out.println("BUSCAR");
            op = teclado.nextInt();
            switch (op){
                case 1:
                    System.out.println("INSERIR");
                    System.out.println("DIGITE O CPF DO CLIENTE: ");
                    cpfaux = teclado.nextLine();
                    teclado.nextLine();
                    clienteDominio = clienteDAO.getCliente(cpfaux);
                    if(clienteDominio == null){
                        clienteDominio = new Cliente();
                        clienteDominio.setPk_cpf(cpfaux); // cpf pego logo acima
                        System.out.println("Digite o nome: ");
                        clienteDominio.setNome(teclado.nextLine());
                        System.out.println("DIGITE O LOGIN: ");
                        clienteDominio.setSenha(teclado.nextLine());
                        System.out.println("DIGITE A SENHA: ");
                        clienteDominio.setSenha(teclado.nextLine());
                    } else {
                        System.out.println("Cliente já cadastrado");
                    }
                    break;
                case 2: break;
                case 3: break;
            }
        } while(op != 3);
    }
}
