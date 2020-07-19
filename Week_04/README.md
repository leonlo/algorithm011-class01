## 二分查找模板

```java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }
        return -1;
    }
}
```