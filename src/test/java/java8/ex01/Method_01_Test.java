package java8.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;


/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        // TODO créer une méthode int sumAge()
        int sumAge(List<Person> personList);
        // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        @Override
        public int sumAge(List<Person> personList) {
            return personList.stream().map(p -> p.getAge()).reduce(0, (a, p) -> a+=p);
        }
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }

        @Override
        public int sumAge(List<Person> personList) {
            return personList.stream().mapToInt(p -> p.getAge()).sum();
        }
    }

    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = 0;
        result = daoA.sumAge(daoA.findAll());
        assert result == 210;
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = 0;
        result = daoB.sumAge(daoB.findAll());
        assert result == 5050;

    }
}
