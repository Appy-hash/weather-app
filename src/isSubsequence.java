public class isSubsequence {



    public static  boolean isSubsequence(String s, String t) {
        if(s.equals("")){
            return false;
        }

        if(s.length() == t.length()){
            return s.equals(t);
        }

        if(s.length() > t.length())
            return false;

        return checkIfSubsequence(s.length()-1,t.length()-1,s,t);
    }

    public static boolean checkIfSubsequence(int subIndex,int index,String s,String t){


       if(index == -1){
           return false;
       }

        if(s.charAt(subIndex) == t.charAt(index)) {
            subIndex--;

            if(subIndex == -1){
                return true;
            }
        }
        index--;
        return checkIfSubsequence(subIndex,index,s,t);
    }

    public static  void main(String[] args){

        System.out.println(isSubsequence("bb","ahbgdc"));

        System.out.println(isSubsequence("b","c"));

        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("axc","ahbgdc"));
        System.out.println(isSubsequence("bxc","ahbgdc"));
        System.out.println(isSubsequence("eeee","ahbgdc"));


    }
}
