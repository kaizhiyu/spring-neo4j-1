package io.github.chenmoand.springneo4j.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.annotation.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jAuditing
@EntityScan(basePackages = "io.github.chenmoand.springneo4j.bean")
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = {"io.github.chenmoand.springneo4j.repositories.neo4j"})
public class Neo4jConfig {
}
