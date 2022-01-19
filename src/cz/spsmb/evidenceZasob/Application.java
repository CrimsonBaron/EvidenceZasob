package cz.spsmb.evidenceZasob;

import cz.spsmb.evidenceZasob.Ui.ProductVault;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ProductVault vault = new ProductVault();
        vault.menu();
    }
}
