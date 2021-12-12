package br.edu.infnet.eletronic_store_app.model.domain;

import br.edu.infnet.eletronic_store_app.model.exceptions.QuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.TVIncheseIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.ValueIsInvalidException;

public class Television extends Product{

    private int inches;
    private boolean hasWiFi;
    private boolean isSmart;
    private boolean isScreenCurve;

    public Television(
            String title,
            float value,
            int quantity,
            int inches
    ) throws ValueIsInvalidException, QuantityIsInvalidException, TVIncheseIsInvalidException {

        super(title, value, quantity);

        if(inches <= 0) {
            throw new TVIncheseIsInvalidException("### Nao foi possivel cadastrar "+ getTitle() + " pois o numero de polegadas provido é nulo ou menor que zero");
        }

        this.inches = inches;
    }

    @Override
    public float calculateProductTotalValue() {
        float finalValue = getValue() * getQuantity();
        finalValue = hasWiFi == true ? finalValue + 500 : finalValue;
        finalValue = isSmart == true ? finalValue + 700 : finalValue;
        finalValue = isScreenCurve == true ? finalValue + 300 : finalValue;

        return finalValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\r\n");
        sb.append(" - Polegadas: ");
        sb.append(this.inches);
        sb.append("\r\n");
        sb.append(" - Tem Wi-Fi: ");
        sb.append(this.hasWiFi == true ? "Sim" : "Não");
        sb.append("\r\n");
        sb.append(" - É Smart TV: ");
        sb.append(this.isSmart == true ? "Sim" : "Nao");
        sb.append("\r\n");
        sb.append(" - Tem tela curva: ");
        sb.append(this.isScreenCurve == true ? "Sim" : "Nao");

        return sb.toString();
    }

    public int getInches() {
        return inches;
    }

    public boolean isHasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    public boolean isScreenCurve() {
        return isScreenCurve;
    }

    public void setScreenCurve(boolean screenCurve) {
        isScreenCurve = screenCurve;
    }
}
