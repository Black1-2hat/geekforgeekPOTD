class Solution{
    public:
    bool is_possible_to_get_seats(int n, int m, vector<int>& seats){
        // Write your code here.
        if(n==0)return true;
        int cnt=0;
        for(int i=0;i<m;i++){
            bool left=(i==0 || seats[i-1]==0),right=(i==m-1 || seats[i+1]==0);
            if(left && right && seats[i]!=1){
                ++cnt;
                seats[i++]=1;
            }
        }
        return cnt>=n;
    }
};
