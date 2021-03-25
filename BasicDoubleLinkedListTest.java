package _Solution;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListTest {
BasicDoubleLinkedList<String> StrLinked;
BasicDoubleLinkedList<Double> dblLinked;
StringComparator comp;
DoubleComparator dblComp;

@Before
public void setUp() throws Exception {
StrLinked = new BasicDoubleLinkedList<String>();
StrLinked.addToEnd("Hello");
StrLinked.addToEnd("World");
comp = new StringComparator();


dblLinked = new BasicDoubleLinkedList<Double>();
dblLinked.addToEnd(2.0);
dblLinked.addToEnd(122.0);
dblComp = new DoubleComparator();

}

@After
public void tearDown() throws Exception {
StrLinked = null;
comp = null;
}

@Test
public void testGetSize() {
assertEquals(2,StrLinked.getSize());
assertEquals(2,dblLinked.getSize());
}

@Test
public void testAddToEnd() {
assertEquals("World", StrLinked.getLast());
StrLinked.addToEnd("End");
assertEquals("End", StrLinked.getLast());
}



@Test
public void testAddToFront() {
assertEquals("Hello", StrLinked.getFirst());
StrLinked.addToFront("Begin");
assertEquals("Begin", StrLinked.getFirst());
}



@Test
public void testGetFirst() {
assertEquals("Hello", StrLinked.getFirst());
StrLinked.addToFront("New");
assertEquals("New", StrLinked.getFirst());
}



@Test
public void testGetLast() {
assertEquals("World", StrLinked.getLast());
StrLinked.addToEnd("New");
assertEquals("New", StrLinked.getLast());
}



@Test
public void testToArrayList()
{
ArrayList<String> list;
StrLinked.addToFront("Begin");
StrLinked.addToEnd("End");
list = StrLinked.toArrayList();
assertEquals("Begin", list.get(0));
assertEquals("Hello", list.get(1));
assertEquals("World", list.get(2));
assertEquals("End", list.get(3));
}



@Test
public void testIteratorSuccessfulNext() {
StrLinked.addToFront("Begin");
StrLinked.addToEnd("End");
ListIterator<String> iterator = StrLinked.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals(true, iterator.hasNext());
assertEquals("End", iterator.next());
}

@Test
public void testIteratorSuccessfulPrevious() {
StrLinked.addToFront("Begin");
StrLinked.addToEnd("End");
ListIterator<String> iterator = StrLinked.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals(true, iterator.hasPrevious());
assertEquals("World", iterator.previous());
assertEquals("Hello", iterator.previous());
}



@Test
public void testIteratorNoSuchElementExceptionNext() {
StrLinked.addToFront("Begin");
StrLinked.addToEnd("End");
ListIterator<String> iterator = StrLinked.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals(true, iterator.hasNext());
assertEquals("End", iterator.next());
try{

iterator.next();
assertTrue("Did not throw a NoSuchElementException",false);
}
catch (NoSuchElementException e)
{
assertTrue("Successfully threw a NoSuchElementException",true);
}
catch (Exception e)
{
assertTrue("Threw an exception other than the NoSuchElementException", false);
}

}

@Test
public void testIteratorNoSuchElementExceptionPrevious() {
StrLinked.addToFront("Begin");
StrLinked.addToEnd("End");
ListIterator<String> iterator = StrLinked.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals("End", iterator.next());
assertEquals(false, iterator.hasNext());
assertEquals(true, iterator.hasPrevious());
assertEquals("End", iterator.previous());
assertEquals("World", iterator.previous());
assertEquals("Hello", iterator.previous());
assertEquals("Begin", iterator.previous());
try{
//no more elements in list
iterator.previous();
assertTrue("Did not throw a NoSuchElementException",false);
}
catch (NoSuchElementException e)
{
assertTrue("Successfully threw a NoSuchElementException",true);
}
catch (Exception e)
{
System.out.println(e.getMessage());
assertTrue("Threw an exception other than the NoSuchElementException", false);
}

}


@Test
public void testIteratorUnsupportedOperationException() {
StrLinked.addToFront("Begin");
StrLinked.addToEnd("End");
ListIterator<String> iterator = StrLinked.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals(true, iterator.hasNext());
assertEquals("End", iterator.next());

try{

iterator.remove();
assertTrue("Did not throw a UnsupportedOperationException",false);
}
catch (UnsupportedOperationException e)
{
assertTrue("Successfully threw a UnsupportedOperationException",true);
}
catch (Exception e)
{
assertTrue("Threw an exception other than the UnsupportedOperationException", false);
}

}



@Test
public void testRemove() {

assertEquals("Hello", StrLinked.getFirst());
assertEquals("World", StrLinked.getLast());
StrLinked.addToFront("New");
assertEquals("New", StrLinked.getFirst());
StrLinked.remove("New", comp);
assertEquals("Hello", StrLinked.getFirst());

StrLinked.addToEnd("End");
assertEquals("End", StrLinked.getLast());
StrLinked.remove("End", comp);
assertEquals("World", StrLinked.getLast());
//remove from middle of list
StrLinked.addToFront("Begin");
assertEquals("Begin", StrLinked.getFirst());
assertEquals("World", StrLinked.getLast());
StrLinked.remove("Hello", comp);
assertEquals("Begin", StrLinked.getFirst());
assertEquals("World", StrLinked.getLast());

}



@Test
public void testRetrieveFirstElement() {
assertEquals("Hello", StrLinked.getFirst());
StrLinked.addToFront("New");
assertEquals("New", StrLinked.getFirst());
assertEquals("New", StrLinked.retrieveFirstElement());
assertEquals("Hello",StrLinked.getFirst());
assertEquals("Hello", StrLinked.retrieveFirstElement());
assertEquals("World",StrLinked.getFirst());

}



@Test
public void testRetrieveLastElement() {
assertEquals("World", StrLinked.getLast());
StrLinked.addToEnd("New");
assertEquals("New", StrLinked.getLast());
assertEquals("New", StrLinked.retrieveLastElement());
assertEquals("World",StrLinked.getLast());
}



private class StringComparator implements Comparator<String>
{

@Override
public int compare(String arg0, String arg1) {

return arg0.compareTo(arg1);
}

}

private class DoubleComparator implements Comparator<Double>
{

@Override
public int compare(Double arg0, Double arg1) {

return arg0.compareTo(arg1);
}

}
