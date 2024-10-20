package creational.abstractfactory.concrete;

import creational.abstractfactory.AlgorithmsFactory;
import creational.abstractfactory.products.BubbleSort;
import creational.abstractfactory.products.LinearSearch;
import creational.abstractfactory.products.Searcher;
import creational.abstractfactory.products.Sorter;

public class NaiveAlgorithmsFactory implements AlgorithmsFactory {
    @Override
    public Sorter createSorter() {
        return new BubbleSort();
    }

    @Override
    public Searcher createSearcher() {
        return new LinearSearch();
    }
}
