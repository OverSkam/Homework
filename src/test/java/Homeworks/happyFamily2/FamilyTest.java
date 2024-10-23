package Homeworks.happyFamily2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @Test
    void addChild() {
        Human human1 = new Human("1", "1", 1, 1);
        Human human2 = new Human("2", "2", 2, 2);
        Human child1 = new Human("3", "3", 3, 3);
        Family family = new Family(human1, human2);
        family.addChild(child1);
        Human result = family.getChild(0);
        assertEquals(child1, result);
        assertEquals(3, family.countFamily());
    }

    @Test
    void removeChild() {
        Human human1 = new Human("1", "1", 1, 1);
        Human human2 = new Human("2", "2", 2, 2);
        Human child1 = new Human("3", "3", 3, 3);
        Family family = new Family(human1, human2);
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
        Human human1 = new Human("1", "1", 1, 1);
        Human human2 = new Human("2", "2", 2, 2);
        Human child1 = new Human("3", "3", 3, 3);
        Family family = new Family(human1, human2);
        family.addChild(child1);
        assertEquals(3, family.countFamily());
    }

    @Test
    void testToString() {
        Human human1 = new Human("1", "1", 1, 1);
        Human human2 = new Human("2", "2", 2, 2);
        Human child1 = new Human("3", "3", 3, 3);
        Family family = new Family(human1, human2);
        family.addChild(child1);
        assertEquals("Family: mother: '1 1', father: '2 2', children: '3'", family.toString());
    }
}