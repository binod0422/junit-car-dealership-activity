package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarDealershipTest {

    private CarDealership carDealership;
    private Car car1;
    private Car car2;

    @BeforeEach
    public void setup() {
        carDealership = new CarDealership();
        car1 = new Car("Toyota", "Camry", 12000);
        car2 = new Car("Toyota", "Camry", 31000);
    }

    @Test
    public void testGetInventoryCount() {
        assertEquals(0, carDealership.getInventoryCount());
    }

    @Test
    public void testAddCar() {
        assertEquals("The car has been added to the inventory", carDealership.addCar(car1));
    }

    @Test
    public void testBudgetAfterBuying() {
        carDealership.addCar(car1);
        double initialBudget = carDealership.getBudget();
        int originalInventory = carDealership.getInventoryCount();

        assertEquals(initialBudget - car1.getPrice(), carDealership.getBudget());
        assertEquals(originalInventory + 1, carDealership.getInventoryCount());
        assertEquals("Not enough money in the budget", carDealership.addCar(car2));
    }

    @Test
    public void testCarSold() {
        carDealership.addCar(car1);
        carDealership.addCar(car1);
        int inventoryAfterAddingCar = carDealership.getInventoryCount();
        double initialMoney = carDealership.getMoneyMade();

        carDealership.sellCar(car1);

        assertEquals(inventoryAfterAddingCar - 1, carDealership.getInventoryCount());
        assertEquals(initialMoney + carDealership.getDealerMarkUp() * car1.getPrice(), carDealership.getMoneyMade());
    }
}
