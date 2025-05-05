// public class test {

//     public static void main(String[] args) {
//        String string="java";
//         System.out.println(string);

//         String str1=new String("c++");
//         System.out.println(str1);

//         char[] ch={'a','b','c','d'};
//         System.out.println(ch);
        

//     }
// }

//-------------------------------------------------------------------------

// public class test {

//     public static void main(String[] args) {
//        String string="java";
//        String string1="java";

//        System.out.println(string==string1);

//        String str1=new String("c++");
//        String str2=new String("c++");



//         System.out.println(str1.equals(str2));
//         // System.out.println(str1);

//         // char[] ch={'a','b','c','d'};
//         // System.out.println(ch);
        

//     }
// }


//=------------------------------------------------------------

public class test{
    public static void main(String[] args) {
        String str = " Hello World ";

        // 1. charAt(int index)
        System.out.println("1. charAt(2): " + str.charAt(2)); // 'H'

        // 2. length()
        System.out.println("2. length(): " + str.length()); // 15

        // 3. toLowerCase()
        System.out.println("3. toLowerCase(): " + str.toLowerCase()); // " hello world "

        // 4. toUpperCase()
        System.out.println("4. toUpperCase(): " + str.toUpperCase()); // " HELLO WORLD "

        // 5. equals()
        System.out.println("5. equals(\" Hello World \"): " + str.equals(" Hello World ")); // true

        // 6. equalsIgnoreCase()
        System.out.println("6. equalsIgnoreCase(\" hello world \"): " + str.equalsIgnoreCase(" hello worlD ")); // true

        // 7. substring(int beginIndex)
        System.out.println("7. substring(2): " + str.substring(2)); // "Hello World "

        // 8. substring(int beginIndex, int endIndex)
        System.out.println("8. substring(2, 7): " + str.substring(2, 7)); // "Hello"

        // 9. contains(CharSequence s)
        System.out.println("9. contains(\"World\"): " + str.contains("World")); // true

        // 10. replace(char oldChar, char newChar)
        System.out.println("10. replace('l', 'x'): " + str.replace('l', 'x')); // " Hexxo Worxd "

        // 11. trim()
        System.out.println("11. trim(): " + str.trim()); // "Hello World"
    }
}