package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw4.Animal.Sex.*;
import static edu.hw4.Animal.Type.*;
import static edu.hw4.AnimalTasks.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTasksTest {
    private final Animal cat = new Animal("Leo", CAT, M, 4, 150, 10, true);
    private final Animal cat2 = new Animal("Simba", CAT, F, 5, 200, 12, true);
    private final Animal dog = new Animal("Bonya", DOG, F, 8, 450, 20, true);
    private final Animal fish = new Animal("Lun", FISH, M, 1, 110, 3, false);
    private final Animal bird = new Animal("Snegir", BIRD, M, 3, 50, 2, false);
    private final Animal spider = new Animal("Spider Man Lack", SPIDER, M, 20, 5, 1, true);
    private final List<Animal> animals = new ArrayList<>();{
        animals.add(cat);
        animals.add(cat2);
        animals.add(dog);
        animals.add(fish);
        animals.add(bird);
        animals.add(spider);
    }

    @Test
    @DisplayName("Отсортировать животных по росту от самого маленького к самому большому ")
    void sortByHeightFromShortToTallTest() {
        List<Animal> expected = List.of(spider, bird, fish, cat, cat2, dog);
        assertEquals(expected, sortByHeightFromShortToTall(animals));
    }

    @Test
    @DisplayName("Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых")
    void sortByWeightFromLightToHeavyTest() {
        List<Animal> expected = List.of(dog, cat2, cat);
        int k = 3;
        assertEquals(expected, sortByWeightFromLightToHeavy(animals, 3));
    }

    @Test
    @DisplayName("Количество животных каждого вида")
    void countOfAnimalsByTypeTest() {
        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(BIRD, 1);
        expected.put(DOG, 1);
        expected.put(FISH, 1);
        expected.put(CAT, 2);
        expected.put(SPIDER, 1);
        assertEquals(expected, countOfAnimalsByType(animals));
    }

    @Test
    @DisplayName("Cамое длинное имя")
    void animalLongestNameTest() {
        Animal expected = spider;
        assertEquals(expected, animalLongestName(animals));
    }

    @Test
    @DisplayName("Каких животных больше: самцов или самок")
    void moreMalesOrFemalesTest() {
        Animal.Sex expected = M;
        assertEquals(expected, moreMalesOrFemales(animals));
    }

    @Test
    @DisplayName("Самое тяжелое животное каждого вида")
    void getHeaviestAnimalsMapTest() {
        Map<Animal.Type, Animal> expected = new HashMap<>();
        expected.put(BIRD, bird);
        expected.put(DOG, dog);
        expected.put(FISH, fish);
        expected.put(CAT, cat2);
        expected.put(SPIDER, spider);
        assertEquals(expected, getHeaviestAnimalsMap(animals));
    }

    @Test
    @DisplayName("K-е самое старое животное -> Animal")
    void getOldestAnimalTest() {
        Animal expected = dog;
        assertEquals(expected, getOldestAnimal(animals, 2));
    }

    @Test
    @DisplayName("Самое тяжелое животное среди животных ниже k см")
    void getHeaviestAmongAnimalsBelowKHeightTest() {
        Optional<Animal> expected = Optional.of(spider);
        assertEquals(expected, getHeaviestAmongAnimalsBelowKHeight(animals, 12));
    }

    @Test
    @DisplayName("Сколько в сумме лап у животных в списке")
    void countPawsTest() {
        Integer expected = 22;
        assertEquals(expected, countPaws(animals));
    }

    @Test
    @DisplayName("Список животных, возраст у которых не совпадает с количеством лап")
    void ageNotEqualsAmountOfPawsTest() {
        List<Animal> expected = List.of(cat2, dog, fish, bird, spider);
        assertEquals(expected, ageNotEqualsAmountOfPaws(animals));
    }

    @Test
    @DisplayName("Список животных, которые могут укусить и рост которых превышает 100 см")
    void canBiteAndHigherThan100Test() {
        List<Animal> expected = List.of(cat, cat2, dog);
        assertEquals(expected, canBiteAndHigherThan100(animals));
    }

    @Test
    @DisplayName("Сколько в списке животных, вес которых превышает рост")
    void weightMoreThanHeightTest() {
        Integer expected = 0;
        assertEquals(expected, weightMoreThanHeight(animals));
    }

    @Test
    @DisplayName("Список животных, имена которых состоят из более чем двух слов ")
    void nameConsistOfMoreThanTwoWordsTest() {
        List<Animal> expected = List.of(spider);
        assertEquals(expected, nameConsistOfMoreThanTwoWords(animals));
    }

    @Test
    @DisplayName("Есть ли в списке собака ростом более k см")
    void isDogHeightMoreThanKTest() {
        Boolean expected = true;
        assertEquals(expected, isDogHeightMoreThanK(animals, 200));
    }

    @Test
    @DisplayName("Cуммарный вес животных каждого вида, которым от k до l лет")
    void sumWeightWithAgeMoreThatKAndLessThatLTest() {
        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(BIRD, 2);
        expected.put(DOG, 20);
        expected.put(FISH, 3);
        expected.put(CAT, 22);
        expected.put(SPIDER, 1);
        assertEquals(expected, sumWeightWithAgeMoreThatKAndLessThatL(animals, 1, 25));
    }

    @Test
    @DisplayName("Список животных, отсортированный по виду, затем по полу, затем по имени")
    void sortedByTypeSexNameTest() {
        List<Animal> expected = List.of(cat, cat2, dog, bird, fish, spider);
        assertEquals(expected, sortedByTypeSexName(animals));
    }

    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки")
    void isSpidersBitesMoreDogsTest() {
        Boolean expected = false;
        assertEquals(expected, isSpidersBitesMoreDogs(animals));
    }

    @Test
    @DisplayName("Cамая тяжелая рыбка в 2-х или более списках")
    void mostHeavyFishTest() {
        Animal dog2 = new Animal("Lika", DOG, F, 7, 400, 15, true);
        Animal fish2 = new Animal("Mike", FISH, M, 2, 100, 1, false);
        Animal bird2 = new Animal("Chick", BIRD, M, 5, 20, 1, false);
        List<Animal> animals2 = new ArrayList<>();
        {
            animals.add(dog2);
            animals.add(fish2);
            animals.add(bird2);
        }
        List<List<Animal>> animalsList = new ArrayList<>();
        {
            animalsList.add(animals);
            animalsList.add(animals2);
        }
        Animal expected = fish;
        assertEquals(expected, mostHeavyFish(animalsList));
    }

}
