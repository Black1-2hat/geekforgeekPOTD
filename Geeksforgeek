
class Solution {
    static int modulo = (int) 1e9 + 7;
    static int[] maskPrime = new int[31];
    
    public Solution() {
        modulo = (int) 1e9 + 7;
        maskPrime = new int[31];
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int i = 2; i <= 30; ++i) {
            if (i % 4 == 0 || i % 9 == 0 || i == 25) continue;
            int mask = 0;
            for (int j = 0; j < 10; ++j) {
                if (i % primeNumbers[j] == 0) mask |= 1 << j;
            }
            maskPrime[i] = mask;
        }
    }
    
    public static long powerOfTwo(int n) {
        long result = 1, value = 2;
        while (n != 0) {
            if ((n & 1) == 1) result = (result * value) % modulo;
            value = (value * value) % modulo;
            n >>= 1;
        }
        return result;
    }
    
    public static int goodSubsets(int[] arr, int n) {
        
        int[] array = arr;
        int size = n;
        
        int oneCount = 0;
        int[] dp = new int[1024];
        int[] count = new int[31];
        dp[0] = 1;
        for (int element : array) {
            if (element == 1) {
                oneCount++;
            } else if (maskPrime[element] != 0) {
                count[element]++;
            }
        }
        for (int i = 0; i < 31; ++i) {
            if (count[i] == 0) continue;
            for (int j = 0; j < 1024; ++j) {
                if ((j & maskPrime[i]) != 0) continue;
                dp[j | maskPrime[i]] = (int) ((dp[j | maskPrime[i]] + dp[j] * (long) count[i]) % modulo);
            }
        }
        long answer = 0;
        for (int i : dp) {
            answer = (answer + i) % modulo;
        }
        answer--;
        if (oneCount != 0) {
            answer = (answer * powerOfTwo(oneCount)) % modulo;
        }
        return (int) answer;
    }
};
