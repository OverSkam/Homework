package Homeworks.homework7;

import Homeworks.happyFamily2.Family;
import Homeworks.happyFamily2.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    @Test
    void addChild() {
        Homeworks.happyFamily2.Human human1 = new Homeworks.happyFamily2.Human("1", "1", 1, 1);
        Homeworks.happyFamily2.Human human2 = new Homeworks.happyFamily2.Human("2", "2", 2, 2);
        Homeworks.happyFamily2.Human child1 = new Homeworks.happyFamily2.Human("3", "3", 3, 3);
        Homeworks.happyFamily2.Family family = new Homeworks.happyFamily2.Family(human1, human2);
        family.addChild(child1);
        Homeworks.happyFamily2.Human result = family.getChild(0);
        assertEquals(child1, result);
        assertEquals(3, family.countFamily());
    }

    @Test
    void removeChild() {
        Homeworks.happyFamily2.Human human1 = new Homeworks.happyFamily2.Human("1", "1", 1, 1);
        Homeworks.happyFamily2.Human human2 = new Homeworks.happyFamily2.Human("2", "2", 2, 2);
        Homeworks.happyFamily2.Human child1 = new Homeworks.happyFamily2.Human("3", "3", 3, 3);
        Homeworks.happyFamily2.Family family = new Homeworks.happyFamily2.Family(human1, human2);
        family.addChild(child1);
        family.removeChild(human1);
        assertEquals(1, family.getChildren().length);
        family.removeChild(child1);
        assertEquals(0, family.getChildren().length);
        family.addChild(child1);
        family.removeChild(2);
        assertEquals(1, family.getChildren().length);
        family.removeChild(0);
        assertEquals(0, family.getChildren().length);
    }

    @Test
    void countFamily() {
        Homeworks.happyFamily2.Human human1 = new Homeworks.happyFamily2.Human("1", "1", 1, 1);
        Homeworks.happyFamily2.Human human2 = new Homeworks.happyFamily2.Human("2", "2", 2, 2);
        Homeworks.happyFamily2.Human child1 = new Homeworks.happyFamily2.Human("3", "3", 3, 3);
        Homeworks.happyFamily2.Family family = new Homeworks.happyFamily2.Family(human1, human2);
        family.addChild(child1);
        assertEquals(3, family.countFamily());
    }

    @Test
    void testToString() {
        Homeworks.happyFamily2.Human human1 = new Homeworks.happyFamily2.Human("1", "1", 1, 1);
        Homeworks.happyFamily2.Human human2 = new Homeworks.happyFamily2.Human("2", "2", 2, 2);
        Homeworks.happyFamily2.Human child1 = new Human("3", "3", 3, 3);
        Homeworks.happyFamily2.Family family = new Family(human1, human2);
        family.addChild(child1);
        assertEquals("Family: mother: '1 1', father: '2 2', children: '3'", family.toString());
    }
}