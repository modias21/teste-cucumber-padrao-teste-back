package br.com.murillo.teste;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;

@RunWith(Cucumber.class)
@ComponentScan
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"br.com.murillo.teste", "br.com.murillo.configuration"},
        //tags = "@Teste",
        plugin = {"pretty",
                  "json:target/relatorio/cucumber-reports.json",
                  "html:target/relatorio/cucumber-reports.html"})
public class RunnerTest {
}
