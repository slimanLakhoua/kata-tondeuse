package com.kata.tondeuse.service;

import com.kata.tondeuse.domain.Mower;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;

public interface MowItNowService {

    public List<Mower> fetchMowersFromFile();
    List<String> readLinesFromFile(String fileName) throws IOException, URISyntaxException;
}
