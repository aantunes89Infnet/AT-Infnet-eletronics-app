package br.edu.infnet.eletronic_store_app.model.domain;

import br.edu.infnet.eletronic_store_app.model.exceptions.ChipsQuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.QuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.ValueIsInvalidException;

public class Cellphone extends Product {
    private String version;
    private boolean faceRecognition;
    private int chipsQuantity;
    private boolean isNewestModel;

    public Cellphone(
            String title,
            float value,
            int quantity,
            int chipsQuantity
    ) throws ValueIsInvalidException, QuantityIsInvalidException, ChipsQuantityIsInvalidException {
        super(title, value, quantity);

        if(chipsQuantity <= 0) {
            throw new ChipsQuantityIsInvalidException("### Nao foi possivel cadastrar "+ getTitle() + " pois a quantidade de chips provida é nula ou negativa");
        }

        this.chipsQuantity = chipsQuantity;
    }

    @Override
    public float calculateProductTotalValue() {
        float finalValue = getValue() * getQuantity();
        return chipsQuantity > 1 ? finalValue + 200 : finalValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\r\n");
        sb.append(" - Versao: ");
        sb.append(version != null ? version : " Ultimo modelo ");
        sb.append("\r\n");
        sb.append(" - Quantidade de Chips: ");
        sb.append(chipsQuantity);
        sb.append("\r\n");
        sb.append((faceRecognition == true ? " - Tem" : " Nao tem") + " reconhecimento Facial.");

        return sb.toString();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isFaceRecognition() {
        return faceRecognition;
    }

    public void setFaceRecognition(boolean faceRecognition) {
        this.faceRecognition = faceRecognition;
    }

    public int getChipsQuantity() {
        return chipsQuantity;
    }

    public boolean isNewestModel() {
        return isNewestModel;
    }

    public void setNewestModel(boolean newestModel) {
        isNewestModel = newestModel;
    }
}
