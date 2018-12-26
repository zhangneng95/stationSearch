package indi.nengz.service;

import indi.nengz.entity.Station;

import java.util.List;

public interface StationService {
    void add(Station station);
    List<Station> findAllStation();
    void delectStation(String id);
}
