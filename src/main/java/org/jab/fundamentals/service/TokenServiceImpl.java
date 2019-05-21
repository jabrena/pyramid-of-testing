package org.jab.fundamentals.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TokenServiceImpl implements TokenService {

    final int CAPACITY = 100;

    @Override
    public String getToken() {
        return smartSeedComputing();
    }

    /**
     * A 'SMART' algorithm to provide security in the project.
     */
    private String smartSeedComputing(){

        //return getInitialList().stream().findAny().get();
        return generateList().stream()
                .skip(ThreadLocalRandom.current().nextInt(CAPACITY - 1))
                .findFirst()
                .get();
    }

    private List<String> generateList() {

        return IntStream.range(0, CAPACITY)
                .mapToObj(i -> RandomStringUtils.randomAlphabetic(TOKEN_LENGTH))
                .collect(Collectors.toList());
    }

}
