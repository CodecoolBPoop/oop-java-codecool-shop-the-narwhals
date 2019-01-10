package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier earth616 = new Supplier("Earth-616", "");
        supplierDataStore.add(earth616);
        Supplier middleEarth = new Supplier("Middle-Earth", "");
        supplierDataStore.add(middleEarth);
        Supplier dcVerse = new Supplier("DC-Verse", "");
        supplierDataStore.add(dcVerse);
        Supplier hogwarts = new Supplier("Hogwarts", "");
        supplierDataStore.add(hogwarts);
        Supplier sw = new Supplier("Faraway galaxy", "");
        supplierDataStore.add(sw);

        //setting up a new product category
        ProductCategory weapon = new ProductCategory("Weapon", "", "");
        productCategoryDataStore.add(weapon);
        ProductCategory mystic = new ProductCategory("Mystic", "", "");
        productCategoryDataStore.add(mystic);
        ProductCategory vehicle = new ProductCategory("Vehicle", "", "");
        productCategoryDataStore.add(vehicle);
        ProductCategory pet = new ProductCategory("Pet", "", "");
        productCategoryDataStore.add(pet);

        ProductCategory collectorItem = new ProductCategory("Collectors' Item", "", "");
        productCategoryDataStore.add(collectorItem);

        //setting up products and printing it
        productDataStore.add(new Product("Captain America's Shield", 49.9f, "Credits", "Made from the strongest metal on earth, this one-of-a-kind shield will keep you safe against all manner of enemies. Also useful for bashing in arc reactors..", weapon, earth616));
        productDataStore.add(new Product("Sauron's Ring", 49.9f, "Credits", "Description here", weapon, middleEarth));
        productDataStore.add(new Product("Fury's Lightsaber", 49.9f, "Credits", "Description here", weapon, sw));
        productDataStore.add(new Product("Gandalf the White's Staff", 49.9f, "Credits", "Description here", weapon, middleEarth));
        productDataStore.add(new Product("Elder Wand", 49.9f, "Credits", "Description here", weapon, hogwarts));

        productDataStore.add(new Product("Lasso of Truth", 49.9f, "Credits", "Description here", mystic, dcVerse));
        productDataStore.add(new Product("Cloak of Levitation", 49.9f, "Credits", "Description here", mystic, earth616));
        productDataStore.add(new Product("Invisibility Cloak", 49.9f, "Credits", "Description here", mystic, hogwarts));
        productDataStore.add(new Product("Kyber Crystal", 49.9f, "Credits", "Description here", mystic, sw));
        productDataStore.add(new Product("Sorting Hat", 49.9f, "Credits", "Description here", mystic, hogwarts));

        productDataStore.add(new Product("The Millenium Falcon", 49.9f, "Credits", "Description here", vehicle, sw));
        productDataStore.add(new Product("Batmobile", 49.9f, "Credits", "Description here", vehicle, dcVerse));
        productDataStore.add(new Product("Avengers' Quinjet", 49.9f, "Credits", "Description here", vehicle, earth616));
        productDataStore.add(new Product("Flying Car", 49.9f, "Credits", "Description here", vehicle, hogwarts));

        productDataStore.add(new Product("Dum-E", 49.9f, "Credits", "Description here", pet, earth616));
        productDataStore.add(new Product("Porg", 49.9f, "Credits", "Description here", pet, sw));
        productDataStore.add(new Product("Hedwig", 49.9f, "Credits", "Description here", pet, hogwarts));
        productDataStore.add(new Product("Shadowfax", 49.9f, "Credits", "Description here", pet, middleEarth));

        productDataStore.add(new Product("Serious Clown Make-Up Kit", 49.9f, "Credits", "Description here", collectorItem, dcVerse));
        productDataStore.add(new Product("Wakanda-made bionic arm", 49.9f, "Credits", "Description here", collectorItem, earth616));
        productDataStore.add(new Product("Horn of Gondor", 49.9f, "Credits", "Description here", collectorItem, middleEarth));
        productDataStore.add(new Product("Bane's Mask", 49.9f, "Credits", "Description here", collectorItem, dcVerse));
        productDataStore.add(new Product("Harry's Glasses", 49.9f, "Credits", "Description here", collectorItem, hogwarts));


    }
}
