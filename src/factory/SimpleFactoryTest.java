package factory;

/**
 * @author: 焦
 * @date:   createDate：2017年10月5日 下午8:00:59   
 * @Description: 我们举一个发送邮件和短信的例子
 * 
 */

//发送接口
interface Sender {  
    public void Send();  
}  

//发送邮件实现类
class MailSender implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  

//发送短信实现类
class SmsSender implements Sender {  
	  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}  

/*
 * 就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 */
//发送工厂类
class SendFactory {  
	  
    public Sender produce(String type) {  
        if ("mail".equals(type)) {  
            return new MailSender();  
        } else if ("sms".equals(type)) {  
            return new SmsSender();  
        } else {  
            System.out.println("请输入正确的类型!");  
            return null;  
        }  
    }  
}  

public class SimpleFactoryTest {
	public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("sms");  
        sender.Send(); 
        
    }  
}
