public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        return (bigCount >= 0) && (smallCount >= 0) && (goal >= 0)
                && (((bigCount * 5) + smallCount) >= goal) && (smallCount >= (goal % 5)
                || ((bigCount * 5) % goal == 0));

//        Did not think a loop was necessary as we only need to state true or false. if we had to fine out the amount left over or
//        how many of each it took. Then a loop would be suffice.

//        if(bigCount<0 || smallCount<0 || goal<0)
//            return false;
//        if((bigCount*5) + smallCount<goal)
//            return false;
//        return (smallCount>=goal%5);
//        Another way someone did
//    }
    }
}
