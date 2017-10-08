package abstractfactory;

/**
 * @author: 焦
 * @date:   createDate：2017年10月5日 下午8:56:01   
 * @Description: 
 * 
 */
//形状接口
interface Shape {
	void draw();
}

//三角形
class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}

//矩形
class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}

//圆
class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
   
}

//颜色接口
interface Color {
   void fill();
}

//红色
class Red implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Red::fill() method.");
   }
}

//绿色
class Green implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}

//蓝色
class Blue implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Blue::fill() method.");
   }
}

//为 Color 和 Shape 对象创建抽象类来获取工厂。
abstract class AbstractFactory {
	
   abstract Color getColor(String color);
   abstract Shape getShape(String shape) ;
   
}

//形状工厂实现类
class ShapeFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }        
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      return null;
   }
   
   @Override
   Color getColor(String color) {
      return null;
   }
}

//颜色工厂实现类
class ColorFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      return null;
   }
   
   @Override
   Color getColor(String color) {
      if(color == null){
         return null;
      }        
      if(color.equalsIgnoreCase("RED")){
         return new Red();
      } else if(color.equalsIgnoreCase("GREEN")){
         return new Green();
      } else if(color.equalsIgnoreCase("BLUE")){
         return new Blue();
      }
      return null;
   }
}

//创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      return null;
   }
}

public class AbstractFactoryTest {
	 public static void main(String[] args) {

	      //获取形状工厂
	      AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

	      //获取形状为 Circle 的对象
	      Shape shape1 = shapeFactory.getShape("CIRCLE");

	      //调用 Circle 的 draw 方法
	      shape1.draw();

	      //获取形状为 Rectangle 的对象
	      Shape shape2 = shapeFactory.getShape("RECTANGLE");

	      //调用 Rectangle 的 draw 方法
	      shape2.draw();
	      
	      //获取形状为 Square 的对象
	      Shape shape3 = shapeFactory.getShape("SQUARE");

	      //调用 Square 的 draw 方法
	      shape3.draw();

	      //获取颜色工厂
	      AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

	      //获取颜色为 Red 的对象
	      Color color1 = colorFactory.getColor("RED");

	      //调用 Red 的 fill 方法
	      color1.fill();

	      //获取颜色为 Green 的对象
	      Color color2 = colorFactory.getColor("Green");

	      //调用 Green 的 fill 方法
	      color2.fill();

	      //获取颜色为 Blue 的对象
	      Color color3 = colorFactory.getColor("BLUE");

	      //调用 Blue 的 fill 方法
	      color3.fill();
	   }
}
