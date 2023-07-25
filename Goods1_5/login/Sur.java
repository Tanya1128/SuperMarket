package javacode.Goods1_5.login;

import com.javacode.Goods1_5.Exception.DuplicateEntryException;
import com.javacode.Goods1_5.Exception.InvalidInputException;
import javacode.Goods1_5.Product.Goods;

import java.util.List;

public interface Sur {
        void addMarketProducts(List<Goods.Fruit> fruits,List<Goods.Meat> meats,List<Goods.Vegetable> vegetables) throws InvalidInputException, DuplicateEntryException;
        void deleteProducts(List<Goods.Fruit> fruits,List<Goods.Meat> meats,List<Goods.Vegetable> vegetables)throws InvalidInputException,DuplicateEntryException;
        void changeProducts(List<Goods.Fruit> fruits,List<Goods.Meat> meats,List<Goods.Vegetable> vegetables)throws InvalidInputException;
        void searchProducts(List<Goods.Fruit> fruits,List<Goods.Meat> meats,List<Goods.Vegetable> vegetables)throws InvalidInputException;
        void calculateTotal(List<Goods.Fruit> fruits,List<Goods.Meat> meats,List<Goods.Vegetable> vegetables)throws InvalidInputException;
}
