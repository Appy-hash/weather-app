public class Anagram {

    public static boolean isAnagram(String s, String t) {
        int anagramArray[] = new int[26];

        for(char c : s.toCharArray()){
            int charIndex = (int)c - 97;
            anagramArray[charIndex]++;
        }
        for(char c : t.toCharArray()){
            int charIndex = (int)c - 97;
            anagramArray[charIndex]--;
        }

        for(int charIndex: anagramArray){
            if(charIndex != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String ... args){
        System.out.println(isAnagram("a", "ab"));
    }
}
