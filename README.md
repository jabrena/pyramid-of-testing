# Pyramid of testing

```
          ,/`.
        ,'/ __`.
      ,'_/_  _ _`.
    ,'__/_ ___ _  `.
  ,'_  /___ __ _ __ `.
 '-.._/___...-"-.-..__`.

```

# Context

When you are testing your API, you need to implement the Pyramid of testing.
In the development process, you will observe that some tests has a Slow performance like
the integration tests so, how to increase the granularity in the execution with Maven?

## How to execute the tests with more granular control?

In JUnit 4, exist the Category concept and in JUnit 5, exist the concept about Tags.

Using this concept, it is possible to create some Interfaces, defining the type of tests:

``` java

public interface Unit { }

public interface Integration { }

```

and use it in your Tests:

``` java
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TokenServiceTest {

    @Autowired
    private TokenService tokenService;

    @Tag("unit")
    @Test
    public void demoTest(){

        assertThat(tokenService.getToken().length()).isEqualTo(TOKEN_LENGTH);
    }

}

```

The execution of the tests is managed by the Maven plugin Surefire.

Using the following combinations, you can satisfy your needs:


``` bash
mvn test
mvn test -Dgroups=unit
mvn test -Dgroups=integration
mvn test -Dgroups=unit,integration
mvn test -DexcludedGroups=unit
mvn test -DexcludedGroups=integration
mvn test -DexcludedGroups=unit,integration
mvn test -Dgroups=unit -DexcludedGroups=integration

```

## References

- https://martinfowler.com/articles/practical-test-pyramid.html
- https://github.com/junit-team/junit4/wiki/categories
- https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering
- https://maven.apache.org/surefire/maven-surefire-plugin/
