class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return Different_Ways(expression);
    }

    public List<Integer> Different_Ways(String str)
    {
        if(str.indexOf('+') == -1 && str.indexOf('-') == -1 && str.indexOf('*') == -1)
        {
            List<Integer> ls = new ArrayList<>();
            ls.add(Integer.parseInt(str));
            return ls;

        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(isOperator(ch))
            {
                List<Integer> left = Different_Ways(str.substring(0,i));
                List<Integer> right = Different_Ways(str.substring(i+1));
                for(int a : left)
                {
                    for(int b : right)
                    {
                        int val = Calculation(a,b,ch);
                        ans.add(val);
                    }
                }
            }
        }
        return ans;

    }

    public boolean isOperator(char ch)
    {
        if(ch == '+' || ch == '-' || ch == '*')
        {
            return true;
        }
        return false;
    }

    public int Calculation(int a,int b,char ch)
    {
        if(ch == '+')
        {
            return a+b;
        }
        else if(ch == '-')
        {
            return a-b;
        }
        else
        {
            return a*b;
        }
    }
}
    

    