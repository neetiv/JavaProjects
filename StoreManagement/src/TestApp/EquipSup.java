package TestApp;

import java.util.*;

/* name: EquipSup
  author: Neeti Vaidya
  purpose: to hold a set of methods universal for desk chair and pencil subclasses
also holds all the general information about all three such as inventory and manages all features relevant with inventory and acts
as the next step in the "process" to reach the subclasses
also holds all the getters and setters for desk chair and pencil parameters
  extends: n/a*/

public class EquipSup{

  public int deskInvent;
  public int chairInvent;
  public int pencilInvent;

  private int item;

  //constructors for EquipSup class
  public EquipSup(){
    deskInvent = 50;
    chairInvent = 50;
    pencilInvent = 50;
  }
  public EquipSup(int desk,int chair,int pencil){
    deskInvent = desk;
    chairInvent = chair;
    pencilInvent = pencil;
  }

  /* name; setItem
purpose; sets item variable (this.item) to user parameter item
parameters; int item
return type; void
  */
  public void setItem(int item){
    this.item = item;
  }

    /* name; checkInvent
purpose; checks to see if the inventory of the selected object is available for the number items requested
parameters; int inp
return type; boolean
  */
  public boolean checkInvent(int inp){
    if ((item==1 && inp<=deskInvent)||(item==2 && inp<=chairInvent)||(item==3 && inp<=pencilInvent)){
      return true;
    }

    return false;
  }

  /* name; setDeskInvent
purpose; sets deskInvent variable to user parameter invent
parameters; int invent
return type; void
  */
  
  public void setDeskInvent(int invent){
    deskInvent = invent;
  }

    /* name; getDeskInvent
purpose; returns inventory of how many desks there are
parameters; none
return type; int
  */
  public int getDeskInvent(){
    return deskInvent;
  }

  /* name; setChairInvent
purpose; sets chairInvent variable to user parameter invent
parameters; int invent
return type; void
  */
  
  public void setChairInvent(int invent){
    chairInvent = invent;
  }

  /* name; getChairInvent
purpose; returns inventory of how many chairs there are
parameters; none
return type; int
  */
  
  public int getChairInvent(){
    return chairInvent;
  }

  /* name; setChairInvent
purpose; sets chairInvent variable to user parameter invent
parameters; int invent
return type; void
  */
  
  public void setPencilInvent(int invent){
    pencilInvent = invent;
  }

  /* name; getPencilInvent
purpose; returns inventory of how many pencils there are
parameters; none
return type; int
  */
  
  public int getPencilInvent(){
    return pencilInvent;
  }

}