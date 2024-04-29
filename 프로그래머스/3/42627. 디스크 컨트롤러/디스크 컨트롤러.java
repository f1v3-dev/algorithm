import java.util.PriorityQueue;

class Process {
    private int requestTime;
    private int proceedTime;

    public Process(int requestTime, int proceedTime) {
        this.requestTime = requestTime;
        this.proceedTime = proceedTime;
    }

    public int getRequestTime() {
        return requestTime;
    }

    public int getProceedTime() {
        return proceedTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {


        PriorityQueue<Process> requestQueue = new PriorityQueue<>((p1, p2) -> p1.getRequestTime() - p2.getRequestTime());
        PriorityQueue<Process> proceedQueue = new PriorityQueue<>((p1, p2) -> p1.getProceedTime() - p2.getProceedTime());


        for (int[] job : jobs) {
            Process process = new Process(job[0], job[1]);
            requestQueue.offer(process);
        }

        int time = 0;
        int answer = 0;

        while (!requestQueue.isEmpty() || !proceedQueue.isEmpty()) {

            while (!requestQueue.isEmpty() && requestQueue.peek().getRequestTime() <= time) {
                proceedQueue.offer(requestQueue.poll());
            }

            if (proceedQueue.isEmpty()) {
                time = requestQueue.peek().getRequestTime();
            } else {
                Process process = proceedQueue.poll();
                time += process.getProceedTime();
                answer = answer + time - process.getRequestTime();
            }
        }

        return answer /= jobs.length;
    }
}