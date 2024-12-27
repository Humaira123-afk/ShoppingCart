Shopping Cart System
Overview
The Shopping Cart System is a Java-based application that simulates a shopping cart. It allows users to add items to their cart, remove items, replace items, view cart details, calculate taxes, and search for items by name. It also includes functionality to sort items based on their price and calculates the total tax for all items in the cart.

Features
Add Items: Users can add items to their cart.
Remove Items: Items can be removed from the cart.
View Cart: Users can view all items in their cart.
Search Items: Items can be searched by name.
Sort Items by Price: Items in the cart can be sorted based on their price using QuickSort.
Calculate Tax: The system calculates tax for each item and the total tax for all items in the cart.
Replace Items: Items in the cart can be replaced by new items.
Project Setup
Prerequisites
Before running the project, ensure that you have the following installed:

Java Development Kit (JDK) version 8 or later.
Steps to Execute
Clone the Repository

Clone the repository to your local machine using the following command:
git clone https://github.com/Humaira123-afk/ShoppingCart.git
Navigate to the Project Folder

Open a terminal or command prompt and navigate to the project folder:

 ShoppingCart
Compile the Project

Use the javac command to compile the Java files. Run the following command in the terminal:

javac Item.java ShoppingCart.java
Run the Project
To run the main program, use the java command:

java ShoppingCart
Example Output

Once the program is running, you can interact with the cart and perform actions such as adding, removing, and viewing items.

Libraries and Packages Used
This project uses the Java Standard Library and does not require any additional external packages or libraries.

ArrayList (java.util): Used to manage the list of items in the shopping cart.
System (java.lang): Used for input/output operations and system-related tasks.
Methods and Classes
Item Class
This class represents an individual item in the cart. It includes the following methods:

Constructor: Initializes an item with its name, price, category, favourite status, and tax rate.
calculateTax(): Calculates the tax for the item.
toString(): Returns a string representation of the item.
ShoppingCart Class
This class manages the shopping cart and includes various methods to perform actions on the cart:

AddItem(): Adds an item to the cart.
removeItem(): Removes an item from the cart by index.
ViewCart(): Displays the items in the cart.
SearchItem(): Searches for an item by name.
QuickSortByPrice(): Sorts the items in the cart by their price using QuickSort.
ReplacingItem(): Replaces an item at a specific index.
CalculateTotalTax(): Calculates the total tax for all items in the cart.
Grow(): Expands the cart's capacity if it is full.
Contribution
If you want to contribute to this project, you can fork the repository, make changes, and submit a pull request.
License
This project is open-source and available under the MIT License.
Contact
For any questions or issues related to the project, please contact the project maintainer at:

Email: [humairabaksh38@gmail.com]

