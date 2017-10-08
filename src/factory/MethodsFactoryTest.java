package factory;

/**
 * @author: 焦
 * @date:   createDate：2017年10月5日 下午8:46:53   
 * @Description: 多个工厂方法模式
 * 
 */

/*
 * 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，
而多个工厂方法模式是提供多个工厂方法，分别创建对象。
*/
class SendFactory2 {  
    
    public Sender produceMail(){  
        return new MailSender();  
    }  
      
    public Sender produceSms(){  
        return new SmsSender();  
    }  
}  

public class MethodsFactoryTest {
	public static void main(String[] args) {  
        SendFactory2 factory = new SendFactory2();  
        Sender sender = factory.produceMail();  
        sender.Send();  
    }  
}
