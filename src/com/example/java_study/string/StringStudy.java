
package com.example.java_study.string;

public class StringStudy {
    //up to java 8, string impl. used char[]
    //since Java9 byte[] is used to store characters and an encoding field is used.
    //If all characters are ISO-8859-1/Latin-1, they use one byte per character



    void stringPoolMethod()  {
        //String pooling
        String str1 = "myStr";
        String str2 = "myStr";

        System.out.println(str1 == str2); // true

        //not pooled
        String str3 = new String("ali");
        String str4 = new String("ali");

        System.out.println(str3 == str4);  //false
        System.out.println(str3.equals(str4));  //true
    }

    void stringAPI()  {
        String str = "abcdefghijklm";

        System.out.println(str.charAt(3));  // d
        str.indexOf('f');  // 5
        str.indexOf("cd");  // 2
        str.indexOf("cvf");  // -1

        str.substring(3); //  defghijklm
        str.substring(2,5); //cde    index 5 is exclusive

        str.length();  // 13


        String str2 = "    vbg  sdff   ";
        str2.trim(); //vbg  sdff        leading and trailing spaces are removed.

        //values returned by string methods are creaetd by "new" operator. So They are not pooled
    }

    void stringConcat()  {
        String eJava = "eJava";
        String guru = "Guru";
        String concatStr = eJava + guru;
        String eJavaGuru = "eJavaGuru";
        //Strings computed by concatenation at runtime are newly created and distinct.
        //String values created from concat. of constant exp. are computed at runtime and are treated as if they were literals
        //if eJava and guru were FINAL, then below expression would be true
        System.out.println(concatStr == eJavaGuru);  //false.


        // + and += operations are evaluted from left to right
        int num = 10;
        int val = 12;
        String aString = "str";

        System.out.println(num + val + aString);  //prints 22str
        System.out.println("" + num + val + aString);  //prints 1012str

    }

    void stringBuilder()  {
        //StringBuilder stores a MUTABLE sequence of characters
        //String builder is very efficient when user needs to modify a sequence of characters
        //similar to String class, uses the concept of CompactStrings

        StringBuilder sb = new StringBuilder(); //init. capacity 16
        sb = new StringBuilder(56);
        sb = new StringBuilder("myStr");   //underlying byte[] is created with bigger capacity

        //charAt, indexOf, substring and length methods are same as in String class

        sb.append("dfsddf");  //  myStrdfsddf
        sb.append("wsdfred", 2, 4);  // myStrdfsddfdf

        sb.insert(2, "ddf"); // myddfStrdfsddfdf

        sb.delete(3, 6); //  mydtrdfsddfdf

        //no trim method

        sb.replace(4,7,"nnn");  //  mydtnnnsddfdf

        sb.replace(4,7,"nnnnnn");  //  mydtnnnnnnsddfdf


        sb.subSequence(3, 5);  //similar to substring method, returns a CharSequence     "tn"
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(); //init. capacity 16

        sb = new StringBuilder("myStr");   //underlying byte[] is created with bigger capacity

        sb.append("dfsddf");  //  myStrdfsddf
        sb.append("wsdfred", 2, 4);  // myStrdfsddfdf

        sb.insert(2, "ddf"); // myddfStrdfsddfdf

        sb.delete(3, 6); //  mydtrdfsddfdf

        //no trim method



        sb.replace(4,7,"nnnnnn");  //  mydtnnnnnnsddfdf



        System.out.println(sb.toString());
    }


}
