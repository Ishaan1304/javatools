import com.thinking.machines.util.*;
class TMLinkedListTestCase
{
public static void main(String gg[])
{
TMLinkedList list1=new TMLinkedList();
list1.add(0);
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(4,40);
for(int i=0;i<list1.size();i++)
{
System.out.println(list1.get(i));
}
TMLinkedList list2=new TMLinkedList();
list2.copyFrom(list1);

for(int i=0;i<list2.size();i++)
{
System.out.println(list2.get(i));
}
}


}