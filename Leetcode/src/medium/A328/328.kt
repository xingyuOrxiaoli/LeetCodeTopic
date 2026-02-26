package medium.A328

import utils.ListNode

fun oddEvenList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    var odd = head
    var even = head.next
    val evenHead = even

    while (true) {
        if (even?.next == null) {
            break
        }
        odd?.next = even.next
        odd = odd?.next

        if (odd?.next == null) {
            break
        }
        even.next = odd.next
        even = even.next
    }

    odd?.next = evenHead
    even.next = null
    return head
}