package mod09.binarySearch.ex05;

public class FirstBadVersion {
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
                //This tells us that mid may or may not be the first bad version,
                // but we can tell for sure that all versions after mid can be discarded.
                // Therefore, we set right=mid as the new search space of interval [left,mid](inclusive).
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
