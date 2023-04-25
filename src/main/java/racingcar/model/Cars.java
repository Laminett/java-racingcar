package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void checkForwardConditionAndGo() {
        for (Car car : cars) {
            car.increaseDistance();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public String getWinner() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(car -> car.hasMaxDistance(maxDistance))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        return maxDistance;
    }

    public Cars getClone() {
        List<Car> copyCars = new ArrayList<>();
        for (Car car : cars) {
            copyCars.add(new Car(car.getName(), car.getDistance()));
        }

        return new Cars(copyCars);
    }

    public int getCarSize() {
        return cars.size();
    }

    public static Cars generateCars(String carNames) {
        String[] carName = carNames.split(",");
        List<Car> tempCars = new ArrayList<>();
        for (String name : carName) {
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            Car car = new Car(name, randomNumberGenerator);
            tempCars.add(car);
        }

        return new Cars(tempCars);
    }

}
