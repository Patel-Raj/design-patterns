package creational.abstractfactory;

import creational.abstractfactory.products.Searcher;
import creational.abstractfactory.products.Sorter;

public interface AlgorithmsFactory {
    Sorter createSorter();
    Searcher createSearcher();
}
