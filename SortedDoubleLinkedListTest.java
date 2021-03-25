package _Solution;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SortedDoubleLinkedListTest {
SortedDoubleLinkedList<String> dblSotedList;
StringComparator comp;
DoubleComparator DblComp;
SortedDoubleLinkedList<Double> dblSortedLinkedList;


@Before
public void setUp() throws Exception {
comp = new StringComparator();
dblSotedList = new SortedDoubleLinkedList<String>(comp);

DblComp = new DoubleComparator();
dblSortedLinkedList = new SortedDoubleLinkedList<Double>(DblComp);
}

@After
public void tearDown() throws Exception {
comp = null;
dblSotedList = null;
}

@Test
public void testAddToEnd() {
try {
dblSotedList.addToEnd("Hello");
assertTrue("Did not throw an UnsupportedOperationException", false);
}
catch (UnsupportedOperationException e)
{
assertTrue(" threw an UnsupportedOperationException", true);
}
catch (Exception e)
{
assertTrue("Threw an exception other than the UnsupportedOperationException", false);
}
}

@Test
public void testAddToFront() {
try {
dblSotedList.addToFront("Hello");
assertTrue("Did not throw an UnsupportedOperationException", false);
}
catch (UnsupportedOperationException e)
{
assertTrue(" threw an UnsupportedOperationException", true);
}
catch (Exception e)
{
assertTrue("Threw an exception other than the UnsupportedOperationException", false);
}
}

@Test
public void testIteratorSuccessfulStringNext() {
dblSotedList.add("Hello");
dblSotedList.add("World");
dblSotedList.add("Begin");
dblSotedList.add("Zebra");
ListIterator<String> iterator = dblSotedList.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals(true, iterator.hasNext());
}

@Test
public void testIteratorSuccessfulStringPreviousProblem() {
dblSotedList.add("Begin");
dblSotedList.add("World");
dblSotedList.add("Hello");
dblSotedList.add("Zebra");
ListIterator<String> iterator = dblSotedList.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals("Zebra", iterator.next());
assertEquals(true, iterator.hasPrevious());
assertEquals("Zebra", iterator.previous());
assertEquals("World", iterator.previous());
assertEquals("Hello", iterator.previous());
}
@Test
public void testIteratorSuccessfulStringPrevious() {
dblSotedList.add("Hello");
dblSotedList.add("World");
dblSotedList.add("Begin");
dblSotedList.add("Zebra");
ListIterator<String> iterator = dblSotedList.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals("Zebra", iterator.next());
assertEquals(true, iterator.hasPrevious());
assertEquals("Zebra", iterator.previous());
assertEquals("World", iterator.previous());
assertEquals("Hello", iterator.previous());
}
@Test
public void testIteratorSuccessfulDoubleNext() {
dblSortedLinkedList.add(new Double(5));
dblSortedLinkedList.add(new Double(8));
dblSortedLinkedList.add(new Double(2));
dblSortedLinkedList.add(new Double(10));
ListIterator<Double> iterator = dblSortedLinkedList.iterator();
assertEquals(true, iterator.hasNext());
assertEquals(new Double(2), iterator.next());
assertEquals(new Double(5), iterator.next());
assertEquals(new Double(8), iterator.next());
assertEquals(true, iterator.hasNext()); }

@Test
public void testIteratorSuccessfulDoublePrevious() {
dblSortedLinkedList.add(new Double(5));
dblSortedLinkedList.add(new Double(8));
dblSortedLinkedList.add(new Double(2));
dblSortedLinkedList.add(new Double(10));
ListIterator<Double> iterator = dblSortedLinkedList.iterator();
assertEquals(new Double(2), iterator.next());
assertEquals(new Double(5), iterator.next());
assertEquals(new Double(8), iterator.next());
assertEquals(new Double(10), iterator.next());
assertEquals(true, iterator.hasPrevious());
assertEquals(new Double(10), iterator.previous());
assertEquals(true, iterator.hasPrevious());
}

@Test
public void testIteratorNoSuchElementExceptionString() {
dblSotedList.add("Hello");
dblSotedList.add("World");
dblSotedList.add("Begin");
dblSotedList.add("Zebra");
ListIterator<String> iterator = dblSotedList.iterator();
assertEquals(true, iterator.hasNext());
assertEquals("Begin", iterator.next());
assertEquals("Hello", iterator.next());
assertEquals("World", iterator.next());
assertEquals(true, iterator.hasNext());
assertEquals("Zebra", iterator.next());
try{

iterator.next();
assertTrue("Did not throw a NoSuchElementException",false);
}
catch (NoSuchElementException e)
{
assertTrue(" threw a NoSuchElementException",true);
}
catch (Exception e)
{
assertTrue("Threw an exception other than the NoSuchElementException", false);
}
}

@Test
public void testIteratorNoSuchElementExceptionDouble() {
dblSortedLinkedList.add(new Double(5));
dblSortedLinkedList.add(new Double(8));
dblSortedLinkedList.add(new Double(2));
dblSortedLinkedList.add(new Double(10));
ListIterator<Double> iterator = dblSortedLinkedList.iterator();
assertEquals(true, iterator.hasNext());
assertEquals(new Double(2), iterator.next());
assertEquals(new Double(5), iterator.next());
assertEquals(new Double(8), iterator.next());
assertEquals(true, iterator.hasNext());
assertEquals(new Double(10), iterator.next());
try{

iterator.next();
assertTrue("Did not throw a NoSuchElementException",false);
}
catch (NoSuchElementException e)
{
assertTrue(" threw a NoSuchElementException",true);
}
catch (Exception e)
{
assertTrue("Threw an exception other than the NoSuchElementException", false);
} }

@Test
public void testIteratorUnsupportedOperationExceptionString() {
dblSotedList.add("Hello");
dblSotedList.add("World");
dblSotedList.add("Begin");
dblSotedList.add("Zebra");
ListIterator<String> iterator = dblSotedList.iterator();
try{

iterator.remove();
assertTrue("Did not throw a UnsupportedOperationException",false);
}
catch (UnsupportedOperationException e)
{
assertTrue("threw a UnsupportedOperationException",true);
}
catch (Exception e)
{
assertTrue("Threw an exception other than the UnsupportedOperationException", false);
}
}

@Test
public void testIteratorUnsupportedOperationExceptionDoubleSTUDENT() {
}

@Test
public void testAddString() {
dblSotedList.add("Banana");
dblSotedList.add("Elephant");
dblSotedList.add("Apple");
assertEquals("Apple", dblSotedList.getFirst());
assertEquals("Elephant", dblSotedList.getLast());
dblSotedList.add("Cat");
dblSotedList.add("Dog");
assertEquals("Apple", dblSotedList.getFirst());
assertEquals("Elephant", dblSotedList.getLast());

assertEquals("Elephant",dblSotedList.retrieveLastElement());

assertEquals("Dog", dblSotedList.getLast());
}


@Test
public void testRemoveFirstString() {
dblSotedList.add("Hello");
dblSotedList.add("World");
assertEquals("Hello", dblSotedList.getFirst());
assertEquals("World", dblSotedList.getLast());
dblSotedList.add("Begin");
assertEquals("Begin", dblSotedList.getFirst());
// remove the first
dblSotedList.remove("Begin", comp);
assertEquals("Hello", dblSotedList.getFirst());
}

@Test
public void testRemoveFirstDouble() {
dblSortedLinkedList.add(new Double(5));
dblSortedLinkedList.add(new Double(8));
assertEquals(new Double(5), dblSortedLinkedList.getFirst());
assertEquals(new Double(8), dblSortedLinkedList.getLast());
dblSortedLinkedList.add(new Double(2));
assertEquals(new Double(2), dblSortedLinkedList.getFirst());
// remove the first
dblSortedLinkedList.remove(new Double(2), DblComp);
assertEquals(new Double(5), dblSortedLinkedList.getFirst());
}

@Test
public void testRemoveEndString() {
dblSotedList.add("Hello");
dblSotedList.add("World");
assertEquals("Hello", dblSotedList.getFirst());
assertEquals("World", dblSotedList.getLast());
dblSotedList.add("Zebra");
assertEquals("Zebra", dblSotedList.getLast());
//remove from the end of the list
dblSotedList.remove("Zebra", comp);
assertEquals("World", dblSotedList.getLast());
}



@Test
public void testRemoveMiddleString() {
dblSotedList.add("Hello");
dblSotedList.add("World");
assertEquals("Hello", dblSotedList.getFirst());
assertEquals("World", dblSotedList.getLast());
dblSotedList.add("Begin");
assertEquals("Begin", dblSotedList.getFirst());
assertEquals("World", dblSotedList.getLast());
assertEquals(3,dblSotedList.getSize());
//remove from middle of list
dblSotedList.remove("Hello", comp);
assertEquals("Begin", dblSotedList.getFirst());
assertEquals("World", dblSotedList.getLast());
assertEquals(2,dblSotedList.getSize());
}



private class StringComparator implements Comparator<String>
{

@Override
public int compare(String first, String second) {

return first.compareTo(second);
}

}

private class DoubleComparator implements Comparator<Double>
{

@Override
public int compare(Double first, Double second) {

return first.compareTo(second);
}

}
