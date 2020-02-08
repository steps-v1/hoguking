package com.steps.hoguking.support.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

@Slf4j
class DateUtilsTest {

	@Test
	void getFirstDayOfMonth() {
		Date date = DateUtils.getFirstDayOfMonth(2020, 2);
		log.info(date.toString());
	}

	@Test
	void getLastDayOfMonth() {
		Date date = DateUtils.getLastDayOfMonth(2020, 2);
		log.info(date.toString());
	}
}