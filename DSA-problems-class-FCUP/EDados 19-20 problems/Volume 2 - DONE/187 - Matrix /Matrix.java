import java.util.Scanner;
class Matrix {
   int data[][]; // matrix elements
   int rows;     // number of lines
   int cols;     // number of colums

   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }
   public static Matrix identity(int n){
      Matrix m = new Matrix(n,n);
      for(int i=0;i<n;i++)
         m.data[i][i]=1;
      return m;
   }
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }
   public Matrix transpose(){
      Matrix m = new Matrix(cols, rows);
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            m.data[j][i]= data[i][j];
      return m;
      
   }
   public Matrix sum(Matrix m){
      if(m.cols != cols || m.rows != rows){
         throw new RuntimeException("Matrices don't have the same size.");
      }
      Matrix mx = new Matrix(rows, cols);
      for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
            mx.data[i][j] = m.data[i][j]+data[i][j];
         }
      }
      return mx;
   }
   public Matrix multiply(Matrix m){
      if(cols != m.rows){
         throw new RuntimeException("Multiplication is not valid due to size of matrices.");
      }
      Matrix mx = new Matrix(rows, m.cols);
      int a = rows;
      int b = m.cols;
      int n = cols;
      for(int i=0;i<a;i++){
         for(int j=0;j<b;j++){
            int val= 0;
            for(int k=0;k<n;k++){
               val += data[i][k]*m.data[k][j];
            }
            mx.data[i][j] = val;
         }
      }
      return mx;
   }
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }
}