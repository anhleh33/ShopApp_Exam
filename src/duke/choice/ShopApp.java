package duke.choice;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.UnknownHostException;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ShopApp {
    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        System.out.println("Welcome to Duke Shop!");
        ArrayList<Clothing> items = new ArrayList<>();
        double total = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("clothing.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String desc = parts[0];
                double price = Double.parseDouble(parts[1]);
                items.add(new Clothing(desc, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Customer c1 = new Customer("Pinky");
//        Collections.sort(c1.getItems());
        int measurement = 6;
        c1.setSize(measurement);
        c1.addItems(items);
        System.out.println("Customer added to clothing:");
        c1.print();
        System.out.println("Average price: " + c1.avaragePrice());

        System.out.println("---------------------------------------");

        Collections.sort(c1.getItems());
        System.out.println("Items loaded from file:");
        for (Clothing c : items) {
            System.out.println("Item: " + c);
        }

        ItemList list = new ItemList(items);
        Routing routing = Routing.builder()
                .get("/items", list).build();

        ServerConfiguration config = ServerConfiguration.builder()
                .bindAddress(InetAddress.getByName("0.0.0.0")) // bind to all interfaces
                .port(8888) // specify port
                .build();

        WebServer ws = WebServer.create(config, routing);
        ws.start()
                .thenAccept(server -> System.out.println("Server started at http://localhost:8888"))
                .exceptionally(t -> { t.printStackTrace(); return null; }); //hjy

        // Keep main thread alive so server doesn't exit
        Thread.currentThread().join();
    }
}