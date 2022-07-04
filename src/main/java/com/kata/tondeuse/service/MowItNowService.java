package com.kata.tondeuse.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface MowItNowService {

    List<String> readLinesFromFile(String fileName) throws IOException;
}
