 package PROJECTOFDSA;

 public class Stack {

    private Item[] items;
    private int top;

    public Stack(int Capacity) {
     items = new Item[Capacity];
        top = -1;
    }

     public void push(Item item) {
         if (top < items.length - 1) {
             items[++top] = item;
         } else {
             System.out.println("Stack overflow");
         }
     }





}
