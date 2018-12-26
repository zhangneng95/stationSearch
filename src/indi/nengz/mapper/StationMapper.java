package indi.nengz.mapper;

import indi.nengz.entity.Region;
import indi.nengz.entity.Station;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StationMapper {
    @Insert("INSERT INTO station(province,city,stationName,id,password) VALIES(#{province},#{city},#{stationName},#{id},#{password})")
    void add(Station station);

    @Select("SELECT * FROM station")
    List<Station> findAllStation();

    @Delete("DELETE FROM station WHERE id = #{id}")
    void delectStation(String id);
}
