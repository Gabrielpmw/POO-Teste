package Service;

import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RelatorioServiceImpl implements RelatorioService {
    CadastroServiceImpl cadastroService;
    Scanner scanner = new Scanner(System.in);

    public RelatorioServiceImpl(CadastroServiceImpl cadastroService) {
        this.cadastroService = cadastroService;
    }

    @Override
    public void relatorio() {
        boolean menu = true;
        do {
            System.out.println("====== Relatórios ======");
            System.out.println("1. Clientes");
            System.out.println("2. Funcionários");
            System.out.println("3. Equipamentos");
            System.out.println("4. Aulas");
            System.out.println("5. Sair do menu");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 1:
                    relatorioCliente();
                    menu = false;
                    break;
                case 2:
                    relatorioFuncionario();
                    menu = false;
                    break;
                case 3:
                    relatorioEquipamento();
                    menu = false;
                    break;
                case 4:
                    relatorioAula();
                    menu = false;
                    break;
                default:
                    throw new RuntimeException("Escolha inválida");
            }
        }while (menu);

    }

    private void relatorioCliente() {
        System.out.println("Escolha o tipo de cliente: ");
        System.out.println("1. Clientes do plano basic");
        System.out.println("2. Clientes do plano premium");
        System.out.println("3. Cliente do plano ultimate");
        System.out.println("4. Todos os clientes");
        System.out.println("5. Sair do menu");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        List<Cliente> clientes = new ArrayList<>();

        switch (escolha) {
            case 1:
                clientes = buscarClientePorPlano("basic");
                System.out.println("====== Clientes do plano basic ======");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
                break;
            case 2:
                clientes = buscarClientePorPlano("premium");
                System.out.println("====== Clientes do plano premium ======");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
                break;
            case 3:
                clientes = buscarClientePorPlano("ultimate");
                System.out.println("====== Clientes do plano ultimate ======");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
                break;
            case 4:
                clientes = buscarTodosClientes();
                System.out.println("====== Todos os clientes ======");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
        }
    }

    private void relatorioFuncionario() {
        boolean menu = true;

        do {
            System.out.println("Escolha o tipo de funcionário");
            System.out.println("1. Instrutores");
            System.out.println("2. Recepcionista");
            System.out.println("3. Todos");
            System.out.println("4. Sair do menu");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    List<Instrutor> instrutores = buscarInstrutores();
                    System.out.println("====== Instrutores ======");
                    for (Instrutor instrutor : instrutores) {
                        System.out.println(instrutor);
                    }
                    menu = false;
                    break;
                case 2:
                    List<Recepcionista> recepcionistas = buscarRecepcionista();
                    System.out.println("====== Recepcionistas ======");
                    for (Recepcionista recepcionista : recepcionistas) {
                        System.out.println(recepcionista);
                    }
                    menu = false;
                    break;
                case 3:
                    List<Pessoa> pessoas = buscarTodosFuncionarios();
                    System.out.println("====== Todos os funcionários ======");
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa instanceof Instrutor) {
                            Instrutor instrutor = (Instrutor) pessoa;
                            System.out.println(instrutor);
                        } else if (pessoa instanceof Recepcionista) {
                            Recepcionista recepcionista = (Recepcionista) pessoa;
                            System.out.println(recepcionista);
                        }
                    }
                    menu = false;
                    break;
                case 4:
                    menu = false;
                default:
                    throw new RuntimeException("Escolha inválida");
            }
        } while (menu);
    }

    private void relatorioEquipamento() {
        System.out.println("====== Equipamentos ======");
        for (Equipamento equipamento : cadastroService.equipamentos){
            System.out.println(equipamento);
        }
    }

    private void relatorioAula() {
        System.out.println("=== Aulas ===");
        for (Aula aula : cadastroService.aulas){
            System.out.println(aula);
        }
    }

    private List<Cliente> buscarClientePorPlano(String nome) {
        List<Cliente> clientes = new ArrayList<>();

        for (Pessoa pessoa : cadastroService.cadastros) {
            if (pessoa instanceof Cliente) {
                Cliente cliente = (Cliente) pessoa;
                if (cliente.getTipoPlano().getNome().equalsIgnoreCase(nome)) {
                    clientes.add(cliente);
                }
            }
        }
        return clientes;
    }

    private List<Cliente> buscarTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();

        for (Pessoa pessoa : cadastroService.cadastros) {
            if (pessoa instanceof Cliente) {
                Cliente cliente = (Cliente) pessoa;
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    private List<Instrutor> buscarInstrutores() {
        List<Instrutor> instrutores = new ArrayList<>();

        for (Pessoa pessoa : cadastroService.cadastros) {
            if (pessoa instanceof Instrutor) {
                Instrutor instrutor = (Instrutor) pessoa;
                instrutores.add(instrutor);
            }
        }
        return instrutores;
    }

    private List<Recepcionista> buscarRecepcionista() {
        List<Recepcionista> recepcionistas = new ArrayList<>();

        for (Pessoa pessoa : cadastroService.cadastros) {
            if (pessoa instanceof Recepcionista) {
                Recepcionista instrutor = (Recepcionista) pessoa;
                recepcionistas.add(instrutor);
            }
        }
        return recepcionistas;
    }

    private List<Pessoa> buscarTodosFuncionarios() {
        List<Pessoa> pessoas = new ArrayList<>();

        for (Pessoa pessoa : cadastroService.cadastros) {
            if (pessoa instanceof Instrutor) {
                Instrutor instrutor = (Instrutor) pessoa;
                pessoas.add(instrutor);
            } else if (pessoa instanceof Recepcionista) {
                Recepcionista recepcionista = (Recepcionista) pessoa;
                pessoas.add(recepcionista);
            }
        }
        return pessoas;
    }
}