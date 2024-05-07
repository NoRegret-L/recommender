package nbu.lwf.recommenderbackend.model.recommender;

import nbu.lwf.recommenderbackend.entity.Recommendation;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.Math.min;

public class HybridRecommender {
    public List<Recommendation> hybridRecommender(long uid, int size) {
        List<Recommendation> recommendation = new ArrayList<>();

        UserBasedRecommender ubr = new UserBasedRecommender();
        ItemBasedRecommender ibr = new ItemBasedRecommender();
        List<Recommendation> ures = ubr.userBasedRecommender(uid, size);
        List<Recommendation> ires = ibr.itemBasedRecommender(uid, size);
        try {
            recommendation= recommendMixer(ures, ires).subList(0, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recommendation;
    }


    public List<Recommendation> recommendMixer(List<Recommendation> list1, List<Recommendation> list2) {
        List<Recommendation> combinedList = new ArrayList<>();
        // 合并列表
        for (int i = 0; i < Math.max(list1.size(), list2.size()); i++) {
            if (i < list1.size()) {
                combinedList.add(list1.get(i));
            }
            if (i < list2.size()) {
                combinedList.add(list2.get(i));
            }
        }

        // 使用顺序流来保持结果的一致性
        Map<Recommendation, Long> itemCounts = combinedList.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        List<Map.Entry<Recommendation, Long>> weightedList = new ArrayList<>(itemCounts.entrySet());

        // 自定义比较器以实现稳定排序
        weightedList.sort((e1, e2) -> {
            int compare = e2.getValue().compareTo(e1.getValue());
            if (compare == 0) {
                // 当计数相同时，比较 Recommendation 在 combinedList 中的索引
                int index1 = combinedList.indexOf(e1.getKey());
                int index2 = combinedList.indexOf(e2.getKey());
                return Integer.compare(index1, index2);
            }
            return compare;
        });

        // 提取排序后的 Recommendation 对象列表
        List<Recommendation> sortedItems = weightedList.stream().map(Map.Entry::getKey).distinct().collect(Collectors.toList());


        return sortedItems;
    }


}
