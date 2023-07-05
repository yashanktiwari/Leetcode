class Solution {
    public int minimizeXor(int num1, int num2) {
        return XOR(num1, num2);
    }

    public int XOR(int nums1, int num2)
    {
        int count = setBit(num2);
        int ans = 0;
        for (int i = 31; i >= 0 && count > 0; i--)
        {
            if( (nums1 & ( 1 << i ) ) != 0)
            {
                ans += ( 1 << i );
                count--;
            }
        }

        for (int i = 0; i <= 31 && count > 0; i++)
        {
            if( (nums1 & ( 1 << i ) ) == 0)
            {
                ans += ( 1 << i );
                count--;
            }
        }
        return ans;
    }

    public int setBit(int num2)
    {
        int count = 0;
        while(num2 > 0)
        {
            num2 = ( num2 & (num2 - 1));
            count++;
        }
        return count;
    }
}