# POO-Teste
Inspirado nas aulas do DevDojo, este desafio é um teste prático de Orientação a Objetos. O objetivo é modelar o sistema da academia "Steel &amp; Code", criando classes para Membros, Funcionários e Aulas e aplicando conceitos como herança, polimorfismo e tratamento de exceções em um cenário real.


### **Desafio de Programação: Sistema de Gerenciamento de Academia "Steel & Code"**

#### **Cenário**

A "Steel & Code" é uma nova academia que precisa de um sistema de gerenciamento interno para controlar seus membros, funcionários e equipamentos. O sistema deve ser robusto, flexível e seguir as melhores práticas de Orientação a Objetos para garantir que seja fácil de manter e expandir no futuro. Você foi contratado como desenvolvedor principal para modelar e construir o núcleo deste sistema.

#### **Texto de Interpretação para Modelagem**

**1. A Estrutura Organizacional: Pessoas**

O sistema precisa lidar com diferentes tipos de pessoas. Toda pessoa na academia, seja cliente ou funcionário, possui dados em comum: um **ID** (único e que não pode ser alterado após a criação), **nome** e **CPF**.

- **Membros (Clientes):** Além dos dados comuns, cada membro tem um **plano de assinatura** associado. Os planos determinam o que o membro pode fazer. Os membros também têm um **status**, que pode ser `ATIVO` ou `INATIVO`.
    
- **Funcionários:** São a base da operação. Um funcionário também é uma pessoa. Existem dois tipos principais de funcionários:
    
    - **Instrutores:** Cada instrutor possui uma **especialidade** (ex: "Musculação", "Pilates", "CrossFit"). Um instrutor é responsável por acompanhar e auxiliar os membros.
        
    - **Recepcionistas:** São responsáveis pelo atendimento e gerenciamento de matrículas.
        

**2. Planos e Acesso: A Lógica do Negócio**

A academia oferece diferentes **tipos de plano** de assinatura. Para começar, teremos três: `BASIC` (acesso apenas à musculação), `PREMIUM` (acesso a musculação e aulas em grupo) e `ULTIMATE` (acesso total, incluindo áreas especiais). Cada tipo de plano tem um **nome descritivo** e um **valor mensal**. A modelagem dos planos deve ser feita de uma forma que seja impossível criar um plano fora desses tipos pré-definidos.

**3. O Coração da Academia: Atividades e Equipamentos**

- **Equipamentos:** A academia possui diversos equipamentos. Cada equipamento tem um **código de identificação**, um **nome** (ex: "Supino Reto", "Esteira ergométrica T100") e um **grupo muscular** principal que trabalha (ex: "Peitoral", "Cardio"). O código de identificação de um equipamento é **estático e final** para cada instância, ou seja, uma vez definido no sistema, não pode mudar. Precisamos de uma forma de contar quantos equipamentos foram cadastrados no total, independentemente do tipo.
    
- **Aulas:** Aulas em grupo são uma parte vital. Uma `Aula` é definida por um **nome** (ex: "Aula de Zumba"), um **instrutor** responsável e uma **lista de membros** inscritos. Nem todo instrutor pode dar qualquer aula; a especialidade do instrutor deve ser compatível.
    

**4. A Interação do Sistema: Operações e Regras**

O sistema precisa ter um ponto de entrada, uma classe principal que permita realizar as seguintes operações através do console:

- **Cadastro:** Deve ser possível cadastrar novos Membros, Instrutores e Equipamentos.
    
- **Associação:** Um membro `ATIVO` pode se inscrever em uma `Aula`. O sistema deve validar:
    
    1. O plano do membro dá acesso àquela aula? (Ex: Plano `BASIC` não pode se inscrever em aulas).
        
    2. O membro já não está inscrito?
        
- **Gerenciamento de Funcionários:** É preciso poder associar um instrutor a uma nova aula que será criada. Apenas um instrutor pode ser o responsável principal pela aula.
    
- **Relatórios:** O sistema deve ser capaz de gerar relatórios polimórficos. Por exemplo, uma função que recebe uma lista de `Pessoas` (contendo `Membros` e `Instrutores`) e imprime os detalhes específicos de cada um. A impressão de um `Membro` deve mostrar seu plano, enquanto a de um `Instrutor` deve mostrar sua especialidade.
    

**5. Tratamento de Erros e Situações Excepcionais**

O sistema deve ser resiliente. As seguintes situações devem ser tratadas:

- **Matrícula Inválida:** Tentar inscrever um membro em uma aula para a qual seu plano não dá direito deve lançar uma exceção customizada, como `PlanoIncompativelException`.
    
- **Capacidade Excedida:** Se uma aula tiver um limite máximo de alunos (um atributo `final`), tentar inscrever além desse limite deve lançar uma `CapacidadeExcedidaException`.
    
- **Dados Inválidos:** Tentar cadastrar uma pessoa com um CPF inválido (ex: formato incorreto) deve lançar uma `DadoInvalidoException`.
    
- **Recursos:** Se o sistema precisasse ler dados de um arquivo de configuração para inicializar os tipos de plano, essa operação deveria garantir que o arquivo fosse fechado corretamente, mesmo que um erro ocorresse durante a leitura.
