package com.kata.tondeuse.service;

import com.kata.tondeuse.domain.Direction;
import com.kata.tondeuse.domain.Field;
import com.kata.tondeuse.domain.Mower;
import com.kata.tondeuse.domain.Position;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
            mowers = this.createMowersFromLines(lines);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return mowers;
    }

    private List<Mower> createMowersFromLines(List<String> lines) {
        List<Mower> mowers = new ArrayList<>();

        Field field = new Field(lines.get(0));

        for(int i =1; i<lines.size(); i = i+2) {
            String[] coordinatesAsStringArray = lines.get(i).split(SEPARATOR);
            Position position = new Position(Integer.parseInt(coordinatesAsStringArray[0]),Integer.parseInt(coordinatesAsStringArray[1]), Direction.fromValue(coordinatesAsStringArray[3]));
            String instructions = lines.get(i++);
            Mower mower = new Mower(field,position,instructions);
            mowers.add(mower);
        }
        return mowers;
    }


    public List<String> readLinesFromFile(String fileName) throws IOException {

        Path path = Paths.get("classpath:" + fileName +".txt");

        try (Stream<String> stream = Files.lines(path)) {
            return stream.collect(Collectors.toList());
        }
    }
}
