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

import java.util.stream.Stream;

/**
 * The countries with states and holidays.
 *
 * @author Fabio Hellmann
 *
 */
public enum Country {
	/** Germany */
	GERMANY(com.fhellmann.holidays.de.State.values(),
			com.fhellmann.holidays.de.Holiday.values());

	private final IState[] states;
	private final IHoliday[] holidays;

	private Country(final IState[] states, final IHoliday[] holidays) {
		this.states = states;
		this.holidays = holidays;
	}

	/**
	 * Get the states of the country.
	 *
	 * @return all states.
	 */
	public Stream<IState> getStates() {
		return Stream.of(states);
	}

	/**
	 * Get the holidays of the country.
	 *
	 * @return all holidays.
	 */
	public Stream<IHoliday> getHolidays() {
		return Stream.of(holidays);
	}
}
