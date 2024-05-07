package nbu.lwf.recommenderbackend.dao;


import nbu.lwf.recommenderbackend.entity.Movies;
import nbu.lwf.recommenderbackend.entity.Preference;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MoviesDao{
    @Select("select * from movies where mid=#{mid}")
    List<Movies> getmovies(@Param("mid") Long mid);
}
