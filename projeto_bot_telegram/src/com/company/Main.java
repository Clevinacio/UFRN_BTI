package com.company;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Criação do objeto bot com as informações de acesso
        TelegramBot bot = new TelegramBot("1029513435:AAE3c0Dgz-YByWCdYeIxp2kvyBZV8XjzJvw");

        //objeto responsável por receber as mensagens
        GetUpdatesResponse updatesResponse;

        //objeto responsável por gerenciar o envio de respostas
        SendResponse sendResponse;

        //objeto responsável por gerenciar o envio de ações do chat
        BaseResponse baseResponse;

        CommandController commandCurrent = null;
        String mensagem = "";

        //controle de off-set, isto é, a partir deste ID será lido as mensagens pendentes na fila
        int m=0;

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


                if(commandCurrent == null) {                                            /*Verifica se existe algum comendo em andamendo*/
                    if(update.message().text().equals("/addlocal")){                    /*Verifica se a mensagem que o usuario forneceu é de cadastro de localizacao*/
                        commandCurrent = new CadastroLocalizacaoController();           /*O cadastro em andamendo torna-se o de cadastro de localizacao*/
                        mensagem = commandCurrent.conversar(update.message().text());   /*Inicia a troca de mensagens*/
                    }
                }else{
                    if(update.message().text().equals("/cancelar")){                    /*Verifica se o usuario solicitou cancelamento da operacao em andamento*/
                        mensagem = "Operacao cancelada";
                        commandCurrent = null;
                    }else{
                        mensagem = commandCurrent.conversar(update.message().text());   /*A mensagem que o usuario enviou é tratada pelo
                                                                                        controlador da tarefa em andamento*/
                    }
                }

                //envio da mensagem de resposta
                sendResponse = bot.execute(new SendMessage(update.message().chat().id(), mensagem));
                //verificação de mensagem enviada com sucesso
                System.out.println("Mensagem Enviada?" + sendResponse.isOk());

                mensagem = "";
            }
        }
    }
}
