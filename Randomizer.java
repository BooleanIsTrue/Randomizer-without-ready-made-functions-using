public class Randomizer {

    /*
     * produce a private variable of type int
     */
    private static int number;

    public static void main(String[] args) throws InterruptedException {

        /*
         * We declare the thread, the quantity does not matter,
         * in the lambda expression we go the for up to 10000-1000000
         * the variable is increment in the thread
         */

        Thread threadOne = new Thread(() ->{
            for (int i = 0; i < 10000 ; i++) {
                number++;
            }
        });
        Thread threadTwo = new Thread(() ->{
            for (int i = 0; i < 10000 ; i++) {
                number++;
            }
        });
        Thread threadThree = new Thread(() ->{
            for (int i = 0; i < 10000 ; i++) {
                number++;
            }
        });

        /*
         * based on this framework,
         * anti-synchronization is performed
         * and the connection between the cache memory and the main memory is broken.
         */
        threadOne.start();
        threadOne.join();
        threadTwo.start();
        threadThree.join();
        threadThree.start();
        threadThree.join();

        /*
          for more information, you can find out about race condition
         */

        System.out.println(getNumber(number));

    }
    private static int getNumber(int number){
        return number/100%12;
    }

}
