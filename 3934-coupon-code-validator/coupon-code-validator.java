class Solution {
    static class Coupon implements Comparable<Coupon>{
        String code;
        String business;
        boolean flag;
        Coupon(String code,String business,boolean flag){
            this.code=code;
            this.business=business;
            this.flag=flag;
        }
        public int compareTo(Coupon othr){
            if(this.business.equals(othr.business)) return this.code.compareTo(othr.code);
            return (this.business.compareTo(othr.business));
        }
    }
    public boolean isValidCombination(String code,String business,boolean flag,Set<String>ss){
        if(flag==false){
            return false;
        }
        if(ss.contains(business)==false){
            return false;
        }
        if(code.length()==0) return false;
        for(int i=0;i<code.length();i++){
            char cc=code.charAt(i);
            if(Character.isLetterOrDigit(cc) || cc=='_'){
                continue;
            }else{
                return false;
            }

        }
        return true;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon>res=new ArrayList<>();
        Set<String> ss=new HashSet<>();
        ss.add("electronics");
        ss.add("grocery");
        ss.add("pharmacy");
        ss.add("restaurant");
        for(int i=0;i<code.length;i++){
            if(isValidCombination(code[i],businessLine[i],isActive[i],ss)){
                res.add(new Coupon(code[i],businessLine[i],isActive[i]));
            }
        }
        Collections.sort(res);
        List<String>ans=new ArrayList<>();
        for(Coupon cp:res){
            ans.add(cp.code);
        }
        return ans;
    }
}