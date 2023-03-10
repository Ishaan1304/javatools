import com.thinking.machines.util.*;
class KeyboardTestCase
{
public static void main(String gg[])
{
Keyboard k=new Keyboard();
String a;
System.out.print("Enter a String:");
a=k.getString();
String b;
b=k.getString("Enter another String:");
System.out.println(a);
System.out.println(b);

}




}