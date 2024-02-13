package TestApp;

import java.util.*;

/* name: PencilSub
  author: Neeti Vaidya
  purpose: to hold all features and parameters of the pencil class, holds color height wood and other features of ordered pencils
  extends: EquipSup*/

public class PencilSub extends EquipSup{
  private int wood;
  private double height;
  private int color;
  
//constructor for PencilSub subclass

  public PencilSub(){
    super();
  }
  public PencilSub(int wood, double height, int color){
    this.wood = wood;
    this.height = height;
    this.color=color;
  }

  /* name; getColor
purpose; returns user selected color of pencils
parameters; none
return type; int
  */
  
  public int getColor(){
    return color;
  }

  /* name; getHeight
purpose; returns user selected length of pencil
parameters; none
return type; double
  */
  
  public double getHeight(){
    return height;
  }

  /* name; getWood
purpose; returns user selected wood type of pencil
parameters; none
return type; int
  */
  
  public int getWood(){
    return wood;
  }

        /* name; getColorStr
purpose; returns color String of color selected by user by converting numerical user integer input (user inputs a number corresponding to
an option on a menu and the method converts the number back to corresponding option)
parameters; none
return type; String
  */

  public String getColorStr(){
    if (this.color==1){
      return "green";
    }
    if(this.color==2){
      return "blue";
    }
    if (this.color==3){
      return "pink";
    }
    else{
      return "none";
    }
  }

      /* name; getWoodStr
purpose; returns wood tyle String of wood type selected by user by converting numerical user integer input (user inputs a number corresponding to
an option on a menu and the method converts the number back to corresponding option)
parameters; none
return type; String
  */
  
  public String getWoodStr(){
    if (this.wood==1){
      return "mahogany";
    }
    if(this.wood==2){
      return "oak";
    }
    else{
      return "pine";
    }
    
  }

    /* name; toString
purpose; returns String containing information about pencils such as name of object
parameters; none
return type; String
  */
  
  public String toString(){
    return "Pencils \n";
  }
}

