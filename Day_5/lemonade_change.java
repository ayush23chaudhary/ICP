class Solution {
    public boolean lemonadeChange(int[] bills) {
//  maintaining two variable for 5 and teo rupees change and i any of them at any time goes less than zero returning false and else true
      
        int countfive = 0, countten = 0;
        for(int i = 0; i < bills.length; ++i){
            if(bills[i] == 5){
                countfive += 1;
            } else if(bills[i] == 10){
                if(countfive == 0) return false;
                countfive -= 1;
                countten += 1;
            } else {
                if(!(countfive > 2) && !(countfive > 0 && countten > 0)){
                     return false;
                }

                if(countfive > 0 && countten > 0){
                    countfive -= 1;
                    countten -= 1;
                } else{
                    countfive -= 3;
                }
            }
        }
        return true;
    }
}
