/*
 * Copyright 2011-2017 Frank W. Rahn and the project authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.rahn.performance.beanmapper.selma;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * Ein Konverter.
 *
 * @author Frank W. Rahn
 */
@Component
public class DateCustomMapper {

	/**
	 * Konvertiere ein {@link Calendar} in ein {@link Date}.
	 *
	 * @param in ein {@link Calendar}
	 * @return das {@link Date}
	 */
	public Date calendarAsDate(Calendar in) {
		if (in == null) {
			return null;
		}

		return in.getTime();
	}

	/**
	 * Konvertiere ein {@link Date} in ein {@link Calendar}.
	 *
	 * @param in das {@link Date}
	 * @return der {@link Calendar}
	 */
	public Calendar dateAsCalendar(Date in) {
		if (in == null) {
			return null;
		}

		Calendar out = Calendar.getInstance();
		out.setTime(in);

		return out;
	}

}