/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

import static java.lang.System.currentTimeMillis;
import static org.assertj.core.api.Assertions.assertThat;

import de.rahn.performance.beanmapper.vendors.SpringBeanUtilsTestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;
import java.util.ArrayList;

/**
 * Ein Performanz-Test der Mapper mit unvollständig gefüllten Test-Objekten.
 *
 * @author Frank W. Rahn
 */
@SuppressWarnings("NewClassNamingConvention")
class PerformanceTestWithIncompleteFixtures extends AbstractPerformanceTest {

  @Override
  protected void setUpAfter() {
    // Leere die Attribute, die nicht durch alle Mapper verarbeitet werden
    xmlTable.setDate(null);

    // Leere die Attribute, die nicht durch alle Mapper verarbeitet werden
    domainTable.setDate(null);
    domainTable.getRows().clear();
  }

  @Override
  protected void setUpBefore() {
    numberOfRows = 0;
    numberOfColumns = 0;
  }

  @Override
  void runTestWithMapper(TestBeansMapperBean mapper, int run) {
    if (mapper instanceof SpringBeanUtilsTestBeansMapperBean) {
      final String msg = "FEHLER im " + mapper.getMapperName() + " beim " + run + "ten Durchlauf";

      try {
        // Messung
        long start = currentTimeMillis();
        DomainTable table = mapper.map(xmlTable);
        long value = currentTimeMillis() - start;

        // Überprüfung
        assertThat(table).as(msg).isNotNull();
        table.setRows(new ArrayList<>()); // Wegen des Unterschieds zu org.apache.commons.beanutils.BeanUtils
        assertThat(domainTable).as(msg).isEqualTo(table);

        // Messwert registrieren
        measurement.addValue(mapper.getMapperName(), value);
      } catch (Exception exception) {
        LOGGER.error(msg, exception);

        throw new AssertionError(msg);
      }
    } else {
      super.runTestWithMapper(mapper, run);
    }
  }
}
