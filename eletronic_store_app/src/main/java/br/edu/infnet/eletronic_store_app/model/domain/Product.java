package br.edu.infnet.eletronic_store_app.model.domain;

import br.edu.infnet.eletronic_store_app.model.exceptions.QuantityIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.ValueIsInvalidException;

public abstract class Product {

    private String title;
    private float value;
    private int quantity;

    public Product(String title, float value, int quantity) throws ValueIsInvalidException, QuantityIsInvalidException {

        if (value <= 0) {
            throw new ValueIsInvalidException(
                    "Nao foi possível cadastrar o produto: " + title +
                    " pois o valor provido é negativo ou menor que zero."
            );
        }

        if (quantity <= 0) {
            throw new QuantityIsInvalidException(
                    "Nao foi possível cadastrar o produto: " + title +
                    " pois a quantidade provida é negativa ou menor que zero."
            );
        }

        this.title = title;
        this.value = value;
        this.quantity = quantity;
    }

    public abstract float calculateProductTotalValue();

    @Override
    public String toString() {
        System.out.println("----------------------------------");
        StringBuilder sb = new StringBuilder();
        sb.append("# Titulo: ");
        sb.append(title);
        sb.append("\r\n");
        sb.append(" - Valor: R$");
        sb.append(value);
        sb.append("\r\n");
        sb.append(" - Quantidade: ");
        sb.append(quantity);

        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public float getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
