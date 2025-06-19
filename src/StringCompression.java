public class StringCompression {

    public static  int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        String s = "";
        int count = 1;
        char prev = chars[0];
        int i = 1;

        while (i < chars.length) {
            if (chars[i] != prev) {
                s += prev;
                if (count > 1) {
                    s += count;
                }

                count = 1;
                prev = chars[i];

            } else {
                count++;

            }
            i++;
        }
        s += prev;
        if (count > 1) {
            s += count;
        }





        for( i = 0 ; i < s.length();i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }


    public static  void main(String[] args){
        System.out.println(compress(new char[]{'a','b','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b','b'}));

        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
