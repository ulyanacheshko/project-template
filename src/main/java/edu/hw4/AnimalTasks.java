package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnimalTasks {
    private static final int MIN_HEIGHT = 100;

    private AnimalTasks() {

    }

    public static List<Animal> sortByHeightFromShortToTall(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    public static List<Animal> sortByWeightFromLightToHeavy(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight)
                .reversed())
            .limit(k)
            .toList();
    }

    public static Map<Animal.Type, Integer> countOfAnimalsByType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    public static Animal animalLongestName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(o -> o.name().length()))
            .orElse(null);
    }

    public static Animal.Sex moreMalesOrFemales(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
    }

    public static Map<Animal.Type, Animal> getHeaviestAnimalsMap(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(Animal::weight)),
                Optional::orElseThrow
            )));
    }

    public static Animal getOldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElseThrow();
    }

    public static Optional<Animal> getHeaviestAmongAnimalsBelowKHeight(List<Animal> animals, int k) {
        return animals.stream()
            .filter(a -> a.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer countPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> ageNotEqualsAmountOfPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    public static List<Animal> canBiteAndHigherThan100(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > MIN_HEIGHT)
            .toList();
    }

    public static Integer weightMoreThanHeight(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .toList()
            .size();
    }

    public static List<Animal> nameConsistOfMoreThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    public static Boolean isDogHeightMoreThanK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> sumWeightWithAgeMoreThatKAndLessThatL(
        List<Animal> animals, int k, int l
    ) {
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> sortedByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    public static boolean isSpidersBitesMoreDogs(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.type() == Animal.Type.SPIDER || a.type() == Animal.Type.DOG)
            .collect(Collectors.collectingAndThen(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(a -> a.bites() ? 1 : 0)
            ), (map) -> {
                if (!map.containsKey(Animal.Type.SPIDER) || !map.containsKey(Animal.Type.DOG)) {
                    return false;
                }
                return map.get(Animal.Type.SPIDER) > map.get(Animal.Type.DOG);
            }));
    }

    public static Animal mostHeavyFish(List<List<Animal>> animals) {
        return animals.stream()
            .flatMap(Collection::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .get();
    }
}
