package br.edu.infnet.eletronic_store_app.model.domain;

import br.edu.infnet.eletronic_store_app.model.exceptions.BatteryAutonomyIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.QuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.ValueIsInvalidException;

public class Notebook extends Product{

    private int batteryAutonomy;
    private boolean touchScreen;
    private boolean digitalRecognition;

    public Notebook(
            String title,
            float value,
            int quantity,
            int batteryAutonomy
    ) throws ValueIsInvalidException, QuantityIsInvalidException, BatteryAutonomyIsInvalidException {
        super(title, value, quantity);

        if (batteryAutonomy <= 0) {
            throw new BatteryAutonomyIsInvalidException("### Nao foi possivel cadastrar "+ getTitle() + " pois o tempo de bateria provido é nulo ou menor que zero");
        }

        this.batteryAutonomy = batteryAutonomy;
    }

    @Override
    public float calculateProductTotalValue() {
        float finalValue = getValue() * getQuantity();
        return  batteryAutonomy > 6 ? finalValue + 500 : finalValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\r\n");
        sb.append(" - Tempo de Bateria: ");
        sb.append(this.batteryAutonomy);
        sb.append("\r\n");
        sb.append(" - É touch screen: ");
        sb.append(this.touchScreen == true ? "Sim" : "Não");
        sb.append("\r\n");
        sb.append(" - Tem reconhecimento digital: ");
                sb.append(this.digitalRecognition == true ? "Sim" : "Nao");

        return sb.toString();
    }

    public int getBatteryAutonomy() {
        return batteryAutonomy;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public boolean isDigitalRecognition() {
        return digitalRecognition;
    }

    public void setDigitalRecognition(boolean digitalRecognition) {
        this.digitalRecognition = digitalRecognition;
    }
}
