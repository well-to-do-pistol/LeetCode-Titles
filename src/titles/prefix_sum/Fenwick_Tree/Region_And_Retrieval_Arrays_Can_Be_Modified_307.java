package titles.prefix_sum.Fenwick_Tree;

public class Region_And_Retrieval_Arrays_Can_Be_Modified_307 {
}



class NumArray {
    /**
     1. 先把lowbit写出来
     2. a数组和tr数组，索引都从1开始，先初始化tr，add(i,val)
     3. add函数（相当于遍历父树节点加val,i+=lowbit(i)），query函数（相当于遍历子树节点累加tr[i],i-=lowbit(i)）
     4. 单值修改(x为索引，y为差值): add(x,-a[x]),a[x]+=y,add(x,a[x])
     5. 区间前缀和: query(r+1)-query(l)

     */
    int[] a;
    int[] tr;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        a = new int[n+1];
        tr = new int[n+1];
        for (int i=1; i<=n; ++i) {
            a[i] = nums[i-1];
            add(i,nums[i-1]);
        }
    }

    public void update(int index, int val) {
        index+=1;
        int delta = val-a[index];
        a[index] = val;
        add(index,delta);
    }

    public int sumRange(int left, int right) {
        return query(right+1)-query(left);
    }

    private void add(int i, int val) {
        for(; i<=n; i+=lowbit(i)) {
            tr[i]+=val;
        }
    }

    private int query(int i) {
        int res=0;
        for(; i>=1; i-=lowbit(i)) {
            res+=tr[i];
        }
        return res;
    }

    private int lowbit(int i) {
        return i &-i;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */