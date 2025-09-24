import java.util.*;

public class TrainDispatch {

    // 深度优先搜索 + 回溯
    public static void dfs(List<Integer> input, Stack<Integer> station,
                           List<Integer> output, int index) {
        // 如果输出序列长度等于输入车厢数，说明得到一种结果
        if (output.size() == input.size()) {
            System.out.println(output);
            return;
        }

        // 进栈操作
        if (index < input.size()) {
            station.push(input.get(index));    // 车厢进栈
            dfs(input, station, output, index + 1);
            station.pop(); // 回溯
        }

        // 出栈操作
        if (!station.isEmpty()) {
            int top = station.pop();          // 出栈
            output.add(top);                  // 记录到出站序列

            dfs(input, station, output, index);

            output.remove(output.size() - 1); // 回溯
            station.push(top);                // 恢复状态
        }
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4); // 车厢编号
        Stack<Integer> station = new Stack<>();          // 调度站（栈）
        List<Integer> output = new ArrayList<>();        // 出站序列

        dfs(input, station, output, 0);
    }
}
