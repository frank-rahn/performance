/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.utils;

import static org.apache.commons.lang.ArrayUtils.contains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.rahn.performance.beanmapper.TestBeansMapperBean;

/**
 * Dieser Manager kennt alle implementierten {@link TestBeansMapperBean}s.
 * 
 * @author Frank W. Rahn
 */
@Component
public class MapperManager {

	@Autowired
	private TestBeansMapperBean[] mappers;

	private Map<String, TestBeansMapperBean> mapperByName;

	private String[] names;

	/**
	 * @param der Names des gewünschten Mappers
	 * @return der Mapper zum Namen
	 */
	public TestBeansMapperBean getMapper(String name) {
		return mapperByName.get(name);
	}

	/**
	 * @return alle existierenden Mappers
	 */
	public TestBeansMapperBean[] getMappers() {
		return mappers;
	}

	/**
	 * @param excluded die auszulassenden Mapper
	 * @return die existierenden Mappers ohne die angegebenen Mapper
	 */
	public TestBeansMapperBean[] getMappersExcluded(String[] excluded) {
		List<TestBeansMapperBean> result = new ArrayList<>();

		for (String name : names) {
			if (!contains(excluded, name)) {
				result.add(mapperByName.get(name));
			}
		}
		return result.toArray(new TestBeansMapperBean[result.size()]);
	}

	/**
	 * @return die Liste der Namen der Mappers
	 */
	public String[] getNames() {
		return names;
	}

	@PostConstruct
	public void initialize() {
		mapperByName = new HashMap<>(mappers.length);
		names = new String[mappers.length];

		for (int i = 0; i < mappers.length; i++) {
			names[i] = mappers[i].getMapperName();
			mapperByName.put(mappers[i].getMapperName(), mappers[i]);
		}
	}

}