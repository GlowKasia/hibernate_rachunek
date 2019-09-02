package hibernate_rachunek;

import java.util.Scanner;

//- dodawanie rachunku
//- dodawanie produktów (do rachunku)
//- ustawianie rachunku jako opłaconego (po opłaceniu rachunku nie powinna istnieć możliwość dodawania produktów)
//- sprawdzanie kwoty rachunku po identyfikatorze
//- listowanie produktów na rachunku
//- listowanie rachunków
//- listowanie wszystkich produktów
//- listowanie rachunków nieopłaconych
//- listowanie rachunków z ostatniego tygodnia
//- wypisywanie sumy kwot rachunku z obecnego dnia.
public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityDao dao = new EntityDao();

        String komenda;
        do {
            komenda = scanner.nextLine();
            if (komenda.equalsIgnoreCase("dodajR")){

            }
        }while (!komenda.equalsIgnoreCase("quit"));

    }
}
