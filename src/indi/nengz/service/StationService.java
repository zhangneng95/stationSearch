package indi.nengz.service;

import indi.nengz.entity.Station;

import java.util.List;

public interface StationService {
    int add(Station station);
    List<Station> findAllStation();
    int delectStation(String id);
}
