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
import java.util.*;

import static com.kata.tondeuse.utils.Constants.SEPARATOR;


@Service
@Slf4j
public class MowItNowServiceImpl implements MowItNowService{

    private final FileUtils fileUtils;

    public MowItNowServiceImpl(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }

    public void proceed() {
        this.fetchMowersFromFile().stream().map(Mower::run).forEach(log::info);
    }
    private List<Mower> fetchMowersFromFile()  {
        List<Mower> mowers ;

        try {
            List<String> lines = this.fileUtils.readLinesFromFile("exercice");
            log.info("reading lines from file. {} line found", lines.size());
            mowers = this.createMowersFromLines(lines);
            log.info("{} Mowers found", mowers.size());
            log.info("Running Mowers ...");

        } catch (IOException | URISyntaxException e) {
            throw new FileConverterException("error converting file to list of Mower");
        }

        return mowers;
    }

    private List<Mower> createMowersFromLines(List<String> lines) {
        List<Mower> mowers = new ArrayList<>();

        Field field = new Field(lines.get(0));

        for(int i =1; i<lines.size(); i = i+2) {
            String[] coordinatesAsStringArray = lines.get(i).split(SEPARATOR);
            Position position = new Position(Integer.parseInt(coordinatesAsStringArray[0]),Integer.parseInt(coordinatesAsStringArray[1]));
            String instructions = lines.get(i+1);
            Mower mower = new Mower(field,Direction.fromValue(coordinatesAsStringArray[2]),position,instructions);
            mowers.add(mower);
        }
        return mowers;
    }

}
