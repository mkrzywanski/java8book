package chapter2.task15;

public class InvoiceDemo {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addItem("Blackwell Toster", 2, 24.95);
        invoice.addItem("ZapXpress Kuchenka Mikrofalowa", 1, 49.95);
        invoice.print();
    }
}
