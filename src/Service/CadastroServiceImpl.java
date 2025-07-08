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


    public CadastroServiceImpl(){
        carregarBanco();
    }

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
                case 3:
                    Equipamento equipamento = registrarEquipamento();
                    System.out.println("Equipamento registrado com sucesso: \n" + equipamento);
                    equipamentos.add(equipamento);
                    break;
                case 4:
                    Aula aula = cadastrarAula();
                    System.out.println("Aula registrada com sucesso: \n" + aula);
                    aulas.add(aula);
                    break;
                case 5:
                    cadastro = false;
                    break;
                default:
                    throw new RuntimeException("Escolha inválida");
            }

        }
    }

    private void carregarBanco(){
        List<Cliente> aulas1 = new ArrayList<>();
        List<Cliente> aulas2 = new ArrayList<>();
        List<Cliente> aulas3 = new ArrayList<>();

        Cliente cliente1 = new Cliente("Gabriel", "03518783190", TipoPlano.ULTIMATE, true);
        Cliente cliente2 = new Cliente("Italo", "123654", TipoPlano.ULTIMATE, true);
        Cliente cliente3 = new Cliente("Luan", "1312321", TipoPlano.BASIC, true);
        Cliente cliente4 = new Cliente("Milena", "67451234", TipoPlano.BASIC, true);
        Cliente cliente5 = new Cliente("Felipe", "652345", TipoPlano.PREMIUM, true);
        Cliente cliente6 = new Cliente("alguem", "75474", TipoPlano.PREMIUM, true);
        Cliente cliente7 = new Cliente("Icaro", "423545", TipoPlano.BASIC, true);
        Cliente cliente8 = new Cliente("Matheuus", "763345", TipoPlano.PREMIUM, true);
        Cliente cliente9 = new Cliente("alguem", "42243", TipoPlano.ULTIMATE, true);

        aulas1.add(cliente1);
        aulas1.add(cliente3);
        aulas1.add(cliente5);

        aulas2.add(cliente2);
        aulas2.add(cliente4);
        aulas2.add(cliente6);

        aulas3.add(cliente7);
        aulas3.add(cliente8);
        aulas3.add(cliente9);

        Instrutor instrutor1 = new Instrutor("Ronny", "234352", "Costas");
        Instrutor instrutor2 = new Instrutor("Brad", "34213312", "Bíceps");
        Instrutor instrutor3 = new Instrutor("Kevivn", "44223", "Tríceps");
        Instrutor instrutor4 = new Instrutor("Neymar", "654456", "Ombro");
        Instrutor instrutor5 = new Instrutor("Di Maria", "64564634", "Peitos");
        Instrutor instrutor6 = new Instrutor("Lebron", "4234242", "Panturrilha");

        Recepcionista recepcionista1 = new Recepcionista("Mariele", "1234523");
        Recepcionista recepcionista2 = new Recepcionista("Ederson", "41321");
        Recepcionista recepcionista3 = new Recepcionista("Cássio", "24353524");
        Recepcionista recepcionista4 = new Recepcionista("Mulher", "123132");

        Equipamento equipamento1 = new Equipamento("Voador", "Peitos");
        Equipamento equipamento2 = new Equipamento("Leg press", "Quadríceps");
        Equipamento equipamento3 = new Equipamento("Supino", "Peitos");
        Equipamento equipamento4 = new Equipamento("Mesa flexora", "superior de coxa");
        Equipamento equipamento5 = new Equipamento("Elevação de halteres", "Ombro");
        Equipamento equipamento6 = new Equipamento("Mesa extensora", "Quadríceps");

        Aula aula1 = Aula.registrarAula("Aperfeiçoando costas", "Costas", instrutor1, 30);
        Aula aula2 = Aula.registrarAula("Básico sobre bíceps", "Bíceps", instrutor2, 10);
        Aula aula3 = Aula.registrarAula("Top 10 exercícios para tríceps", "Tríceps", instrutor3, 100);
        Aula aula4 = Aula.registrarAula("O que posso melhorar no meu ombro?!", "Ombro", instrutor4, 20);
        Aula aula5 = Aula.registrarAula("Como ficar com o peito igual do Arnold", "Peitos", instrutor5, 15);
        Aula aula6 = Aula.registrarAula("Ficando com a panturrilha igual de vó", "Panturrilha", instrutor6, 40);

        Aula aula_1 = Aula.inserirAlunos(aula1, aulas1);
        Aula aula_2 = Aula.inserirAlunos(aula2, aulas2);
        Aula aula_3 = Aula.inserirAlunos(aula3, aulas3);

        cadastros.add(cliente1);
        cadastros.add(cliente2);
        cadastros.add(cliente3);
        cadastros.add(cliente4);
        cadastros.add(cliente5);
        cadastros.add(cliente6);

        cadastros.add(instrutor1);
        cadastros.add(instrutor2);
        cadastros.add(instrutor3);
        cadastros.add(instrutor4);
        cadastros.add(instrutor5);
        cadastros.add(instrutor6);

        cadastros.add(recepcionista1);
        cadastros.add(recepcionista2);
        cadastros.add(recepcionista3);
        cadastros.add(recepcionista4);

        equipamentos.add(equipamento1);
        equipamentos.add(equipamento2);
        equipamentos.add(equipamento3);
        equipamentos.add(equipamento4);
        equipamentos.add(equipamento5);
        equipamentos.add(equipamento6);

        aulas.add(aula_1);
        aulas.add(aula_2);
        aulas.add(aula_3);
        aulas.add(aula4);
        aulas.add(aula5);
        aulas.add(aula6);
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
           if (pessoa instanceof Instrutor){
               Instrutor instrutor = (Instrutor) pessoa;
               if (instrutor.getId() == id){
                   return instrutor;
               }
           }
        }
        return null;
    }
}
