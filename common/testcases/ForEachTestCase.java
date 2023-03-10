import com.thinking.machines.util.*;
class ForEachTestCase
{
public static void main(String gg[])
{
TMList list1=new TMArrayList();
list1.add(0);
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
list1.forEach((p)->{
System.out.println(p);
});
System.out.println("**********************");
TMList list2=new TMLinkedList();
list2.add(0);
list2.add(100);
list2.add(200);
list2.add(300);
list2.add(400);
list2.forEach((q)->{
System.out.println(q);
});
}
}