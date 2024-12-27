package PROJECTOFDSA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart(5);

        double Grocery_Tax= 5.25;
        double Cooking_Tax= 8.95;
        double Electronic_Tax= 10.98;
        double Clothing_Tax= 7.99;
        double Accessories_Tax= 6.33;


        Item[] Grocery_Item = {
                new Item("Rice", 120.0,"Grocery",true,Grocery_Tax),
                new Item("Wheat",200.1,"Grocery",true,Grocery_Tax),
                new Item("Sugar",90.0,"Grocery",false,Grocery_Tax),
                new Item("Oil",400.0,"Grocery",true,Grocery_Tax),
                new Item("Ketchup",250.0,"Grocery",true,Grocery_Tax)
        };

        Item[] Cooking_Item = {
                new Item("Salt",100.0,"Cooking",true,Cooking_Tax),
                new Item("Vinegar",250.0,"Cooking",true,Cooking_Tax),
                new Item("Pepper",150.0,"Cooking",false,Cooking_Tax),
                new Item("Garlic",200.5,"Cooking",true,Cooking_Tax),
                new Item("Ginger",300.9,"Cooking",true,Cooking_Tax)
        };

        Item[] Electronics_Items = {
                new Item("Laptop",50000.0,"Electronics",true,Electronic_Tax),
                new Item("Mobile phone",30000.3,"Electronics",true,Electronic_Tax),
                new Item("Headphones",2000.99,"Electronics",false,Electronic_Tax),
                new Item("Smart watch",15000.09,"Electronics",true,Electronic_Tax),
                new Item("Camera",100000.10,"Electronics",true,Electronic_Tax)
        };

        Item[] Clothing_Items = {
                new Item("T-Shirt",500.2,"Clothing",true,Clothing_Tax),
                new Item("Jeans",1500.3,"Clothing",true,Clothing_Tax),
                new Item("Jacket",3000.1,"Clothing",false,Clothing_Tax),
                new Item("Shoes",2000.8,"Clothing",true,Clothing_Tax),
                new Item("Hat",400.1,"Clothing",true,Clothing_Tax)
        };

        Item[] Accessories_Items = {
                new Item("Watch",2502.9,"Accessories",true,Accessories_Tax),
                new Item("Sunglasses",1503.5,"Accessories",true,Accessories_Tax),
                new Item("Earrings",1000.5,"Accessories",false,Accessories_Tax),
                new Item("Ring",1200.9,"Accessories",true,Accessories_Tax),
                new Item("Necklace",2050.10,"Accessories",true,Accessories_Tax)
        };


        while (true) {

            System.out.println();
            System.out.println("\n**** MAIN MENU ****");
            System.out.println();
            System.out.println("1. View Categories");
            System.out.println("2. View Cart");
            System.out.println("3. Remove Item from Cart");
            System.out.println("4. Replace Item in Cart");
            System.out.println("5. Sort Cart by Price");
            System.out.println("6. Sort Cart by Name");
            System.out.println("7. Calculate Total with Tax");
            System.out.println("8. Search if item is already added in cart or not");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Select an option: ");

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println();
                    System.out.println("\n--- CATEGORIES ---");
                    System.out.println("1. Grocery");
                    System.out.println("2. Cooking");
                    System.out.println("3. Electronics");
                    System.out.println("4. Clothing");
                    System.out.println("5. Accessories");
                    System.out.println();
                    System.out.print  ("Select a category: ");
                    int categoryChoice = scanner.nextInt();

                    Item[] selectedItem = null;

                    switch (categoryChoice) {

                        case 1: selectedItem = Grocery_Item;
                          break;
                        case 2: selectedItem = Cooking_Item;
                          break;
                        case 3: selectedItem = Electronics_Items;
                          break;
                        case 4: selectedItem = Clothing_Items;
                           break;
                        case 5: selectedItem = Accessories_Items;
                          break;
                        default: System.out.println("Invalid category choice!");
                           break;
                    }

                    if(selectedItem != null) {
                        System.out.println();
                        System.out.println("\n--- ITEMS IN SELECTED CATEGORY ---");

                        for(int i = 0; i < selectedItem.length; i++) {
                            Item item = selectedItem[i];
                            String availability = item.isFavourite ? "Available" : "Sold Out";
                            System.out.println(i + 1 + ". " + item.Name + " - Rs." + item.price + " (" + availability + ")");
                        }


                        System.out.println();
                        System.out.print("Enter the item number to add to cart or 0 to go back: ");
                        int itemChoice = scanner.nextInt();
                        if (itemChoice > 0 && itemChoice <= selectedItem.length) {
                            Item chosenItem = selectedItem[itemChoice - 1];
                            if(chosenItem.isFavourite) {
                                cart.AddItem(chosenItem);
                                System.out.println(chosenItem.Name + " added to cart!");
                            } else {
                                System.out.println("Can't access " + chosenItem.Name + " because it has already been sold out!");
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- YOUR CART ---");
                    cart.ViewCart();
                    break;

                case 3:

                    System.out.println("\n\n--- REMOVE ITEM FROM CART ---");
                    cart.ViewCart();
                    System.out.print("Enter the index of the item to remove: ");
                    int removeIndex = scanner.nextInt();
                    cart.removeItem(removeIndex);
                    break;

                case 4:
                    System.out.println("\n--- REPLACE ITEM IN CART ---");
                    System.out.println();
                    cart.ViewCart();
                    System.out.print("\nEnter the index of the item to replace: ");
                    int replaceIndex = scanner.nextInt();


                    System.out.println("\n\n--- CATEGORIES FOR REPLACEMENTS ---");
                    System.out.println();
                    System.out.println("1. Grocery");
                    System.out.println("2. Cooking");
                    System.out.println("3. Electronics");
                    System.out.println("4. Clothing");
                    System.out.println("5. Accessories");
                    System.out.println();
                    System.out.print("Select a category: ");
                    int newCategoryChoice = scanner.nextInt();

                    Item[] newSelectedItems = null;
                    switch (newCategoryChoice) {
                        case 1: newSelectedItems = Grocery_Item;
                         break;
                        case 2: newSelectedItems = Cooking_Item;
                         break;
                        case 3: newSelectedItems = Electronics_Items;
                        break;
                        case 4: newSelectedItems = Clothing_Items;
                         break;
                        case 5: newSelectedItems = Accessories_Items;
                        break;
                        default: System.out.println("Invalid category choice!");
                        break;
                    }

                    if (newSelectedItems != null) {
                        System.out.println();
                        System.out.println("\n--- ITEMS IN SELECTED CATEGORIES ---");
                           for (int i = 0; i < newSelectedItems.length; i++) {
                              Item item = newSelectedItems[i];
                             String availability = item.isFavourite ? "Available" : "Sold Out";
                             System.out.println(i + 1 + ". " + item.Name + " - Rs." + item.price + " (" + availability + ")");
                        }

                        System.out.println();
                        System.out.print("Enter the item number to replace with: ");
                        int newItemChoice = scanner.nextInt();

                        if (newItemChoice > 0 && newItemChoice <= newSelectedItems.length) {
                            Item newChosenItem = newSelectedItems[newItemChoice - 1];
                            if ( newChosenItem.isFavourite ) {
                                  cart.ReplacingItem(  replaceIndex,  newChosenItem);
                                 System.out.println();
                                 System.out.println( newChosenItem.Name  +  " has been replaced in the cart!");
                            } else {
                                System.out.println("Can't access " + newChosenItem.Name + " because it has already been sold out!");
                            }
                        }
                    }
                    break;

                    case 5:
                    System.out.println("\n--- SORTING CART BY PRICE ---");
                     cart.QuickSortByPrice();
                    cart.ViewCart();
                    break;

                    case 6:
                    System.out.println("\n--- SORTING CART BY NAME ---");
                     cart.QuickSortByName();
                     cart.ViewCart();
                    break;

                    case 7:
                    System.out.println("\n--- TAX RATES PER CATEGORY --- ");
                    System.out.println("Tax for grocery items is : " + Grocery_Tax);
                    System.out.println("Tax for cooking items is : " + Clothing_Tax);
                    System.out.println("Tax for electronic items is : " + Electronic_Tax);
                    System.out.println("Tax for clothing items is : " + Clothing_Tax);
                    System.out.println("Tax for accessories items is : " + Accessories_Tax);

                    System.out.println("\n--- Calculating Total with Tax ---");
                     cart.CalculateTotalTax();
                     break;


                case 8:
                    System.out.print("Enter the name of the item to search: ");
                    scanner.nextLine();
                    String searchName = scanner.nextLine();
                    cart.SearchItem(searchName);
                    break;

                case  9:
                     System.out.println("EXITING PROGRAM.PLEASE COME AGAIN !");
                     scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
