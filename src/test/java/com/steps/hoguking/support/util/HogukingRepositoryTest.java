package com.steps.hoguking.support.util;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.config.Charset.UTF8;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_7_latest;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Profile("dev")
public abstract class HogukingRepositoryTest {
	private static EmbeddedMysql mysqld;

	@BeforeAll
	public static void setUp() {
		MysqldConfig config = aMysqldConfig(v5_7_latest)
				.withCharset(UTF8)
				.withPort(3306)
				.withUser("admin", "admin!@#123")
				.withTimeZone("Asia/Seoul")
				.withTimeout(2, TimeUnit.MINUTES)
				.withServerVariable("max_connect_errors", 666)
				.build();

		mysqld = anEmbeddedMysql(config)
				.addSchema("hoguking")
				.start();

		System.out.println("db init");
	}

	@AfterAll
	public static void tearDown() {
		mysqld.stop();
	}
}
