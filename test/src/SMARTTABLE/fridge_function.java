package SMARTTABLE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class fridge_function {
   

   public int Id;
   public String Name;
   public String IdNFC;
   public String Category;
   public String Calories;
   public String Address;
   public String Quantity;
   public Date ExpirationDate;
   public boolean Available;

   public fridge_function(){}
   
   public fridge_function(int Id, String Name, String IdNFC, String Category, String Calories, 
         String Address, String Quantity, Date ExpirationDate) {
      
      setId(Id);
      setName(Name);
      setIdNFC(IdNFC);
      setCategory(Category);
      setCalories(Calories);
      setAddress(Address);
      setQuantity(Quantity);
      setExpirationDate(ExpirationDate);
      setAvailable(ExpirationDate);
   }

   private void setAvailable(Date ExpirationDate2) {
      // TODO Auto-generated method stub
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      Date date = new Date();
      boolean available;
      if(date.compareTo(ExpirationDate2)>0){
         available = false;
      }
      else if(date.compareTo(ExpirationDate2)<0){
         available = true;
      }
      else if(date.compareTo(ExpirationDate2)==0){
         available = true;
      }
      else{
         available = false;
      }
      
      this.Available = available;
   }
   
   public String getAvailable(){
	   if(Available==true)
		   return "Available";
	   else
		   return "Unavailable";
   }

   private void setExpirationDate(Date expirationDate2) {
      // TODO Auto-generated method stub
      this.ExpirationDate = expirationDate2;
   }

   public Date getExpirationDate(){
      return ExpirationDate;
   }
   
   private void setQuantity(String quantity2) {
      // TODO Auto-generated method stub
      this.Quantity = quantity2;
   }
   
   public String getQuantity(){
      return Quantity;
   }
   
   private void setAddress(String address2) {
      // TODO Auto-generated method stub
      this.Address = address2;
   }
   
   public String getAddress(){
      return Address;
   }

   private void setCalories(String calories2) {
      // TODO Auto-generated method stub
      this.Calories = calories2;
   }

   public String getCalories(){
      return Calories;
   }
   
   private void setCategory(String category2) {
      // TODO Auto-generated method stub
      this.Category = category2;
   }
   
   public String getCategory(){
      return Category;
   }
   
   private void setIdNFC(String idNFC2) {
      // TODO Auto-generated method stub
      this.IdNFC = idNFC2;
   }
   
   public String getIdNFC(){
      return IdNFC;
   }
   
   private void setName(String name2) {
      // TODO Auto-generated method stub
      this.Name = name2;
   }
   
   public String getName(){
      return Name;
   }
   
   private void setId(int id2) {
      // TODO Auto-generated method stub
      this.Id = id2;
   }
   
   public int getId(){
      return Id;
   }   
   
   public String[] getAll(){        
        SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
      String[] temp={Integer.toString(Id),Name,Category,Calories,Address,Quantity,dateformatyyyyMMdd.format(ExpirationDate),getAvailable()};      
      return temp;
   }   
   
}