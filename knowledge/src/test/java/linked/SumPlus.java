package linked;

public class SumPlus {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode header = null;
        int sum = 0;
        while (l1 != null && l2 != null) {
            if (res == null) {
                res = new ListNode();
                header = res;
            } else {
                res.next = new ListNode();
                res = res.next;
            }

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            System.err.println(sum);
            res.val = sum % 10;
            sum = sum / 10;
        }
        if (sum != 0)
            res.next = new ListNode(sum);
        return header;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);

    }

}
