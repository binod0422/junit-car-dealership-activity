package org.example;


import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarDealershipTest {

        CarDealership carDealership = new CarDealership();
        Car car1 = new Car("Toyota", "Camry", 12000);
        double initialBudget = carDealership.budget;

        @Test
        public void testGetInventoryCount(){
            assertEquals(0,carDealership.getInventoryCount());
        }

        @Test
        public void testAddCar(){
            assertEquals("The car has been added to the inventory",carDealership.addCar(car1));
        }

        @Test
        public void budgetAfterBuying(){
            carDealership.addCar(car1);
            assertEquals(initialBudget - car1.getPrice(), carDealership.budget);
        }
        @Test
        public void getCount(){
            carDealership.addCar(car1);
            assertEquals(1, carDealership.getInventoryCount());
        }


        @Test
        public void carSold(){
            carDealership.sellCar(car1);
            assertEquals(0, carDealership.getInventoryCount());
        }
        @Test
        public void budgetAfterSelling(){
            assertEquals(initialBudget + car1.getPrice(), carDealership.budget);
        }





}
