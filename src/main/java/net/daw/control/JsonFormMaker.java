/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.control;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import net.daw.bean.Element;
import net.daw.bean.Form;
import net.daw.bean.Input;
import net.daw.bean.Label;
import net.daw.bean.Option;
import net.daw.bean.Select;

/**
 *
 * @author rafa
 */
public class JsonFormMaker {

    public String getForm(int nivel) throws Exception {
        String resultado = "";
        try {
            Form oForm = new Form();
            if (nivel == 1) {
                oForm = getForm(oForm);
                oForm = fillInputText(oForm, 1);
            }

            if (nivel == 2) {
                oForm = getForm(oForm);
                oForm = fillInputText(oForm, RandomGenerator.randInt(1, 10));
            }
            if (nivel == 3) {
                oForm = getForm(oForm);
                oForm = fillInputText(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputHidden(oForm, RandomGenerator.randInt(1, 10));
            }
            if (nivel == 4) {
                oForm = getForm(oForm);
                oForm = fillInputText(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputHidden(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputCheckbox(oForm, RandomGenerator.randInt(1, 10));
            }
            if (nivel == 5) {
                oForm = getForm(oForm);
                oForm = fillInputText(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputHidden(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputCheckbox(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputRadio(oForm, RandomGenerator.randInt(1, 10));
            }
            if (nivel == 6) {
                oForm = getForm(oForm);
                oForm = fillInputText(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputHidden(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputCheckbox(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputRadio(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputButton(oForm, RandomGenerator.randInt(1, 10));
            }
            if (nivel == 7) {
                oForm = getForm(oForm);
                oForm = fillInputText(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputHidden(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputCheckbox(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputRadio(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillInputButton(oForm, RandomGenerator.randInt(1, 10));
                oForm = fillSelect(oForm, RandomGenerator.randInt(1, 10), RandomGenerator.randInt(2, 5));
            }
            //Collections.shuffle(oForm.getElements());
            oForm = addSubmit(oForm);

            Gson gson = new Gson();
            resultado = gson.toJson(oForm);

        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":getForm ERROR: " + ex.getMessage());
        }
        return "{\"json\":" + resultado + "}";
    }

    public Form fillSelect(Form oForm, int numControles, int numMaxOpciones) throws Exception {
        try {
            for (int contador1 = 1; contador1 <= numControles; contador1++) {
                Select oSelect = new Select();
                int numSelect = RandomGenerator.randInt(1, 99999);
                oSelect.setName("select" + numSelect);
                oSelect.setId("select" + numSelect);
                oSelect.setName("select" + numSelect);
                ArrayList<Option> oOptions = new ArrayList<>();
                oSelect.setOptions(oOptions);
                int numOpciones = RandomGenerator.randInt(2, numMaxOpciones);
                for (int contador2 = 1; contador2 <= numOpciones; contador2++) {
                    int numOption = RandomGenerator.randInt(1, 99999);
                    Option oOption = new Option();
                    oOption.setId("option" + numOption);
                    oOption.setText("option" + numOption);
                    oOption.setValue("option" + numOption);
                    ArrayList<Option> ooOptions = oSelect.getOptions();
                    ooOptions.add(oOption);
                }
                ArrayList<Element> oElements = oForm.getElements();
                oElements.add(oSelect);
            }
        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":fillSelect ERROR: " + ex.getMessage());
        }
        return oForm;
    }

    public Form fillInputRadio(Form oForm, int numControles) throws Exception {
        try {
            for (int contador = 1; contador <= numControles; contador++) {
                int numInput = RandomGenerator.randInt(1, 99999);

                Input oInput = new Input();

                oInput.setType("radio");
                oInput.setName("inputRadio" + numInput);
                oInput.setId("inputRadio" + numInput);
                oInput.setText("inputRadio" + numInput);

                ArrayList<Element> oElements = oForm.getElements();

                oElements.add(oInput);

            }
        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":fillInputText ERROR: " + ex.getMessage());
        }
        return oForm;
    }

    public Form fillInputButton(Form oForm, int numControles) throws Exception {
        try {
            for (int contador = 1; contador <= numControles; contador++) {
                int numInput = RandomGenerator.randInt(1, 99999);

                Input oInput = new Input();
                oInput.setType("button");
                oInput.setName("inputButton" + numInput);
                oInput.setId("inputButton" + numInput);
                oInput.setValue("inputButton" + numInput);
                //Element oElement = oInput;

                ArrayList<Element> oElements = oForm.getElements();

                oElements.add(oInput);

            }
        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":fillInputText ERROR: " + ex.getMessage());
        }
        return oForm;
    }

    public Form fillInputText(Form oForm, int numControles) throws Exception {
        try {
            for (int contador = 1; contador <= numControles; contador++) {
                int numInput = RandomGenerator.randInt(1, 99999);
                Label oLabel = new Label();
                oLabel.setLabeltext("Texto_" + numInput + ":");
                oLabel.setLabelfor("inputText" + numInput);

                Input oInput = new Input();
                oInput.setType("text");
                oInput.setName("inputText" + numInput);
                oInput.setId("inputText" + numInput);
                //Element oElement = oInput;

                ArrayList<Element> oElements = oForm.getElements();
                oElements.add(oLabel);
                oElements.add(oInput);

            }
        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":fillInputText ERROR: " + ex.getMessage());
        }
        return oForm;
    }

    public Form fillInputCheckbox(Form oForm, int numControles) throws Exception {
        try {
            for (int contador = 1; contador <= numControles; contador++) {
                int numInput = RandomGenerator.randInt(1, 99999);

                Input oInput = new Input();
                oInput.setType("checkbox");
                oInput.setName("inputCheck" + numInput);
                oInput.setId("inputCheck" + numInput);
                oInput.setValue("inputCheck" + numInput);
                oInput.setText("inputCheck" + numInput);

                //Element oElement = oInput;
                ArrayList<Element> oElements = oForm.getElements();

                oElements.add(oInput);

            }
        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":fillInputText ERROR: " + ex.getMessage());
        }
        return oForm;
    }

    public Form fillInputHidden(Form oForm, int numControles) throws Exception {
        try {
            for (int contador = 1; contador <= numControles; contador++) {
                int numInput = RandomGenerator.randInt(1, 99999);

                Input oInput = new Input();
                oInput.setType("hidden");
                oInput.setName("inputText" + numInput);

                //Element oElement = oInput;
                ArrayList<Element> oElements = oForm.getElements();

                oElements.add(oInput);

            }
        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":fillInputText ERROR: " + ex.getMessage());
        }
        return oForm;
    }

    public Form addSubmit(Form oForm) throws Exception {
        try {

            Input oInput1 = new Input();
            oInput1.setType("reset");
            oInput1.setName("reset");
            oInput1.setId("reset");

            Input oInput2 = new Input();
            oInput2.setType("submit");
            oInput2.setName("submit");
            oInput2.setId("submit");

            ArrayList<Element> oElements = oForm.getElements();
            oElements.add(oInput1);
            oElements.add(oInput2);

        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":getForm01 ERROR: " + ex.getMessage());
        }
        return oForm;
    }

    public Form getForm(Form oForm) throws Exception {
        try {
            int numForm = RandomGenerator.randInt(1, 99999);
            oForm.setName("formulario" + numForm);
            oForm.setId("form" + numForm);
            ArrayList<Element> oElem = new ArrayList<>();
            oForm.setElements(oElem);
            if (RandomGenerator.randInt(1, 2) == 1) {
                oForm.setAction("post");
            } else {
                oForm.setAction("get");
            }

        } catch (Exception ex) {
            throw new Exception(this.getClass().getName() + ":getForm01 ERROR: " + ex.getMessage());
        }
        return oForm;
    }
}
