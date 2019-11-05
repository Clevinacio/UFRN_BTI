package com.company;

public class CadastroLocalizacaoController extends CommandController {
    Localizacao localizacao;
    public CadastroLocalizacaoController() {
        super("/addlocal", 5);
        localizacao = new Localizacao();
    }

    @Override
    public String conversar(String mensagemRecebida) {
        String texto = "";
        switch (getEtapaAtual()){
            case 1:
                texto = "Me diz o nome do local";
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 2:
                localizacao.setNome(mensagemRecebida);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);
                break;
            case 3:
                texto = "Me da mais detalhes sobre esse lugar";
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            case 4:
                localizacao.setDescricao(mensagemRecebida);
                setEtapaAtual(getEtapaAtual() + 1);
                texto = conversar(mensagemRecebida);
                break;
            case 5:
                texto = exibirInformacoes();
                setEtapaAtual(getEtapaAtual() + 1);
                break;
            default:
                texto = "etapa inválida";
                break;
        }
        return texto;
    }

    @Override
    protected String exibirInformacoes() {
        String texto = "Nome: " + localizacao.getNome() + "\nDescricao: " + localizacao.getDescricao();
        return texto;
    }
}
