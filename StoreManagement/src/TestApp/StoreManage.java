package TestApp;

import java.util.*;

/* name: StoreManage
  author: Neeti Vaidya
  purpose: manages storefront and is basically the center that outsources to EquipSup class, holds all the store information about inventory,
receipt, order, item specifications, etc. Essentially the "store" end of the program
  extends: n/a*/

public class StoreManage{

  EquipSup equip = new EquipSup();
  List<Integer> items = new ArrayList<Integer>();
  List<String> names = new ArrayList<String>();
  

  DeskSub desk = new DeskSub();
  ChairSub chair = new ChairSub();
  PencilSub pencil = new PencilSub();

//constructor for StoreManage class
  
  public StoreManage(){
    names.add("Desk");
    names.add("Chair");
    names.add("Pencil");

    items.add(equip.getDeskInvent());
    items.add(equip.getChairInvent());
    items.add(equip.getPencilInvent());
  }

  /* name; printReceipt
purpose; collects information provided by user throughout the process and prints cohesive receipt with all previously collected features and information
parameters; int item, int amount
return type; void
  */
  
  public void printReceipt( int item, int amount){
    
    System.out.println("**************************************\n");
    System.out.println("RECEIPT: TEACHER RESOURCES HUB\n");
    System.out.println("**************************************\n");
    System.out.print("item type: ");
    if (item==1){
      System.out.println(desk.toString());
    }
    else if (item==2){
      System.out.println(chair.toString());
    }
    else{
      System.out.println(pencil.toString());
    }

    System.out.println(amount+" units"+"\n");
    System.out.println("**************************************\n");
  
    String color;
    String wood;
    double height;
    
    if(item==1){
      color = desk.getColorStr();
      wood = desk.getWoodStr();
      height = desk.getHeight();
    }
    if(item==2){
      color = chair.getColorStr();
      wood = chair.getWoodStr();
      height = chair.getHeight();
    }
    else{
      color = pencil.getColorStr();
      wood = pencil.getWoodStr();
      height = pencil.getHeight();
    }

      System.out.println("Color:"+ color +"\n Wood Type:"+ wood +"\n Height/Length: "+ height+"\n");
    
    System.out.println("**************************************\n");


  }

  /* name; setItem
purpose; sets item in class EquipSup to user inputted item, setter
parameters; int item
return type; void
  */
  
  public void setItem(int item){
      equip.setItem(item);
  }

  /* name; getName
purpose; returns value at provided index of list names
parameters; int index
return type; String
  */
  
  public String getName(int index){
    return names.get(index);
  }
  
    /* name; checkInvent
purpose; outsources to method in EquipSup to check whether or not there is enough inventory to purchase a certain amount of an object
parameters; int inp
return type; boolean
  */
  public boolean checkInvent(int inp){
      return equip.checkInvent(inp);
  }
}
