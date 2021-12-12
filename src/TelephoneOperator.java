public class TelephoneOperator extends Thread {
    private static final int WORK_TIME_WITH_ONE_CALL = 3000;
    private final CallCenter callCenter;

    public TelephoneOperator(ThreadGroup flowSpecialists, String name, CallCenter callCenter) {
        super(flowSpecialists, name);
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        while (true)
            try {
                Call call;
                call = callCenter.get();
                if (null != call) {
                    System.out.println(Thread.currentThread().getName() + " беру в работу звонок!");
                    Thread.sleep(WORK_TIME_WITH_ONE_CALL);
                }
            } catch (InterruptedException ex) {
                System.out.println(" Работа АТС завершена: " + Thread.currentThread().getName()
                        + " закончил рабочий день!");
                return;
            }
    }
}
