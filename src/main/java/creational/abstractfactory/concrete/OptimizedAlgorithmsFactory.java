package creational.abstractfactory.concrete;

import creational.abstractfactory.AlgorithmsFactory;
import creational.abstractfactory.products.BinarySearch;
import creational.abstractfactory.products.MergeSort;
import creational.abstractfactory.products.Searcher;
import creational.abstractfactory.products.Sorter;

public class OptimizedAlgorithmsFactory implements AlgorithmsFactory {
    @Override
    public Sorter createSorter() {
        return new MergeSort();
    }

    @Override
    public Searcher createSearcher() {
        return new BinarySearch();
    }
}
