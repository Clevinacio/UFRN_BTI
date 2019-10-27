Projeto LP2 - Unidade 2

O que foi feito:
*Funcionalidades solicitadas:
- SetIP, getIp, setMAC e getMAC em DispositivoDeRede;
- Classe roteador com métodos roteamento (implementado da interface
Roteamento), além dos gets e sets dos atributos que foram necessários;
- Classe Pacote com os métodos setDados e getDados;
- Classe Porta com os atributos BufferSaida e BufferEntrada e seus 
respectivos gets e sets,atributo Referência e seus respectivos gets e sets;
- Interface roteamento com método roteamento;
- Definição das 5 portas em cada roteador (portas definidas como atributos
da classe Roteador);
- Leitura do arquivo ips e atribuição deles aos roteadores;
- Leitura do arquivo de comunicação e atribuição dos dados aos respectivos
roteadores;
- Criação do arquivo ip.txt com a escrita dos pacote recebido no mesmo.
*Funcionalidades extras:
- Classe FuncoesAuxiliares com funções de apoio na leitura e atribuição de
informações dos arquivos para os objetos das classes;


O que faria de forma diferente:
- Ao invés de sempre buscar o caminho do roteador, após realizar uma
entrega de pacote a um, salvar esse caminho e utiliza-lo sempre para
diminuir o tempo de execução, tendo sempre que verificar o mesmo caminho
várias vezes.


Como compilar:
executar arquivo .jar que está dentro do anexo no terminal com o comando
java -jar roteador.jar

Autores e tarefas realizadas:
Cleverton Inácio:
Métodos atribuirIP, inicializar e atribuirCoordenadas.
Métodos roteamento e rotear.
Criação de .jar para execução do projeto.

Hilton Carvalho:
método escrevePacote.

Jordevá Lucas:
método de atribuicao dos pacotes aos respectivos roteadores de origem

Raul Santos:
Criação do projeto e escrita de classes definidas no documento;
Método setarPortas().

