import java.util.concurrent.Callable;

class MyThread implements Callable<Integer> {
    private  int countThread;
    public MyThread(int countThread){
        this.countThread=countThread;
    }

    @Override
    public Integer call() throws Exception {

                Thread.sleep(2500);
                System.out.println(Thread.currentThread().getName()+ " Всем привет!");


        return countThread++;
    }

    @Override
    public String toString() {
        return "MyThread{" +
                "countThread=" + countThread +
                '}';
    }
}