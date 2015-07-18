/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.frank_rahn.xmlns.types.testtypes._1.XmlRow;
import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainRow;
import de.rahn.performance.testbeans.DomainTable;

/**
 * Der Mapper per "ByHand".
 * @author Frank W. Rahn
 */
@Component("ByHand")
@Order(0)
public class ByHandTestBeansMapperBean extends AbstractTestBeansMapperBean {

	/**
	 * {@inheritDoc}
	 * @see TestBeansMapperBean#map(DomainTable)
	 */
	@Override
	public XmlTable map(DomainTable source) throws Exception {
		return map(createXmlTable(), source);
	}

	/**
	 * {@inheritDoc}
	 * @see TestBeansMapperBean#map(XmlTable)
	 */
	@Override
	public DomainTable map(XmlTable source) throws Exception {
		return map(new DomainTable(), source);
	}

	private DomainRow map(DomainRow target, XmlRow source) {
		// Mapping String
		target.setColumn00(source.getColumn00());
		target.setColumn01(source.getColumn01());
		target.setColumn02(source.getColumn02());
		target.setColumn03(source.getColumn03());
		target.setColumn04(source.getColumn04());
		target.setColumn05(source.getColumn05());
		target.setColumn06(source.getColumn06());
		target.setColumn07(source.getColumn07());
		target.setColumn08(source.getColumn08());
		target.setColumn09(source.getColumn09());

		// Mapping int
		target.setColumn10(source.getColumn10());
		target.setColumn11(source.getColumn11());
		target.setColumn12(source.getColumn12());
		target.setColumn13(source.getColumn13());
		target.setColumn14(source.getColumn14());
		target.setColumn15(source.getColumn15());
		target.setColumn16(source.getColumn16());
		target.setColumn17(source.getColumn17());
		target.setColumn18(source.getColumn18());
		target.setColumn19(source.getColumn19());

		// Mapping boolean
		target.setColumn20(source.isColumn20());
		target.setColumn21(source.isColumn21());
		target.setColumn22(source.getColumn22());
		target.setColumn23(source.isColumn23());
		target.setColumn24(source.isColumn24());
		target.setColumn25(source.isColumn25());
		target.setColumn26(source.isColumn26());
		target.setColumn27(source.isColumn27());
		target.setColumn28(source.isColumn28());
		target.setColumn29(source.isColumn29());

		// Mapping long
		target.setColumn30(source.getColumn30());
		target.setColumn31(source.getColumn31());
		target.setColumn32(source.getColumn32());
		target.setColumn33(source.getColumn33());
		target.setColumn34(source.getColumn34());
		target.setColumn35(source.getColumn35());
		target.setColumn36(source.getColumn36());
		target.setColumn37(source.getColumn37());
		target.setColumn38(source.getColumn38());
		target.setColumn39(source.getColumn39());

		// Mapping BigDecimal
		target.setColumn40(source.getColumn40());
		target.setColumn41(source.getColumn41());
		target.setColumn42(source.getColumn42());
		target.setColumn43(source.getColumn43());
		target.setColumn44(source.getColumn44());
		target.setColumn45(source.getColumn45());
		target.setColumn46(source.getColumn46());
		target.setColumn47(source.getColumn47());
		target.setColumn48(source.getColumn48());
		target.setColumn49(source.getColumn49());

		// Mapping Calendar
		target.setColumn50(source.getColumn50());
		target.setColumn51(source.getColumn51());
		target.setColumn52(source.getColumn52());
		target.setColumn53(source.getColumn53());
		target.setColumn54(source.getColumn54());
		target.setColumn55(source.getColumn55());
		target.setColumn56(source.getColumn56());
		target.setColumn57(source.getColumn57());
		target.setColumn58(source.getColumn58());
		target.setColumn59(source.getColumn59());

		// Mapping String
		target.setColumn60(source.getColumn60());
		target.setColumn61(source.getColumn61());
		target.setColumn62(source.getColumn62());
		target.setColumn63(source.getColumn63());
		target.setColumn64(source.getColumn64());
		target.setColumn65(source.getColumn65());
		target.setColumn66(source.getColumn66());
		target.setColumn67(source.getColumn67());
		target.setColumn68(source.getColumn68());
		target.setColumn69(source.getColumn69());

		// Mapping int
		target.setColumn70(source.getColumn70());
		target.setColumn71(source.getColumn71());
		target.setColumn72(source.getColumn72());
		target.setColumn73(source.getColumn73());
		target.setColumn74(source.getColumn74());
		target.setColumn75(source.getColumn75());
		target.setColumn76(source.getColumn76());
		target.setColumn77(source.getColumn77());
		target.setColumn78(source.getColumn78());
		target.setColumn79(source.getColumn79());

		// Mapping String[]
		if (source.getColumns() != null) {
			target.setColumns(new ArrayList<>(source.getColumns()));
		}

		return target;
	}

	private DomainTable map(DomainTable target, XmlTable source) {
		target.setName(source.getName());

		if (source.getDate() != null) {
			target.setDate(source.getDate().getTime());
		}

		if (source.getRows().isEmpty()) {
			target.setRows(new ArrayList<DomainRow>());
		} else {
			List<DomainRow> rows = new ArrayList<>();
			for (XmlRow xmlRow : source.getRows()) {
				rows.add(map(new DomainRow(), xmlRow));
			}
			target.setRows(rows);
		}

		return target;
	}

	private XmlRow map(XmlRow target, DomainRow source) {
		// Mapping String
		target.setColumn00(source.getColumn00());
		target.setColumn01(source.getColumn01());
		target.setColumn02(source.getColumn02());
		target.setColumn03(source.getColumn03());
		target.setColumn04(source.getColumn04());
		target.setColumn05(source.getColumn05());
		target.setColumn06(source.getColumn06());
		target.setColumn07(source.getColumn07());
		target.setColumn08(source.getColumn08());
		target.setColumn09(source.getColumn09());

		// Mapping int
		target.setColumn10(source.getColumn10());
		target.setColumn11(source.getColumn11());
		target.setColumn12(source.getColumn12());
		target.setColumn13(source.getColumn13());
		target.setColumn14(source.getColumn14());
		target.setColumn15(source.getColumn15());
		target.setColumn16(source.getColumn16());
		target.setColumn17(source.getColumn17());
		target.setColumn18(source.getColumn18());
		target.setColumn19(source.getColumn19());

		// Mapping boolean
		target.setColumn20(source.isColumn20());
		target.setColumn21(source.isColumn21());
		target.setColumn22(source.getColumn22());
		target.setColumn23(source.isColumn23());
		target.setColumn24(source.isColumn24());
		target.setColumn25(source.isColumn25());
		target.setColumn26(source.isColumn26());
		target.setColumn27(source.isColumn27());
		target.setColumn28(source.isColumn28());
		target.setColumn29(source.isColumn29());

		// Mapping long
		target.setColumn30(source.getColumn30());
		target.setColumn31(source.getColumn31());
		target.setColumn32(source.getColumn32());
		target.setColumn33(source.getColumn33());
		target.setColumn34(source.getColumn34());
		target.setColumn35(source.getColumn35());
		target.setColumn36(source.getColumn36());
		target.setColumn37(source.getColumn37());
		target.setColumn38(source.getColumn38());
		target.setColumn39(source.getColumn39());

		// Mapping BigDecimal
		target.setColumn40(source.getColumn40());
		target.setColumn41(source.getColumn41());
		target.setColumn42(source.getColumn42());
		target.setColumn43(source.getColumn43());
		target.setColumn44(source.getColumn44());
		target.setColumn45(source.getColumn45());
		target.setColumn46(source.getColumn46());
		target.setColumn47(source.getColumn47());
		target.setColumn48(source.getColumn48());
		target.setColumn49(source.getColumn49());

		// Mapping Calendar
		target.setColumn50(source.getColumn50());
		target.setColumn51(source.getColumn51());
		target.setColumn52(source.getColumn52());
		target.setColumn53(source.getColumn53());
		target.setColumn54(source.getColumn54());
		target.setColumn55(source.getColumn55());
		target.setColumn56(source.getColumn56());
		target.setColumn57(source.getColumn57());
		target.setColumn58(source.getColumn58());
		target.setColumn59(source.getColumn59());

		// Mapping String
		target.setColumn60(source.getColumn60());
		target.setColumn61(source.getColumn61());
		target.setColumn62(source.getColumn62());
		target.setColumn63(source.getColumn63());
		target.setColumn64(source.getColumn64());
		target.setColumn65(source.getColumn65());
		target.setColumn66(source.getColumn66());
		target.setColumn67(source.getColumn67());
		target.setColumn68(source.getColumn68());
		target.setColumn69(source.getColumn69());

		// Mapping int
		target.setColumn70(source.getColumn70());
		target.setColumn71(source.getColumn71());
		target.setColumn72(source.getColumn72());
		target.setColumn73(source.getColumn73());
		target.setColumn74(source.getColumn74());
		target.setColumn75(source.getColumn75());
		target.setColumn76(source.getColumn76());
		target.setColumn77(source.getColumn77());
		target.setColumn78(source.getColumn78());
		target.setColumn79(source.getColumn79());

		// Mapping String[]
		if (source.getColumns() == null) {
			target.setColumns(null);
		} else {
			target.setColumns(new ArrayList<>(source.getColumns()));
		}

		return target;
	}

	private XmlTable map(XmlTable target, DomainTable source) {
		target.setName(source.getName());

		if (source.getDate() != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(source.getDate());
			target.setDate(calendar);
		}

		if (source.getRows() != null) {
			for (DomainRow domainRow : source.getRows()) {
				target.getRows().add(map(createXmlRow(), domainRow));
			}
		}

		return target;
	}

}