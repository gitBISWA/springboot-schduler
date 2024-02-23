/*package service;

import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    public synchronized void startAndWait() {
        System.out.println("Starting Process...");
        // Start the process
        Thread processThread = new Thread(() -> {
            try {
                // Simulate process execution
              //  Thread.sleep(2 * 60 * 60 * 1000); // Sleep for 2.5 hours
            	 Thread.sleep(2 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Process completed.");
        });
        processThread.start();
        
        try {
            // Wait for the process to finish
            processThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}*/

package service;

import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private Thread processThread;

    public synchronized void startAndWait() {
        System.out.println("Starting Process...");
        // Start the process
        processThread = new Thread(() -> {
            try {
                // Simulate process execution
                Thread.sleep(2 * 60 * 1000); // Sleep for 2 minutes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Process completed.");
        });
        processThread.start();
        
        try {
            // Wait for the process to finish
            processThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void restart() {
        if (processThread != null) {
            // Interrupt the current process thread
            processThread.interrupt();
            // Start a new process thread
            startAndWait();
        } else {
            System.out.println("No process is currently running.");
        }
    }
}





















