package Service;

import Model.Aula;
import Model.Cliente;
import Model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AulaServiceImpl implements AulaService {
    Scanner scanner = new Scanner(System.in);
    CadastroServiceImpl cadastroService;

    public AulaServiceImpl(CadastroServiceImpl cadastroService) {
        this.cadastroService = cadastroService;
    }

    @Override
    public void aulas() {
        boolean menu = true;

        do {
            System.out.println("====== Aulas ======");
            System.out.println("1. Se inscrever em uma aula");
            System.out.println("2. Aulas disponíveis");
            System.out.println("3. Sair do menu");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 1:
                    inscreverAlunoAula();
                    menu = false;
                    break;
                case 2:
                    aulasDisponivel();
                    menu = false;
                    break;
                case  3:
                    menu = false;
                    break;
                default:
                    throw new RuntimeException("Entrada inválida");
            }
        }while (menu);
    }

    private void inscreverAlunoAula() {
        System.out.println("Digite o id da aula");
        int aulaId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o id do aluno");
        int alunoId = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = null;

        for (Pessoa pessoa : cadastroService.cadastros) {
            if (alunoId == pessoa.getId()) {
                if (!(pessoa instanceof Cliente)) {
                    throw new RuntimeException("Este usuário não tem permissão para se inscrever em uma aula");
                }
                cliente = (Cliente) pessoa;
                break;
            }
        }

        if (cliente == null) {
            throw new RuntimeException("Aluno não encontrado");
        }

        boolean aulaEncontrada = false;

        for (int x = 0; x < cadastroService.aulas.size(); x++) {
            Aula aulaLoop = cadastroService.aulas.get(x);

            if (aulaLoop == null) continue;

            if (aulaId == aulaLoop.getId()) {
                if (verificacaoCliente_Aula(alunoId, aulaId)) {
                    throw new RuntimeException("Usuário já está inscrito nessa aula");
                }

                aulaLoop.getAlunos().add(cliente);
                aulaLoop.setVaga(aulaLoop.getVaga() - 1);
                cadastroService.aulas.set(x, aulaLoop);

                aulaEncontrada = true;
                System.out.println("Inscrição realizada com sucesso!");
                break;
            }
        }

        if (!aulaEncontrada) {
            throw new RuntimeException("Aula não encontrada");
        }
    }

    private void aulasDisponivel() {
        System.out.println("====== Aulas disponíveis ======");
        for (Aula aula : cadastroService.aulas) {
            if (aula.isDisponivel()) {
                System.out.println(aula);
            }
        }
    }

    private boolean verificacaoCliente_Aula(int idAluno, int idAula) {
        Cliente cliente = null;

        for (Pessoa pessoa : cadastroService.cadastros) {
            if (pessoa instanceof Cliente && pessoa.getId() == idAluno) {
                cliente = (Cliente) pessoa;
                break;
            }
        }

        if (cliente == null) {
            throw new RuntimeException("Aluno não encontrado");
        }

        for (Aula aula : cadastroService.aulas) {
            if (aula == null) continue;

            if (aula.getId() == idAula) {
                for (Pessoa pessoa : aula.getAlunos()) {
                    if (pessoa.getId() == cliente.getId()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
