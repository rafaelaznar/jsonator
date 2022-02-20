package net.daw.control;

import java.util.ArrayList;
import net.daw.bean.Li;
import net.daw.bean.Ol;
import net.daw.bean.Table;
import net.daw.bean.Td;
import net.daw.bean.Tdop;
import net.daw.bean.Th;
import net.daw.bean.Tr;
import net.daw.bean.Ul;

public class JsonMaker {

    public static Ol getOl(int numitems, int depth) throws Exception {
        Ol ol = new Ol();
        ArrayList contenido = new ArrayList<>();
        for (int contador3 = 1; contador3 <= numitems; contador3++) {
            Li li = new Li();

            if (depth > 0) {
                if (RandomGenerator.randInt(0, 4) == 0) {
                    if (RandomGenerator.randInt(0, 1) == 0) {
                        li.setSublist(JsonMaker.getUl(RandomGenerator.randInt(1, numitems), depth - 1));
                    } else {
                        li.setSublist(JsonMaker.getOl(RandomGenerator.randInt(1, numitems), depth - 1));
                    }
                }
            }

            li.setContent(Generator.generaNombre());
            contenido.add(li);
        }
        ol.setSublist(contenido);
        return ol;
    }

    public static Ul getUl(int numitems, int depth) throws Exception {
        Ul ul = new Ul();
        ArrayList contenido = new ArrayList<>();
        for (int contador3 = 1; contador3 <= numitems; contador3++) {
            Li li = new Li();

            if (depth > 0) {
                if (RandomGenerator.randInt(0, 4) == 0) {
                    if (RandomGenerator.randInt(0, 1) == 0) {
                        li.setSublist(JsonMaker.getUl(RandomGenerator.randInt(1, numitems), depth - 1));
                    } else {
                        li.setSublist(JsonMaker.getOl(RandomGenerator.randInt(1, numitems), depth - 1));
                    }
                }
            }

            li.setContent(Generator.generaNombre());
            contenido.add(li);
        }
        ul.setSublist(contenido);
        return ul;
    }

    public static Table getTable(int ancho, int alto) throws Exception {
        Table t = new Table();
        t.setTagClass("table table-responsive table-bordered table-hover table-striped table-condensed dataTable no-footer");
        ArrayList filah = new ArrayList<>();
        for (int contador3 = 1; contador3 <= ancho; contador3++) {
            Th th = new Th();
            th.setContent("Listado " + contador3);
            th.setId("cabecera" + contador3);
            filah.add(th);
        }
        t.setCabecera(filah);

        ArrayList filas = new ArrayList<>();
        t.setCuerpo(filas);
        for (int contador1 = 1; contador1 <= alto; contador1++) {
            Tr tr = new Tr();
            ArrayList fila = new ArrayList<>();
            tr.setGroup(fila);
            for (int contador2 = 1; contador2 <= ancho; contador2++) {
                if (RandomGenerator.randInt(0, 1) == 0) {
                    Td td = new Td();
                    td.setContentType("name");
                    td.setContent(Generator.generaNombre());
                    td.setId("cuerpo" + contador1 + contador2);
                    fila.add(td);
                } else {
                    Tdop tdop = new Tdop();
                    tdop.setContentType("operation");
                    tdop.setContent(Generator.generaOperacion());
                    tdop.setId("cuerpo" + contador1 + contador2);
                    fila.add(tdop);
                }
            }
            filas.add(fila);
        }
        return t;
    }

}
