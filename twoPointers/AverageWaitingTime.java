class AverageWaitingTime {

  public static void main(String[] args) {
    AverageWaitingTime sol = new AverageWaitingTime();
    int[][] val = new int[][] {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
    System.out.println(sol.averageWaitingTime(val));
  }

  public double averageWaitingTime(int[][] customers) {
    int currentTime = 0;
    int totalWaitingTime = 0;
    for (int i = 0; i < customers.length; i++) {
      currentTime = customers[i][0] + currentTime;
      totalWaitingTime = currentTime - customers[i][0];
    }
    double average = totalWaitingTime / customers.length;
    return average;
  }
}
