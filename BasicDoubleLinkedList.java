package _Solution;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements java.lang.Iterable<T> {
	protected class Node {
		protected T item;
		protected Node next, previous;

		protected Node(T item, Node next, Node previous) {
			this.item = item;
			this.next = next;
			this.previous = previous;
		}
	}

	protected int size;
	protected Node header, tail;

	public BasicDoubleLinkedList() {
		header = tail = null;
		size = 0;
		

	}
	

	public BasicDoubleLinkedList<T> addToEnd(T E) {

		Node tempo = new Node(E, null, tail);
		if (tail != null) {
			tail.next = tempo;
		}
		tail = tempo;
		if (header == null) {
			header = tempo;
		}
		size++;
		return this;
	}
	

	public BasicDoubleLinkedList<T> addToFront(T E) {

		Node tempo = new Node(E, header, null);
		if (header != null) {
			header.previous = tempo;
		}
		header = tempo;
		if (tail == null) {
			tail = tempo;
		}
		size++;
		return this;
	}

	public int getSize() {
		return size;
	}
	
	public T getLast() {
		return tail.item;
	}
	
	public T getFirst() {
		return header.item;
	}

	

	public BasicDoubleLinkedList<T> remove(T E, java.util.Comparator<T> comparator) {
		Node pre = null, cur = header;
		while (cur != null) {
			if (comparator.compare(cur.item, E) == 0) {
				if (cur == header) {
					header = header.next;
					cur = header;
				} else if (cur == tail) {
					cur = null;
					tail = pre;
					pre.next = null;
				} else {
					pre.next = cur.next;
					cur = cur.next;
				}
				size--;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return this;
	}
	
	public T retrieveFirstElement() {
		if (size == 0) {
			throw new NoSuchElementException("the linked list is empty");
		}
		Node tempo = header;
		header = header.next;
		header.previous = null;
		size--;
		return tempo.item;
	}
	

	public T retrieveLastElement() {

		if (header == null) {
			throw new NoSuchElementException("the linked list is empty");

		}
		Node curNode = header;
		Node preNode = null;

		while (curNode != null) {
			if (curNode.equals(tail)) {
				tail = preNode;
				break;
			}
			preNode = curNode;
			curNode = curNode.next;
		}
		size--;
		return curNode.item;
	}
	

	public ArrayList<T> toArrayList() {
		ArrayList<T> tempo = new ArrayList<T>();
		ListIterator<T> firstIterator = new iterator();

		while (firstIterator.hasNext()) {
			tempo.add(firstIterator.next());
		}
		return tempo;
	}
	public class iterator implements ListIterator<T> {
		private Node current;
		private Node last;
		public iterator()
		{
			current = header;
			last = null;
		}
		public T next()
		{
			if(current != null)
			{
				T returnData = current.item;
				last = current;
				current = current.next;
				if(current != null) { current.previous = last;}
				return returnData;
			}
			else
				throw new NoSuchElementException();
		}
		public boolean hasNext()
		{
			return current!=null;
		}
		public T previous()
		{
			if(last!= null)
			{
				current = last;
				last = current.previous;
				T returnData = current.item;
				return returnData;
			}
			else
				throw new NoSuchElementException();
		}
		public boolean hasPrevious()
		{
			return last!=null;
		}
		public void set(T elem) {
			current.item = elem;
		}
		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();

		}
	}

	public ListIterator<T> iterator() {
		return new iterator();
	}

}