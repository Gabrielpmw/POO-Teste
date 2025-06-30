package Service;

import Model.Aula;
import Model.Cliente;
import Model.Pessoa;

import javax.swing.*;
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

    }

    private void inscreverAlunoAula() {
        Aula aula;
        List<Cliente> alunos = new ArrayList<>();

        System.out.println("Digite o id da aula");
        int aulaId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o id do aluno");
        int alunoId = scanner.nextInt();
        scanner.nextLine();

        for (Pessoa pessoa : cadastroService.cadastros) {
            if (alunoId == pessoa.getId()) {
                if (!(pessoa instanceof Cliente)) {
                    throw new RuntimeException("Este usuário não tem permissão para se inscrever em uma aula");
                }
                alunos.add((Cliente) pessoa);
            }
        }

        for (int x = 0; x < cadastroService.aulas.size(); x++){
            Aula aulaLoop = cadastroService.aulas.get(x);
            if (aulaId == aulaLoop.getId()){
                aula = aulaLoop;
                aula.setAlunos(alunos);
                cadastroService.aulas.set(x, aula);
                int vagas = cadastroService.aulas.get(x).getVaga();
                cadastroService.aulas.get(x).setVaga(vagas--);
            }else {
                throw new RuntimeException("Aula não encontrada");
            }
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
}
