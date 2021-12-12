package br.edu.infnet.eletronic_store_app.model.domain;

import br.edu.infnet.eletronic_store_app.model.exceptions.ClientIsInvalidException;
import br.edu.infnet.eletronic_store_app.model.exceptions.ProductListIsInvalidException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ShoppingCart {

    private LocalDateTime purchaseDate;
    private float totalBill;
    private Client client;
    private List<Product> products;

    public ShoppingCart(Client client) throws ClientIsInvalidException {

        if (client == null) {
            throw new ClientIsInvalidException("Impossivel iniciar um carinho sem um cliente valido.");
        }

        this.purchaseDate = LocalDateTime.now();
        this.client = client;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        StringBuilder sb = new StringBuilder();
        sb.append("****************** RESUMO DO CARRINHO ******************");
        sb.append("\r\n");
        sb.append("Nome do Cliente: ");
        sb.append(client.getName());
        sb.append("\r\n");
        sb.append("Email do Cliente: ");
        sb.append(client.getEmail());
        sb.append("\r\n");
        sb.append("Data de Compra :");
        sb.append(purchaseDate.format(format));
        sb.append("\r\n");
        sb.append("-------------------------------------------------------");
        sb.append("\r\n");

        return sb.toString();
    }

    public void printShoppingCartInfo() throws ProductListIsInvalidException {

        if (products == null) {
            throw new ProductListIsInvalidException("Não é possível emitir um resumo sem produtos");
        }

        if (products.size() <= 0) {
            throw new ProductListIsInvalidException("Não é possível emitir um resumo sem produtos");
        }


        System.out.println(this);
        StringBuilder sb = new StringBuilder();
        sb.append("PRODUTOS: ");
        sb.append("\r\n");
        sb.append("Quantidade: " + products.size());
        sb.append("\r\n");
        sb.append("-----------------------------");
        sb.append("\r\n");

        for (Product p: products) {
            sb.append("Prduto: ");
            sb.append(p.getTitle());
            sb.append("\r\n");
            sb.append("Valor Inicial R$");
            sb.append(p.getValue());
            sb.append("\r\n");
            sb.append("Valor Final R$");
            sb.append(p.calculateProductTotalValue());
            sb.append("\r\n");
            sb.append("-----------------------------");
            sb.append("\r\n");
        }

        sb.append("Total: R$" + this.calculateTotalBill());

        System.out.println(sb);
    }

    public String writeLineInFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.toString());
        sb.append("PRODUTOS: ");
        sb.append("\r\n");
        sb.append("Quantidade: " + products.size());
        sb.append("\r\n");
        sb.append("-----------------------------");
        sb.append("\r\n");

        for (Product p: products) {
            sb.append("Prduto: ");
            sb.append(p.getTitle());
            sb.append("\r\n");
            sb.append("Valor Inicial R$");
            sb.append(p.getValue());
            sb.append("\r\n");
            sb.append("Valor Final R$");
            sb.append(p.calculateProductTotalValue());
            sb.append("\r\n");
            sb.append("-----------------------------");
            sb.append("\r\n");
        }

        sb.append("Total: R$" + this.calculateTotalBill());

        return sb.toString();
    }

    public float calculateTotalBill() {
        this.totalBill  = 0;

        for (Product p: products) {
            this.totalBill  += p.calculateProductTotalValue();
        }

        return this.totalBill;
    }

    public void confirmPurchase() {
        this.purchaseDate = LocalDateTime.now();
        // TODO finalizar compra
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public float getTotalBill() {
        return totalBill;
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
