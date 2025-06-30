package Service;

import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroServiceImpl implements CadastroService {
    List<Pessoa> cadastros = new ArrayList<>();
    List<Equipamento> equipamentos = new ArrayList<>();
    List<Aula> aulas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void cadastrar() {
        boolean cadastro = true;

        while (cadastro) {
            System.out.println("Deseja cadastrar qual tipo:");
            System.out.println("1 - Cliente");
            System.out.println("2 - Funcionario");
            System.out.println("3 - Equipamento");
            System.out.println("4 - Aula");
            System.out.println("5 - Sair do menu");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    Cliente cliente = registrarCliente();
                    cadastros.add(cliente);
                    System.out.println("Cliente cadastrado com sucesso: \n" + cliente);
                    cadastro = false;
                    break;
                case 2:
                    registrarFuncionario();
                    cadastro = false;
                    break;
                case 4:
                    Equipamento equipamento = registrarEquipamento();
                    System.out.println("Equipamento registrado com sucesso: \n" + equipamento);
                    equipamentos.add(equipamento);
                    break;
                case 5:
                    Aula aula = cadastrarAula();
                    System.out.println("Aula registrada com sucesso: \n" + aula);
                    aulas.add(aula);
                    break;
                case 6:
                    cadastro = false;
                    break;
                default:
                    throw new RuntimeException("Escolha inválida");
            }

        }
    }

    private Aula cadastrarAula(){
        System.out.println("Digite o nome da aula: ");
        String aula = scanner.nextLine();

        System.out.println("Digite a especialização da aula: ");
        String especializacao = scanner.nextLine();

        System.out.println("Diga o id do instrutor: ");
        int idInstrutor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Quantidade de vagas: ");
        int quantidadeVaga = scanner.nextInt();
        scanner.nextLine();

        Instrutor instrutor = econtrarInstrutor(idInstrutor);

        return Aula.registrarAula(aula, especializacao, instrutor, quantidadeVaga);
    }

    private Cliente registrarCliente() {
        boolean registro = true;
        Cliente clienteRegistrado;
        while (registro) {
            System.out.println("Qual o seu nome: ");
            String nome = scanner.nextLine();

            System.out.println("Qual o seu cpf: ");
            String cpf = scanner.nextLine();

            System.out.println("Escolha o seu plano: ");
            System.out.println("1. Plano basic - R$80,00");
            System.out.println("2. Plano premium - R$100,00");
            System.out.println("3. Plano Ultimate - R$150,00");
            int plano = scanner.nextInt();
            scanner.nextLine();

            switch (plano) {
                case 1:
                    clienteRegistrado = new Cliente(nome, cpf, TipoPlano.BASIC, true);

                    return clienteRegistrado;
                case 2:
                    clienteRegistrado = new Cliente(nome, cpf, TipoPlano.PREMIUM, true);

                    return clienteRegistrado;

                case 3:
                    clienteRegistrado = new Cliente(nome, cpf, TipoPlano.ULTIMATE, true);

                    return clienteRegistrado;
                default:
                    throw new RuntimeException("Plano inválido");
            }
        }
        return null;
    }

    private void registrarFuncionario() {
        Instrutor instrutor;
        Recepcionista recepcionista;

        System.out.println("Qual tipo de funcionário");
        System.out.println("1. Instrutor");
        System.out.println("2. Recepcionista");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                System.out.println("Qual o seu nome: ");
                String nome = scanner.nextLine();

                System.out.println("Qual o seu cpf: ");
                String cpf = scanner.nextLine();

                System.out.println("Qual a sua especialização");
                String especialidade = scanner.nextLine();

                instrutor = new Instrutor(nome, cpf, especialidade);
                cadastros.add(instrutor);
                System.out.println("Instrutor cadastrado com sucesso: " + instrutor);
                break;
            case 2:
                System.out.println("Qual o seu nome: ");
                String nome1 = scanner.nextLine();

                System.out.println("Qual o seu cpf: ");
                String cpf2 = scanner.nextLine();

                recepcionista = new Recepcionista(nome1, cpf2);
                cadastros.add(recepcionista);
                System.out.println("Recepcionista cadastrada com sucesso: " + recepcionista);
                break;
        }
    }

    private Equipamento registrarEquipamento(){
        System.out.println("Nome do equipamento: ");
        String nomeEquipamento = scanner.nextLine();

        System.out.println("Qual o grupo muscular responsável: ");
        String grupoMuscular = scanner.nextLine();

        return new Equipamento(nomeEquipamento, grupoMuscular);
    }

    private Instrutor econtrarInstrutor(int id){
        for (Pessoa pessoa : cadastros){
            if (pessoa.getId() == id){
                return (Instrutor) pessoa;
            }else {
                System.out.println("Nenhum instrutor encontrado com este ID.");
            }
        }
        return null;
    }
}
