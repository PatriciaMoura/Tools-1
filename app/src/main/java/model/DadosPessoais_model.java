package model;

/**
 * Created by Patricia on 23/11/2018.
 */

public class DadosPessoais_model extends Pessoa {

        //Nome tabela

        public static final String TABLE = "dadospessoais";

        //Nome colunas

        public static final String COLUMN_PESO = "peso";
        public static final String COLUMN_ALTURA = "altura";

        //Criando tabela

        public static final String SQL_CREATE = "CREATE TABLE " + TABLE + "( " + SQL_PESSOA
                + COLUMN_PESO    + " REAL,"
                + COLUMN_ALTURA  + " REAL)";


        private double peso, altura;

        public double getPeso () { return peso;}
        public void setPeso (double peso) {this.peso = peso;}

        public double getAltura () {return altura;}
        public void setAltura (double altura) {this.altura = altura;}



    }
