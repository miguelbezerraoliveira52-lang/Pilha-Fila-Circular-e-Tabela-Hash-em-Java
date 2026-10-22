<div align="center">

# 📚 Estruturas de Dados em Java

**Pilha • Fila Circular • Tabela Hash**

Implementação manual de estruturas de dados para demonstrar inserções, remoções, tratamento de colisões e controle de capacidade.

**Java 17 | Projeto acadêmico | Sem coleções prontas**

</div>

---

## 📌 Sobre o projeto

Projeto desenvolvido para a disciplina de **Estrutura de Dados**, com três implementações:

- **Pilha:** armazenamento de inteiros seguindo a política LIFO.
- **Fila circular:** controle de atendimento de clientes seguindo a política FIFO.
- **Tabela hash:** armazenamento de inteiros com tratamento de colisões por encadeamento simples.

O programa apresenta os estados das estruturas após cada operação e demonstra situações de **overflow** e **underflow**.

> As estruturas foram construídas manualmente, utilizando vetores e nós encadeados. Não são utilizadas coleções como `ArrayList`, `LinkedList`, `Stack`, `Queue` ou `HashMap`.

## 🧭 Sumário

- [Organização do projeto](#-organização-do-projeto)
- [Pilha](#-pilha)
- [Fila circular](#-fila-circular)
- [Tabela hash](#-tabela-hash)
- [Tratamento de erros](#-tratamento-de-erros)
- [Como executar](#-como-executar)
- [Conceitos trabalhados](#-conceitos-trabalhados)
- [Identificação acadêmica](#-identificação-acadêmica)

---

## 📂 Organização do projeto

| Arquivo | Responsabilidade |
| :--- | :--- |
| `Main.java` | Executa as operações do exercício e apresenta os resultados. |
| `Pilha.java` | Implementa a pilha de inteiros utilizando vetor. |
| `FilaCircular.java` | Implementa a fila circular de clientes utilizando vetor. |
| `No.java` | Representa um valor e a referência para o próximo nó. |
| `TabelaHash.java` | Implementa a tabela hash com listas simplesmente encadeadas. |

**Todos os arquivos devem permanecer na mesma pasta, sem declaração de `package`.**

---

## 📚 Pilha

A pilha possui capacidade para **6 elementos** e segue a política **LIFO — Last In, First Out**:

> O último elemento inserido é o primeiro a ser removido.

### Operações disponíveis

| Método | Função |
| :--- | :--- |
| `push(int valor)` | Insere um valor no topo. |
| `pop()` | Remove e retorna o valor do topo. |
| `estaVazia()` | Verifica se a pilha está vazia. |
| `estaCheia()` | Verifica se a pilha atingiu sua capacidade. |
| `tamanho()` | Retorna a quantidade de elementos. |
| `copiar()` | Cria uma cópia independente da pilha. |
| `exibir()` | Exibe os valores da base para o topo. |
| `exibirTopoParaBase()` | Exibe os valores do topo para a base. |

### Sequência executada

```text
push(14), push(27), push(35), pop(), push(42),
push(19), pop(), push(50), push(11), pop(), push(60)
```

### Resultados

| Informação | Resultado |
| :--- | :--- |
| Elementos removidos | `35`, `19` e `11` |
| Estado final — topo para a base | `[60, 50, 42, 27, 14]` |
| Quantidade final | 5 elementos |
| Após três remoções adicionais — topo para a base | `[27, 14]` |

### Controle de capacidade

O programa utiliza uma cópia da pilha para testar a inserção de `75`.

- `push(75)` ocupa a sexta posição e **não causa overflow**.
- A tentativa seguinte, `push(80)`, causa **overflow**, pois a cópia está cheia.
- As três remoções adicionais ocorrem na pilha original, sem o valor `75`.

Também é demonstrado o **underflow** ao executar `pop()` em uma pilha vazia.

---

## 🔄 Fila circular

A fila possui capacidade para **5 clientes** e segue a política **FIFO — First In, First Out**:

> O primeiro cliente a entrar é o primeiro a ser atendido.

O comportamento circular permite reutilizar as posições liberadas no início do vetor, sem deslocar os demais elementos.

### Operações disponíveis

| Método | Função |
| :--- | :--- |
| `enqueue(String cliente)` | Insere um cliente no fim. |
| `dequeue()` | Remove e retorna o cliente do início. |
| `consultarInicio()` | Consulta o primeiro cliente sem removê-lo. |
| `consultarFim()` | Consulta o último cliente sem removê-lo. |
| `estaVazia()` | Verifica se a fila está vazia. |
| `estaCheia()` | Verifica se a fila atingiu sua capacidade. |
| `tamanho()` | Retorna a quantidade de clientes. |
| `exibir()` | Exibe a ordem de atendimento e os índices. |

### Sequência executada

```text
enqueue(Ana), enqueue(Bruno), enqueue(Carlos),
dequeue(), enqueue(Daniela), enqueue(Eduardo),
enqueue(Fernanda), dequeue(), enqueue(Gustavo)
```

### Resultados

| Informação | Resultado |
| :--- | :--- |
| Clientes removidos | Ana e Bruno |
| Início da fila | Carlos — índice `2` |
| Fim da fila | Gustavo — índice `1` |
| Ordem de atendimento | Carlos, Daniela, Eduardo, Fernanda e Gustavo |

### Reaproveitamento de posições

| Posição | Liberada por | Reutilizada por |
| :---: | :--- | :--- |
| `0` | Ana | Fernanda |
| `1` | Bruno | Gustavo |

O avanço circular dos índices utiliza:

```java
(indice + 1) % elementos.length
```

> A tentativa de inserir Henrique causa **overflow**, pois os cinco espaços estão ocupados. O comportamento circular reaproveita posições livres, mas não aumenta a capacidade da fila.

---

## 🔎 Tabela hash

A tabela possui **10 posições** e utiliza a função:

```text
h(x) = x mod 10
```

As colisões são resolvidas por **encadeamento simples**: cada posição pode apontar para uma lista de nós.

Os novos valores são inseridos no fim da lista correspondente, preservando a ordem de chegada.

### Operações disponíveis

| Método | Função |
| :--- | :--- |
| `hash(int valor)` | Calcula o índice do valor. |
| `inserir(int valor)` | Insere o valor e informa se houve colisão. |
| `buscar(int valor)` | Verifica se o valor está armazenado. |
| `getColisoes()` | Retorna a quantidade de inserções em posições já ocupadas. |
| `fatorCarga()` | Calcula a relação entre elementos e posições. |
| `exibirMaioresListas()` | Apresenta as posições com mais elementos. |
| `exibir()` | Exibe a tabela e suas listas. |

### Valores inseridos

```text
15, 25, 35, 18, 28, 38, 44, 54, 64
```

### Distribuição final

| Índice | Lista encadeada |
| :---: | :--- |
| `0` | Vazia |
| `1` | Vazia |
| `2` | Vazia |
| `3` | Vazia |
| `4` | `44 → 54 → 64 → null` |
| `5` | `15 → 25 → 35 → null` |
| `6` | Vazia |
| `7` | Vazia |
| `8` | `18 → 28 → 38 → null` |
| `9` | Vazia |

### Colisões

As inserções de `25`, `35`, `28`, `38`, `54` e `64` encontram posições já ocupadas, totalizando **6 colisões**.

As posições **4, 5 e 8** empatam com a maior quantidade de elementos: **3 em cada lista**.

### Fator de carga

O fator de carga relaciona a quantidade de elementos armazenados com o tamanho da tabela:

```text
λ = n / m

n = 9 elementos
m = 10 posições

λ = 9 / 10 = 0,9
```

Listas maiores podem exigir mais comparações durante uma busca. Por isso, o desempenho depende tanto do fator de carga quanto da distribuição dos valores entre as posições.

---

## 🛡️ Tratamento de erros

| Situação | Comportamento |
| :--- | :--- |
| Inserção em pilha ou fila cheia | Lança `IllegalStateException` — overflow. |
| Remoção em pilha ou fila vazia | Lança `IllegalStateException` — underflow. |
| Consulta ao início ou fim de uma fila vazia | Lança `IllegalStateException`. |
| Capacidade menor ou igual a zero | Lança `IllegalArgumentException`. |
| Inserção de cliente `null` | Lança `IllegalArgumentException`. |

A classe `Main` captura as exceções dos exemplos de overflow e underflow, apresenta as mensagens e permite que a demonstração continue.

---

## ▶️ Como executar

### Pré-requisito

Ter um **JDK instalado**, como o JDK 17.

### 1. Organize os arquivos

Coloque os cinco arquivos `.java` na mesma pasta.

### 2. Compile

Abra o terminal nessa pasta e execute:

```bash
javac -encoding UTF-8 Main.java Pilha.java FilaCircular.java No.java TabelaHash.java
```

### 3. Execute

```bash
java Main
```

Também é possível abrir os arquivos em uma IDE e executar o método `main` da classe `Main`.

> O programa não solicita dados pelo teclado. As operações do exercício já estão definidas no código.

---

## 🧠 Conceitos trabalhados

- Implementação manual de estruturas de dados.
- Política LIFO em pilhas.
- Política FIFO em filas.
- Reaproveitamento de posições em vetores circulares.
- Tratamento de colisões por encadeamento simples.
- Cálculo do fator de carga.
- Encapsulamento e organização em classes.
- Tratamento de exceções.

---

## 🎓 Identificação acadêmica

| Campo | Informação |
| :--- | :--- |
| **Instituição** | Universidade de Fortaleza — Unifor |
| **Curso** | Ciência da Computação |
| **Disciplina** | Estrutura de Dados |
| **Integrante(s)** | Preencher |
| **Matrícula(s)** | Preencher |
| **Turma** | Preencher |
| **Professor(a)** | Preencher |
