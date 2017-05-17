package collections.sort;

/**
 * author: cshuo
 * date: 2017/4/16
 * version: 1.0
 * description:  最大堆，进行升序排序
 */
public class Heap extends Sort{
    public static void main(String[] args) {
        int []a = {1,3,4,2,7,5,-1,2,2,0};
        heapSort(a);
        printList(a);
    }

    public static void fixUpDown(int[] a, int start, int end){
        int c = start;
        int l = c*2 + 1;
        int tmp = a[c];
        for(; l<=end; c=l, l=c*2+1){
            if(l<end && a[l] < a[l+1]) l++;           //找出左右孩子最大者
            if(tmp >= a[l]) break;                    //父节点比最大子节点还要大
            a[c] = a[l];
        }
        a[c] = tmp;
    }

    public static void heapSort(int a[]){
        int n = a.length;
        for(int i=n/2-1; i>=0; i--){
            UpDown(a, i, n-1);
        }
        for(int i=n-1; i>0; i--){
            swap(a, 0, i);
            UpDown(a, 0, i-1);
        }
    }

    /*
     * for ever-practicing.
     */
    public static void UpDown(int[] a, int start, int end){
    }
}
