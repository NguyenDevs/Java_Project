//Tạo một Thread trong một khoảng thời gian nào đó sinh ra một số ngẫu nhiên <10

import java.util.Random;

public class main extends Thread {

    public void run() {
        try {
            // Ngủ trong khoảng thời gian từ 1 đến 5 giây
            int sleepTime = new Random().nextInt(5000) + 1000;
            Thread.sleep(sleepTime);

            // Sinh số ngẫu nhiên nhỏ hơn 10
            int randomNumber = new Random().nextInt(10);

            System.out.println("Số ngẫu nhiên nhỏ hơn 10: " + randomNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Tạo và bắt đầu luồng mới
    	main randomNumberThread = new main();
        randomNumberThread.start();
    }
}
