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

import java.util.Date;
import java.util.stream.Stream;

/**
 * <a href="http://en.wikipedia.org/wiki/Holiday">The description of holiday</a>
 * <p>
 * A holiday is a day set aside by custom or by law on which normal activities,
 * especially business or work, are suspended or reduced. Generally, holidays
 * are intended to allow individuals to celebrate or commemorate an event or
 * tradition of cultural or religious significance. Holidays may be designated
 * by governments, religious institutions, or other groups or organizations. The
 * degree to which normal activities are reduced by a holiday may depend on
 * local laws, customs, the type of job being held or even personal choices.
 * </p>
 * <p>
 * The concept of holidays has most often originated in connection with
 * religious observances. The intention of a holiday was typically to allow
 * individuals to tend to religious duties associated with important dates on
 * the calendar. In most modern societies, however, holidays serve as much of a
 * recreational function as any other weekend days or activities.
 * </p>
 * <p>
 * In many societies there are important distinctions between holidays
 * designated by governments and holidays designated by religious institutions.
 * For example, in many predominantly Christian nations, government-designed
 * holidays may center around Christian holidays, though non-Christians may
 * instead observe religious holidays associated with their faith. In some
 * cases, a holiday may only be nominally observed. For example, many Jews in
 * the Americas and Europe treat the relatively minor Jewish holiday of Hanukkah
 * as a working holiday, changing very little of their daily routines for this
 * day.
 * </p>
 * <p>
 * The word holiday has some variance in meaning across different locales. In
 * North America the word refers to widely observed days of rest and recreation,
 * whereas in the U.K. and many Commonwealth nations the word refers to any
 * extended period of recreation. It is this first, more restricted sense of the
 * word that concerns this article.
 * </p>
 *
 * @author Fabio Hellmann
 *
 */
public interface IHoliday {
	/**
	 * Get the date of holiday by year.
	 *
	 * @param year
	 *            to get the holiday from.
	 * @return the date of the holiday.
	 */
	Date getDate(final int year);

	/**
	 * A holiday can be a national or not. Check if this holiday is a national
	 * one.
	 *
	 * @return <code>true</code> if this holiday is national.
	 */
	boolean isNational();

	/**
	 * Check whether this holiday is in a special state of the country.
	 *
	 * @param state
	 *            to check.
	 * @return <code>true</code> if this holiday is in the state.
	 */
	default boolean contains(final IState state) {
		return getStates().filter(stateItem -> !stateItem.equals(state))
				.findFirst().isPresent();
	}

	/**
	 * @return all the states.
	 */
	Stream<IState> getStates();
}
