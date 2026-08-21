import java.io.*;
import java.util.*;

interface Tradable {
    void buy(int qty);

    void sell(int qty);
}

abstract class FinancialProduct {
    protected String name;
    protected double price;
    protected int quantity;

    public FinancialProduct(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Stock extends FinancialProduct implements Tradable {

    public Stock(String name, double price) {
        super(name, price);
    }

    @Override
    public void buy(int qty) {
        quantity += qty;
    }

    @Override
    public void sell(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Stock sold successfully.");
        } else {
            System.out.println("Insufficient quantity available.");
        }
    }
}

public class VirtualFinancialPortfolio {

    static ArrayList<Stock> portfolio = new ArrayList<>();

    static void displayPortfolio() {

        if (portfolio.isEmpty()) {
            System.out.println("\nNo stocks available in portfolio.");
            return;
        }

        System.out.println("\n================================================================");
        System.out.printf("%-15s %-12s %-12s %-12s\n", "STOCK", "QUANTITY", "PRICE", "TOTAL");
        System.out.println("================================================================");

        for (Stock s : portfolio) {

            double total = s.getQuantity() * s.getPrice();

            System.out.printf("%-15s %-12d %-12.2f %-12.2f\n", s.getName(), s.getQuantity(), s.getPrice(), total);
        }

        System.out.println("================================================================");
    }

    static void calculatePortfolioValue() {

        double totalValue = 0;

        for (Stock s : portfolio) {
            totalValue += s.getQuantity() * s.getPrice();
        }

        System.out.println("\n====================================");
        System.out.printf("Total Portfolio Value: RS.%.2f\n", totalValue);
        System.out.println("====================================");
    }

    static void saveData() {

        try (PrintWriter pw = new PrintWriter("portfolio.csv")) {

            pw.println("ItemName,Quantity,UnitPrice,Total");

            for (Stock s : portfolio) {

                double total = s.getQuantity() * s.getPrice();

                pw.println(s.getName() + "," + s.getQuantity() + "," + s.getPrice() + "," + total);
            }

            System.out.println("\nPortfolio saved successfully to portfolio.csv");

        } catch (Exception e) {
            System.out.println("Error while saving data.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n====================================");
            System.out.println("   INVESTMENT PORTFOLIO SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Save Portfolio");
            System.out.println("5. View Portfolio Value");
            System.out.println("6. Exit");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n----------- BUY STOCK -----------");

                    System.out.print("Enter Stock Name: ");
                    String buyName = sc.next();

                    System.out.print("Enter Unit Price: ");
                    double unitPrice = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    boolean foundBuy = false;

                    for (Stock s : portfolio) {
                        if (s.getName().equalsIgnoreCase(buyName)) {
                            s.buy(qty);
                            foundBuy = true;
                            break;
                        }
                    }

                    if (!foundBuy) {
                        Stock stock = new Stock(buyName, unitPrice);
                        stock.buy(qty);
                        portfolio.add(stock);
                    }

                    System.out.println("Stock purchased successfully.");
                    break;

                case 2:

                    System.out.println("\n----------- SELL STOCK -----------");

                    System.out.print("Enter Stock Name: ");
                    String sellName = sc.next();

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    boolean foundSell = false;

                    for (Stock s : portfolio) {
                        if (s.getName().equalsIgnoreCase(sellName)) {
                            s.sell(sellQty);
                            foundSell = true;
                            break;
                        }
                    }

                    if (!foundSell) {
                        System.out.println("Stock not found.");
                    }

                    break;

                case 3:

                    displayPortfolio();
                    break;

                case 4:

                    saveData();
                    break;

                case 5:

                    calculatePortfolioValue();
                    break;

                case 6:

                    System.out.println("\nThank you for using Investment Portfolio System.");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}