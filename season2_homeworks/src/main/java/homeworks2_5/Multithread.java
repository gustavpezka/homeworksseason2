package homeworks2_5;

public class Multithread{
    public static void main(String[] args) {
        firstMethod();
        //secondMethod();
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        float[] leftArr = new float[size/2];
        float[] rightArr = new float[size/2];
        System.arraycopy(arr,0,leftArr,0,5_000_000);
        System.arraycopy(arr,5_000_000,rightArr,0,5_000_000);

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < leftArr.length; i++) {
                leftArr[i] = (float) (leftArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < leftArr.length; i++) {
                leftArr[i] = (float) (leftArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        float[] mergedArr = new float[size];
        System.arraycopy(leftArr,0,mergedArr,0,5_000_000);
        System.arraycopy(rightArr,0,mergedArr,5_000_000,5_000_000);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}




