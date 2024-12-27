package PROJECTOFDSA;


public class ShoppingCart {

    Stack stack;
    Item[] Cart;
    int Size;
    int Capacity;


    public ShoppingCart(int Initial_Capacity) {
        this.Capacity = Initial_Capacity;
        this.Cart = new Item[Capacity];
        this.stack = new Stack(Capacity);
        this.Size = 0;
        System.out.println();
        System.out.println("\n---WELCOME TO SHOPPING CART---\n");
        System.out.print(" Shopping cart is initializes with capacity: " + Capacity);

    }


    private void Grow() {
        int newCapacity = Capacity * 2;
        Item[] newCart = new Item[newCapacity];
        for (int i = 0; i < Size; i++) {
            newCart[i] = Cart[i];
        }
        Cart = newCart;
        Capacity = newCapacity;
        System.out.println("Cart capacity is extended to : " + Capacity);
    }

    public void AddItem(Item item) {
        if (Size >= Capacity) {
            Grow();
        }
        stack.push(item);
        Cart[Size] = item;
        Size++;
        System.out.println(item.Name + "has been added to the cart ");
    }


      public void removeItem(int index) {
            if (index < 0 || index >= Size)
                throw new IndexOutOfBoundsException("Invalid index.Cart is Empty");
            for(int i= index;i <Size-1;i++)  {
                Cart[i] = Cart[i + 1];
            }
            Cart[Size - 1] = null;
            Size--;
            System.out.println(" Item at index " + index + " has been removed from the cart.");
        }


        public void ViewCart() {
            if (Size == 0) {
                System.out.println("Cart is empty.Nothing to view");
                return;
            } else {
                System.out.println("Item in the cart: \n");
                for (int i = 0; i < Size; i++) {
                    System.out.println(i + " : " + Cart[i]);
                }
            }
        }


        public void QuickSortByPrice() {
            QuickSort(Cart,0,Size- 1,"Price");
            System.out.println("Cart sorted by price using Quick Sort");
        }
        public void QuickSortByName() {
            QuickSort(Cart,0,Size-1,"Name");
            System.out.println("Cart sorted alphabetically using Quick Sort");
        }

        private void QuickSort(Item[] arr, int low, int high, String sortBy) {
            if (low < high) {
                int pi = partition(arr, low, high, sortBy);
                QuickSort(arr, low, pi - 1, sortBy);
                QuickSort(arr, pi + 1, high, sortBy);
            }
        }

        private int partition(Item[] arr, int low, int high, String sortBy) {
            Item pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                boolean condition;
                if (sortBy.equals("Price")) {
                    condition = arr[j].price <= pivot.price;
                } else {
                    condition = arr[j].Name.compareToIgnoreCase(pivot.Name) <= 0;
                }
                if (condition) {
                    i++;
                    Item temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            Item temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }


        public void ReplacingItem(int index, Item newitem){
            if(index<0 || index>=Size){
                System.out.println("Invalid index! Can't replace item");
                return;
            }
            Item Olditem = Cart[index];
            Cart[index]=newitem;
            System.out.println(" Index "  +  index  + " has been replaced  with : " + newitem);
        }

        public double CalculateTotalTax() {
        double total = 0;
        double totalWithTax = 0;

        for (int i = 0; i < Size; i++) {
            Item item = Cart[i];
            total += item.price;
            double itemTax = item.calculateTax();
            totalWithTax += item.price + itemTax;
        }
        System.out.println("Total: Rs." + total + ", Total with tax: Rs." + totalWithTax);
        return totalWithTax;
    }


    public boolean SearchItem(String Name) {
        boolean found = false;
        for (int i=0; i<Size;i++) {
            if (Cart[i].Name.equalsIgnoreCase(Name)) {
                System.out.println("Found: " + Cart[i]);
                found=true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item '" + Name + "' not found in the cart.");
        }
        return found;
    }


}
