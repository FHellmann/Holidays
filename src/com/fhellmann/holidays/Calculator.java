/**
 * Copyright 2014 Fabio Hellmann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fhellmann.holidays;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

/**
 * The calculator interface is the best Java 8 solution to calculate the holiday
 * only if necessary.
 *
 * @author Fabio Hellmann
 *
 */
@FunctionalInterface
public interface Calculator {
	/**
	 * In many culctures easter is a holiday. This day is mostly used as a
	 * relative reference value to calculate other holidays. It can be
	 * calculated by Gauss formula.
	 */
	Function<Integer, Calendar> EASTER = (year) -> {
		final int i = year % 19;
		final int j = year / 100;
		final int k = year % 100;

		final int l = (19 * i + j - j / 4 - (j - (j + 8) / 25 + 1) / 3 + 15) % 30;
		final int m = (32 + 2 * (j % 4) + 2 * (k / 4) - l - k % 4) % 7;
		final int n = l + m - 7 * ((i + 11 * l + 22 * m) / 451) + 114;

		final int month = n / 31;
		final int day = n % 31 + 1;

		final Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		return cal;
	};

	Function<Integer, Integer> EASTER_DAY_COUNT = (year) -> {
		final Calendar cal = EASTER.apply(year);
		final int dayCount = (30 - cal.get(Calendar.DAY_OF_MONTH)) % 7;
		return dayCount;
	};

	/**
	 * Calculate the holiday relative by year.
	 *
	 * @param year
	 *            of holiday.
	 * @return the date.
	 */
	Date calculate(int year);

	/**
	 * Convert the int values to a date.
	 *
	 * @param year
	 *            of the date.
	 * @param month
	 *            of the date.
	 * @param day
	 *            of the date.
	 * @return the date.
	 */
	static Date toDate(final int year, final int month, final int day) {
		final Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal.getTime();
	}
}
