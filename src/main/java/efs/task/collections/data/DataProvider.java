package efs.task.collections.data;

import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.*;
import java.util.stream.Collectors;

public class DataProvider {

    public static final String DATA_SEPARATOR = ",";

    // TODO Utwórz listę miast na podstawie tablicy Data.baseTownsArray.
    //  Tablica zawiera String zawierający nazwę miasta oraz dwie klasy bohatera związane z tym miastem oddzielone przecinkami.
    //  Korzystając z funkcji split() oraz stałej DATA_SEPARATOR utwórz listę obiektów klasy efs.task.collections.entities.Town.
    //  Funkcja zwraca listę obiektów typu Town ze wszystkimi dziewięcioma podstawowymi miastami.
    public List<Town> getTownsList() {
        List<Town> townList = new ArrayList<>();
        for(String line: Data.baseTownsArray ) {
            String text[] = line.split(DATA_SEPARATOR);
            townList.add(new Town(text[0], Arrays.stream(text).skip(1).collect(Collectors.toList())));
        }
        return townList;
    }

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        List<Town> townList = new ArrayList<>();
        for(String line: Data.dlcTownsArray ) {
            String text[] = line.split(DATA_SEPARATOR);
            townList.add(new Town(text[0], Arrays.stream(text).skip(1).collect(Collectors.toList())));
        }

        return townList;
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno
    // imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
        Set<Hero> heroSet = new HashSet<>();
        for(String line : Data.baseCharactersArray) {
            String text[] = line.split(DATA_SEPARATOR);
            heroSet.add(new Hero(text[0].trim(), text[1].trim()));
        }
        return heroSet;
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        Set<Hero> heroSet = new HashSet<>();
        for(String line: Data.dlcCharactersArray) {
            String text[] = line.split(DATA_SEPARATOR);
            heroSet.add(new Hero(text[0].trim(), text[1].trim()));
        }
        return heroSet;
    }
}
