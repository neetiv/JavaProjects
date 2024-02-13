package TestApp;

import java.util.*;

/* name: TestApp
  author: Neeti Vaidya
  purpose: to execute methods written in other classes and outline what the user will see t=when they run the program
essentially guide them through the program and allow for them to work the program and use the functionalities of the store
  extends: n/a*/

public class TestApp {
  public static void main(String[] args) {

    while (true){
      int x;
      int y;
      
      Scanner scan = new Scanner(System.in);
      StoreManage manager = new StoreManage();
      boolean valid;
  
      System.out.print("Welcome to the Teacher Resources Hub, any teacher's one stop shop for all their teaching needs \n");

      for(int p=0; p<(manager.items.size()); p++){
        System.out.println((p+1) + ": " +manager.names.get(p));
      }

      System.out.println("Which item would you like to order?");
      try{
        x = scan.nextInt();
      }
      catch (Exception e){
        System.out.println("Please enter a valid integer value \n System restart...");
        continue;
      }
      if (0>x || x>3){
          System.out.println("Please enter a valid integer value \n System restart...");
          continue;
        
      }
      else{
        manager.setItem(x);
      }

      while (true){
        System.out.println("How many of this item would you like to order?");
        try{
          y = scan.nextInt();
        }
        catch (Exception e){
          System.out.println("Please enter a valid integer value \n System restart...");
          continue;
        }
        if (manager.checkInvent(y)){
          System.out.println("Fantastic!");
          break;
        }
        else{
          System.out.println("This item is not in stock");
          continue;
        }
      }

      int color;
      double height;
      int wood;
      
      String item = manager.getName(x-1);
      System.out.println("Please enter the following settings: \n Color of"+ item+"\n 1: green \n 2: blue \n 3: pink \n 4: none");
      color = scan.nextInt();
      if(x==3){
        System.out.println("Length of"+item+"(please enter a decimal value ):");
        height=scan.nextDouble();
        if (height == 0.0){
          while (height !=0.0){
            System.out.println("Length of"+item+"(please enter a decimal value ):");
            height=scan.nextDouble();
          }
        }
      }
      System.out.println("Wood type of" + item + "\n 1: mahogany\n 2: oak\n 3: pine");
      wood = scan.nextInt();

     manager.printReceipt( x, y);
     System.out.println("Thank you for shopping with us! \n Please enter \n 1: to buy another item \n 0: to exit");
   
     
      int last = scan.nextInt();
      if (last == 0){
        System.out.println("Thank you for shopping with us!");
        break;
      }
      else{
        System.out.println("System processing... \n Success \n \n");
        continue;
      }
    
    }
  }
}