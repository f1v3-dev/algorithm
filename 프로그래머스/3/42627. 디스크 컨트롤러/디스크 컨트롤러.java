import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    private static class Job {
        int requestTime;
        int processTime;

        public Job(int requestTime, int processTime) {
            this.requestTime = requestTime;
            this.processTime = processTime;
        }

    }

    public int solution(int[][] jobs) {


        Queue<Job> waitingQueue = new PriorityQueue<>(Comparator.comparingInt(j -> j.requestTime));
        Queue<Job> readyQueue = new PriorityQueue<>(Comparator.comparingInt(j -> j.processTime));

        for (int[] job : jobs) {
            waitingQueue.offer(new Job(job[0], job[1]));
        }

        int currentTime = 0;
        int totalTime = 0;

        while (!waitingQueue.isEmpty() || !readyQueue.isEmpty()) {

            while (!waitingQueue.isEmpty() && waitingQueue.peek().requestTime <= currentTime) {
                readyQueue.offer(waitingQueue.poll());
            }

            if (readyQueue.isEmpty()) {
                currentTime = waitingQueue.peek().requestTime;
            } else {
                Job job = readyQueue.poll();
                currentTime += job.processTime;
                totalTime += currentTime - job.requestTime;
            }
        }


        return totalTime / jobs.length;
    }
}
