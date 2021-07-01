package com.example.demo;

import com.example.demo.model.Flight;
import com.example.demo.model.Flight.Ticket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
public class FlightController {



@PostMapping("/flight/tickets/total/2")
public Flight totalTicketsPrice(@RequestBody Flight f){
//    ArrayList<Ticket> list = (ArrayList<Ticket>) f.getListofTickets();

//    ArrayList<Ticket>  listticket = f.addTicketintoList(t);
//    System.out.println(f.toString());
    return f;
//    System.out.println(f.toString());
//    System.out.println(f.listofTickets.size());
//    //
//    int total =0;
//  //  Ticket[] tickets = f.toArray();
////    ArrayList<Tickets> list = f.getFlightList();
////     Iterator<String> crunchifyIterator = list.iterator();
////    while (crunchifyIterator.hasNext()) {
////        System.out.println(crunchifyIterator.next());
////    }
//    for (int i = 0; i < f.listofTickets.size(); i++) {
//         total += f.listofTickets.get(i).getPrice();
//         System.out.println(i);
//    }
//    System.out.println(total);
//    return "Total is $" + total;
//String.format("This is %s, %d"str_1, int_1)


}

}
