package nbu.lwf.recommenderbackend.controller;

import jakarta.annotation.Resource;
import nbu.lwf.recommenderbackend.common.Result;
import nbu.lwf.recommenderbackend.service.PreferenceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/preference")
public class PreferenceController {
    @Resource
    private PreferenceService preferenceService;

    @GetMapping
    public Result getPreference(){
        return Result.success(preferenceService.getPreference());
    }
}
