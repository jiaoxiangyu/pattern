package factory;

/**
 * @author: 焦
 * @date:   createDate：2017年10月5日 下午8:50:15   
 * @Description: 静态工厂方法模式
 * 
 */

//将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
class SendFactory3 {  
    
    public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }  
}  

public class StaticFactoryTest {
	
	 public static void main(String[] args) {      
	        Sender sender = SendFactory3.produceMail();  
	        sender.Send();  
	 }  
}
