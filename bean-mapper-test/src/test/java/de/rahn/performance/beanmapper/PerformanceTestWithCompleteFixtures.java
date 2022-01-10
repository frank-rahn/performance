/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper;

/**
 * Ein Performanz-Test der Mapper mit vollständig gefüllten Test-Objekten.
 *
 * @author Frank W. Rahn
 */
@SuppressWarnings("NewClassNamingConvention")
public class PerformanceTestWithCompleteFixtures extends AbstractPerformanceTest {

  @Override
  protected void setUpBefore() {
    numberOfRows = 100;
    numberOfColumns = 100;
    excludedMapper = new String[]{"Commons-BeanUtils", "Spring-BeanUtils"};
  }
}
