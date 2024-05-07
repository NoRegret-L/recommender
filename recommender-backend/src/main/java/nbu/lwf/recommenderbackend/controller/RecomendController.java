package nbu.lwf.recommenderbackend.controller;

import jakarta.annotation.Resource;
import nbu.lwf.recommenderbackend.common.Result;
import nbu.lwf.recommenderbackend.entity.Params;
import nbu.lwf.recommenderbackend.entity.Recommendation;
import nbu.lwf.recommenderbackend.service.RecommendService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/recommend",method = RequestMethod.GET)
public class RecomendController {

    @Resource
    private RecommendService recommendService;

    @GetMapping
    public Result recommend(Params params){
        List<Recommendation> recommendations=recommendService.recommendService(params);
        return Result.success(recommendations);
    }
}
