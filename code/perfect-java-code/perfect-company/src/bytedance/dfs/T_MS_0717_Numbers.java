package bytedance.dfs;

/**
 * @author Kelly
 * @create 2020-07-18 23:30
 *
 * 2 个 1 之间 1 个数，两个 2 之前两个数，两个 3 之间三个数。。。
 * 回溯 dfs
 */
public class T_MS_0717_Numbers {
    private static int[] arr = new int[8];
    private static boolean[] visited = new boolean[4];

    public static void dfs(int[] arr, int pos) {
        if (pos == 8) {
            showArray(arr);
            System.out.println();
            return;
        }
        // 当前位置已经被占用了，看下一个位置
        if (arr[pos] != 0) {
            dfs(arr, pos + 1);
        }
        // 遍历要插入的数字，递归进行判断，能否插入
        for (int i = 1; i <= 4; i++) {
            // 当前数字用过了
            if (visited[i - 1]) continue;
            if (pos + i + 1 > 7) break;
            // 检查能否插入数据
            if (arr[pos] == 0 && arr[pos + i + 1] == 0) {
                // 将数据插入相应位置
                arr[pos] = arr[pos + i + 1] = i;
                visited[i - 1] = true;
                
                dfs(arr, pos + 1);

                arr[pos] = arr[pos + i + 1] = 0;
                visited[i - 1] = false;
            }
        }
    }

    private static void showArray(int[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.printf("%d",array[i]);
        }
    }

    public static void main(String[] args) {
        dfs(arr,0);
    }
}
