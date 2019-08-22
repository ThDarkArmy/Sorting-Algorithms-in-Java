import java.util.*;
import java.io.*;

class QuickSort{
    private static int partition(int ar[], int l, int r){
        int pivot = ar[r];
        int i=l-1;
        for(int j=l;j<r;j++){
            

            if(ar[j]<=pivot){
                i++;
                int temp = ar[i];
                ar[i]=ar[j];
                ar[j]=temp;
            }
        }
        int temp = ar[r];
        ar[r] = ar[i+1];
        ar[i+1] = temp;
        return i+1;
    }

    private static void quickSort(int ar[], int l, int r){
        if(l<r){
            int p = partition(ar, l, r);
            quickSort(ar, l,p-1);
            quickSort(ar, p+1, r);
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

            quickSort(ar, 0, n-1);

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