package Resource;

import Service.CadastroService;
import Service.CadastroServiceImpl;
import Service.RelatorioService;
import Service.RelatorioServiceImpl;

import java.util.Scanner;

public class AcademiaResource {
    public static void main(String[] args) {
        boolean menu = true;
        CadastroServiceImpl cadastroService = new CadastroServiceImpl();
        RelatorioService relatorioService = new RelatorioServiceImpl(cadastroService);
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("==== Menu ====");
            System.out.println("1. Cadastro");
            System.out.println("2. Aula");
            System.out.println("3. Relatório");
            System.out.println("4. Conta");
            int escolha = scanner.nextInt();

            switch (escolha){
                case 1:
                    cadastroService.cadastrar();
                    break;
                case 2:

                    break;
                case 3:
                    relatorioService.relatorio();
            }

        }while (menu);
    }
}
