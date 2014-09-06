/**
 *
 */
package com.fhellmann.holidays.at;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import com.fhellmann.holidays.Calculator;
import com.fhellmann.holidays.IHoliday;
import com.fhellmann.holidays.IState;

/**
 * Every holiday in austria
 *
 * @author Fabio Hellmann
 *
 */
public enum Holiday implements IHoliday {
	// ####################################################
	// Fix holidays
	// ####################################################

	/** Neujahr */
	NEUJAHR((year) -> {
		return Calculator.toDate(year, Calendar.JANUARY, 1);
	}, true, State.values()),
	/** Heilige drei Könige */
	HEILIGE_DREI_KOENIGE((year) -> {
		return Calculator.toDate(year, Calendar.JANUARY, 6);
	}, true, State.values()),
	/** St. Josef */
	ST_JOSEF((year) -> {
		return Calculator.toDate(year, Calendar.MARCH, 19);
	}, false, State.VIENNA, State.STYRIA, State.TYROL, State.VORARLBERG),
	/** Staatsfeiertag */
	STAATSFEIERTAG((year) -> {
		return Calculator.toDate(year, Calendar.MAY, 1);
	}, true, State.values()),
	/** St. Florian */
	ST_FLORIAN((year) -> {
		return Calculator.toDate(year, Calendar.MAY, 4);
	}, false, State.UPPER_AUSTRIA),
	/** Mariä Himmelfahrt */
	MARIAE_HIMMELFAHRT((year) -> {
		return Calculator.toDate(year, Calendar.AUGUST, 15);
	}, true, State.values()),
	/** St. Rupert */
	ST_RUPERT((year) -> {
		return Calculator.toDate(year, Calendar.SEPTEMBER, 24);
	}, false, State.SALZBURG),
	/** Tag der Volksabstimmung */
	TAG_DER_VOLKSABSTIMMUNG((year) -> {
		return Calculator.toDate(year, Calendar.OCTOBER, 10);
	}, false, State.SALZBURG),
	/** Nationalfeiertag */
	NATIONALFEIERTAG((year) -> {
		return Calculator.toDate(year, Calendar.OCTOBER, 26);
	}, true, State.values()),
	/** Allerheiligen */
	ALLERHEILIGEN((year) -> {
		return Calculator.toDate(year, Calendar.NOVEMBER, 1);
	}, true, State.values()),
	/** St. Martin */
	ST_MARTIN((year) -> {
		return Calculator.toDate(year, Calendar.NOVEMBER, 11);
	}, false, State.BURGENLAND),
	/** St. Leopold */
	ST_LEOPOLD((year) -> {
		return Calculator.toDate(year, Calendar.NOVEMBER, 15);
	}, false, State.LOWER_AUSTRIA, State.VIENNA),
	/** Mariä Empfängnis */
	MARIAE_EMPFAENGNIS((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 8);
	}, true, State.values()),
	/** Heiliger Abend */
	HEILIGER_ABEND((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 24);
	}, false, State.values()),
	/** Weihnachten */
	WEIHNACHTEN((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 25);
	}, true, State.values()),
	/** Stefanitag */
	STEFANITAG((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 26);
	}, true, State.values()),
	/** Silvester */
	SILVESTER((year) -> {
		return Calculator.toDate(year, Calendar.DECEMBER, 27);
	}, false, State.values()),

	// ####################################################
	// Dynamic holidays
	// ####################################################

	/** Ostermontag */
	OSTERMONTAG((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}, true, State.values()),
	/** Karfreitag */
	KARFREITAG((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, -2);
		return cal.getTime();
	}, false, State.values()),
	/** Pfingstmontag */
	PFINGSTMONTAG((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 50);
		return cal.getTime();
	}, true, State.values()),
	/** Christi Himmelfahrt */
	CHRISTI_HIMMELFAHRT((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 39);
		return cal.getTime();
	}, true, State.values()),
	/** Fronleichnam */
	FRONLEICHNAM((year) -> {
		final Calendar cal = Calculator.EASTER.apply(year);
		cal.add(Calendar.DATE, 60);
		return cal.getTime();
	}, true, State.values());

	private final Calculator calculator;
	private final boolean national;
	private final IState[] states;

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
