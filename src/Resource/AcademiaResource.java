package Resource;

import Service.AulaServiceImpl;
import Service.CadastroServiceImpl;
import Service.RelatorioService;
import Service.RelatorioServiceImpl;

import java.util.Scanner;

public class AcademiaResource {
    public static void main(String[] args) {
        boolean menu = true;
        CadastroServiceImpl cadastroService = new CadastroServiceImpl();
        RelatorioService relatorioService = new RelatorioServiceImpl(cadastroService);
        AulaServiceImpl aulaService = new AulaServiceImpl(cadastroService);
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
                    aulaService.aulas();
                    break;
                case 3:
                    relatorioService.relatorio();
                    break;
                case 4:
            }

        }while (menu);
    }
}
