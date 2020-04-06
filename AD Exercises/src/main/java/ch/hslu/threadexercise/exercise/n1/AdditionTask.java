package ch.hslu.threadexercise.exercise.n1;

public class AdditionTask implements Runnable{
    private final int rangeEnd;
    private final int rangeBegin;
    private volatile Thread runThread;
    private volatile boolean isStopped = false;


    public AdditionTask(int rangeBegin, int rangeEnd){
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    public void stopRequest() {
        isStopped = true;
        if (runThread != null) {
            runThread.interrupt();
        }
    }

    public boolean isStopped() {
        return isStopped;
    }


    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        // Initialisierungsphase
        int i = this.rangeBegin;
        long sum = 0;
        try {
            // Arbeitsphase
            while (this.runThread.isInterrupted() == false && i <= this.rangeEnd && isStopped() == false) {
                sum += i;
                i++;
            }
        }
        //catch(InterruptedException ex){        }
        finally {
            // Aufräumphase
            if (!isStopped()) {
                System.out.println(runThread.getName() + ": SUM" + i + " -> " + sum);
            } else {
                System.out.println(runThread.getName() + ": interrupted.");
            }
        }
    }
}
