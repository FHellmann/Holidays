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
package com.fhellmann.holidays.de;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import com.fhellmann.holidays.Calculator;
import com.fhellmann.holidays.IHoliday;
import com.fhellmann.holidays.IState;

/**
 * Every holiday in germany.
 *
 * @author Fabio Hellmann
 *
 */
public enum Holiday implements IHoliday {
	// ####################################################
	// Fix holidays
	// ####################################################

	/** Neujahr */
	NEW_YEAR((year) -> {
		return Calculator.toDate(year, Calendar.JANUARY, 1);
	}, true, State.values()),
	/** Heilige drei Könige */
	EPIPHANY((year) -> {
		return Calculator.toDate(year, Calendar.JANUARY, 6);
	}, true, State.BADEN_WURTTEMBERG, State.BAVARIA, State.SCHLESWIG_HOLSTEIN),
	/** Valentinstag */
	VALENTINES_DAY((year) -> {
		return Calculator.toDate(year, Calendar.FEBRUARY, 14);
	}),
	/** Tag der Arbeit */
	LABOR_DAY((year) -> {
		return Calculator.toDate(year, Calendar.MAY, 1);
	}, true, State.values()),
	/** Mariä Himmelfahrt */
	ASSUMPTION((year) -> {
		return Calculator.toDate(year, Calendar.AUGUST, 15);
	}, true, State.BAVARIA, State.SAARLAND),
	/** Tag der Deutschen Einheit */
	DAY_OF_GERMAN_UNITY((year) -> {
		return Calculator.toDate(year, Calendar.OCTOBER, 3);
	}, true, State.values()),
	/** Reformationstag */
	REFORMATION_DAY((year) -> {
		return Calculator.toDate(year, Calendar.OCTOBER, 31);
	}, true, State.BRANDENBURG, State.MECKLENBUR_WEST_PORNERANIA, State.SAXONY,
			State.SAXONY_ANHALT, State.THURINGIA),
	/** Allerheiligen */
	ALL_SAINTS_DAY((year) -> {
		return Calculator.toDate(year, Calendar.NOVEMBER, 1);
	}, true, State.BADEN_WURTTEMBERG, State.BAVARIA,
			State.NORTH_RHINEWEST_PHALIA, State.RHINELAND_PALATINATE,
			State.SAARLAND),
	/** Nikolaus */
	NICHOLAS((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 6);
	}),
	/** Heiligabend */
	CHRISTMAS_EVE((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 24);
	}),
	/** 1. Weihnachtstag */
	FIRST_CHRISTMAS_DAY((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 25);
	}, true, State.values()),
	/** 2. Weihnachtstag */
	SECOND_CHRISTMAS_DAY((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 26);
	}, true, State.values()),
	/** Silvester */
	NEW_YEARS_EVE((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 27);
	}, true, State.values()),

	// ####################################################
	// Dynamic holidays
	// ####################################################

	/** Ostersonntag */
	EASTER_DAY((year) -> Calculator.EASTER.apply(year).getTime(), true,
			State.BRANDENBURG),
	/** Ostermontag */
	EASTER_MONDAY((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}, true, State.values()),
	/** Karfreitag */
	GOOD_FRIDAY((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, -2);
		return cal.getTime();
	}, true, State.values()),
	/** Gründonnerstag */
	MAUNDY_THURSDAY((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, -3);
		return cal.getTime();
	}),
	/** Buß- und Bettag */
	REPENTANCE_AND_PRAYER((year) -> {
		final int dayCount = Calculator.EASTER_DAY_COUNT.apply(year);
		final Calendar cal = Calendar.getInstance();
		cal.set(year, Calendar.DECEMBER, 24);
		cal.add(Calendar.DATE, -32);
		cal.add(Calendar.DATE, -dayCount);
		return cal.getTime();
	}, true, State.SAXONY),
	/** 1. Advent */
	FIRST_ADVENT((year) -> {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(REPENTANCE_AND_PRAYER.getDate(year));
		cal.add(Calendar.DATE, 11);
		return cal.getTime();
	}),
	/** 2. Advent */
	SECOND_ADVENT((year) -> {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(REPENTANCE_AND_PRAYER.getDate(year));
		cal.add(Calendar.DATE, 18);
		return cal.getTime();
	}),
	/** 3. Advent */
	THIRD_ADVENT((year) -> {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(REPENTANCE_AND_PRAYER.getDate(year));
		cal.add(Calendar.DATE, 25);
		return cal.getTime();
	}),
	/** 4. Advent */
	FOURTH_ADVENT((year) -> {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(REPENTANCE_AND_PRAYER.getDate(year));
		cal.add(Calendar.DATE, 32);
		return cal.getTime();
	}),
	/** Rosenmontag */
	ROSE_MONDAY((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, -48);
		return cal.getTime();
	}),
	/** Pfingstsonntag */
	PENTECOST_SUNDAY((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 49);
		return cal.getTime();
	}, true, State.BRANDENBURG),
	/** Pfingstmontag */
	WHIT_MONDAY((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 50);
		return cal.getTime();
	}, true, State.values()),
	/** Christi Himmelfahrt */
	ASCENSION_OF_CHRIST((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 39);
		return cal.getTime();
	}, true, State.values()),
	/** Fronleichnam */
	CORPUS_CHRISTI((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 60);
		return cal.getTime();
	}, true, State.BADEN_WURTTEMBERG, State.BAVARIA, State.HESSE,
			State.NORTH_RHINEWEST_PHALIA, State.RHINELAND_PALATINATE,
			State.SAARLAND);

	private final Calculator calculator;
	private final boolean national;
	private final IState[] states;

	private Holiday(final Calculator calculator) {
		this(calculator, false, State.values());
	}

	private Holiday(final Calculator calculator, final boolean national,
			final IState... states) {
		this.calculator = calculator;
		this.national = national;
		this.states = states;
	}

	@Override
	public Date getDate(final int year) {
		return calculator.calculate(year);
	}

	@Override
	public boolean isNational() {
		return national;
	}

	@Override
	public Stream<IState> getStates() {
		return Stream.of(states);
	}
}
