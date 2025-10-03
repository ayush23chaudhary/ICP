class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> l1= new ArrayList<>();
        comb(ans,l1,k,n,1);
        return ans;

    }
    static void comb(List<List<Integer>> ans,List<Integer> l1,int k,int n,int idx){
        if(l1.size()==k){
            ans.add(new ArrayList<>(l1));
            return;
        }
        for(int i=idx;i<n+1;i++){
            l1.add(i);
            comb(ans,l1,k,n,++idx);
            l1.remove(l1.size()-1);
        }

    }
}
