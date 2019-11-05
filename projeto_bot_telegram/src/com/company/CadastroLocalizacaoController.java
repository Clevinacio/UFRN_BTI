package com.company;

public class CadastroLocalizacaoController extends CommandController {

    Localizacao localizacao;                             /*Objeto que o controlador trata*/

    public CadastroLocalizacaoController() {
        super("/addlocal", 6);                     /*Determina o comando do controlador e quantas etapas possui*/
        localizacao = new Localizacao();
    }

    /*De acordo com a etapa corrente, a mensagem fornecida é tratada e
    as informacoes do objeto do comando são adicionadas */
    @Override
    public String conversar(String mensagemRecebida) {
        String texto = "";
        switch (getEtapaAtual()){
            case 1:
                texto = "Me diz o nome do local";               /*Determina a mensagem que sera enviada para o usuario*/
                setEtapaAtual(getEtapaAtual() + 1);             /*Incrementa a etapa, que só sera executada quando o usuario fornecer uma resposta*/
                break;
            case 2:
                localizacao.setNome(mensagemRecebida);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);            /*A resposta sendo validada, o proximo passo é chamado*/
                break;
            case 3:
                texto = "Me da mais detalhes sobre esse lugar";
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 4:
                localizacao.setDescricao(mensagemRecebida);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);            /*Apos fornecer a ultima informacao, os datos sao listados para validacao*/
                break;
            case 5:
                texto = confirmarOperacao();
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 6:
                if(mensagemRecebida.equals("s")){               /*Verifica se o usuario aprovou a insercao de dados=*/
                    texto = "Fim do processo";
                    setEtapaAtual(getEtapaAtual() + 1);
                }else if(mensagemRecebida.equals("n")){
                    texto = "Processo cancelado";
                    setEtapaAtual(getEtapaAtual() + 1);
                }else {
                    texto = "Resposta invalida";
                }
                break;
            default:
                texto = "etapa inválida";
                break;
        }
        return texto;
    }

    @Override
    protected String confirmarOperacao() {
        String texto = "Os dados passados foram \n\nNome: " + localizacao.getNome() + "\nDescricao: " + localizacao.getDescricao();
        texto = texto + "\n\nDeseja salvar esta operacao? (s/n)";
        return texto;
    }

    @Override
    protected void reset() {                        /*Limpa todos os dados do controlador*/
        localizacao = new Localizacao();
        setEtapaAtual(1);
    }
}
