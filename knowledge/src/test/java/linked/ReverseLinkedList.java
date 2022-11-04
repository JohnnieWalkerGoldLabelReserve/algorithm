package linked;


public class ReverseLinkedList {

    class ListNode {

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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        for (ListNode cur = head; cur != null; ) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListParatation(ListNode head, int l, int r) {
        if (head == null || head.next == null || l == r) {
            return head;
        }
        ListNode pre = null;
        ListNode start = null;
        ListNode firstNode = null;
        int ans = 1;
        for (ListNode cur = head; cur != null; ) {
            if ((ans + 1) == l) {
                start = cur;
            }

            if (ans == l) {
                ListNode next = cur.next;
                cur.next = null;
                firstNode = cur;
                pre = cur;
                cur = next;
                ans++;
                continue;
            }

            if (ans == r) {
                ListNode next = cur.next;
                if (null != start) {
                    start.next = cur;
                }
                if (null != firstNode) {
                    firstNode.next = next;
                }
                cur.next = pre;
                break;
            }

            if (ans < l) {
                pre =cur;
                cur = cur.next;
            } else {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ans++;
        }
        return head;
    }

}
