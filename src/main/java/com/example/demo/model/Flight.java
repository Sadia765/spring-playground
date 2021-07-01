package com.example.demo.model;

import java.util.*;

public class Flight {
    public List<Ticket> listofTickets = new ArrayList<Ticket>();

    public Flight(){

    }
    public Flight(List<Ticket> listofTickets) {
        this.listofTickets = listofTickets;
    }
    public List<Ticket> getListofTickets() {
        return listofTickets;
    }

    public void setListofTickets(List<Ticket> listofTickets) {
        this.listofTickets = listofTickets;
    }

    public static class Ticket {
        private Passenger passenger;
        private int price;

        public Ticket(){

        }

        public Ticket(Passenger passenger, int price) {
            this.passenger = passenger;
            this.price = price;
        }

        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public static class Passenger {

            private String firstName;
            private String lastName;

            public Passenger(){

            }
            public Passenger(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }



        }

    }



//    public List<Ticket> addTicketintoList(){
//       Ticket ticket = new Ticket(passenger, price);
//        this.listofTickets.add(ticket) ;
//
//    }
    @Override
    public String toString() {
        return "Flight{" +
                "listofTickets=" + listofTickets +
                '}';
    }
}
