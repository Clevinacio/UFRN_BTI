package br.ufrn.imd.lpii.hospedagem.dominio;

import java.util.*;

public class Reserva {
        private Integer codigo;
        private Date dataEntrada;
        private Date dataSaida;
        //private Hospede hospede;
        private Aposento aposento;
        private Conta conta;

        private LinkedHashSet<Hospede> hospedes;

        public Reserva (Integer codigo){
                this.codigo = codigo;
                hospedes = new LinkedHashSet<>();

        }

        @Override
        public String toString(){
                StringBuffer sb = new StringBuffer();

                sb.append("Codigo : " + this.codigo + "\n");
                sb.append("Listagem de hospedes : \n");
                for (Hospede x : hospedes) {
                        sb.append(x);
                }
                return sb.toString();
        }

        public void addHospedes(Hospede h){
                //TODO fazer a validação de hospede que for necessária
                hospedes.add(h);
        }

//        public Integer getCodigo() {
//                return codigo;
//        }
//
//        public void setCodigo(Integer codigo) {
//                this.codigo = codigo;
//        }

        public Date getDataEntrada() {
                return dataEntrada;
        }

        public void setDataEntrada(Date dataEntrada) {
                this.dataEntrada = dataEntrada;
        }

        public Date getDataSaida() {
                return dataSaida;
        }

        public void setDataSaida(Date dataSaida) {
                this.dataSaida = dataSaida;
        }


        public Aposento getAposento() {
                return aposento;
        }

        public void setAposento(Aposento aposento) {
                this.aposento = aposento;
        }

        public Conta getConta() {
                return conta;
        }

        public void setConta(Conta conta) {
                this.conta = conta;
        }

        public LinkedHashSet<Hospede> getHospedes() {
                return hospedes;
        }
}
