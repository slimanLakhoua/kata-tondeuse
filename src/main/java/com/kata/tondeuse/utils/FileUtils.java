package com.kata.tondeuse.utils;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileUtils {

    public List<String> readLinesFromFile(String fileName) throws URISyntaxException, IOException {

        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource(fileName + ".txt")).toURI());

        try (Stream<String> stream = Files.lines(path)) {
            return stream.collect(Collectors.toList());
        }
    }
}
