package indi.nengz.service.impl;

import indi.nengz.entity.Station;
import indi.nengz.mapper.StationMapper;
import indi.nengz.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationMapper stationMapper;

    @Override
    public int add(Station station) {
        return stationMapper.add(station);
    }

    @Override
    public List<Station> findAllStation() {
        return stationMapper.findAllStation();
    }

    @Override
    public int deleteStation(String id) {
        return stationMapper.deleteStation(id);
    }

}
