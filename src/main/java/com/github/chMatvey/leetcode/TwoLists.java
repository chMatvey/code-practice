package com.github.chMatvey.leetcode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class TwoLists {
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {this.val = val;}
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode();
        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if (list2.val < list1.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }

        return head.next;
    }

    public static int[] mergeTwoArrays(int[] a, int[] b) {
//        Stream.of(Arrays.stream(a), Arrays.stream(b))
//                .flatMap(IntStream::boxed)
//                .sorted()
//                .toArray();
        int[] result = new int[a.length + b.length];
        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < result.length; i++) {
            if (firstIndex != a.length && (secondIndex == b.length || a[firstIndex] < b[secondIndex])) {
                result[i] = a[firstIndex];
                firstIndex++;
            } else {
                result[i] = b[secondIndex];
                secondIndex++;
            }
        }

        return result;
    }
}
