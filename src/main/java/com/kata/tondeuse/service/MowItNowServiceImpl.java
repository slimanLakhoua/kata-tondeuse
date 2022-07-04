package com.kata.tondeuse.service;

import com.kata.tondeuse.domain.Direction;
import com.kata.tondeuse.domain.Field;
import com.kata.tondeuse.domain.Mower;
import com.kata.tondeuse.domain.Position;
import com.kata.tondeuse.exception.FileConverterException;
import com.kata.tondeuse.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.kata.tondeuse.utils.Constants.SEPARATOR;
import static java.util.stream.Collectors.toList;


@Service
@Slf4j
public class MowItNowServiceImpl implements MowItNowService {

    public List<String> processFile(String fileName) {
        try {
            var lines = FileUtils.readLinesFromFile(fileName);
            log.debug("reading lines from file. {} line found", lines.size());
            var mowers = this.createMowersFromLines(lines);
            log.debug("{} Mowers found", mowers.size());
            log.debug("Running Mowers ...");
            return this.proceed(mowers);

        } catch (IOException | URISyntaxException e) {
            throw new FileConverterException("error converting file to list of Mower");
        }
    }

    private List<Mower> createMowersFromLines(List<String> lines) {
        List<Mower> mowers = new ArrayList<>();

        Field field = new Field(lines.get(0));

        for (int i = 1; i < lines.size(); i = i + 2) {
            String[] coordinatesAsStringArray = lines.get(i).split(SEPARATOR);
            log.info(Arrays.toString(coordinatesAsStringArray));
            Position position = new Position(Integer.parseInt(coordinatesAsStringArray[0]), Integer.parseInt(coordinatesAsStringArray[1]));
            String instructions = lines.get(i + 1);
            Mower mower = new Mower(field, Direction.fromValue(coordinatesAsStringArray[2]), position, instructions);
            mowers.add(mower);
        }
        return mowers;
    }

    private List<String> proceed(List<Mower> mowers) {
        return mowers.stream().map(Mower::run).collect(toList());
    }
}
