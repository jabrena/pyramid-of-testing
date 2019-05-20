# Pyramid of testing

```
          ,/`.
        ,'/ __`.
      ,'_/_  _ _`.
    ,'__/_ ___ _  `.
  ,'_  /___ __ _ __ `.
 '-.._/___...-"-.-..__`.

```

## How to execute tests in a more granular way?

### Alternative 1

```
mvn test -Dgroups=integration
mvn test -DexcludedGroups=integration

```

### Alternative 2

```
mvn clean test
mvn clean test -Dgroups=unit
mvn clean test -Dgroups=integration
```