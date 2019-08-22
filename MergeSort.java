import java.util.*;
import java.io.*;

class MergeSort{

    private static void merge(int ar[], int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        int i=0,j=0,k=l;
        for(i=0;i<n1;i++)
            L[i] = ar[l+i];
        for(j=0;j<n2;j++)
            R[j] = ar[m+j+1];
        i=0;
        j=0;
        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                ar[k]=L[i];
                i++;
            }else{
                ar[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            ar[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            ar[k] = R[j];
            j++;
            k++;
        }

    }

    private static void mergeSort(int ar[],int l, int r){
        if(l<r){
            int m = l+(r-l)/2;
            mergeSort(ar, l, m);
            mergeSort(ar, m+1, r);
            merge(ar, l, m, r);
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

        mergeSort(ar, 0, n-1);

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