package br.com.murillo.teste.configuration;

import br.com.murillo.teste.RunnerTest;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {RunnerTest.class})
public class CucumberSpringConfiguration {
}
