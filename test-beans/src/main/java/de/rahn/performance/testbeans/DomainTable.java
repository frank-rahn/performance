/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.testbeans;

import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang.builder.ToStringStyle.MULTI_LINE_STYLE;

import java.util.Date;
import java.util.List;

/**
 * Ein Java-Bean zum Test, welche eine Tabelle darstellt.
 * @author Frank W. Rahn
 */
public class DomainTable {

	private String name;

	private Date date;

	private List<DomainRow> rows;

	/**
	 * @return Gets the value of the name property
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param value Sets the value of the name property
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * @return Gets the value of the date property
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param value Sets the value of the date property
	 */
	public void setDate(Date value) {
		date = value;
	}

	/**
	 * @return Gets the value of the rows property
	 */
	public List<DomainRow> getRows() {
		return rows;
	}

	/**
	 * @param value Sets the value of the rows property
	 */
	public void setRows(List<DomainRow> value) {
		rows = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return reflectionToString(this, MULTI_LINE_STYLE);
	}

	/**
	 * {@inheritDoc}
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int p = 31;
		int r = 1;

		r = p * r + (date == null ? 0 : date.hashCode());
		r = p * r + (rows == null ? 0 : rows.hashCode());
		r = p * r + (name == null ? 0 : name.hashCode());

		return r;
	}

	/**
	 * {@inheritDoc}
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DomainTable)) {
			return false;
		}

		DomainTable other = (DomainTable) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (rows == null) {
			if (other.rows != null) {
				return false;
			}
		} else if (!rows.equals(other.rows)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}