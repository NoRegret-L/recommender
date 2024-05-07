package nbu.lwf.recommenderbackend.model.recommender;

import nbu.lwf.recommenderbackend.entity.Recommendation;
import nbu.lwf.recommenderbackend.model.MyDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.util.ArrayList;
import java.util.List;

public class UserBasedRecommender {
    public List<Recommendation> userBasedRecommender(long uid, int size) {
        // step:1 构建模型 2 计算相似度 3 查找k紧邻 4 构造推荐引擎
        List<RecommendedItem> res = null;
        try {
            DataModel model = MyDataModel.myDataModel();//构造数据模型
            UserSimilarity similarity = new LogLikelihoodSimilarity(model);//TanimotoCoefficientSimilarity 算法计算用户相似度
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(50, similarity, model);//计算用户的“邻居”，这里将与该用户最近距离为20 的用户设置为该用户的“邻居”。
            Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(model, neighborhood, similarity));//采用 CachingRecommender 为 RecommendationItem 进行缓存
            res = recommender.recommend(uid, size);//得到推荐的结果，size是推荐结果的数目
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        return getRecommendations(res);
    }

    static List<Recommendation> getRecommendations(List<RecommendedItem> res) {
        List<Recommendation> recommendations = new ArrayList<>();
        if (res != null) {
            for (RecommendedItem re : res) {
                Recommendation recommendation = new Recommendation(re.getItemID(), null, "https://movie.douban.com/subject/" + re.getItemID());
                recommendations.add(recommendation);
            }
        }

        return recommendations;
    }

}
