import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCenter {
    //выбрана эта коллекция ввиду ее быстрой неблокирующей работы. Я исходил из того, что потоки специалисты успевают
    // обрабатывать все звонки и поэтому просадок по памяти не ожидаю (хоть она и не работает с массивами).
    // Также коллекция обладает высокой эффективностью удаления из очереди
    private final Queue<Call> callQueue = new ConcurrentLinkedQueue<>();
   // private final Queue<Call> callQueue = new LinkedBlockingQueue<>();
    // как альтернативу можно выбрать LinkedBlockingQueue причне того, что она упорядочивает порядок поступления и выдачи элементов
    // (FIFO — «первым прибыл - первым убыл»). Новые элементы вставляются в хвост очереди. Таким образом соблюдается “честность” и правильный порядок.
    //При условии, что оператор будет в коллчестве один человек, будет справедлимыв если обрабатывать он будет строго по очеререди.
    //Плюс коллекция более гибкая.

    public void add(Call call) {
        callQueue.add(call);
    }

    public Call get() {
        return callQueue.poll();
    }
}
