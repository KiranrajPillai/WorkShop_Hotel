package com.HotelManagement;
import java.util.ArrayList;
import java.util.Scanner;

public class UC1 {
    public static ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    private static boolean Duplex;

    public static void addHotel() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Hotel hotel = new Hotel();
            System.out.println("Enter the name of the Customer");
            hotel.setName(sc.nextLine());
            System.out.println("Enter the type of the room (Duplex/Regular) ");
            hotel.setRateForRegularCustomer(sc.nextLine());
            if (Duplex) {
                System.out.println("Rate of the room is 1200");
            }
            else {
                System.out.println("Rate of the room is 800");
            }
            hotelList.add(hotel);
            break;
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Taj Mahal");
        addHotel();
        System.out.println(hotelList);
    }
}