package nbu.lwf.recommenderbackend.model.recommender;

import nbu.lwf.recommenderbackend.entity.Recommendation;
import nbu.lwf.recommenderbackend.model.MyDataModel;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.util.List;

import static nbu.lwf.recommenderbackend.model.recommender.UserBasedRecommender.getRecommendations;

public class ItemBasedRecommender {

    public List<Recommendation> itemBasedRecommender(long userID, int size) {
        List<RecommendedItem> res = null;
        try {
            DataModel model = MyDataModel.myDataModel();//构造数据模型
            ItemSimilarity similarity = new LogLikelihoodSimilarity(model);
            Recommender recommender = new CachingRecommender(new GenericItemBasedRecommender(model, similarity));//采用 CachingRecommender 为 RecommendationItem 进行缓存
            res = recommender.recommend(userID, size);//得到推荐结果
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());

//            e.printStackTrace();
        }
        return getRecommendations(res);
    }

}
