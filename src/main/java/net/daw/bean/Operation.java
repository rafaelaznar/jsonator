package net.daw.bean;

import com.google.gson.annotations.Expose;
import net.daw.control.RandomGenerator;

public class Operation {

    @Expose
    private int primerOperando = 1;
    @Expose
    private int segundoOperando = 1;
    @Expose
    private String operacion = "+";

    public Operation() {
        int op = RandomGenerator.randInt(0, 4);
        if (op == 0) {
            operacion = "+";
        }
        if (op == 1) {
            operacion = "-";
        }
        if (op == 2) {
            operacion = "*";
        }
        if (op == 3) {
            operacion = "/";
        }
        this.primerOperando = RandomGenerator.randInt(1, 100);
        this.segundoOperando = RandomGenerator.randInt(1, 100);
    }

    public int getPrimerOperando() {
        return primerOperando;
    }

    public void setPrimerOperando(int primerOperando) {
        this.primerOperando = primerOperando;
    }

    public int getSegundoOperando() {
        return segundoOperando;
    }

    public void setSegundoOperando(int segundoOperando) {
        this.segundoOperando = segundoOperando;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

}
