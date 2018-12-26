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
    public void add(Station station) {
        stationMapper.add(station);
    }

    @Override
    public List<Station> findAllStation() {
        return stationMapper.findAllStation();
    }

    @Override
    public void delectStation(String id) {
        stationMapper.delectStation(id);
    }

}
