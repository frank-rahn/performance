/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.testbeans;

import static javax.persistence.AccessType.FIELD;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang.builder.ToStringStyle.MULTI_LINE_STYLE;

import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Ein Java-Bean zum Test, welche eine Tabelle darstellt.
 * @author Frank W. Rahn
 */
@Entity
@Access(FIELD)
@Table(schema = "rahn")
public class DomainTable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "TableSEQ")
	@SequenceGenerator(name = "TableSEQ", sequenceName = "TableSEQ",
		schema = "rahn")
	private Long id;

	private String name;

	@Temporal(DATE)
	private Date date;

	@OneToMany(cascade = ALL)
	private List<DomainRow> rows;

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

	/**
	 * @return Gets the value of the date property
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return Gets the value of the name property
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Gets the value of the rows property
	 */
	public List<DomainRow> getRows() {
		return rows;
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
	 * @param value Sets the value of the date property
	 */
	public void setDate(Date value) {
		date = value;
	}

	/**
	 * @param value Sets the value of the name property
	 */
	public void setName(String value) {
		name = value;
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

}