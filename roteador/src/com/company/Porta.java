package com.company;

public class Porta {
   private Pacote bufferSaida;
   private Pacote bufferEntrada; // buffer de entrada é destinado aos pacotes que chegam no roteador sendo armazenados diretamente no buffer de pacotes
   private Roteador referencia;

   public Roteador getReferencia() {
      return referencia;
   }

   public void setReferencia(Roteador referencia) {
      this.referencia = referencia;
   }
/*Do buffer os pacotes devem ser passados para o roteamento para calcular qual deve ser a porta
     de saída daquele pacote e do roteamento encaminhado para o atributo saída na porta de saída retornada
     pelo método de roteamento, da porta de saída o pacote deve ser encaminhado para a buffer de entrada
     do próximo roteador.
     */

}
