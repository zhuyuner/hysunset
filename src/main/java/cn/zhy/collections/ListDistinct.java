package cn.zhy.collections;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LIST 去重 list.contain 和 hashSet 性能比较
 */
public class ListDistinct {

    public static List<String> getTestList() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            list.add(String.valueOf(i));
        }
        for (int i = 10000; i >= 1; i--) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    /**
     * 使用list.contain 去重
     *
     * @param testList
     */
    private static void useContain2Distinct(List<String> testList) {
        System.out.println("Contains 开始去重，条数：" + testList.size());
        List<String> testListDistinctResult = new ArrayList<>();
        for (String str : testList) {
            if (!testListDistinctResult.contains(str)) {
                testListDistinctResult.add(str);
            }
        }

        System.out.println("contains 去重完毕，条数：" + testListDistinctResult.size());
    }

    public static void use2ForDistinct(List<String> testList) {
        System.out.println("list 双循环 开始去重，条数：" + testList.size());
        for (int i = 0; i < testList.size(); i++) {
            for (int j = i + 1; j < testList.size(); j++) {
                if (testList.get(i).equals(testList.get(j))) {
                    testList.remove(j);
                }
            }
        }
    }

    private static void useSetDistinct(List<String> testList) {
        System.out.println("HashSet.add 开始去重,条数：" + testList.size());
        List<String> testListDistinctResult = new ArrayList<>(new HashSet<>(testList));
        System.out.println("HashSet.add 去重完毕，条数：" + testListDistinctResult.size());
    }

    private static void useStreamDistinct(List<String> testList) {
        System.out.println("stream 开始去重，条数：" + testList.size());
        List<String> testListDistinctResult = testList.stream().distinct().collect(Collectors.toList());
        System.out.println("Stream 去重完毕，条数：" + getTestList().size());
    }

    public static void main(String[] args) {
        List<String> testList = getTestList();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        useContain2Distinct(testList);
        useSetDistinct(testList);
        use2ForDistinct(testList);
        useStreamDistinct(testList);
        stopWatch.stop();
        System.out.println("去重，最终耗时：" + stopWatch.getTotalTimeMillis());
    }
}
