package linked;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;

public class DummpHeadLinkedListTest extends TestCase {

    @Test
    public void testDummpHeadLinkedList() {
        DummpHeadLinkedList<Integer> dummpHeadLinkedList = new DummpHeadLinkedList<>();
        for (int i = 0; i < 6; i++) {
            dummpHeadLinkedList.addFrist(i);
        }
        System.err.println(dummpHeadLinkedList);
        dummpHeadLinkedList.add(6,7);
        System.err.println(dummpHeadLinkedList);
        dummpHeadLinkedList.removeFrist();
        System.err.println(dummpHeadLinkedList);
        dummpHeadLinkedList.remove(5);
        System.err.println(dummpHeadLinkedList);
    }

}