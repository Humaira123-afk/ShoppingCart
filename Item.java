package PROJECTOFDSA;

public class Item {
        String Name;
        double price;
        String Category;
        boolean isFavourite;
        double taxRate;


        public Item(String Name, double price, String category, boolean isFavourite , double taxRate) {
            this.Name = Name;
            this.price = price;
            this.Category = category;
            this.isFavourite = isFavourite;
            this.taxRate = taxRate;

        }


    public double calculateTax() {
        return (this.price * this.taxRate) / 100;
    }

        @Override
        public String toString() {
            return "Item{" +
                    "Name='" + Name + '\'' +
                    ", price=" + price +
                    ", Category='" + Category + '\'' +
                    ", isFavourite=" + isFavourite +
                    '}';
        }
    }
