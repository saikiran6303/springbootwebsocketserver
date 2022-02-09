package dp.websocket.server.socket;
import java.util.*;




public class ServiceClass {
	
public static List<Customer> customers = Arrays.asList
				(new Customer("saikiran","Gajwel","1234", 1000) 
				,new Customer("linga","Gajwel","4567",1000));
	

public static  boolean searchbyID(String account_id) {
    for (int i = 0; i < customers.size(); i++) {
      if (customers.get(i).getAccountID().equals(account_id))
        return true;
    }
    return false;
  }
public  static String debit(String id,double balance){

    for(int i=0;i<customers.size();i++){
        if(customers.get(i).getAccountID().equals(id)){
            if(customers.get(i).getBalance()>=balance){
				customers.get(i).debitAmount(balance);
				return "Amount debited  and current balance is "+customers.get(i).getBalance();
            }
            else {
                return "Insufficient Balance !";
            }
        }
        
    }
    return "Invalid AccountId";
}

public static  String checkBalance(String id){
	for(int i=0;i<customers.size();i++){
		if(customers.get(i).getAccountID().equals(id)){
			return "Current Balance is rs  "+customers.get(i).getBalance();
		}
	}
	return "Account Not Found";
}

}
