public class MatrixSum{
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] rowSums = new int[rows]; 
        int totalSum = 0;
        Thread[] threads = new Thread[rows];

        for (int i = 0; i < rows; i++){
            final int rowIdx = i;
            threads[i] = new Thread(() -> {
                int rowSum = 0;
                for (int j = 0; j < cols; j++){
                    rowSum += matrix[rowIdx][j];
                }
                synchronized (rowSums){
                    rowSums[rowIdx] = rowSum;
                }
                System.out.println("Thread " + Thread.currentThread().getId() + ", Somma della riga " + rowIdx + ": " + rowSum);
            });
            threads[i].start();
        }

        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        for (int sum : rowSums){
            totalSum += sum;
        }

        System.out.println("Risultato finale - Somma di tutti gli elementi della matrice: " + totalSum);
    }
}
