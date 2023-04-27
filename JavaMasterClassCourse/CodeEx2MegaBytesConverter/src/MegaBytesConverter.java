public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int megaBytes = kiloBytes / 1024;
        int remainingKiloBytes = kiloBytes % 1024;

        System.out.println(kiloBytes < 0 ? "Invalid Value" : kiloBytes + " KB = " + megaBytes + " MB and " +
                remainingKiloBytes + " KB");

//        OR

//        System.out.println(kiloBytes < 0 ? "Invalid Value" : kiloBytes + " KB = " + (kiloBytes / 1024) + " MB and " +
//                (kiloBytes % 1024) + " KB");
    }
}
