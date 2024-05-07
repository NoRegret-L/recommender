package nbu.lwf.recommenderbackend.service;

import jakarta.annotation.Resource;
import nbu.lwf.recommenderbackend.dao.PreferenceDao;
import nbu.lwf.recommenderbackend.entity.Preference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {
    @Resource
    private PreferenceDao preferenceDao;

    public List<Preference> getPreference() {
        return preferenceDao.getPreference();
    }
}