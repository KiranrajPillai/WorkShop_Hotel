package com.HotelManagement;
import java.util.Arrays;
import java.util.Scanner;

public class HotelProgram {

    private static boolean MainMenu = true;
    private static boolean SubMenu = true;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Room[] myHotel = new Room[10];
        myHotel[0] = new Room();
        myHotel[1] = new Room();
        myHotel[2] = new Room();
        myHotel[3] = new Room();
        myHotel[4] = new Room();
        myHotel[5] = new Room();
        myHotel[6] = new Room();
        myHotel[7] = new Room();
        myHotel[8] = new Room();
        myHotel[9] = new Room();
        int roomNum = 0;
        initialise(myHotel);
        while (MainMenu) {
            while (SubMenu) {
                System.out.println("Welcome to our TAJ MAHAL HOTEl");
                System.out.println("Select a option from the given option below");
                System.out.println("A: Book a Room in an Hotel");
                System.out.println("E: Display all the empty room available for booking");
                System.out.println("V: View all the rooms available for booking ");
                System.out.println("D: Delete customer from room.");
                System.out.println("F: Find room from customer name.");
                //System.out.println("S: Store program data in to file.");
                //System.out.println("L: Load program data from file.");
                System.out.println("O: View rooms Ordered alphabetically by name.");
                String Selection = input.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookARoom(myHotel, roomNum);
                        break;
                    case "E":
                        CheckIfEmpty(myHotel);
                        break;
                    case "V":
                        ViewAllRooms(myHotel);
                        break;
                    case "D":
                        DeleteCustomerFromRoom(myHotel, roomNum);
                        break;
                    case "F":
                        FindRoomFromCustomerName(myHotel);
                        break;
                    case "O":
                        ViewRoomsOrderedAlphabeticallyByName(myHotel);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }

    }

    private static void initialise(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            myHotel[x].setName("nobody");
        }
    }

    private static void CheckIfEmpty(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("nobody")) {
                System.out.println("room " + (x + 1) + " is empty");
            }
        }
    }

    private static void BookARoom(Room[] myHotel, int roomNum) {
        String roomName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (1-10):");
        roomNum = input.nextInt() - 1;
        System.out.println("Enter name for room " + (roomNum + 1) + " :");
        roomName = input.next();
        myHotel[roomNum].setName(roomName);
    }

    private static void ViewAllRooms(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            System.out.println("room " + (x + 1) + " occupied by " + myHotel[x].getName());
        }
    }

    private static void DeleteCustomerFromRoom(Room[] myHotel, int roomNum) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-10):");
        roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("nobody");
        System.out.println("Entery Deleted :)");
    }

    private static void FindRoomFromCustomerName(Room[] myHotel) {
        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to Search for:");
        roomName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < myHotel.length; x++) {
            if (roomName.equals(myHotel[x].getName())) {
                System.out.println("The Account That Matches That name is Account number " + x);
                Checker = true;
            }
        }
        if (Checker == false) {
            System.out.println("There are no Rooms Booked with that name\n(make sure you've used the correct CAP's)");
        }
    }

    private static void ViewRoomsOrderedAlphabeticallyByName(Room[] myHotel) {
        String[] myStrArray = new String[myHotel.length];
        for (int i = 0; i < myHotel.length; i++) {
            myStrArray[i] = myHotel[1].getName();
        }

        Arrays.sort(myStrArray);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);
        }

    }

    public static class Room {
        private String mainName;
        int guestsInRoom;

        public Room() {
            mainName = "k";

        }
        public String getName() {
            return mainName;
        }
        public void setName(String nobody) {
        }
    }
}
