package nbu.lwf.recommenderbackend.dao;

import nbu.lwf.recommenderbackend.entity.Preference;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PreferenceDao{

    @Select("select * from preferences")
    List<Preference> getPreference();
}
