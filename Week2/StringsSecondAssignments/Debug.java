
/**
 * Write a description of Debug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Debug {
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        System.out.println("input.length "+input.length());
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                break;
            }
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+4);
            System.out.println("index "+ index);
        }
    }

    public void test() {
        //no code yet
        findAbc("abcdabc");
    }
}
