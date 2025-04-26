# Common DSA Patterns Cheat Sheet

## Sliding Window
Efficient for problems involving subarrays or substrings.
```java
int left = 0, right = 0;
while (right < arr.length) {
    // expand window
    right++;
    // shrink window if needed
    left++;
}
```

## Two Pointers
Used for searching pairs in sorted arrays.
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    // logic
    left++;
    right--;
}
```

## Fast & Slow Pointers
Detect cycles in linked lists.
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) break;
}
```

## Recursion
```java
void recurse(int n) {
    if (n == 0) return;
    recurse(n-1);
}
```

---
Add more patterns as you discover them!
