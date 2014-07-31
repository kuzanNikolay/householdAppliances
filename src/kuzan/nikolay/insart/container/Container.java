package kuzan.nikolay.insart.container;

import kuzan.nikolay.insart.model.HouseholdAppliances;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Nikolay on 15.07.14.
 */
public class Container <T extends HouseholdAppliances> {

    private List<T> list;

    public Container () {
        list = new ArrayList<T>();
    }

    /**
     * Appends the specified element to the end of this container
     *
     * @param item element to be appended to this container
     * @return true if this collection changed as a result of the call
     */
    public boolean add(T item){
        return list.add(item);
    }

    /**
     * Returns the element at the specified position in this container.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this container
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index >= size())
     */
    public T get(int index){
        return list.get(index);
    }


    /**
     * Returns the number of elements in this container. If this list contains
     * more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this container
     */
    public int count(){
        return list.size();
    }

    /**
     * Sorts the elements of the container by the price
     */
    public void sort(){
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1.getPrice() < o2.getPrice()) return -1;
                else if (o1.getPrice() == o2.getPrice()) return 0;
                else return 1;
            }
        });
    }

    /**
     * Print all elements of the container to standard output
     */
    public void print(){
        if (list != null){
            for (T temp : list){
                System.out.println(temp);
            }
        }
    }
}
