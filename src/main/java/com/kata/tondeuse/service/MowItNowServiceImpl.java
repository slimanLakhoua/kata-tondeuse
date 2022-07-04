package com.kata.tondeuse.service;

import com.kata.tondeuse.domain.Direction;
import com.kata.tondeuse.domain.Field;
import com.kata.tondeuse.domain.Mower;
import com.kata.tondeuse.domain.Position;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kata.tondeuse.utils.Constants.SEPARATOR;


@Service
@Slf4j
public class MowItNowServiceImpl implements MowItNowService{


    public List<Mower> fetchMowersFromFile()  {
        List<Mower> mowers ;

        try {
            List<String> lines = this.readLinesFromFile("exercice");
            log.debug("reading lines from file. {} line found", lines.size());
            mowers = this.createMowersFromLines(lines);
            log.debug("{} Mowers found", mowers.size());
            log.debug("Running Mowers ...");
            this.proceed(mowers);

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }


        return mowers;
    }

    private List<Mower> createMowersFromLines(List<String> lines) {
        List<Mower> mowers = new ArrayList<>();

        Field field = new Field(lines.get(0));

        for(int i =1; i<lines.size(); i = i+2) {
            String[] coordinatesAsStringArray = lines.get(i).split(SEPARATOR);
            log.info(Arrays.toString(coordinatesAsStringArray));
            Position position = new Position(Integer.parseInt(coordinatesAsStringArray[0]),Integer.parseInt(coordinatesAsStringArray[1]));
            String instructions = lines.get(i+1);
            Mower mower = new Mower(field,Direction.fromValue(coordinatesAsStringArray[2]),position,instructions);
            mowers.add(mower);
        }
        return mowers;
    }


    public List<String> readLinesFromFile(String fileName) throws URISyntaxException, IOException {

        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource(fileName + ".txt")).toURI());

        try (Stream<String> stream = Files.lines(path)) {
            return stream.collect(Collectors.toList());
        }
    }

    private void proceed(List<Mower> mowers) {
        mowers.stream().map(Mower::run).forEach(log::info);
    }
}
