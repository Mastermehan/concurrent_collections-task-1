public class Main {
    private static final int WORK_TIME = 20000;
    public static void main(String[] args) {

        CallCenter callCenter = new CallCenter();
        ThreadGroup flowSpecialists = new ThreadGroup("Оператор");
        Thread telephoneSwitch = new TelephoneSwitch("АТС", callCenter);

        telephoneSwitch.start();
        for(int i = 1; i < 4; i++) {
            new Thread(flowSpecialists,new TelephoneOperator(flowSpecialists, ""+i, callCenter)).start();
        }

        try {
            Thread.sleep(WORK_TIME);
            flowSpecialists.interrupt();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
