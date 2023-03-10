package com.thinking.machines.util;
public class TMLinkedList<T> implements TMList<T>
{
private class TMNode<T>
{
public T data;
public TMNode<T> next;
}
private TMNode<T> start;
private TMNode<T> end;
private int size;




public class TMLinkedListIterator<T> implements TMIterator<T>
{
private TMNode<T> ptr;
public TMLinkedListIterator(TMNode<T> ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
T data=(T)this.ptr.data;
this.ptr=this.ptr.next;
return (T)data;
}
}

public TMIterator<T> iterator()
{
return new TMLinkedListIterator<T>(this.start);
}





public TMLinkedList()
{
this.start=null;
this.end=null;
}
public void add(T data)
{
TMNode<T> t;
t=new TMNode<T>();
t.data=data;
if(this.start==null)
{
this.start=this.end=t;
}
this.end.next=t;
this.end=t;
this.size++;
}
public void add(int index,T data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(index==this.size)
{
this.add(data);
return;
}
TMNode<T> p1,p2=null,t;
t=new TMNode<T>();
t.data=data;
p1=start;
for(int e=0;e<index;e++)
{
p2=p1;
p1=p1.next;
}
if(p1==this.start)
{
t.next=this.start;
this.start=t;
}
else
{
t.next=p1;
p2.next=t;
}
this.size++;
}
public void insert(int index,T data)
{
this.add(index,data);
}
public void removeAll()
{
this.size=0;
this.start=this.end=null;
}
public void clear()
{
this.size=0;
this.start=this.end=null;
}

public int size()
{
return this.size;
}
public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
TMNode<T> p1=this.start;
for(int e=0;e<index;e++)
{
p1=p1.next;
}
return (T)p1.data;
}
public void update(int index,T data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
TMNode<T> p1=start;
for(int e=0;e<index;e++)
{
p1=p1.next;
}
p1.data=data;
}
public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
TMNode<T> p1=start;
TMNode<T> p2=null;
for(int e=0;e<index;e++)
{
p2=p1;
p1=p1.next;
}
if(p1==start && p1==end) start=end=null;
else if(p1==start) start=p1.next;
else if(p1==end)
{
p2.next=null;
end=p2;
}
p2.next=p1.next;
end=p2;
this.size--;
return (T)p1.data;
}
public void copyTo(TMList<T> other)
{
other.clear();
for(int e=0;e<this.size();e++)
{
other.add(this.get(e));
}
}
public void copyFrom(TMList<T> other)
{
this.clear();
for(int e=0;e<other.size();e++)
{
this.add(other.get(e));
}
}
public void appendTo(TMList<T> other)
{
for(int e=0;e<this.size();e++)
{
other.add(this.get(e));
}
}
public void appendFrom(TMList<T> other)
{
for(int e=0;e<other.size();e++)
{
this.add(other.get(e));
}
}
public void forEach(TMListItemAcceptor<T> a)
{
if(a==null) return;
TMNode<T> t;
for(t=start;t!=null;t=t.next) a.accept((T)t.data);
}
}