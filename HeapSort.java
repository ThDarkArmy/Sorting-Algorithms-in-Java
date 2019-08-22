import java.util.*;
import java.io.*;

class HeapSort{
    private static void heapify(int ar[],int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<n && ar[largest] < ar[left])
            largest = left;
        if(right < n && ar[largest] < ar[right])
            largest = right;

        if(largest!=i){
            //swapping ar[i] and ar[largest]
            // ar[largest] = ar[largest]^ar[i];
            // ar[i] = ar[largest]^ar[i];
            // ar[largest] = ar[largest]^ar[i];
            int temp = ar[i];
            ar[i] = ar[largest];
            ar[largest] = temp;

            heapify(ar,n,largest);
        }
    }

    private static void heapSort(int ar[], int n){
        for(int i=n/2-1;i>=0;i--)
            heapify(ar, n, i);

        for(int i=n-1;i>=0;i--){
            //swapping ar[i] and ar[0]
            // ar[i] = ar[i]^ar[0];
            // ar[0] = ar[i]^ar[0];
            // ar[i] = ar[i]^ar[0];
            int temp = ar[i];
            ar[i] = ar[0];
            ar[0] = temp;

            heapify(ar, i, 0);
        }
    }

        public static void main(String[] args){
            DarkReader dr = new DarkReader();
            PrintStream ps = new PrintStream(System.out);
            ps.print("Enter the number of Elements of the array: ");
            int n = dr.nextInt();
            int ar[] = new int[n];
            ps.print("Enter the elements of the array: ");
            for(int i=0;i<n;i++)
                ar[i] = dr.nextInt();

            heapSort(ar, n);

            ps.print("Sorted Array: ");
            for(int i=0;i<n;i++)
                ps.print(ar[i]+" ");
            ps.println();

    }


    static class DarkReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public DarkReader(){ 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
        String next(){ 
            while (st == null || !st.hasMoreElements()) { 
                try{ 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        }  
        int nextInt(){ 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong(){ 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble(){ 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ 
                str = br.readLine(); 
            } 
            catch (IOException e){ 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

}