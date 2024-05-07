package nbu.lwf.recommenderbackend.service;

import jakarta.annotation.Resource;
import nbu.lwf.recommenderbackend.dao.MoviesDao;
import nbu.lwf.recommenderbackend.dao.PreferenceDao;
import nbu.lwf.recommenderbackend.entity.Params;
import nbu.lwf.recommenderbackend.entity.Recommendation;
import nbu.lwf.recommenderbackend.model.recommender.HybridRecommender;
import nbu.lwf.recommenderbackend.model.recommender.ItemBasedRecommender;
import nbu.lwf.recommenderbackend.model.recommender.UserBasedRecommender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendService {

    @Resource
    private MoviesDao moviesDao;

    public List<Recommendation> recommendService(Params params) {
        List<Recommendation> recommendation;

        switch (params.getType()) {
            case 0:
                ItemBasedRecommender ibr = new ItemBasedRecommender();
                recommendation = ibr.itemBasedRecommender(params.getUid(), params.getSize());
                break;
            case 1:
                UserBasedRecommender ubr = new UserBasedRecommender();
                recommendation = ubr.userBasedRecommender(params.getUid(), params.getSize());
                break;
            case 2:
                HybridRecommender hbr = new HybridRecommender();
                recommendation = hbr.hybridRecommender(params.getUid(), params.getSize());
                break;
            default:
                return null;
        }

        for (int i = 0; i < recommendation.size(); i++) {
            Long mid = recommendation.get(i).getMid();
            String name=null;
            try {
                name = moviesDao.getmovies(mid).get(0).getName();
            } catch (Exception e) {
                name=null;
            }

            String link=recommendation.get(i).getLink();
            Recommendation recommendation1 = new Recommendation(mid,name,link);
            recommendation.set(i,recommendation1);
        }

        return recommendation;
    }
}
