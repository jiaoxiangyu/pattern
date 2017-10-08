package factory;

/**
 * @author: 焦
 * @date:   createDate：2017年10月5日 下午9:10:35   
 * @Description: 
 * 
 */
class SendFactory4 {  
    
    public static <T> T produce(Class<?> clazz){  
    	  T result = null;
          try {
              result = (T) Class.forName(clazz.getName()).newInstance();
          } catch (Exception e) {
              e.printStackTrace();
          }
          return result; 
    }  	      
    
}  

public class ReflectFactoryTest {
	 public static void main(String[] args) {      
	        Sender sender = SendFactory4.produce(MailSender.class);  
	        sender.Send();  
	 }  

}
