package com.company;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //Criação do objeto bot com as informações de acesso
        TelegramBot bot = new TelegramBot("1029513435:AAE3c0Dgz-YByWCdYeIxp2kvyBZV8XjzJvw");
        //objeto responsável por receber as mensagens
        GetUpdatesResponse updatesResponse;
        //objeto responsável por gerenciar o envio de respostas
        SendResponse sendResponse;
        //objeto responsável por gerenciar o envio de ações do chat
        BaseResponse baseResponse;
        //controle de off-set, isto é, a partir deste ID será lido as mensagens pendentes na fila
        int m=0;


        String mensagem = "";
        CommandController commandCurrent = null;                            /*Comando em andamento inicia como nulo*/
        List<CommandController> commands = new ArrayList<CommandController>();           /*Array de controladores*/

        /*Todos os controladores implementados devem ser adicionados no array*/
        commands.add(new CadastroLocalizacaoController());

        //loop infinito pode ser alterado por algum timer de intervalo curto
        while (true){
            //executa comando no Telegram para obter as mensagens pendentes a partir de um off-set (limite inicial)
            updatesResponse =  bot.execute(new GetUpdates().limit(100).offset(m));
            //lista de mensagens
            List<Update> updates = updatesResponse.updates();
            //análise de cada ação da mensagem
            for (Update update : updates) {

                //atualização do off-set
                m = update.updateId() + 1;
                System.out.println("Recebendo mensagem:" + update.message().text());
                //envio de "Escrevendo" antes de enviar a resposta
                baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
                //verificação de ação de chat foi enviada com sucesso
                System.out.println("Resposta de Chat Action Enviada?" + baseResponse.isOk());


                /* --- INICIO TRATAMENTO DE MENSAGENS --- */

                if(commandCurrent == null) {                                            /*Verifica se existe algum comendo em andamendo*/
                    for (CommandController controlador: commands) {                     /*Verifica cada um dos controladores*/
                        if(controlador.getComando().equals(update.message().text())){
                            commandCurrent = controlador;                               /*O commando em andamendo torna-se o que o usuario solicitou*/
                            break;
                        }
                    }

                    if(commandCurrent != null){
                        mensagem = commandCurrent.conversar(update.message().text());   /*Inicia a troca de mensagens*/
                    }else{
                        mensagem = "Desculpa, ainda não entendo esse comando..";
                    }
                }else{
                    if(update.message().text().equals("/cancelar")){                    /*Verifica se o usuario solicitou cancelamento da operacao em andamento*/
                        mensagem = "Tudo bem! Operacao cancelada.";
                        commandCurrent.reset();
                        commandCurrent = null;
                    }else{
                        if(update.message().text().charAt(0) == '/') {
                            mensagem = "Para iniciarmos uma outra operacao, você deve usar o comando /cancelar. Assim, " +
                                        "o processo atual será interrompido. Caso contrário, iremos prosseguir...";
                        }else{
                            mensagem = commandCurrent.conversar(update.message().text());   /*A mensagem que o usuario enviou é tratada pelo
                                                                                            controlador da tarefa em andamento*/

                            if(commandCurrent.getEtapaAtual() == commandCurrent.getTotalEtapas()+1){        /*Se a ultima etapa for concluida, o controlador é resetado*/
                                commandCurrent.reset();
                                commandCurrent = null;
                            }
                        }
                    }
                }

                /* --- FIM --- */

                //envio da mensagem de resposta
                sendResponse = bot.execute(new SendMessage(update.message().chat().id(), mensagem));
                //verificação de mensagem enviada com sucesso
                System.out.println("Mensagem Enviada?" + sendResponse.isOk());

                mensagem = "";
            }
        }
    }
}