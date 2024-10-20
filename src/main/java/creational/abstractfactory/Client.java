package creational.abstractfactory;

import creational.abstractfactory.concrete.NaiveAlgorithmsFactory;
import creational.abstractfactory.products.Searcher;

// It's an object creational pattern.
// Used when we want to create a class of objects, without worrying about mixing them altogether.
// Switch b/w NaiveAlgorithmsFactory and Optimized factory classes to get new sets of objects.
// The actual concrete object creation like BubbleSort, BinarySearch are hidden away.
public class Client {
    public static void main(String[] args) {
        AlgorithmsFactory algorithmsFactory = new NaiveAlgorithmsFactory();
        Searcher searcher = algorithmsFactory.createSearcher();
        System.out.println(searcher.search(new int[]{1,2,3}, 3));
    }
}
