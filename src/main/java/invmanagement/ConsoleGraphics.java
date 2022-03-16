package invmanagement;

public class ConsoleGraphics {

    public static void printBannerLine() {
        System.out.println("----------------------");
    }
    public static String sOrNot(Integer number) {
        return (number != 1)?"s":"";
    }
    //literally just prints a bunch of newlines, can be adjusted based on need
    //the entire program's dirty secret
    public static void clearScreen() {
        clearScreen(50);
    }
    public static void clearScreen(int numOfLines) {
        for(int i = 0; i < numOfLines; i++) {
            System.out.print('\n');
        }
    }
}
